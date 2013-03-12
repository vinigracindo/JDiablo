package br.ufal.lamp.diablo.core.block;


import org.jhotdraw.figures.RectangleFigure;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class OutPutDataImpress extends BlockText {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3151104926747792242L;

	public OutPutDataImpress() throws InstantiationException, IllegalAccessException {
		super(new RectangleFigure(), NumberMaxChildren.NUMBER_CHILDREN_MAX_OUTPUT_DATA_IMPRESS, DefaultTextToBlock.TEXT_OUTPUT_DATA_IMPRESS, true);
		super.initialize(this);
	}

	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
