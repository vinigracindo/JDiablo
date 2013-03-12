package br.ufal.lamp.diablo.core;

import java.awt.Insets;

import org.jhotdraw.contrib.GraphicalCompositeFigure;
import org.jhotdraw.figures.RoundRectangleFigure;
import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.framework.Figure;

import br.ufal.lamp.diablo.exception.OverCapacity;
import br.ufal.lamp.diablo.utils.DefaultNameToBlock;
import br.ufal.lamp.diablo.utils.DefaultTextToBlock;
import br.ufal.lamp.diablo.utils.ExtraMethodsVector;
import br.ufal.lamp.diablo.utils.NumberMaxChildren;


public class EndTerminal extends Terminal {
	
	public EndTerminal(Figure newPresentationFigure) {
		super(newPresentationFigure, NumberMaxChildren.NUMBER_CHILDREN_MAX_END_TERMINAL, DefaultTextToBlock.TEXT_END_TERMINAL);
	}

	protected void initialize() {
        removeAll();
        setModellerClass(new JDiabloClass(this.giveMeId(), DefaultNameToBlock.NAME_END_TERMINAL, this.getNumberMaxChildren()));
        setClassNameFigure(new TextFigure() {
            public void setText(String newText) {
                super.setText(newText);
                getModellerClass().setName(newText);
                update();
            }
        });
        getClassNameFigure().setText(getModellerClass().getName());
        GraphicalCompositeFigure nameFigure;
        nameFigure = new GraphicalCompositeFigure(new RoundRectangleFigure());
        nameFigure.add(getClassNameFigure());
        nameFigure.getLayouter().setInsets(new Insets(5, 20, 5, 20));
        add(nameFigure);
        super.initialize();
    }
	
	@Override
	public boolean PolicyRules(Block block) {
		return true;
	}
	
}
