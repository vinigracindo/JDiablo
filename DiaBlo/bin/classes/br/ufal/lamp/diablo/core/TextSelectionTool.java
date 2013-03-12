package br.ufal.lamp.diablo.core;

import java.awt.event.MouseEvent;

import org.jhotdraw.contrib.CustomSelectionTool;
import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.figures.TextTool;
import org.jhotdraw.framework.DrawingEditor;
import org.jhotdraw.framework.Figure;


public class TextSelectionTool extends CustomSelectionTool {
    private TextTool myTextTool;

    public TextSelectionTool(DrawingEditor newEditor) {
        super(newEditor);
        setTextTool(new TextTool(newEditor, new TextFigure()));
    }

    protected void handleMouseDoubleClick(MouseEvent e, int x, int y) {
        Figure figure = drawing().findFigureInside(e.getX(), e.getY());
        if ((figure != null) && (figure instanceof TextFigure)) {
            getTextTool().activate();
            getTextTool().mouseDown(e, x, y);
        }
    }

    protected void handleMouseClick(MouseEvent e, int x, int y) {
        deactivate();
    }
    
    public void deactivate() {
        super.deactivate();
        if (getTextTool().isActive()) {
    	    getTextTool().deactivate();
        }
    }

    protected void setTextTool(TextTool newTextTool) {
        myTextTool = newTextTool;
    }

    protected TextTool getTextTool() {
       return myTextTool;
    }

}
