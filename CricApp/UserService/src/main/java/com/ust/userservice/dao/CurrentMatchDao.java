package com.ust.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.userservice.entity.CurrentMatch;

public interface CurrentMatchDao extends JpaRepository<CurrentMatch, Integer>{

}
