package com.esisba.first.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long idClient;
    private String login;
    private String password;

}
