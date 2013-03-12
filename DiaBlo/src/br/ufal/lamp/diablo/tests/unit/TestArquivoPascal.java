package br.ufal.lamp.diablo.tests.unit;

import java.io.File;

import junit.framework.TestCase;
import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.JDiabloClass;
import br.ufal.lamp.diablo.core.block.Connector;
import br.ufal.lamp.diablo.core.block.Decision;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.core.block.InputData;
import br.ufal.lamp.diablo.core.block.InputOutputData;
import br.ufal.lamp.diablo.core.block.OutPutDataImpress;
import br.ufal.lamp.diablo.core.block.OutputData;
import br.ufal.lamp.diablo.core.block.Processing;
import br.ufal.lamp.diablo.core.gerador.ArquivoPascal;

public class TestArquivoPascal extends TestCase {
	
	ArquivoPascal arquivo;
	JDiabloClass jdc;
	Block fim;
	
	@Override
	protected void setUp() throws Exception {
		arquivo = new ArquivoPascal();
		fim = new EndTerminal();
		jdc = new JDiabloClass("var S:string;", new Processing());
		jdc.setID(0);
		fim.getModellerClass().setID(1);
	}
	
	public void testWriteBegin() {
		assertEquals("",arquivo.getTexto());
		arquivo.writeBegin(jdc);
		assertEquals("begin { program }\n#0#end. { program }", arquivo.getTexto());
	}
	
	public void testWriteProcess() {
		arquivo.writeBegin(jdc);
		arquivo.writeProcess(jdc);
		assertEquals("begin { program }\n"+ jdc.getName()+ "\nend. { program }", arquivo.getTexto());
	}
	
	public void testWriteProcessWithChildren() throws InstantiationException, IllegalAccessException {
		arquivo.writeBegin(jdc);
		JDiabloClass j = new JDiabloClass("Processamento", new Processing());
		j.setID(1);
		jdc.addChildrenClass(j);
		arquivo.writeProcess(jdc);
		assertEquals("begin { program }\n"+ jdc.getName()+ "\n#"+j.getID()+"#\nend. { program }", arquivo.getTexto());
	}
	
	public void testWriteIfElse() throws InstantiationException, IllegalAccessException {
		arquivo.writeBegin(jdc);
		JDiabloClass j = new JDiabloClass("Decisão", new Decision());
		j.addChildrenClass(jdc);
		j.addChildrenClass(jdc);
		arquivo.writeIfElse(j);
		assertEquals("begin { program }\nif "+ j.getName()+ " then\nbegin#"+ jdc.getID() +"#end\nelse\nbegin\n#"+ jdc.getID() +"#\nend\nend. { program }", arquivo.getTexto());
	}
	
	public void testWriteIfElseWithEndChildren() throws InstantiationException, IllegalAccessException {
		arquivo.writeBegin(jdc);
		JDiabloClass j = new JDiabloClass("Decisão", new Decision());
		j.addChildrenClass(jdc);
		jdc = new JDiabloClass("Fim", new EndTerminal());
		j.addChildrenClass(jdc);
		arquivo.writeIfElse(j);
		assertEquals("begin { program }\nif "+ j.getName()+ " then\nbegin#"+ jdc.getID() +"#endend. { program }", arquivo.getTexto());
	}
	
	public void testWriteConnector() throws InstantiationException, IllegalAccessException {
		
		Block b1 = new Connector();
		b1.getModellerClass().setID(1);
				
		Block b2 = new EndTerminal();
		b2.getModellerClass().setID(2);
		
		b1.getModellerClass().addChildrenClass(b2.getModellerClass());
		
		arquivo.writeBegin(b1.getModellerClass());
		assertEquals("begin { program }\n#"+b1.getModellerClass().getID()+"#end. { program }", arquivo.getTexto());
		arquivo.writeConnector(b1.getModellerClass());
		assertEquals("begin { program }\n#"+b2.getModellerClass().getID()+"#end. { program }", arquivo.getTexto());
	}
	
	public void testWriteEndTerminal() throws InstantiationException, IllegalAccessException {
		jdc = new JDiabloClass("", new EndTerminal());
		jdc.setID(0);
		arquivo.writeBegin(jdc);
		assertEquals("begin { program }\n#0#end. { program }", arquivo.getTexto());
		arquivo.writeEndTerminal(jdc);
		assertEquals("begin { program }\nend. { program }", arquivo.getTexto());
	}
	
	public void testWriteInputData() throws InstantiationException, IllegalAccessException {
		arquivo.writeBegin(jdc);
		assertEquals("begin { program }\n#0#end. { program }", arquivo.getTexto());
		Block b1 = new InputData();
		b1.getModellerClass().addChildrenClass(fim.getModellerClass());
		arquivo.writeInputData(b1.getModellerClass());
		assertEquals("begin { program }\nReadln("+b1.getModellerClass().getName()+");\n#1#end. { program }", arquivo.getTexto());
	}
	
	public void testWriteInputOutputData() throws InstantiationException, IllegalAccessException {
		arquivo.writeBegin(jdc);
		assertEquals("begin { program }\n#0#end. { program }", arquivo.getTexto());
		Block b1 = new InputOutputData();
		b1.getModellerClass().addChildrenClass(fim.getModellerClass());
		arquivo.writeInputOutputData(b1.getModellerClass());
		assertEquals("begin { program }\nWriteln ('Entre com um valor');\nReadln("+b1.getModellerClass().getName()+");\n#1#end. { program }", arquivo.getTexto());
	}
	
	public void testWriteOutputData() throws InstantiationException, IllegalAccessException {
		arquivo.writeBegin(jdc);
		assertEquals("begin { program }\n#0#end. { program }", arquivo.getTexto());
		Block b1 = new OutputData();
		b1.getModellerClass().addChildrenClass(fim.getModellerClass());
		arquivo.writeOutputData(b1.getModellerClass());
		assertEquals("begin { program }\nWriteln("+b1.getModellerClass().getName()+");\n#1#end. { program }", arquivo.getTexto());
	}
	
	public void testWriteOutPutDataImpress() throws InstantiationException, IllegalAccessException {
		
		Block b1 = new OutPutDataImpress();
		b1.getModellerClass().setID(1);
				
		Block b2 = new EndTerminal();
		b2.getModellerClass().setID(2);
		
		b1.getModellerClass().addChildrenClass(b2.getModellerClass());
		
		arquivo.writeBegin(b1.getModellerClass());
		assertEquals("begin { program }\n#"+b1.getModellerClass().getID()+"#end. { program }", arquivo.getTexto());
		arquivo.writeOutPutDataImpress(b1.getModellerClass());
		assertEquals("begin { program }\n#"+b2.getModellerClass().getID()+"#end. { program }", arquivo.getTexto());
	}
	
	public void testWriteFile() {
		arquivo.writeBegin(jdc);
		arquivo.escreveArquivo("");
		File arq = new File("source.pas");
		assertTrue(arq.exists());
		if(arq.exists()) arq.delete();
	}

}
