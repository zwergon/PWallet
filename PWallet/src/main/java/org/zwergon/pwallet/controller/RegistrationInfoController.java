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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*@RequestMapping(
            value = "/{id}.xml",
            method = RequestMethod.GET,
            produces = "application/xml")
    public @ResponseBody
    Employee getEmployeeInXml(@PathVariable String id) {
        return employeeDao.getEmployeeById(Integer.parseInt(id));
    }

    @RequestMapping(
            value = "/save",
            method = RequestMethod.POST)
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {

        try {
            employeeDao.save(employee);
            return new ResponseEntity<Employee>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {

        try {
            employeeDao.update(employee);
            return new ResponseEntity<Employee>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE,
            headers = "Accept=application/json")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {

        try {
            employeeDao.delete(id);
            return new ResponseEntity<Employee>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }

    }*/

}
