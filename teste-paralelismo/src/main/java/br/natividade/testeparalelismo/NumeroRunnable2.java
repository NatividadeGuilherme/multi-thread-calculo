package br.natividade.testeparalelismo;

import java.util.Map;

public class NumeroRunnable2 implements Runnable {

	private Map<Integer, String> nomes;
	private int numero;
	
	public NumeroRunnable2(Map<Integer, String> nomes, int numero) {
		this.nomes = nomes;
		this.numero = numero;
	}
	
	@Override
	public void run() {
		nomes.put(numero, "Guilherme : " + numero);
	}

}
