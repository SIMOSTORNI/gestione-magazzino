package org.labsis.gestione_ristorante.controller.admin;

import org.labsis.gestione_ristorante.entity.admin.Utente;
import org.labsis.gestione_ristorante.service.admin.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreazioneUtenteController {
    private final UtenteService utenteService;

    @Autowired
    public CreazioneUtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping("/createAccount")
    public String registrazioneUtente(Utente utente) {
        utenteService.registrazioneUtente(utente);
        return "magazzino/forniture"; // Pagina di conferma
    }
}
