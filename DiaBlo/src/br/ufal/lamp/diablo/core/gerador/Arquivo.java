package br.ufal.lamp.diablo.core.gerador;

import br.ufal.lamp.diablo.core.JDiabloClass;

public interface Arquivo {
	public void writeBegin(JDiabloClass chield);
	public void writeProcess(JDiabloClass object);
	public void writeConnector(JDiabloClass object);
	public void writeEndTerminal(JDiabloClass object);
	public void escreveArquivo(String diretorioDestino);
	public void writeIfElse(JDiabloClass object);
	public void writeWhile(JDiabloClass object);
	public void writeInputData(JDiabloClass object);
	public void writeInputOutputData(JDiabloClass object);
	public void writeOutputData(JDiabloClass object);
	public void writeOutPutDataImpress(JDiabloClass object);
	public void verifyDecision(JDiabloClass object);
}
