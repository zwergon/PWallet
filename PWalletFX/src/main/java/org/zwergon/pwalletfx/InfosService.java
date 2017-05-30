/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwalletfx;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author lecomtje
 */
public class InfosService {

    static String BASEURL = "http://localhost:8080/PWallet/infos";
    
    
    public static RegistrationInfoDto getInfo( long id ){
        
        String urlGetAll = BASEURL + "/" + id;

        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<RegistrationInfoDto> entities = new HttpEntity<RegistrationInfoDto>(headers);

        ResponseEntity<RegistrationInfoDto> result = restTemplate.exchange(urlGetAll, HttpMethod.GET, entities, RegistrationInfoDto.class);

        return result.getBody();
        
    }
    

    public static RegistrationInfoDto[] getInfos() {
        
        String urlGetAll = BASEURL;

        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<RegistrationInfoDto[]> entities = new HttpEntity<RegistrationInfoDto[]>(headers);

        ResponseEntity<RegistrationInfoDto[]> result = restTemplate.exchange(urlGetAll, HttpMethod.GET, entities, RegistrationInfoDto[].class);

        RegistrationInfoDto[] infos = result.getBody();

        return infos;

    }
}
