package de.thesis.java.client.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.thesis.java.client.models.Mail;
import org.springframework.stereotype.Service;

@Service
public class MailDataService {

  private Map<Integer, List<Mail>> mailMap = new HashMap<>();

  public void postMail(int memberId, Mail mail) {
    mailMap.putIfAbsent(memberId, new ArrayList<>());
    mailMap.get(memberId).add(mail);
  }

  public List<Mail> getMails(int memberId) {
    return mailMap.get(memberId);
  }
}
