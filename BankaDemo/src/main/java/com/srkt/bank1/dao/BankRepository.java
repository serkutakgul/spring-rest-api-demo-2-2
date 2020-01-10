package com.srkt.bank1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srkt.bank1.entity.Banka;




@Repository
public interface BankRepository extends JpaRepository<Banka, Integer> {

}
