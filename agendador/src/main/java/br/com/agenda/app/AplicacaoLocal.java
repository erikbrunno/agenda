package br.com.agenda.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EntityScan("br.com.agenda.modelo")
@EnableJpaRepositories(basePackages = { "br.com.agenda.dao" })
@ComponentScan(basePackages = { "br.com.agenda" })
public class AplicacaoLocal {

    public static void main(String[] args) {
	SpringApplication.run(AplicacaoLocal.class, args);
    }

    // Para resolve o Same Origin Policy
    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurerAdapter() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		// registry.addMapping("/greeting-javaconfig").allowedOrigins(URL);
		registry.addMapping("/**").allowedOrigins("*");
	    }
	};
    }

}
