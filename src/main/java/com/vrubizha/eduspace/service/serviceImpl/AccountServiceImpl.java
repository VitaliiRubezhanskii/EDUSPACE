package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.Account;
import com.vrubizha.eduspace.repository.AccountRepository;
import com.vrubizha.eduspace.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findAccountById(int accountId) {
        return accountRepository.findById(accountId).orElseGet(Account::new);

    }
}
