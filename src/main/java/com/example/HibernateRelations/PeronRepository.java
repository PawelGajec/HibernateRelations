package com.example.HibernateRelations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PeronRepository extends JpaRepository <Person, Long> {

}

