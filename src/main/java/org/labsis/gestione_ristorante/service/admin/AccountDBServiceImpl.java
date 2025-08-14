package org.labsis.gestione_ristorante.service.admin;

import lombok.extern.slf4j.Slf4j;
import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.AccountDB;
import org.labsis.gestione_ristorante.repository.admin.AccountDBRepository;
import org.labsis.gestione_ristorante.repository.admin.AccountRepository;
import org.labsis.gestione_ristorante.repository.admin.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class AccountDBServiceImpl implements AccountDBService {
    private final AccountDBRepository repository;
    public AccountDBServiceImpl(AccountDBRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<AccountDB> getAllAccount() {
        return repository.findAll();
    }

    @Override
    public AccountDB saveAccount(AccountDB account) {
        return repository.save(account);
    }
/*
    @Override
    public AccountDB getAccountById(Long id) {
        return repository.findBy(id);
    }
*/
    @Override
    public AccountDB updateAccount(AccountDB account) {
        repository.delete(account);
        repository.flush();
        return repository.save(account);    }

}
