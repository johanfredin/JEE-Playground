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

import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.mvc.bean.EditContactPersonBean;
import se.fredin.playground.services.ContactPersonService;

@Controller
@RequestMapping("/editContactPerson/{id}.html")
public class EditContactPersonController {
	
	private static Logger log = Logger.getLogger(EditContactPersonController.class.getName());
	
	@Inject
	private ContactPersonService contactPersonService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@PathVariable long id) {
		ContactPerson contactPerson = null;
		
		if(id > 0) {
			contactPerson = getContactPersonService().getEntity(id);
		} else {
			contactPerson = new ContactPerson();
		}
		
		EditContactPersonBean editContactPersonBean = new EditContactPersonBean();
		editContactPersonBean.setContactPerson(contactPerson);
		ModelAndView mav = new ModelAndView("editContactPerson");
		mav.addObject("editContactPersonBean", editContactPersonBean);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ModelAndView handleSubmit(@Valid EditContactPersonBean bean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("editContactPerson");
			mav.addObject("editContactPersonBean", bean);
			for(ObjectError error : bindingResult.getAllErrors()) {
				log.info("Error " + error.getCode() + " " + error.getDefaultMessage() + " " + error.getObjectName());
			}
			return mav;
		}
		
		ContactPerson contactPerson = bean.getContactPerson();
		long contactPersonId = contactPerson.getId();
		
		if(contactPersonId > 0) {
			ContactPerson dbGig = getContactPersonService().getEntity(contactPersonId);
			contactPerson.copyDataFromEntity(dbGig);
			getContactPersonService().updateEntity(dbGig);
		} else {
			getContactPersonService().createEntity(contactPerson);
		}
		
		return new ModelAndView("redirect:/index.html");
	}
	
	public void setContactPersonService(ContactPersonService contactPersonService) {
		this.contactPersonService = contactPersonService;
	}
	
	public ContactPersonService getContactPersonService() {
		return contactPersonService;
	}

}
