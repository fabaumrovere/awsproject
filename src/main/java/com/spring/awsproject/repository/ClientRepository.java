package com.spring.awsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.awsproject.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
