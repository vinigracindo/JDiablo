package br.ufal.lamp.diablo.core;

import java.io.Serializable;
import java.util.Vector;

public class JDiabloClass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String					myName;
	private Vector<JDiabloClass>	myChildrenBlock;
	private Block					typeBlock;
	private int myID;
	
	public void setID(int id){
		myID = id;
	}
	public int getID() {
		return myID;
	}
	
	public Block getBlock() {
		return typeBlock;
	}
	
	public JDiabloClass(String newClassName, Block block) {
		setName(newClassName);
		this.typeBlock = block;
		myChildrenBlock = new Vector<JDiabloClass>();
    }	
	
	public void addChildrenClass(JDiabloClass newSuperClass) {
		myChildrenBlock.addElement(newSuperClass);
    }

    public void removeSuperclass(JDiabloClass oldSuperClass) {
    	myChildrenBlock.remove(oldSuperClass);
    }
    
	public String getName() {
		return myName;
	}

	public void setName(String myName) {
		this.myName = myName;
	}
	
	public Vector<JDiabloClass> getChildrenBlock() {
		return myChildrenBlock;
	}
	
	public void setChildrenBlock(Vector<JDiabloClass> myChildrenBlock) {
		this.myChildrenBlock = myChildrenBlock;
	}

	public boolean hasChildren(){
		if(this.getChildrenBlock().size() > 0){
			return true;
		}
		return false;
	}
	
}
