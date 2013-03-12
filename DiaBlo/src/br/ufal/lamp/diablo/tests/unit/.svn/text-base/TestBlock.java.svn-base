package br.ufal.lamp.diablo.tests.unit;

import junit.framework.TestCase;
import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.Connector;
import br.ufal.lamp.diablo.core.block.Decision;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.core.block.InputData;
import br.ufal.lamp.diablo.core.block.InputOutputData;
import br.ufal.lamp.diablo.core.block.OutPutDataImpress;
import br.ufal.lamp.diablo.core.block.OutputData;
import br.ufal.lamp.diablo.core.block.Processing;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class TestBlock extends TestCase {
	
	Block block;
	
	public void testBeginTerminal() throws InstantiationException, IllegalAccessException {
		block = new BeginTerminal();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_BEGIN_TERMINAL, block.getNumberMaxChildren());
		assertFalse(block.canConnectWith(new Connector()));
		assertFalse(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testEndTerminal() throws InstantiationException, IllegalAccessException {
		block = new EndTerminal();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_END_TERMINAL, block.getNumberMaxChildren());
		assertFalse(block.canConnectWith(new Connector()));
		assertFalse(block.canConnectWith(new Decision()));
		assertFalse(block.canConnectWith(new EndTerminal()));
		assertFalse(block.canConnectWith(new InputData()));
		assertFalse(block.canConnectWith(new Processing()));
	}
	
	public void testConnector() throws InstantiationException, IllegalAccessException {
		block = new Connector();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_CONNECTOR, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testDecision() throws InstantiationException, IllegalAccessException {
		block = new Decision();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_DECISION, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testInputData() throws InstantiationException, IllegalAccessException {
		block = new InputData();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_INPUT_DATA, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testOutputData() throws InstantiationException, IllegalAccessException {
		block = new OutputData();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_OUTPUT_DATA, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testOutputDataImpress() throws InstantiationException, IllegalAccessException {
		block = new OutPutDataImpress();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_OUTPUT_DATA_IMPRESS, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testProcessing() throws InstantiationException, IllegalAccessException {
		block = new Processing();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_PROCESSING, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
	public void testInputOutputData() throws InstantiationException, IllegalAccessException {
		block = new InputOutputData();
		assertEquals(NumberMaxChildren.NUMBER_CHILDREN_MAX_INPUT_OUTPUT_DATA, block.getNumberMaxChildren());
		assertTrue(block.canConnectWith(new Connector()));
		assertTrue(block.canConnectWith(new Decision()));
		assertTrue(block.canConnectWith(new EndTerminal()));
		assertTrue(block.canConnectWith(new InputData()));
		assertTrue(block.canConnectWith(new Processing()));
	}
	
}
