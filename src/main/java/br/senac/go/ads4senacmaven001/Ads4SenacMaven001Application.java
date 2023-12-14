package br.senac.go.ads4senacmaven001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "br.senac.go.ads4senacmaven001.repositories")
@EntityScan("br.senac.go.ads4senacmaven001.domain")

/*@ComponentScan("com.lapots.breed.platform.cloud.boot")
@EnableJpaRepositories("com.lapots.breed.platform.cloud.boot.repository")
@EntityScan("com.lapots.breed.platform.cloud.boot.domain")*/
public class Ads4SenacMaven001Application {

    public static void main(String[] args) {
        //Springapp
        SpringApplication.run(Ads4SenacMaven001Application.class);
    }
}
