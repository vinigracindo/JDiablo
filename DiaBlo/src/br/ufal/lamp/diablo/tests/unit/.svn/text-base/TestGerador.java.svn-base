package br.ufal.lamp.diablo.tests.unit;

import java.io.File;

import junit.framework.TestCase;
import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.Diagram;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.Connector;
import br.ufal.lamp.diablo.core.block.Decision;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.core.block.InputData;
import br.ufal.lamp.diablo.core.block.InputOutputData;
import br.ufal.lamp.diablo.core.block.OutPutDataImpress;
import br.ufal.lamp.diablo.core.block.OutputData;
import br.ufal.lamp.diablo.core.block.Processing;
import br.ufal.lamp.diablo.core.gerador.Gerador;

public class TestGerador extends TestCase {
	
	Gerador gerador;
	Diagram diagram;
	
	@Override
	protected void setUp() throws Exception {
		diagram = new Diagram();
		Block b1 = new BeginTerminal();
		Block b2 = new Processing();
		Block b3 = new Decision();
		Block b4 = new Connector();
		Block b5 = new OutPutDataImpress();
		Block b6 = new InputData();
		Block b7 = new InputOutputData();
		Block b8 = new OutputData();
		Block b9 = new EndTerminal();
		b1.getModellerClass().setID(0);
		b2.getModellerClass().setID(1);
		b3.getModellerClass().setID(2);
		b4.getModellerClass().setID(3);
		b5.getModellerClass().setID(4);
		b6.getModellerClass().setID(5);
		b7.getModellerClass().setID(6);
		b8.getModellerClass().setID(7);
		b9.getModellerClass().setID(8);
		b1.getModellerClass().addChildrenClass(b2.getModellerClass());
		b2.getModellerClass().addChildrenClass(b3.getModellerClass());
		b3.getModellerClass().addChildrenClass(b4.getModellerClass());
		b4.getModellerClass().addChildrenClass(b5.getModellerClass());
		b5.getModellerClass().addChildrenClass(b6.getModellerClass());
		b6.getModellerClass().addChildrenClass(b7.getModellerClass());
		b7.getModellerClass().addChildrenClass(b8.getModellerClass());
		b8.getModellerClass().addChildrenClass(b9.getModellerClass());
		diagram.addBlock(b1);
		diagram.addBlock(b2);
		diagram.addBlock(b3);
		diagram.addBlock(b4);
		diagram.addBlock(b5);
		diagram.addBlock(b6);
		diagram.addBlock(b7);
		diagram.addBlock(b8);
		diagram.addBlock(b9);
	}
	
	public void testGerarArquivoCC() {
		gerador = new Gerador(diagram, "", "cc");
		gerador.gerarArquivo();
		File arq = new File("source.cpp");
		assertTrue(arq.exists());
		if(arq.exists()) arq.delete();
	}
	
	public void testGerarArquivoPascal() {
		gerador = new Gerador(diagram, "", "pascal");
		gerador.gerarArquivo();
		File arq = new File("source.pas");
		assertTrue(arq.exists());
		if(arq.exists()) arq.delete();
	}

}
