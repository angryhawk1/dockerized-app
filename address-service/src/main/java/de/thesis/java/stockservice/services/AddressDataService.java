package de.thesis.java.stockservice.services;

import de.thesis.java.stockservice.models.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Service
public class AddressDataService {


  private Map<Integer, Address> addressMap;

  AddressDataService() {
    doInit();
  }

  private void doInit() {
    addressMap = new HashMap<>();
    addressMap.put(1,
        new Address("3434 Anderson Avenue", "Apt# 420", "San Jose", "California", "92130",
            "United States"));
    addressMap.put(2,
        new Address("3436 Unison Avenue", "Apt# 421", "San Clara", "California", "92130",
            "United States"));
  }

  public Address getAddress(int memberId) {
    return addressMap.get(memberId);
  }

  public String getStock() throws IOException {
    String fileName = "bitcoin.json";
    Resource resource = new ClassPathResource(fileName);
    BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line + System.lineSeparator());
    }
    return sb.toString();
  }
}
