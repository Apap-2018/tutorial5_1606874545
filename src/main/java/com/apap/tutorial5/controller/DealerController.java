package com.apap.tutorial5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.service.CarService;
import com.apap.tutorial5.service.DealerService;

@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	private String home() {
		
		return "home";
	}
	
	@RequestMapping(value="/dealer/add",method=RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		return "addDealer";
	}
	
	@RequestMapping(value="/dealer/add",method=RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "add";
	}
	
	@RequestMapping(value= {"/dealer/view"}, method=RequestMethod.GET)
	private String viewDealer(@RequestParam(value="dealerId")Long dealerId, Model model) {
		
	
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		List<CarModel> archive = carService.sortByPrice(dealerId);
		dealer.setListCar(archive);
		
		model.addAttribute("dealer",dealer);
		return "view-dealer";
	}
	
	@RequestMapping(value= {"/dealer/view-all"}, method=RequestMethod.GET)
	private String viewDealer(Model model) {
		
		List<DealerModel> listDealer=dealerService.allDealer().findAll();
		
		
		model.addAttribute("listDealer",listDealer);
		
		return "view-all";
	}
	
	@RequestMapping(value={"/dealer/delete/{dealerId}"}, method=RequestMethod.GET)
	private String deleteDealer(@PathVariable(value="dealerId")Long dealerId, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		dealerService.deleteDealer(dealer);
		return "delete";
	}
	
	//update dealer
	@RequestMapping(value="/dealer/update/{dealerId}", method=RequestMethod.GET)
	private String updateDealer(@PathVariable(value="dealerId") Long dealerId, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		model.addAttribute("dealer", dealer);
		
		return "updateDealer";
	}
	
	@RequestMapping(value="/dealer/update/{carId}",method=RequestMethod.POST)
	private String updateDealerSubmit(@PathVariable(value="carId") Long dealerId, @ModelAttribute DealerModel dealerUpdate) {
		
		dealerService.updateDealer(dealerUpdate, dealerId);
		return "update";
	}
		
	
		
		
	

	

}
