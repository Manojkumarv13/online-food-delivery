package com.foodmenu.springbootfoodimages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.foodmenu.springbootfoodimages.entity.DeliveryDetails;
import com.foodmenu.springbootfoodimages.service.DeliveryDetailsService;

@Controller
public class DeliveryDetailsController {
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private DeliveryDetailsService deliverDetailsService;

	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/deliverydetails/show")
	String show(Model map) {
		List<DeliveryDetails> delivery = deliverDetailsService.getAllDeliveryDetails();
		map.addAttribute("delivery", delivery);
		return "delivery";

	}
}
