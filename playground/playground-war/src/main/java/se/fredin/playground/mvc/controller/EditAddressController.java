package se.fredin.playground.mvc.controller;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.mvc.bean.EditAddressBean;
import se.fredin.playground.services.AddressService;

@Controller
@RequestMapping("/editAddress/{id}.html")
public class EditAddressController {
	
	private static Logger log = Logger.getLogger(EditAddressController.class.getName());
	
	@Inject
	private AddressService addressService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@PathVariable long id) {
		Address address = null;
		
		if(id > 0) {
			address = getAddressService().getEntity(id);
		} else {
			address = new Address();
		}
		
		EditAddressBean editAddressBean = new EditAddressBean(address);
		ModelAndView mav = new ModelAndView("editAddress");
		mav.addObject("editAddressBean", editAddressBean);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ModelAndView handleSubmit(@Valid EditAddressBean editAddressBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("editAddress");
			mav.addObject("editAddressBean", editAddressBean);
			for(ObjectError error : bindingResult.getAllErrors()) {
				log.info("Error " + error.getCode() + " " + error.getDefaultMessage() + " " + error.getObjectName());
			}
			return mav;
		}
		
		Address address = editAddressBean.getAddress();
		long addressId = address.getId();
		
		if(addressId > 0) {
			Address dbAddress = getAddressService().getEntity(addressId);
			dbAddress.copyDataFromEntity(address);
			getAddressService().updateEntity(dbAddress);
		} else {
			getAddressService().createEntity(address);
		}
		
		return new ModelAndView("redirect:/index.html");
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public AddressService getAddressService() {
		return addressService;
	}

}
