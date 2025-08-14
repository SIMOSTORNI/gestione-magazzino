package org.labsis.gestione_ristorante.service.admin;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.AccountDB;
import org.labsis.gestione_ristorante.entity.admin.AccountKey;

import java.util.List;

public interface AccountDBService {
    List<AccountDB> getAllAccount();
    AccountDB saveAccount(AccountDB account);
    //AccountDB getAccountById(Long id);
    AccountDB updateAccount(AccountDB account);
}
