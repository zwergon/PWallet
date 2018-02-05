/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwallet.dao;

import org.springframework.data.repository.CrudRepository;
import org.zwergon.pwallet.entity.RegistrationInfo;

/**
 *
 * @author lecomtje
 */
public interface RegistrationInfoRepository extends CrudRepository<RegistrationInfo, Long>{
        RegistrationInfo findByCompany( String company );
}
