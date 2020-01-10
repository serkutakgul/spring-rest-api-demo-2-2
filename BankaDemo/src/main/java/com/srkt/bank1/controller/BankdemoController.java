package com.srkt.bank1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.client.RestTemplate;

import com.srkt.bank1.dao.BankRepository;
import com.srkt.bank1.entity.Banka;
import com.srkt.bank1.entity.Student;
import com.srkt.bank1.service.BankaService;





@Controller
@RequestMapping("/bank")
public class BankdemoController {
	
	  static final String restURI="http://localhost:8004/api/odendi";
	  static RestTemplate restTemplate=new RestTemplate();
	 
private BankRepository br;
	@Autowired
	private BankaService bs;

	public BankdemoController(BankaService bs1) {
		bs1 = bs;
	}

	@GetMapping("/list")
	private String list(Model model) {

		List<Banka> borcList = bs.findAll();
		model.addAttribute("borcList", borcList);
		return "bank/borc";

	}
	
	
	@GetMapping("/showFormForAdd")
	public Banka showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Banka stu = new Banka();
		
		theModel.addAttribute("borclu", stu);
		
		return stu;
	}
	@GetMapping("/showFormForOde")
	public String showFormForOde(Model theModel) {

		// create model attribute to bind form data
		Banka bnk = new Banka();

		theModel.addAttribute("borclu", bnk);

		return "bank/borc";
	}

	@GetMapping("/odendi/{studentId}") 
	public String addBorc(@PathVariable Integer studentId) {
		
		ResponseEntity<Student> st = restTemplate.getForEntity(restURI+"/"+studentId, Student.class);
		Banka borclu =bs.findById(st.getBody().getNo());
		borclu.setBorcDurumu("Ödendi");
		
		
	
		bs.save(borclu);
		
		return "redirect:/bank/list";
	}
	@PostMapping("/save")
	public String saveBank(@ModelAttribute("borclu") Banka stu) {
		
		// save the employee
		bs.save(stu);
		restTemplate.postForEntity(restURI, stu, Banka.class);
		// use a redirect to prevent duplicate submissions
		return "redirect:/bank/borc";
	}
}