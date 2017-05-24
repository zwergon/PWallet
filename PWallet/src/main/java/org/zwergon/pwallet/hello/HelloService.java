/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwallet.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    
    Logger logger = LoggerFactory.getLogger(HelloService.class);
               
    @Autowired
    private Name name;

    public HelloService() {
        logger.debug("HelloService");
    }
    
    public String getName(){
        logger.debug("getName");
        return name.getValue();
    }
    
}
