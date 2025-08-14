package org.labsis.gestione_ristorante;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.labsis.gestione_ristorante.service.admin.SocioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
*/

import java.sql.Date;

/**
 * TODO: Documentazione
 */

@SpringBootApplication
//@EnableAdminServer
public class GestioneRistoranteApplication {

    private static final Logger log = LoggerFactory.getLogger(GestioneRistoranteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GestioneRistoranteApplication.class, args);
    }

    @Bean
    CommandLineRunner run(SocioService socioService, AccountService accountService) {
        return args -> {
            Account ac = new Account("am8", "antoniomon@gmail.com",
                    "admin");
            Socio admin = new Socio();
            admin.setCodiceFiscale("mntntn82");
            admin.setNome("Antonio");
            admin.setCognome("Montera");
            admin.setDataDiNascita(new java.sql.Date(1982, 4, 8));
            admin.setIndirizzo("Via Martiri 22");
            admin.setCitta("Como");
            admin.setAccount(ac);
            accountService.saveAccount(ac);
            socioService.saveSocio(admin);
        };
    }
}
