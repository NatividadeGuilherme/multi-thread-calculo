package br.natividade.testeparalelismo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
@Component
public class Executor {
	
	Map<Integer, String> nomes = new ConcurrentHashMap<>();
	
//	@Value(value = "${quantidade.Itens.Range}")
	
	public void calculaPremioSeguro(int parcelaInical, int parcelaFinal) throws InterruptedException {
		long start = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		for(int x = parcelaInical; x <= parcelaFinal; x += 100000) {
			NumeroRunnable numeroRunnable = new NumeroRunnable(x, x + 99999, nomes);
			executorService.execute(numeroRunnable);
		}
		
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);
		
		System.out.println("Terminou");
		System.out.println(nomes.size());
		System.out.println("Demorou: " + (System.currentTimeMillis() - start));
	}
	
			
}
