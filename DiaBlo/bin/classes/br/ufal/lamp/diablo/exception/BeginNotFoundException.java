package br.ufal.lamp.diablo.exception;

public class BeginNotFoundException extends Exception {
	public BeginNotFoundException() {
		super("O diagrama precisa ter um Terminal Início.");
	}
}
