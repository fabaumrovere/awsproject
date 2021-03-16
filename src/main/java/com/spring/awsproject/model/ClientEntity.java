package com.spring.awsproject.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table( name = "tb_client")
public class ClientEntity {

   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private Long id;

   @NotBlank
   private String nome;

   @NotBlank
   private String apelido;

   @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
   private LocalDate data;


   public Long getId() {
      return id;
   }


   public void setId(Long id) {
      this.id = id;
   }


   public String getNome() {
      return nome;
   }


   public void setNome(String nome) {
      this.nome = nome;
   }


   public String getApelido() {
      return apelido;
   }


   public void setApelido(String apelido) {
      this.apelido = apelido;
   }


   public LocalDate getData() {
      return data;
   }


   public void setData(LocalDate data) {
      this.data = data;
   }


}
