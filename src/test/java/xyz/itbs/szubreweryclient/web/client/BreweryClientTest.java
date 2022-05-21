package xyz.itbs.szubreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.itbs.szubreweryclient.configuration.RestTemplateClient;
import xyz.itbs.szubreweryclient.web.model.BeerDTO;
import xyz.itbs.szubreweryclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {BreweryClient.class, RestTemplateClient.class})
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {

        BeerDTO dto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {

        BeerDTO dto = BeerDTO.builder().beerName("NewBeer").build();
        URI uri = breweryClient.saveNewBeer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {

        BeerDTO dto = BeerDTO.builder().beerName("NewBeer").build();
        breweryClient.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeer() {

        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDTO dto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDTO dto = CustomerDTO.builder().name("Tester").build();
        URI uri = breweryClient.saveNewCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDTO dto = CustomerDTO.builder().name("Tester").build();
        breweryClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}