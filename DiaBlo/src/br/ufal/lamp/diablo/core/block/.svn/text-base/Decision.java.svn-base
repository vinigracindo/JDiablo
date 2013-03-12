package br.ufal.lamp.diablo.core.block;

import org.jhotdraw.contrib.DiamondFigure;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class Decision extends BlockText {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2337580864437249317L;


	public Decision() throws InstantiationException, IllegalAccessException {
		super(new DiamondFigure(), NumberMaxChildren.NUMBER_CHILDREN_MAX_DECISION, DefaultTextToBlock.TEXT_DECISION, true);
		super.initialize(this);
	}
	
	
	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
