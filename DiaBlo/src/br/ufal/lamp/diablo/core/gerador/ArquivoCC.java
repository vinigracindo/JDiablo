package br.ufal.lamp.diablo.core.gerador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

import br.ufal.lamp.diablo.core.JDiabloClass;
import br.ufal.lamp.diablo.core.block.EndTerminal;

public class ArquivoCC implements Arquivo, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String texto;
	public ArquivoCC(){
		texto = "";
	}
	
	public String getTexto() {
		return texto;
	}
	
	private String convertID(int chield){
		String id = "#"+Integer.toString(chield)+"#";
		return id;
	}
	
	public void writeBegin(JDiabloClass chield){
		texto = "int main(){\n"+this.convertID(chield.getID())+"return 0;\n}";
	}
	public void writeProcess(JDiabloClass object){
		String myText = object.getName() + "\n";
		if(object.hasChildren()){
			myText+=convertID(object.getChildrenBlock().get(0).getID())+ "\n";
		}
		texto = texto.replace(convertID(object.getID()), myText);
	}
	
	
	public void verifyDecision(JDiabloClass object){
		if(object.getChildrenBlock().size() == 1){
			writeWhile(object);
		}else{
			writeIfElse(object);
		}
	}
	
	
	public void writeIfElse(JDiabloClass object) {
		String myText = "if("+object.getName()+"){\n"+convertID(object.getChildrenBlock().get(0).getID())+"}";
		if(!(object.getChildrenBlock().get(1).getBlock() instanceof EndTerminal)){//o certo era apontar para nada
			myText += "\nelse{\n"+convertID(object.getChildrenBlock().get(1).getID())+"\n}\n";
		}
		texto = texto.replace(convertID(object.getID()), myText);
	}
	
	
	public void writeWhile(JDiabloClass object) {
		/*
		String controlador ="";
		String op="";
		if(object.getName().contains(">")){
			controlador = object.getName().split("\\>")[0];
			op="--";
		}else{
			controlador = object.getName().split("\\<")[0];
			op="++";
		}
		String myText = "while("+object.getName()+"){\n";
		if(object.hasChildren()){
			myText +=convertID(object.getChildrenBlock().get(0).getID())+"\n"+controlador+op+";"+"\n}";
		}
		texto = texto.replace(convertID(object.getID()), myText);
		*/
	}
	
	
	public void writeConnector(JDiabloClass object) {
		String myText = convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}
	public void writeEndTerminal(JDiabloClass object) {
		String myText = "";
		texto = texto.replace(convertID(object.getID()), myText);
	}
	public void writeInputData(JDiabloClass object) {
		String myText = "scanf(\"%s\","+ object.getName()+")\n"+convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}
	public void writeInputOutputData(JDiabloClass object) {
		String myText = "printf \"Entre com um valor: \";\nscanf(\"%s\","+ object.getName()+");\n"+ convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}
	public void writeOutputData(JDiabloClass object) {
		String myText = "printf \""+object.getName()+"\";\n"+convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}
	public void writeOutPutDataImpress(JDiabloClass object) {
		String myText = convertID(object.getChildrenBlock().get(0).getID());
		texto = texto.replace(convertID(object.getID()), myText);
	}
	public void escreveArquivo(String diretorioDestino){
		try {  
	         // Gravando no arquivo  
	         File arquivo;  
	         arquivo = new File(diretorioDestino+"source.cpp");  
	         FileOutputStream fos = new FileOutputStream(arquivo);  
	         fos.write(this.texto.getBytes());  
	         fos.close();  
	      }  
	      catch (Exception ee) {  
	         ee.printStackTrace();  
	      }  
	}

}
