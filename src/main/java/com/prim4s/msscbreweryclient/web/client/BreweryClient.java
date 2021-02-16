package com.prim4s.msscbreweryclient.web.client;

import com.prim4s.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created By CHAMGOUE in 12/02/2021
 */

@Component
@ConfigurationProperties(value = "mss-brewery", ignoreInvalidFields = true)
public class BreweryClient {

    private final String BEER_PATH = "/api/v1/beer";

    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient( RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplate = restTemplateBuilder.build ();
    }

    public BeerDto getBeerDto( UUID uuid ) {
        return restTemplate.getForObject ( apihost + BEER_PATH + uuid.toString (), BeerDto.class );
    }

    public URI saveBeerDto(BeerDto beerDto) {
        return restTemplate.postForLocation ( apihost + BEER_PATH , beerDto );
    }

    public void updateBeerDto(UUID uuid, BeerDto beerDto) {
        restTemplate.put ( apihost + BEER_PATH + "/" + uuid.toString (), beerDto );
    }

    public void deleteBeerDto(UUID uuid) {
        restTemplate.delete ( apihost + BEER_PATH + "/" + uuid );
    }

    public void setApihost( String apihost ) {
        this.apihost = apihost;
    }
}
