package br.ufal.lamp.diablo.tests.unit;

import junit.framework.TestCase;

import org.jhotdraw.framework.Figure;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.DataStreamLineConnection;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.EndTerminal;

public class TestLineConnection extends TestCase {

	DataStreamLineConnection line;
	
	@Override
	protected void setUp() throws Exception {
		line = new DataStreamLineConnection();
	}

	public void testCanConnect() throws InstantiationException, IllegalAccessException {
		Block b1 = new BeginTerminal();
		Block b2 = new EndTerminal();
		assertTrue(line.canConnect((Figure)b1, (Figure)b2));
		b2 = new BeginTerminal();
		assertFalse(line.canConnect((Figure)b1,(Figure) b2));
	}
	
}
