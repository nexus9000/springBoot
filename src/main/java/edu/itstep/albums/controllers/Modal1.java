package edu.itstep.albums.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itstep.albums.dao.SiteParams;
import edu.itstep.albums.dao.WebSiteRepository;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/modals")
public class Modal1 {
	private Logger logger = LoggerFactory.getLogger(Modal1.class);
	@Autowired
private	WebSiteRepository webSiteRepo;
	@GetMapping("/modal2")
	public String addUser( @Valid  @RequestParam("name") String name, Model model) {
		 model.addAttribute("name", name);
		 logger.info(name );
		 SiteParams site = new SiteParams();
	     webSiteRepo.save(site);
	     model.addAttribute("site", site);
		return "modal2";
	}
}
