package com.example.moviedb.repo;

import com.example.moviedb.entity.ColourType;
import com.example.moviedb.entity.enums.ColourCodeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Repository
@Transactional
public interface ColourTypeRepo extends JpaRepository<ColourType,Enum<ColourCodeType>> {

}
