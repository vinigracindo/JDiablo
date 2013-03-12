package br.ufal.lamp.diablo.core.block;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.figures.FigureToInputData;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class InputData extends BlockText {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9204571278907482548L;

	public InputData() throws InstantiationException, IllegalAccessException {
		super(new FigureToInputData(), NumberMaxChildren.NUMBER_CHILDREN_MAX_INPUT_DATA, DefaultTextToBlock.TEXT_INPUT_DATA, true);
		super.initialize(this);
	}

	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
