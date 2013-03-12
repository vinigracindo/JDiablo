package br.ufal.lamp.diablo.tests.unit;

import junit.framework.TestCase;
import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.Diagram;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.exception.BeginNotFoundException;
import br.ufal.lamp.diablo.exception.EmptyDiagramException;
import br.ufal.lamp.diablo.exception.MoreOneBeginInDiagramExcept;

public class TestDiagram extends TestCase {
	
	Diagram diagram;
	
	@Override
	protected void setUp() throws Exception {
		diagram = new Diagram();
	}

	public void testAddBlock() throws InstantiationException, IllegalAccessException {
		Block b1 = new BeginTerminal();
		Block b2 = new EndTerminal();
		b1.getModellerClass().addChildrenClass(b2.getModellerClass());
		try {
			diagram.isValid();
			fail("Exceção deve ocorrer. Diagrama Vazio");
		} catch (Exception e) {

		}
		diagram.addBlock(b2);
		try {
			diagram.isValid();
			fail("Exceção deve ocorrer. Diagrama não tem bloco inicio.");
		} catch (Exception e) {

		}
		diagram.addBlock(b1);
				try {
			diagram.isValid();
		} catch (Exception e) {
			fail("Não deve ocorrer nenhuma exceção.");
		}
		diagram.addBlock(b1);
		try {
			diagram.isValid();
			fail("Exceção deve ocorrer. Diagrama tem mais de um bloco inicio.");
		} catch (Exception e) {

		}
	}
	
}
