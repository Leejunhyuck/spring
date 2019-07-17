package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.persistence.FreeBoardRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/board/*")
@Log
public class FreeBoardController {

	@Setter(onMethod_= @Autowired)
	private FreeBoardRepository repo;
	
	
	@GetMapping("/read")
	public void read(Model model) {
		
		log.info("board...read");
		model.addAttribute("vo",repo.findById(199L).get());
	}
	
	 @GetMapping("/list")
	  public void sample5(Model model) {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
	    List<Object[]> result = repo.getPage(page);
	    model.addAttribute("list",result);

	  }

	
	
	
}
