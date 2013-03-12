package br.ufal.lamp.diablo.figures;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import org.jhotdraw.contrib.ChopDiamondConnector;
import org.jhotdraw.contrib.PolygonFigure;
import org.jhotdraw.figures.RectangleFigure;
import org.jhotdraw.framework.Connector;


public class FigureToInputData extends RectangleFigure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660528164698653424L;

	public FigureToInputData() {
		super(new Point(0,0), new Point(0,0));
	}

	public FigureToInputData(Point origin, Point corner) {
		super(origin,corner);
	}
	
	protected Polygon getPolygon() {
		Rectangle r = displayBox();
		Polygon p = new Polygon();
		p.addPoint(r.x, r.y);
		p.addPoint(r.x+r.width, r.y);
		p.addPoint(r.x+(r.width-(r.width/4)), r.y+r.height);
		p.addPoint(r.x+(r.width/4), r.y+r.height);
		return p;
	}
	
	public void draw(Graphics g) {
		Polygon p = getPolygon();
		g.setColor(getFillColor());
		g.fillPolygon(p);
		g.setColor(getFrameColor());
		g.drawPolygon(p);
	}
	
	public Insets connectionInsets() {
		Rectangle r = displayBox();
		return new Insets(r.height/2, r.width/2, r.height/2, r.width/2);
	}

	public boolean containsPoint(int x, int y) {
		return getPolygon().contains(x, y);
	}

	public Point chop(Point p) {
		return PolygonFigure.chop(getPolygon(), p);
	}

	public Connector connectorAt(int x, int y) {
		return new ChopDiamondConnector(this);
	}  

}
