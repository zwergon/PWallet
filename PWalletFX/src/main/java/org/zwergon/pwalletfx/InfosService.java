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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author lecomtje
 */
public class InfosService {

    static String BASEURL = "http://localhost:8080/PWallet/infos";

    public static RegistrationInfoDto getInfo(long id) {

        String urlGetAll = BASEURL + "/" + id;

        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<RegistrationInfoDto> entities = new HttpEntity<RegistrationInfoDto>(headers);

        ResponseEntity<RegistrationInfoDto> result = restTemplate.exchange(urlGetAll, HttpMethod.GET, entities, RegistrationInfoDto.class);

        return result.getBody();

    }

    public static void save(RegistrationInfoDto info) {

        String urlSave = BASEURL + "/save";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RegistrationInfoDto> entity = new HttpEntity<RegistrationInfoDto>(info, headers);

        RestTemplate restTemplate = new RestTemplate();

        try {

            restTemplate.exchange(urlSave, HttpMethod.POST, entity, RegistrationInfoDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public static void update(RegistrationInfoDto info) {

        String urlSave = BASEURL + "/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RegistrationInfoDto> entity = new HttpEntity<RegistrationInfoDto>(info, headers);

        RestTemplate restTemplate = new RestTemplate();

        try {

            ResponseEntity<RegistrationInfoDto> response = restTemplate.exchange(urlSave, HttpMethod.PUT, entity, RegistrationInfoDto.class);
            
            System.out.println( response.getStatusCode() );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
      public static void delete(long id) {

          String urlDelete = BASEURL + "/delete/" + id;
          HttpHeaders headers = new HttpHeaders();

          RestTemplate restTemplate = new RestTemplate();

          HttpEntity<RegistrationInfoDto> entities = new HttpEntity<RegistrationInfoDto>(headers);

          restTemplate.exchange(urlDelete, HttpMethod.DELETE, entities, RegistrationInfoDto.class);
      
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
