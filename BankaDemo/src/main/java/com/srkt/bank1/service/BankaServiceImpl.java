package com.srkt.bank1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srkt.bank1.dao.BankRepository;
import com.srkt.bank1.entity.Banka;




@Service
public class BankaServiceImpl implements BankaService {

	private BankRepository br;
	
	@Autowired
	public BankaServiceImpl(BankRepository brep) {
		br = brep;
	}
	
	@Override
	public List<Banka> findAll() {
		return br.findAll();
	}

	@Override
	public Banka findById(int theId) {
		Optional<Banka> result = br.findById(theId);
		
		Banka b = null;
		
		if (result.isPresent()) {
			b = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Ogrenci yok  " + theId);
		}
		
		return b;
	}

	@Override
	public void save(Banka bnk) {
		br.save(bnk);
	}

	@Override
	public void deleteById(int theId) {
		br.deleteById(theId);
	}

}






