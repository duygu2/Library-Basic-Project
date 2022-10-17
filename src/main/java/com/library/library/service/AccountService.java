package com.library.library.service;

import com.library.library.dto.AccountDto;
import com.library.library.dto.AccountDtoConverter;
import com.library.library.dto.CreateAccountRequest;
import com.library.library.dto.UpdateAccountRequest;
import com.library.library.model.Account;
import com.library.library.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, AccountDtoConverter accountDtoConverter) {

        this.accountRepository = accountRepository;
        this.accountDtoConverter = accountDtoConverter;
    }

    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();

        List<AccountDto> accountDtoList= new ArrayList<>();
        for(Account account: accounts){
            accountDtoList.add(accountDtoConverter.convert(account));
        }
        return accountDtoList;
    }

    public AccountDto getAccountDtoById(String id) {
       Optional<Account> accountOptional=accountRepository.findById(id);
       return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Account account=new Account();
        account.setId(createAccountRequest.getId());
        account.setName(createAccountRequest.getName());
        account.setAddress(createAccountRequest.getAddress());
        account.setDateOfBirth(createAccountRequest.getDateOfBirth());
        account.setTelephone(createAccountRequest.getTelephone());

        accountRepository.save(account);

        return accountDtoConverter.convert(account);
    }

    public AccountDto updateAccount(String id, UpdateAccountRequest updateAccountRequest) {
        Optional<Account> accountOptional= accountRepository.findById(id);

       accountOptional.ifPresent(account -> {
           account.setName(updateAccountRequest.getName());
           account.setAddress(updateAccountRequest.getAddress());
           account.setTelephone(updateAccountRequest.getTelephone());
           account.setDateOfBirth(updateAccountRequest.getDateOfBirth());
           accountRepository.save(account);
           });

       return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }

    public void deleteAccount(String id){
        accountRepository.deleteById(id);
    }
}
