package com.library.library.dto;

import com.library.library.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {
    public AccountDto convert(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .address(account.getAddress())
                .dateOfBirth(account.getDateOfBirth())
                .telephone(account.getTelephone())
                .build();
    }
}
