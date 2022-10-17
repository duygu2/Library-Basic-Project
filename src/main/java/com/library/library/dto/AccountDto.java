package com.library.library.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private String id;
    private String name;
    private String address;
    private String telephone;
    private Integer dateOfBirth;
}
