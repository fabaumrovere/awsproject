package com.spring.awsproject.service;

import java.util.List;

public interface ServiceInterface<T> {


   List<T> findAll();

   T findById( Long id);

   T save (T entity);
}
