package org.labsis.gestione_ristorante.repository.admin;

import org.labsis.gestione_ristorante.entity.admin.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
