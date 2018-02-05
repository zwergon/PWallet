/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwalletfx;


import java.util.HashMap;
import java.util.Map;

/**
 * Simple Authenticator service, that checks user logins
 */
public class Authenticator {
    private static final Map<String, String> USERS = new HashMap<String, String>();
    
    static {
        USERS.put("jef", "L7iyzjXB3wCpO+cLdpbfQA==");
    }
    public static boolean validate(String user, String password){
        String encryptedUserPassword = USERS.get(user);
        String validUserPassword = AESencrp.decrypt(encryptedUserPassword);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}