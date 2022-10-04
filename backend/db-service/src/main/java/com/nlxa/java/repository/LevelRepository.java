package com.nlxa.java.repository;

import com.nlxa.java.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, String> {

    List<Level> findByDescription(String description);

}
