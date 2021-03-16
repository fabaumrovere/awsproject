package com.spring.awsproject.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.awsproject.model.ClientEntity;
import com.spring.awsproject.repository.ClientRepository;

@Component
public class criaDados {

   @Autowired
   ClientRepository clientRepository;

   // @PostConstruct
   public void savePosts(){

       List<ClientEntity> clients = new ArrayList<>();
       ClientEntity c1 = new ClientEntity();
       c1.setNome("Bruno Cardoso");
       c1.setApelido("Brunão");
       c1.setData(LocalDate.now());

       ClientEntity c2 = new ClientEntity();
       c1.setNome("Marcela Silva");
       c1.setApelido("Marcela");
       c1.setData(LocalDate.now());

       clients.add(c1);
       clients.add(c2);

       for(ClientEntity client: clients){
          ClientEntity clientSaved = clientRepository.save(client);
           System.out.println(clientSaved.getId());
       }
   }

}
