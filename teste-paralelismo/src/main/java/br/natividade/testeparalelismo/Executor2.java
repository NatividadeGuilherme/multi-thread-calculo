package br.natividade.testeparalelismo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
@Component
public class Executor2 {
	
	Map<Integer, String> nomes = new ConcurrentHashMap<>();
	
	public void calculaPremioSeguro(int parcelaInical, int parcelaFinal) throws InterruptedException {
		long start = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		for(int x = parcelaInical; x <= parcelaFinal; x++) {
			NumeroRunnable2 numeroRunnable2 = new NumeroRunnable2(nomes, x);
			executorService.execute(numeroRunnable2);
		}
		
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);
		
		System.out.println("Terminou");
		System.out.println(nomes.size());
		System.out.println("Demorou: " + (System.currentTimeMillis() - start));
	}
	
			
}
