package de.thesis.java.client.controllers;

import java.util.List;

import de.thesis.java.client.models.Address;
import de.thesis.java.client.models.Mail;
import de.thesis.java.client.service.AddressDataService;
import de.thesis.java.client.service.MailDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

  @Autowired
  private MailDataService mailDataService;

  @Autowired
  private AddressDataService addressDataService;

  @PostMapping("/{member-id}/mails")
  public ResponseEntity sendMail(@PathVariable("member-id") int memberId, @RequestBody Mail mail) {

    Address memberAddress = addressDataService.getAddress(memberId);
    mail.setAddress(memberAddress);
    mailDataService.postMail(memberId, mail);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{member-id}/mails")
  public ResponseEntity<List<Mail>> getMails(@PathVariable("member-id") int memberId) {
    List<Mail> mails = mailDataService.getMails(memberId);
    return ResponseEntity.ok(mails);
  }

}
