package br.ufal.lamp.diablo.core.block;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.BlockText;
import br.ufal.lamp.diablo.figures.FigureToInputOutputData;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class InputOutputData extends BlockText{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4801169484873136392L;

	public InputOutputData() throws InstantiationException, IllegalAccessException {
		super(new FigureToInputOutputData(), NumberMaxChildren.NUMBER_CHILDREN_MAX_INPUT_OUTPUT_DATA, DefaultTextToBlock.TEXT_INPUT_OUTPUT_DATA, true);
		super.initialize(this);
	}

	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
