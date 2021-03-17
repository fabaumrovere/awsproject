package com.spring.awsproject.service;

import java.util.List;

public interface ServiceInterface<T,ID> {


   List<T> findAll();

   T findById( ID id);

   T save (T entity);

   void delete(ID id);


}
