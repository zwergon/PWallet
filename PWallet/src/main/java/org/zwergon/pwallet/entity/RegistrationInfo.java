/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwallet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegistrationInfo {

    @Id
    @GeneratedValue
    Long id;

    String company;

    String login;

    String passwd;

    String detail;

    String comment;
    
    public RegistrationInfo(){
    }

    public RegistrationInfo(
            Long id, 
            String company, 
            String login, 
            String passwd, 
            String detail, 
            String comment) {
        this.id = id;
        this.company = company;
        this.login = login;
        this.passwd = passwd;
        this.detail = detail;
        this.comment = comment;
    }
    
      public RegistrationInfo(
            Long id, 
            String company, 
            String login, 
            String passwd) {
        this.id = id;
        this.company = company;
        this.login = login;
        this.passwd = passwd;
    }
    
    

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", login=" + login + ", passwd=" + passwd + "]";
    }

}
