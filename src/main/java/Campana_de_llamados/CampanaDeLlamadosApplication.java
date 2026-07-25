package Campana_de_llamados;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"controller", "dao", "service", "scheduler"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"dao"})
@EnableScheduling
@SpringBootApplication
public class CampanaDeLlamadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampanaDeLlamadosApplication.class, args);
	}

}
