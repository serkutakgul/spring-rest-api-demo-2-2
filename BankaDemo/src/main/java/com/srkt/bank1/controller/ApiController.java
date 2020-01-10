package com.srkt.bank1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.srkt.bank1.dao.BankRepository;
import com.srkt.bank1.entity.Banka;
import com.srkt.bank1.entity.Student;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private BankRepository br;

	@PostMapping("/borclar") 
	public Banka addBorc(@RequestBody Student stu) {
		Banka borc = new Banka();
		borc.setoNo(stu.getNo());
		borc.setBorcDurumu("500 TL borcunuz var");
		br.save(borc);
		
		return borc;
	}
}
