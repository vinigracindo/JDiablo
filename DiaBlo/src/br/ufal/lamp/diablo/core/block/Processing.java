package br.ufal.lamp.diablo.core.block;

import org.jhotdraw.figures.RectangleFigure;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class Processing extends BlockText {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3695919756363340140L;

	public Processing() throws InstantiationException, IllegalAccessException {
		super(new RectangleFigure(), NumberMaxChildren.NUMBER_CHILDREN_MAX_PROCESSING, DefaultTextToBlock.TEXT_PROCESSING, true);
		super.initialize(this);
	}
	
	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
