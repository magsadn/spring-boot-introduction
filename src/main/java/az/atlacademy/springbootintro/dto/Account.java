package az.atlacademy.springbootintro.dto;

import java.util.Objects;

public class Account {
    private Long id;
    private String name;
    private String customer;

    public Account(Long id, String name, String customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customer);
    }


}
