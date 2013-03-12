package br.ufal.lamp.diablo.core;

import java.awt.Color;

import org.jhotdraw.figures.ArrowTip;
import org.jhotdraw.figures.LineConnection;
import org.jhotdraw.framework.Figure;

public class DataStreamLineConnection extends LineConnection {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8794737629200191221L;

	public DataStreamLineConnection() {
		setStartDecoration(null);
		ArrowTip arrow = new ArrowTip(0.35, 20, 20);
		arrow.setFillColor(Color.black);
        arrow.setBorderColor(Color.black);
        setEndDecoration(arrow);
	}
	
	@Override
	protected void handleConnect(Figure start, Figure end) {
        super.handleConnect(start, end);
        JDiabloClass startClass = ((Block)start).getModellerClass();
        JDiabloClass endClass = ((Block)end).getModellerClass();
        startClass.addChildrenClass(endClass);
    }
	
	@Override
	protected void handleDisconnect(Figure start, Figure end) {
		super.handleDisconnect(start, end);
		if ((start != null) && (end!= null)) {
			((Block)start).getModellerClass().removeSuperclass(((Block)end).getModellerClass());
		}
	}
	
	public boolean canConnect(Figure start, Figure end) {
		return ((Block)start).canConnect((Block)end);
	}
}
