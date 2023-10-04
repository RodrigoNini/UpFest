package com.UpFest.App.repositories;

import com.UpFest.App.entities.GastoCashless;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoCashlessRepository extends JpaRepository<GastoCashless, Long> {
}
