package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.model.FuelConsumptions;
import org.arpit.java2blog.service.FuelConsumptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuelConsumptionsController {

	@Autowired
	FuelConsumptionsService fuelConsumptionsService;

	@RequestMapping(value = "/getAllFuelConsumptions", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<FuelConsumptions> getAllFuelConsumptions(Model model) {
		List<FuelConsumptions> listOfFuelConsumptions = fuelConsumptionsService.getAllFuelConsumptions();
		model.addAttribute("FuelConsumptions", new FuelConsumptions());
		model.addAttribute("listOfFuelConsumptions", listOfFuelConsumptions);
		return listOfFuelConsumptions;
	}

	@RequestMapping(value = "/FuelConsumptionHomePage", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllFuelConsumptions";
	}

	@RequestMapping(value = "/getFuelConsumption/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getFuelConsumptionbyID(@PathVariable int id) {
		fuelConsumptionsService.getFuelConsumption(id);
	}

	@RequestMapping(value = "/addFuelConsumption", method = RequestMethod.POST, headers = "Accept=application/json")
	public FuelConsumptions addFuelConsumption(@RequestBody FuelConsumptions fuelConsumption) {
		return fuelConsumptionsService.addFuelConsumption(fuelConsumption);

	}

	@RequestMapping(value = "/addFuelConsumption", method = RequestMethod.PUT, headers = "Accept=application/json")
	public FuelConsumptions updateFuelConsumption(@RequestBody FuelConsumptions fuelConsumption) {
		return fuelConsumptionsService.updateFuelConsumption(fuelConsumption); 
	}	

	@RequestMapping(value = "/deleteFuelConsumption/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteFuelConsumption(@PathVariable("id") int id) {
		fuelConsumptionsService.deleteFuelConsumption(id);


	}	
}
