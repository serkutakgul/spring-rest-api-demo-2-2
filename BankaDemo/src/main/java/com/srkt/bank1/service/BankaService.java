package com.srkt.bank1.service;

import java.util.List;

import com.srkt.bank1.entity.Banka;




public interface BankaService {

	public List<Banka> findAll();
	
	public Banka findById(int theId);
	
	public void save(Banka stu);
	
	public void deleteById(int theId);
	
}
