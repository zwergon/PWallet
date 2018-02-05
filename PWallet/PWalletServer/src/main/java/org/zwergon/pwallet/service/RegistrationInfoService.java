package org.zwergon.pwallet.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwergon.pwallet.dao.RegistrationInfoRepository;
import org.zwergon.pwallet.entity.RegistrationInfo;

/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
/**
 *
 * @author lecomtje
 */
@Service
public class RegistrationInfoService {

    Logger logger = LoggerFactory.getLogger(RegistrationInfoService.class);

    @Autowired
    private RegistrationInfoRepository repository;

    public RegistrationInfoService() {
        logger.debug("RegistrationInfoService");
    }

    public Iterable<RegistrationInfo> getRegistrationInfos() {
        return repository.findAll();
    }

    public RegistrationInfo getRegistrationInfo(long id) {
        return repository.findOne(id);
    }

    public RegistrationInfo save(RegistrationInfo info) {
        return repository.save(info);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public void update(RegistrationInfo info) {
        logger.debug( info.toString() );
        
        repository.save(info);
    }

}
