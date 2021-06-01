package br.natividade.testeparalelismo;

import java.util.Map;

public class NumeroRunnable implements Runnable {

	private int numeroIncialConsiderar;
	private int numeroFinalConsiderar;
	private Map<Integer, String> nomes;
	
	public NumeroRunnable(int numeroInicialConsiderar, int numeroFinalConsiderar, Map<Integer, String> nomes) {
		this.numeroIncialConsiderar = numeroInicialConsiderar;
		this.numeroFinalConsiderar = numeroFinalConsiderar;
		this.nomes = nomes;
	}
	
	@Override
	public void run() {
		for(int i = numeroIncialConsiderar; i <= numeroFinalConsiderar; i++) {
			nomes.put(i, "Guilherme: " + i);
		}
	}

}
