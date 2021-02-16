package com.prim4s.msscbreweryclient.web.client;

import com.prim4s.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created By CHAMGOUE in 16/02/2021
 */
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomer() {
        CustomerDto customerDto = customerClient.getCustomer ( UUID.randomUUID () );
        assertNotNull ( customerDto );
    }

    @Test
    void saveCustomer() {
        // Given
        CustomerDto customerDto = CustomerDto.builder().name ( "TALLA" ).build();

        URI uri = customerClient.saveCustomer ( customerDto );

        assertNotNull ( uri );
    }

    @Test
    void updateCustomer() {
        // Given
        CustomerDto customerDto = CustomerDto.builder().name ( "TALLA" ).build();

        customerClient.updateCustomer ( UUID.randomUUID (), customerDto );
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer ( UUID.randomUUID () );
    }
}