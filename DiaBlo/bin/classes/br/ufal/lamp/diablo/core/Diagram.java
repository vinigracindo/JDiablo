package br.ufal.lamp.diablo.core;

import java.io.Serializable;
import java.util.Vector;

import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.exception.BeginNotFoundException;
import br.ufal.lamp.diablo.exception.EmptyDiagramException;
import br.ufal.lamp.diablo.exception.MoreOneBeginInDiagramExcept;
import br.ufal.lamp.diablo.utils.ExtraMethodsVector;

public class Diagram implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Block> blocks;
	
	public Diagram() {
		blocks = new Vector<Block>();
	}
	
	public void addBlock(Block block) {
		blocks.add(block);
	}

	public Vector<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(Vector<Block> blocks) {
		this.blocks = blocks;
	}
	
	public void isValid() throws EmptyDiagramException, BeginNotFoundException, MoreOneBeginInDiagramExcept {
		if(getBlocks().isEmpty()) {
			throw new EmptyDiagramException();
		}
		int count = ExtraMethodsVector.countOccurrenceBeginTerminal(this.getBlocks());
		if(count > 1) {
			throw new MoreOneBeginInDiagramExcept();
		}
		if(!(count == 1)) {
			throw new BeginNotFoundException();
		}
	}
	
	
}
