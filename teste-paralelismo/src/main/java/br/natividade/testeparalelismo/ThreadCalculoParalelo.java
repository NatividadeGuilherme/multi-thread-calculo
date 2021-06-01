package br.natividade.testeparalelismo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadCalculoParalelo implements Runnable {

	private int numeroParcelaInicial;
	private int numeroParcelaFinal;
	private Map<Integer, PremioSeguro> mapa = new ConcurrentHashMap<>();
	private final double taxaPrazo = 1.5;
	private BigDecimal valorImportanciaSegurada;
	
	private final Logger LOGGER = LoggerFactory.getLogger(CalculoParcelamentoPremioUseCase.class);
	
	public ThreadCalculoParalelo(Map<Integer, PremioSeguro> mapa, ParametroCalculo parametros) {
		this.numeroParcelaInicial = parametros.getNumeroParcelaInicial();
		this.numeroParcelaFinal = parametros.getNumeroParcelaFinal();
		this.mapa = mapa;
		this.valorImportanciaSegurada = parametros.getValorImportanciaSegurada();
	}
	
	@Override
	public void run() {
		int numeroParcela = 0;
		
		for(numeroParcela = numeroParcelaInicial;  numeroParcela <= numeroParcelaFinal; numeroParcela++) {
			calcularPremio(numeroParcela);
		}
		LOGGER.info("Calculado até a parcela: " + numeroParcela);
		
		LOGGER.info("Nome thread: " + Thread.currentThread().getName());
	}
	
	private void calcularPremio(int numeroParcela) {
		var valorSeguroPorParcelamento = new BigDecimal(valorImportanciaSegurada.doubleValue() * taxaPrazo); 
		var valorParcela = new BigDecimal(valorSeguroPorParcelamento.doubleValue() / numeroParcela);
		
		PremioSeguro premio = new PremioSeguro(numeroParcela, valorSeguroPorParcelamento, valorParcela, new BigDecimal("2.20"));
		mapa.put(numeroParcela, premio);
	}	
}
