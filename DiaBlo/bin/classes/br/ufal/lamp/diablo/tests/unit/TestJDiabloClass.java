package br.ufal.lamp.diablo.tests.unit;

import junit.framework.TestCase;
import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.core.JDiabloClass;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;

public class TestJDiabloClass extends TestCase {
	
	JDiabloClass 	jdc;
	String			name;
	
	@Override
	protected void setUp() throws Exception {
		name = new String("Meu Nome");
		jdc = new JDiabloClass(name, new BeginTerminal());
		super.setUp();
	}
	
	public void testNameOfNewJDiabloClass() {
		assertEquals(name, jdc.getName());
		assertNotNull(jdc.getChildrenBlock());
		assertEquals(0, jdc.getChildrenBlock().size());
	}
	
	public void testNameBlock() {
		assertEquals(DefaultTextToBlock.TEXT_BEGIN_TERMINAL, ((BlockText)jdc.getBlock()).getText());
	}
	
	public void testAddChildrenClass() {
		JDiabloClass j1 = new JDiabloClass(name, null);
		JDiabloClass j2 = new JDiabloClass(name, null);
		jdc.addChildrenClass(j1);
		jdc.addChildrenClass(j2);
		assertEquals(jdc.getChildrenBlock().size(), 2);
		assertEquals(jdc.getChildrenBlock().get(0), j1);
		assertEquals(jdc.getChildrenBlock().get(1), j2);
		jdc.removeSuperclass(j1);
		assertEquals(jdc.getChildrenBlock().size(), 1);
		assertEquals(jdc.getChildrenBlock().get(0), j2);
	}
	
	public void testHasChildren() throws InstantiationException, IllegalAccessException {
		assertFalse(jdc.hasChildren());
		Block block = new BeginTerminal();
		jdc.addChildrenClass(new JDiabloClass("Teste", block));
		assertTrue(jdc.hasChildren());
	}

}
