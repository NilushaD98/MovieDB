package com.example.moviedb.repo;

import com.example.moviedb.entity.Casting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Repository
@Transactional
public interface CastingRepo extends JpaRepository<Casting,InheritableThreadLocal> {
}
