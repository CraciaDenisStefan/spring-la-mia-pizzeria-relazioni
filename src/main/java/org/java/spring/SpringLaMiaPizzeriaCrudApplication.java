package org.java.spring;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serve.Pizzeriaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	@Autowired
	private Pizzeriaservice pizzeriaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		pizzeriaService.save(new Pizza("Margherita", "Mozzarella, pomodoro, basilico", "https://zenideen.com/wp-content/uploads/2020/06/pizza-mozzarella-tomaten-scaled.jpeg", 5.50));
		pizzeriaService.save(new Pizza("Pepperoni", "Mozzarella, pepperoni", "https://sifu.unileversolutions.com/image/pl-PL/recipe-topvisual/2/1260-709/pizza-peperoni-50531704.jpg", 8.50));
		pizzeriaService.save(new Pizza("Funghi", "Mozzarella, funghi", "https://cdn.gutekueche.de/media/recipe/5500/conv/pizza-funghi-default.jpg", 7.00));
		pizzeriaService.save(new Pizza("Quattro Formaggi", "Mozzarella, gorgonzola, parmigiano, ricotta", "https://www.expresschef.ro/wp-content/uploads/2016/08/Pizza-Quattro-Formaggi.jpg", 9.00));
		pizzeriaService.save(new Pizza("Prosciutto e Funghi", "Mozzarella, prosciutto cotto, funghi", "https://andipizza.ro/wp-content/uploads/2020/11/Pizza-prosciutto-funghi-scaled-1.jpg", 8.00));
		pizzeriaService.save(new Pizza("Capricciosa", "Mozzarella, pomodoro, prosciutto cotto, funghi, olive nere", "https://donpizzone.com/wp-content/uploads/2020/05/Pizza-Capriciosa.jpg", 10.00));
		pizzeriaService.save(new Pizza("Diavola", "Mozzarella, pomodoro, salame piccante", "https://imagizr.com/1200_628/cdn.pizzamatch.com/1/11/1366722064-diavola-orig.JPG", 8.50));
		pizzeriaService.save(new Pizza("Rustica", "Mozzarella, pomodoro, salsiccia, patate, rosmarino", "https://pizza-rustica.com/wp-content/uploads/revslider/home-t03/hs-01.jpg", 10.50));

	
	}

}
