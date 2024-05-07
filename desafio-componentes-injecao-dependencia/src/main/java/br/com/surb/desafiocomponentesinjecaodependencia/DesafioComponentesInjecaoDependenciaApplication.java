package br.com.surb.desafiocomponentesinjecaodependencia;

import br.com.surb.desafiocomponentesinjecaodependencia.entities.Order;
import br.com.surb.desafiocomponentesinjecaodependencia.services.OrderService;
import br.com.surb.desafiocomponentesinjecaodependencia.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioComponentesInjecaoDependenciaApplication implements CommandLineRunner {

	private final OrderService orderService;

	public DesafioComponentesInjecaoDependenciaApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioComponentesInjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order1 = new Order(1034, 150.00, 20.0);
		double total1 = orderService.total(order1);
		System.out.println("Exemplo 1 => ");
		System.out.println("Pedido código => " + order1.getCode());
		System.out.printf("Valor total => %.2f %n", total1);

		Order order2 = new Order(2282, 800.00, 10.0);
		double total2 = orderService.total(order2);
		System.out.println("Exemplo 2 => ");
		System.out.println("Pedido código => " + order2.getCode());
		System.out.printf("Valor total => %.2f %n", total2);

		Order order3 = new Order(1309, 95.90, 0.0);
		double total3 = orderService.total(order3);
		System.out.println("Exemplo 3 => ");
		System.out.println("Pedido código => " + order3.getCode());
		System.out.printf("Valor total => %.2f %n", total3);
	}
}
