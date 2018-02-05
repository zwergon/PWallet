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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    
     Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @Autowired
    HelloService helloService;
    
    @RequestMapping(  method = RequestMethod.GET )
    public String printHello( ModelMap model ){
        model.addAttribute("message",  helloService.getName() );
        return "hello";
    }
}
