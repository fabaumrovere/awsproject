package com.spring.awsproject.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.awsproject.model.ClientEntity;
import com.spring.awsproject.repository.ClientRepository;
import com.spring.awsproject.service.ServiceInterface;

@Repository
public class ClientServiceImpl implements ServiceInterface<ClientEntity>{

   @Autowired
   ClientRepository repository;

   @Override
   public List<ClientEntity> findAll() {
      return repository.findAll();
   }

   @Override
   public ClientEntity findById(Long id) {
      return repository.findById(id).get();
   }

   @Override
   public ClientEntity save(ClientEntity entity) {
      return repository.save(entity);
   }

}
