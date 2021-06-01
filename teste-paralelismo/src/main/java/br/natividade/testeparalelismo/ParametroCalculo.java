package br.natividade.testeparalelismo;

import java.math.BigDecimal;

public class ParametroCalculo {
	private int numeroParcelaInicial;
	private int numeroParcelaFinal;
	private BigDecimal valorImportanciaSegurada;

	public ParametroCalculo(int numeroParcelaInicial, int numeroParcelaFinal, BigDecimal valorImportanciaSegurada) {
		this.numeroParcelaInicial = numeroParcelaInicial;
		this.numeroParcelaFinal = numeroParcelaFinal;
		this.valorImportanciaSegurada = valorImportanciaSegurada;
	}

	public int getNumeroParcelaInicial() {
		return numeroParcelaInicial;
	}

	public int getNumeroParcelaFinal() {
		return numeroParcelaFinal;
	}

	public BigDecimal getValorImportanciaSegurada() {
		return valorImportanciaSegurada;
	}

}
