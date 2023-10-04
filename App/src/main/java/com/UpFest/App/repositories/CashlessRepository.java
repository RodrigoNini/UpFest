package com.UpFest.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashlessRepository extends JpaRepository<CashlessRepository, Long> {

}
