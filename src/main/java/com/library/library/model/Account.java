package com.library.library.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    private String id;

    private String name;
    private String address;
    private String telephone;
    private Integer dateOfBirth;
}
