package nl.luuk.controller;

import nl.luuk.database.DiverRepository;
import nl.luuk.model.gasblender.BlendMethod;
import nl.luuk.model.gasblender.Blender;
import nl.luuk.services.DiverService;
import nl.luuk.services.GasBlenderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mobile.device.Device;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WebsiteController {
	

	@Autowired
	private DiverService diverService;
	
	@Autowired
	private GasBlenderService gasBlenderService;
	
	@Autowired
	private DiverRepository diverRepository;
	
	@Autowired
	public WebsiteController() {}
	
	private static final Logger logger = LoggerFactory.getLogger(WebsiteController.class);
	
	@GetMapping({"/home","/"})
	public String home() {
		return "website/home";
	}
	
	@GetMapping("/ssispecialty")
	public String ssispecialty() {
		return "website/ssispecialty";
	}
	
	@GetMapping("/photos")
	public String photos() {
		return "website/photos";
	}
	
	@GetMapping("/gasblender")
	public String gasblender(Model model) {
		model.addAttribute("blender", gasBlenderService.getBlender());
		return "website/gasblender";
	}
	
	@PostMapping("/gasblender")
	public String postGasBlender(Blender blender) {
		gasBlenderService.blend(blender);
		return "redirect:/gasblender";
	}

	
	@GetMapping("/calendar")
	public String calendar() {
		return "website/calendar";
	}
	
	@GetMapping("/contactdetails")
	public String contactdetails() {
		return "website/contactdetails";
	}
	
	
}
