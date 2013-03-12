package br.ufal.lamp.diablo.core.block;

import org.jhotdraw.figures.EllipseFigure;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;

public class Connector extends Block {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3265565312170294468L;

	public Connector() throws InstantiationException, IllegalAccessException {
		super(new EllipseFigure(), NumberMaxChildren.NUMBER_CHILDREN_MAX_CONNECTOR);
		super.initialize(this);
	}

	@Override
	public boolean canConnectWith(Block block) {
		return true;
	}

}
