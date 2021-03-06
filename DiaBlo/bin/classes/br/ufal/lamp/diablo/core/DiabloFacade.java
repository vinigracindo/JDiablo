package br.ufal.lamp.diablo.core;

import java.net.ConnectException;
import java.util.Vector;

import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.Decision;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.core.block.Processing;
import br.ufal.lamp.diablo.exception.BeginNotFoundException;
import br.ufal.lamp.diablo.exception.EmptyDiagramException;
import br.ufal.lamp.diablo.exception.MoreOneBeginInDiagramExcept;
import br.ufal.lamp.diablo.exception.facade.InvalidParameterException;
import br.ufal.lamp.diablo.ui.gui.JDiabloApplication;

public class DiabloFacade {

	JDiabloApplication j;
	Diagram diagram;
	
	public String[] stringToVetor(String texto) {
		if(texto.charAt(0) == '{' && texto.charAt(texto.length()-1) == '}') { 
			texto = texto.substring(1, texto.length()-1);
		}
		return texto.split(",");
	}
	
	public String novoDiagrama(String nomeDiagrama) throws InvalidParameterException {
		if(nomeDiagrama.length() == 0 || stringToVetor(nomeDiagrama).length != 1) {
			throw new InvalidParameterException();
		}
		String[] nome = stringToVetor(nomeDiagrama);
		j = new JDiabloApplication(nome[0]);
		return "Novo diagrama criado com sucesso";
	}
	
	public String inserirBlocoTexto(String blocos, String texto, String indices) throws Exception {
		String[] vb = stringToVetor(blocos);
		String[] vt = stringToVetor(texto);
		String[] vi = stringToVetor(indices);
		
		if((vb.length == vt.length) && (vt.length == vi.length)) {
			for(int i = 0; i<vb.length; i++) {
				Block b1;
				if(vb[i].equals("BeginTerminal")) {
					b1 = new BeginTerminal();
				}
				else if(vb[i].equals("EndTerminal")) {
					b1 = new EndTerminal();
				}
				else if (vb[i].equals("Processing")) {
					b1 = new Processing();
				}
				else {
					b1 = new Processing();
				}
				b1.getModellerClass().setName(vt[i]);
				b1.getModellerClass().setID(Integer.parseInt(vi[i]));
				diagram.addBlock(b1);
			}
			try {
				diagram.isValid();
			} catch (EmptyDiagramException e) {
				throw new EmptyDiagramException();
			} catch (BeginNotFoundException e) {
				throw new BeginNotFoundException();
			} catch (MoreOneBeginInDiagramExcept e) {
				throw new MoreOneBeginInDiagramExcept();
			}
		}
		else {
			throw new InvalidParameterException();
		}
		
		String retorno = "";
		for(int i=0; i<vb.length; i++) {
			retorno += vb[i]+ " ";
		}
		return "bloco "+retorno+"inserido com sucesso";
	}
	
	public void novoDiagramaPersistencia() {
		diagram = new Diagram();
	}
	
	public void fecharDiagrama() {
		diagram = null;
	}
	
	public String inserirConexao(String indiceDe, String indicePara){
		Vector<Block> vetorBlocos = diagram.getBlocks();
		Block de = null;
		Block para = null;
		for(int i =0; i< vetorBlocos.size(); i++){
			if(vetorBlocos.get(i).getModellerClass().getID() == Integer.parseInt(indiceDe)){
				de = vetorBlocos.get(i);
			}
		}
		for(int i =0; i< vetorBlocos.size(); i++){
			if(vetorBlocos.get(i).getModellerClass().getID() == Integer.parseInt(indicePara)){
				para = vetorBlocos.get(i);
			}
		}
		try{
			de.canConnectWith(para);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "conectado com sucesso";
	}
	
	public String removerConexao(String indiceDe, String indicePara) throws ConnectException{
		Vector<Block> vetorBlocos = diagram.getBlocks();
		Block de = null;
		Block para = null;
		for(int i =0; i< vetorBlocos.size(); i++){
			if(vetorBlocos.get(i).getModellerClass().getID() == Integer.parseInt(indiceDe)){
				de = vetorBlocos.get(i);
			}
		}
		for(int i =0; i< vetorBlocos.size(); i++){
			if(vetorBlocos.get(i).getModellerClass().getID() == Integer.parseInt(indicePara)){
				para = vetorBlocos.get(i);
			}
		}
		try{
			de.remove(para.myFigure);
		}catch (Exception e) {
			e.getMessage();
		}
		return "conectado com sucesso";
	}
}
