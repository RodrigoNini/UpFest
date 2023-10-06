package com.UpFest.App.repositories;

import com.UpFest.App.entities.ContaCashless;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCashlessRepository extends JpaRepository<ContaCashless, Long> {



}
