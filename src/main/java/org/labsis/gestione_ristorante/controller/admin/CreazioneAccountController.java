package org.labsis.gestione_ristorante.controller.admin;

import org.labsis.gestione_ristorante.entity.admin.AccountDB;
import org.labsis.gestione_ristorante.service.admin.AccountDBService;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.labsis.gestione_ristorante.entity.admin.Encoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/magazzino")
public class CreazioneAccountController {
    private static final String createAccount = "magazzino/createAccunt";
    private AccountService accountService;
    private AccountDBService accountDBService;
    private Encoder encoder;
    @Autowired
    public CreazioneAccountController(AccountService accountService, AccountDBService accountDBService){
        this.accountService = accountService;
        this.accountDBService = accountDBService;
        this.encoder = new Encoder();
    }

    @PostMapping("/createAccount")
    public String creaUser(@RequestParam("username")String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        if(!checkUserExist(username,password)) {
            try {
                String passHash = encoder.hashPassword(password);
                AccountDB account = new AccountDB(username, email, passHash);
                accountDBService.saveAccount(account);
                return "magazzino/forniture";
            } catch (Exception e) {
                // Logga l'eccezione o ritorna un messaggio di errore
                e.printStackTrace();
                return "magazzino/createAccount";
            }
        }
        return "magazzino/accedi";
    }

  @GetMapping(value="/createAccount")
   public String accesso(){
       return "magazzino/createAccount";
   }

    private boolean checkUserExist(String param, String pass){
        List<AccountDB> account = accountDBService.getAllAccount();
        for(AccountDB a:account) {
            if (a.getUsername().equals(param)) //utente esiste
                return true;
            }
            return false;
        }
}
