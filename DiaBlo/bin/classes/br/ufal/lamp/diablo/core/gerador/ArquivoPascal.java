package br.ufal.lamp.diablo.core.gerador;

import java.io.File;
import java.io.FileOutputStream;

import br.ufal.lamp.diablo.core.JDiabloClass;
import br.ufal.lamp.diablo.core.block.EndTerminal;

public class ArquivoPascal implements Arquivo {

	private String texto;
	public ArquivoPascal() {
		texto = "";
	}
	public String getTexto() {
		return texto;
	}
	
	private String convertID(int chield){
		String id = "#"+Integer.toString(chield)+"#";
		return id;
	}
	@Override
	public void writeBegin(JDiabloClass chield) {
		texto = "begin { program }\n"+this.convertID(chield.getID())+"end. { program }";
	}

	@Override
	public void writeProcess(JDiabloClass object) {
		String myText = object.getName() + "\n";
		if(object.hasChildren()){
			myText+=convertID(object.getChildrenBlock().get(0).getID())+ "\n";
		}
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void writeConnector(JDiabloClass object) {
		String myText = convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void writeEndTerminal(JDiabloClass object) {
		String myText = "";
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void escreveArquivo(String diretorioDestino) {
		try {  
	         // Gravando no arquivo  
	         File arquivo;  
	         arquivo = new File(diretorioDestino+"source.pas");  
	         FileOutputStream fos = new FileOutputStream(arquivo);  
	         fos.write(this.texto.getBytes());  
	         fos.close();  
	      }  
	      catch (Exception ee) {  
	         ee.printStackTrace();  
	      }

	}

	@Override
	public void writeIfElse(JDiabloClass object) {
		String myText = "if "+object.getName()+" then\nbegin"+convertID(object.getChildrenBlock().get(0).getID())+"end";
		if(!(object.getChildrenBlock().get(1).getBlock() instanceof EndTerminal)){//o certo era apontar para nada
			myText += "\nelse\nbegin\n"+convertID(object.getChildrenBlock().get(1).getID())+"\nend\n";
		}
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void writeWhile(JDiabloClass object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeInputData(JDiabloClass object) {
		String myText = "Readln("+ object.getName()+");\n"+convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void writeInputOutputData(JDiabloClass object) {
		String myText = "Writeln ('Entre com um valor');\nReadln("+ object.getName()+");\n"+ convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void writeOutputData(JDiabloClass object) {
		String myText = "Writeln("+object.getName()+");\n"+convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}

	@Override
	public void writeOutPutDataImpress(JDiabloClass object) {
		String myText = convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}
	@Override
	public void verifyDecision(JDiabloClass object) {
		// TODO Auto-generated method stub
		
	}

}
