package de.thesis.java.stockservice.controllers;

import de.thesis.java.stockservice.models.Address;
import de.thesis.java.stockservice.services.AddressDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AddressController {

  @Autowired
  private AddressDataService dataService;

  @GetMapping("/{member-id}/address")
  public ResponseEntity<Address> getAddress(@PathVariable("member-id") int memberId) {
    Address address = dataService.getAddress(memberId);
    return ResponseEntity.ok(address);
  }


  @GetMapping("/stock")
  public ResponseEntity<String> getStockData() throws IOException {
    String stockData = dataService.getStock();
    return ResponseEntity.ok(stockData);
  }

}
