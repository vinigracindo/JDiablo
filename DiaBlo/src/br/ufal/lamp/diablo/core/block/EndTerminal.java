package br.ufal.lamp.diablo.core.block;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.Terminal;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;


public class EndTerminal extends Terminal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6424130127677587436L;

	public EndTerminal() throws InstantiationException, IllegalAccessException {
		super(NumberMaxChildren.NUMBER_CHILDREN_MAX_END_TERMINAL, DefaultTextToBlock.TEXT_END_TERMINAL);
		super.initialize(this);
	}
	
	@Override
	public boolean canConnectWith(Block block) {
		return false;
	}
	
}
