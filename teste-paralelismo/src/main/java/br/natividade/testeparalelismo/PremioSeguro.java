package br.natividade.testeparalelismo;

import java.math.BigDecimal;

public class PremioSeguro {
	private int numeroParcela;
	private BigDecimal valorPremio;
	private BigDecimal valorPremioParcela;
	private BigDecimal valorIof;

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public BigDecimal getValorPremio() {
		return valorPremio;
	}

	public BigDecimal getValorPremioParcela() {
		return valorPremioParcela;
	}

	public BigDecimal getValorIof() {
		return valorIof;
	}

	public PremioSeguro(int numeroParcela, BigDecimal valorPremio, BigDecimal valorPremioParcela,
			BigDecimal valorIof) {
		this.numeroParcela = numeroParcela;
		this.valorPremio = valorPremio;
		this.valorPremioParcela = valorPremioParcela;
		this.valorIof = valorIof;
	}

}
