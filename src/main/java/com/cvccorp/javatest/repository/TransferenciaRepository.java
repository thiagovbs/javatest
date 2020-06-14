package com.cvccorp.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvccorp.javatest.entity.Transferencia;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {


}
