package br.ufal.lamp.diablo.core;

import java.util.Vector;

public class Tesste {
	
	public static void main(String[] args) {
		Vector<String> vetor = new Vector<String>(2);
		vetor.add("alo");
		vetor.add("alo");
		if(!((vetor.size() + 1) > vetor.capacity()))
			vetor.add("alo");
		System.out.println(vetor.size());
	}

}
