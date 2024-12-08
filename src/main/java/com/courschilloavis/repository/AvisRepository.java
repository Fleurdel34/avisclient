package com.courschilloavis.repository;


import com.courschilloavis.enums.TypeAvis;
import com.courschilloavis.models.Avis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvisRepository  extends JpaRepository<Avis, Long> {

    List<Avis> findByType(TypeAvis type);
}
