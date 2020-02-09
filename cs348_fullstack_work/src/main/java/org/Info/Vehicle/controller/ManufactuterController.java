package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Manufactuter;
import org.Info.Vehicle.service.ManufactuterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufactuterController {

	@Autowired
	ManufactuterService manufactuterService;

	@RequestMapping(value = "/getAllManufactuter", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Manufactuter> getAllManufactuter(Model model) {
		List<Manufactuter> listOfManufactuter = manufactuterService.getAllManufactuter();
		model.addAttribute("manufactuter", new Manufactuter());
		model.addAttribute("listOfManufactuter", listOfManufactuter);
		return listOfManufactuter;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllManufactuter";
	}

	@RequestMapping(value = "/getManufactuter/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getManufactuterById(@PathVariable int id) {
		manufactuterService.getManufactuter(id);
	}

	@RequestMapping(value = "/addManufactuter", method = RequestMethod.POST, headers = "Accept=application/json")
	public Manufactuter addManufactuter(@RequestBody Manufactuter manufactuter) {
		return manufactuterService.addManufactuter(manufactuter);

	}

	@RequestMapping(value = "/addManufactuter", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Manufactuter updateManufactuter(@RequestBody Manufactuter manufactuter) {
		return manufactuterService.updateManufactuter(manufactuter); 

	}	

	@RequestMapping(value = "/deleteManufactuter/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteManufactuter(@PathVariable("id") int id) {
		manufactuterService.deleteManufactuter(id);
	}	
}
