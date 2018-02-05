/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zwergon.pwallet.entity.RegistrationInfo;
import org.zwergon.pwallet.service.RegistrationInfoService;

@RestController
@RequestMapping("/infos")
public class RegistrationInfoController {

    Logger logger = LoggerFactory.getLogger(RegistrationInfoController.class);

    @Autowired
    RegistrationInfoService service;

    @GetMapping
    public ResponseEntity<Iterable<RegistrationInfo>> list() {
        Iterable<RegistrationInfo> infos = service.getRegistrationInfos();
        if (!infos.iterator().hasNext()) {
            return new ResponseEntity<Iterable<RegistrationInfo>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Iterable<RegistrationInfo>>(infos, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json")
    public @ResponseBody
    RegistrationInfo getEmployeeInJson(@PathVariable String id) {
        return service.getRegistrationInfo(Integer.parseInt(id));
    }

   
    @PostMapping(value = "/save")
    public ResponseEntity<RegistrationInfo> save(@RequestBody RegistrationInfo employee) {

        try {
            service.save(employee);
            return new ResponseEntity<RegistrationInfo>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<RegistrationInfo>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping( value = "/update" )
    public ResponseEntity<RegistrationInfo> update(@RequestBody RegistrationInfo employee) {
        try {
            logger.debug("should update...");
            service.update(employee);
            return new ResponseEntity<RegistrationInfo>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<RegistrationInfo>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(
            value = "/delete/{id}",
            headers = "Accept=application/json")
    public ResponseEntity<RegistrationInfo> deleteEmployee(@PathVariable("id") int id) {

        try {
            service.delete(id);
            return new ResponseEntity<RegistrationInfo>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<RegistrationInfo>(HttpStatus.BAD_REQUEST);
        }

    }

}
