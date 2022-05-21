package xyz.itbs.szubreweryclient.web.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import xyz.itbs.szubreweryclient.web.model.BeerDTO;
import xyz.itbs.szubreweryclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    @Value("${api.host}")
    private String API_HOST_V1;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BeerDTO getBeerById(UUID uuid) {
        return restTemplate.getForObject(API_HOST_V1 + BEER_PATH_V1 + uuid, BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO) {
        return restTemplate.postForLocation(API_HOST_V1 + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID uuid, BeerDTO beerDTO) {
        restTemplate.put(API_HOST_V1 + BEER_PATH_V1 + "/" + uuid, beerDTO);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(API_HOST_V1 + BEER_PATH_V1 + "/" + uuid);
    }

    public CustomerDTO getCustomerById(UUID uuid) {
        return restTemplate.getForObject(API_HOST_V1 + BEER_PATH_V1 + uuid, CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO) {
        return restTemplate.postForLocation(API_HOST_V1 + BEER_PATH_V1, customerDTO);
    }

    public void updateCustomer(UUID uuid, CustomerDTO customerDTO) {
        restTemplate.put(API_HOST_V1 + BEER_PATH_V1 + "/" + uuid, customerDTO);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(API_HOST_V1 + BEER_PATH_V1 + "/" + uuid);
    }
}
