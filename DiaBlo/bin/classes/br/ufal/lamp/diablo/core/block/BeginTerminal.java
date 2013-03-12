package br.ufal.lamp.diablo.core.block;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.Terminal;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class BeginTerminal extends Terminal {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 393371338933078230L;

	public BeginTerminal() throws InstantiationException, IllegalAccessException {
		super(NumberMaxChildren.NUMBER_CHILDREN_MAX_BEGIN_TERMINAL, DefaultTextToBlock.TEXT_BEGIN_TERMINAL);
		super.initialize(this);
	}

	@Override
	public boolean canConnectWith(Block block) {
		if(block instanceof Connector 		||
		   block instanceof Decision		
		) {
			return false;			
		}
		return true;
	}

}
