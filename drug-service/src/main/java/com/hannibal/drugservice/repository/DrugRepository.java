package com.hannibal.drugservice.repository;

import com.hannibal.drugservice.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}
