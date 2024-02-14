package com.esisba.first.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "pr1", types = Account.class)
public interface ProjectionAccount {
    public Long getIdAccount();

    public String getLogin();

    @Value("#{target.client.email}")
    public String getEmail();

    public String getPassword();

    public Date getDateCreation();
}
