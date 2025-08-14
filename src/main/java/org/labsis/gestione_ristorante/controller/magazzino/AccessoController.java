package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.AccountDB;
import org.labsis.gestione_ristorante.entity.admin.AccountKey;
import org.labsis.gestione_ristorante.entity.admin.Encoder;
import org.labsis.gestione_ristorante.service.admin.AccountDBService;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.labsis.gestione_ristorante.service.admin.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/magazzino")
public class AccessoController {

    private AccountService accountService;
    private AccountDBService accountDBService;
    private Encoder encoder;
    @Autowired
    public AccessoController(AccountService accountService,AccountDBService accountDBService){
        this.accountService = accountService;
        this.accountDBService = accountDBService;
        this.encoder = new Encoder();
    }
    @PostMapping("/accedi")
    public String esisteUser(@RequestParam("username") String param,@RequestParam("password") String pass){
        if(checkUserExist(param,pass)) {
            return "magazzino/logged";
        }
        return "magazzino/accedi";
    }
    private boolean checkUserExist(String param, String pass){
        List<AccountDB> account = accountDBService.getAllAccount();
        for(AccountDB a:account)
            if(a.getUsername().equals(param) && encoder.verifyPassword(pass,a.getPassword()))
                return true;
        return false;
    }

    @GetMapping(value="/accedi")
    public String accesso(){
        return "magazzino/accedi";
    }

}
