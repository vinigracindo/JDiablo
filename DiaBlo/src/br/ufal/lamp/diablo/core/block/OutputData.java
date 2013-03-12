package br.ufal.lamp.diablo.core.block;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.figures.FigureToOutputData;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class OutputData extends BlockText {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2358651869545229263L;
	
	
	public OutputData() throws InstantiationException, IllegalAccessException {
		super(new FigureToOutputData(), NumberMaxChildren.NUMBER_CHILDREN_MAX_OUTPUT_DATA, DefaultTextToBlock.TEXT_OUTPUT_DATA, true);
		super.initialize(this);
	}
	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
