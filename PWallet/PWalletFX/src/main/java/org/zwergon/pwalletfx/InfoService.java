/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 *
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.zwergon.pwalletfx;

import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author lecomtje
 */
public class InfoService {

    //static String BASEURL = "http://89.2.75.134:7070/PWallet-1.0/infos";

    static String BASEURL = "http://localhost:8080/PWallet/infos";

    static SimpleClientHttpRequestFactory clientHttpRequestFactory;

    static {
        clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        /*Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("irproxyweb1", 8082));
        clientHttpRequestFactory.setProxy(proxy);*/
    }

    public static RegistrationInfoDto getInfo(long id) {

        String urlGetAll = BASEURL + "/" + id;

        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        HttpEntity<RegistrationInfoDto> entities = new HttpEntity<RegistrationInfoDto>(headers);

        ResponseEntity<RegistrationInfoDto> result = restTemplate.exchange(urlGetAll, HttpMethod.GET, entities, RegistrationInfoDto.class);

        return result.getBody();

    }

    public static void save(RegistrationInfoDto info) {

        String urlSave = BASEURL + "/save";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RegistrationInfoDto> entity = new HttpEntity<RegistrationInfoDto>(info, headers);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

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

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        try {

            ResponseEntity<RegistrationInfoDto> response = restTemplate.exchange(urlSave, HttpMethod.POST, entity, RegistrationInfoDto.class);

            System.out.println(response.getStatusCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void delete(long id) {

        String urlDelete = BASEURL + "/delete/" + id;
        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        HttpEntity<RegistrationInfoDto> entities = new HttpEntity<RegistrationInfoDto>(headers);

        restTemplate.exchange(urlDelete, HttpMethod.DELETE, entities, RegistrationInfoDto.class);

    }

    public static RegistrationInfoDto[] getInfos() {

        String urlGetAll = BASEURL;

        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        HttpEntity<RegistrationInfoDto[]> entities = new HttpEntity<RegistrationInfoDto[]>(headers);

        ResponseEntity<RegistrationInfoDto[]> result = restTemplate.exchange(urlGetAll, HttpMethod.GET, entities, RegistrationInfoDto[].class);

        RegistrationInfoDto[] infos = result.getBody();

        return infos;

    }
}
