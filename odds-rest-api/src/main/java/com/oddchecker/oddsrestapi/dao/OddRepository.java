package com.oddchecker.oddsrestapi.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oddchecker.oddsrestapi.entity.Odd;

@Repository
public interface OddRepository extends JpaRepository<Odd, Long> {
	
	
	
}
