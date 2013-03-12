package br.ufal.lamp.diablo.core;

import java.io.Serializable;

import org.jhotdraw.figures.RoundRectangleFigure;

public abstract class Terminal extends BlockText implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Terminal(int numberMaxChildren, String myText) {
		super(new RoundRectangleFigure(), numberMaxChildren, myText, false);
	}

}
