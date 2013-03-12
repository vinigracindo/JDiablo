package br.ufal.lamp.diablo.core;

import java.awt.Insets;

import org.jhotdraw.contrib.GraphicalCompositeFigure;
import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.framework.Figure;


public abstract class BlockText extends Block {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4451569145942197403L;
	
	
	protected String myText;
	protected boolean is_editable;
	
	protected void initialize(BlockText block) throws InstantiationException, IllegalAccessException {
        removeAll();
        setModellerClass(new JDiabloClass(block.getText(), this));
        setClassNameFigure(new TextFigure() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1475009502813186356L;

			public void setText(String newText) {
                super.setText(newText);
                getModellerClass().setName(newText);
                update();
            }
        });
        getClassNameFigure().setText(getModellerClass().getName());
        GraphicalCompositeFigure nameFigure;
        nameFigure = new GraphicalCompositeFigure((block.getFigure().getClass().newInstance()));
        nameFigure.add(getClassNameFigure());
        nameFigure.getLayouter().setInsets(new Insets(5, 20, 5, 20));
        //nameFigure.setZValue(JDiabloApplication.cont);
        add(nameFigure);
        super.initialize();
    }
	
	public BlockText(Figure newPresentationFigure, int numberMaxChildren, String myText, boolean is_editable) {
		super(newPresentationFigure, numberMaxChildren);
		this.setText(myText);
		this.setEditable(is_editable);
	}
		
	public String getText() {
		return myText;
	}

	public void setText(String myText) {
		this.myText = myText;
	}
	
	public boolean isEditable() {
		return this.is_editable;
	}
	
	public void setEditable(boolean is_editable) {
		this.is_editable = is_editable;
	}

}
