package com.dotmkey.simplebankingsystem.infrastructure.domain.model.accountrepository;

import com.dotmkey.simplebankingsystem.domain.model.Account;
import com.dotmkey.simplebankingsystem.domain.model.AccountRepository;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryAccountRepository implements AccountRepository {

    private final HashMap<String, Account> storage = new HashMap<>();

    @Override
    public void save(Account account) {
        this.storage.put(account.cardNumber(), account);
    }

    @Override
    public Optional<Account> ofCardNumber(String cardNumber) {
        return Optional.ofNullable(this.storage.get(cardNumber));
    }

    @Override
    public void remove(Account account) {
        this.storage.remove(account.cardNumber());
    }
}
