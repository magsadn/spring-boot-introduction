package az.atlacademy.springbootintro.controller;

import az.atlacademy.springbootintro.dto.Account;
import az.atlacademy.springbootintro.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {

        return ResponseEntity.ok(accountService.getList());
    }

    @GetMapping(value = "/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable("accountId") Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping(value = "/query")
    public ResponseEntity<Account> getAccountByIdQuery(@RequestParam("id") Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.create(account));
    }

    @PutMapping//"/put" - ne istesem yaza bilerem, ancaq put edende onu secmeliyem url-de
    public ResponseEntity<Account> update(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.update(account));
    }

    @DeleteMapping
    public ResponseEntity<Account> delete(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.delete(account));
    }
    @DeleteMapping(value = "/{accountId}")
    public ResponseEntity<Account> deleteById(@PathVariable ("accountId") Long id){
        return ResponseEntity.ok(accountService.deleteById(id));
    }

    @DeleteMapping(value = "/query{id}")
    public ResponseEntity<Account> deleteByIdQuery(@RequestParam ("id") Long id){
        return ResponseEntity.ok(accountService.deleteById(id));
    }


}
