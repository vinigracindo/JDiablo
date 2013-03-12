package br.ufal.lamp.diablo.core.gerador;

import java.io.Serializable;
import java.util.ListIterator;
import java.util.Vector;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.Diagram;
import br.ufal.lamp.diablo.core.JDiabloClass;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.Connector;
import br.ufal.lamp.diablo.core.block.Decision;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.core.block.InputData;
import br.ufal.lamp.diablo.core.block.InputOutputData;
import br.ufal.lamp.diablo.core.block.OutPutDataImpress;
import br.ufal.lamp.diablo.core.block.OutputData;
import br.ufal.lamp.diablo.core.block.Processing;

public class Gerador implements Serializable {
	
	/**
	 * Classe responsável pela geração do código fonte a partir do
	 * diagrama de blocos.
	 * MDI_DrawApplication - objeto da aplicação principal
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Block> listaDeBlocos;
	private Vector<Integer> idBlocosEscritos;
	private Arquivo arquivoGerado;
	private String diretorioDestino;
	//private Diagram diagram;
	//private MDI_DrawApplication mdi;
	
	public Gerador(Diagram diagram, String diretorioDestino, String tipoArquivo){
		this.listaDeBlocos = diagram.getBlocks();
		this.idBlocosEscritos = new Vector<Integer>();
		if(tipoArquivo.equals("cc")){
			this.arquivoGerado = new ArquivoCC();
		}else if(tipoArquivo.equals("pascal")){
			this.arquivoGerado = new ArquivoPascal();
		}
		this.diretorioDestino = diretorioDestino;
	}
	/* carregarBlocosDaAplicacao()
	 * Função que pega uma DrawingView(painel onde ficam os desenhos);
	 * Através do comando drawingView.drawing().figures() pego a 
	 * interface de todas as figuras que estão desenhadas no painel;
	 * No laço, enquanto tiver figuras na lista, faz-se um cast para Block
	 * a partir da interface contida na lista. Caso seja uma seta será ignorada;
	 * Antes do bloco ser inserido na lista de blocos é definido um id para identificá-lo.
	 */
	/*private void carregarBlocosDaAplicacao(){
		DrawingView drawingView = mdi.view();
		FigureEnumeration fe = drawingView.drawing().figures();
		Block aux;
		int i = 0;
		while(fe.hasNextFigure()){
			try{
				aux = (Block)fe.nextFigure();
				aux.getModellerClass().setID(i);
				i++;
				listaDeBlocos.add(aux);
			}catch (Exception e) {
				// passa se o objeto nao for uma instancia de block
			}
		}
	}*/
	/*
	 * A partir de uma lista nós(blocos) passada como parâmetro
	 * é utilizado o método de percorrer árvores n-árias do canto 
	 * mais à esquerda até o mais a direita. Dependendo do tipo da instância
	 * do nó manda escrever no arquivo a estrutura relacionada.
	 * É uma função recursiva que será chamada enquanto o nó tiver filhos.
	 */
	private void criaEstruturaArquivoTexto(Vector<JDiabloClass> noRaiz){
		for(int i = 0; i < noRaiz.size(); i++){
			if(!idBlocosEscritos.contains(noRaiz.get(i).getID())){
				if(noRaiz.get(i).getBlock() instanceof BeginTerminal){
					arquivoGerado.writeBegin(noRaiz.get(i).getChildrenBlock().get(0));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else if(noRaiz.get(i).getBlock() instanceof Processing){
					arquivoGerado.writeProcess(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else if(noRaiz.get(i).getBlock() instanceof Decision){
					arquivoGerado.verifyDecision(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else if(noRaiz.get(i).getBlock() instanceof Connector){
					arquivoGerado.writeConnector(noRaiz.get(i));
				}else if(noRaiz.get(i).getBlock() instanceof EndTerminal){
					arquivoGerado.writeEndTerminal(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else if(noRaiz.get(i).getBlock() instanceof InputData){
					arquivoGerado.writeInputData(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());					
				}else if(noRaiz.get(i).getBlock() instanceof InputOutputData){
					arquivoGerado.writeInputOutputData(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else if(noRaiz.get(i).getBlock() instanceof OutputData){
					arquivoGerado.writeOutputData(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else if(noRaiz.get(i).getBlock() instanceof OutPutDataImpress){
					arquivoGerado.writeOutPutDataImpress(noRaiz.get(i));
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}else{
					System.out.println("Instância não identificada "+noRaiz.get(i).getName()+ " "+noRaiz.get(i).getID());
					idBlocosEscritos.add(noRaiz.get(i).getID());
				}
			}
			if(noRaiz.get(i).hasChildren()){
				criaEstruturaArquivoTexto(noRaiz.get(i).getChildrenBlock());
			}
		}
	}
	/*
	 * Na lista de blocos identifica o bloco início e passa-o para a
	 * função criaEstruturaArquivoTexto(Vector<JDiabloClass>).
	 * Depois do texto do arquivo criado com sucesso a partir dos blocos
	 * escreve o arquivo no diretório espeficicado.
	 */
	public void gerarArquivo(){
		//this.carregarBlocosDaAplicacao();
		ListIterator<Block> lista = listaDeBlocos.listIterator();
		Block inicio;
		Vector<JDiabloClass> root = new Vector<JDiabloClass>();
		while(lista.hasNext()){
			inicio = lista.next();
			if(inicio.getModellerClass().getName().equals("Inicio")){
				root.add(inicio.getModellerClass());
				this.criaEstruturaArquivoTexto(root);
			}
		}
		arquivoGerado.escreveArquivo(this.getDiretorioDestino());
	}

	private String getDiretorioDestino() {
		if(diretorioDestino.length() > 0)
			return this.diretorioDestino+"/";
		return this.diretorioDestino;
	}

}
