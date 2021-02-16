package com.prim4s.msscbreweryclient.web.client;

import com.prim4s.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created By CHAMGOUE in 16/02/2021
 */
@Component
@ConfigurationProperties(value = "mss-customer", ignoreInvalidFields = true)
public class CustomerClient {

    private String apihost;

    private final static String CUSTOMER_PATH_V1 = "/api/v1/customer";

    private final RestTemplate restTemplate;

    public CustomerClient( RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplate = restTemplateBuilder.build (  );
    }

    public CustomerDto getCustomer( UUID uuid ) {
        return restTemplate.getForObject ( apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString (), CustomerDto.class );
    }


    public URI saveCustomer (CustomerDto customerDto) {
        return restTemplate.postForLocation ( apihost + CUSTOMER_PATH_V1, customerDto );
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put ( apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString (), customerDto );
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete ( apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString () );
    }


    public void setApihost( String apihost ) {
        this.apihost = apihost;
    }
}
