package br.natividade.testeparalelismo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculoParcelamentoPremioUseCase {

	@Value(value = "${quantidade.Itens.Range}")
	private int quantidadeParcelasThread;

	private final Logger LOGGER = LoggerFactory.getLogger(CalculoParcelamentoPremioUseCase.class);
	
	private Map<Integer, PremioSeguro> mapa = new ConcurrentHashMap<>();

	public List<PremioSeguro> calcularPremioContrato(int numeroParcelaInicial, int numeroParcelaFinal,
			BigDecimal valorImportanciaSegurada) throws InterruptedException {

		List<PremioSeguro> premios = new ArrayList<>();
		

		for (int numeroParcela = numeroParcelaInicial; numeroParcela <= numeroParcelaFinal; numeroParcela += quantidadeParcelasThread) {
			LOGGER.info("Começando calcular para parcela inicial:  " + numeroParcela);
			
			ParametroCalculo parametroCalculo = new ParametroCalculo(numeroParcela, quantidadeParcelasThread,
					valorImportanciaSegurada);

			new Thread(new ThreadCalculoParalelo(mapa, parametroCalculo)).start();
		}
		while(mapa.size() != numeroParcelaFinal)
			System.out.println("Estou aqui");
		
		return premios;
	}
}
