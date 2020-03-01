package com.parking.dao;

import org.springframework.data.repository.CrudRepository;

import com.parking.model.Image;

public interface ImageDao extends CrudRepository<Image, Integer> {

}
