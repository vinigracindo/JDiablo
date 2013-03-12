package br.ufal.lamp.diablo.core;

import java.awt.Insets;

import org.jhotdraw.contrib.GraphicalCompositeFigure;
import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.framework.Figure;

import br.ufal.lamp.diablo.core.block.BeginTerminal;


public abstract class Block extends GraphicalCompositeFigure {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 173776893540758792L;
	
	protected final int 	numberMaxChildren;	
	protected JDiabloClass 	myClass;
	protected TextFigure	myClassNameFigure;
	protected Figure		myFigure;
	
	public abstract boolean canConnectWith(Block block);
	
	
	protected void initialize(Block block) throws InstantiationException, IllegalAccessException {
		removeAll();
        setModellerClass(new JDiabloClass("", this));
        setClassNameFigure(new TextFigure() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3078598990411458813L;

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
	public Block(Figure newPresentationFigure, int numberMaxChildren) {
        super(newPresentationFigure);
        this.setFigure(newPresentationFigure);
        this.numberMaxChildren = numberMaxChildren;
    }
	protected void setClassNameFigure(TextFigure newClassNameFigure) {
        myClassNameFigure = newClassNameFigure;
    }
    
    public TextFigure getClassNameFigure() {
        return myClassNameFigure;
    }
	
	protected void setModellerClass(JDiabloClass newClass) {
        myClass = newClass;
    }
	
	public JDiabloClass getModellerClass() {
        return myClass;
    }
	
	public int getNumberMaxChildren() {
		return numberMaxChildren;
	}
	
	public Figure getFigure() {
		return myFigure;
	}

	public void setFigure(Figure myFigure) {
		this.myFigure = myFigure;
	}
	
	protected boolean hasCapacity() {
		return (this.getNumberMaxChildren() >= this.getModellerClass().getChildrenBlock().size() + 1);
	}
	
	protected boolean canConnect(Block block) {
		if(hasCapacity() 					 	&& 
		   this != block						&&
		   !(block instanceof BeginTerminal)	&&
		   canConnectWith(block)){
			return true;
		}
		return false;
	}

}
