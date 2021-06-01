package br.natividade.testeparalelismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TesteParalelismoApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext run = SpringApplication.run(TesteParalelismoApplication.class, args);
//		CalculoParcelamentoPremioUseCase calculo = run.getBean(CalculoParcelamentoPremioUseCase.class);
//		
//		List<PremioSeguro> premios = calculo.calcularPremioContrato(1, 20, new BigDecimal("2000.0"));
//		
//		System.out.println(premios.size());
		Executor bean = run.getBean(Executor.class);
//		Executor2 bean2 = run.getBean(Executor2.class);
		
		bean.calculaPremioSeguro(1, 500000);
//		bean2.calculaPremioSeguro(1, 500000);
		
	}

}
