package az.atlacademy.springbootintro.service;

import az.atlacademy.springbootintro.dto.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {
    private static List<Account> accounts = new ArrayList<>();
    static {
        accounts.add(new Account(1L,"ACC001AZN","Anar Xocayev"));
        accounts.add(new Account(2L,"ACC004AZN","Nihad Aliyev"));
        accounts.add(new Account(3L,"ACC002AZN","Kamil Aliyev"));
        accounts.add(new Account(4L,"ACC003AZN","Vuqar Sadiqov"));
        accounts.add(new Account(5l,"ACC006AZN","Araz Ismayilov"));
    }

    public List<Account> getList() {
        return accounts;
    }

    public Account getAccountById(Long id) {
        return accounts.stream().filter(a->a.getId().equals(id)).findFirst().get();
    }

    public Account create(Account account) {
        account.setId((long) Math.random()*100);
        accounts.add(account);
        return account;
    }

    public Account update(Account account){
        Account forUpdate = getAccountById(account.getId());
        forUpdate.setId(account.getId());
        forUpdate.setName(account.getName());
        forUpdate.setCustomer(account.getCustomer());
        return forUpdate;
    }

    public Account delete(Account account) {
        Account forDelete = getAccountById(account.getId());
        accounts.remove(forDelete);
        return account;
    }

    public Account deleteById(Long id) {
        Account forDelete = getAccountById(id);
        accounts.remove(forDelete);
        return forDelete;
    }
}
