package org.labsis.gestione_ristorante.service.admin;
import org.labsis.gestione_ristorante.entity.admin.Utente;
import org.labsis.gestione_ristorante.repository.admin.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteServiceImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public Utente registrazioneUtente(Utente utente) {
        return utenteRepository.save(utente);
    }
}
