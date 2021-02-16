package com.prim4s.msscbreweryclient.web.client;

import com.prim4s.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created By CHAMGOUE in 12/02/2021
 */

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerDto() {
        BeerDto beerDto = breweryClient.getBeerDto ( UUID.randomUUID () );
        assertNotNull ( beerDto );
    }

    @Test
    void saveBeerDto() {
        // given
        BeerDto beerDto = BeerDto.builder ().beerName ( "new beer" ).beerStyle ( "beer" ).build ();

        URI uri = breweryClient.saveBeerDto ( beerDto );

        assertNotNull ( uri );

        System.out.println ( "################################################################################" );
        System.out.println ( uri );
        System.out.println ( "################################################################################" );
    }

    @Test
    void updateBeerDto() {
        // given
        BeerDto beerDto = BeerDto.builder ().beerName ( "new beer" ).beerStyle ( "beer" ).build ();
        breweryClient.updateBeerDto ( UUID.randomUUID (), beerDto );
    }

    @Test
    void deleteBeerDTO() {
        breweryClient.deleteBeerDto ( UUID.randomUUID () );
    }
}