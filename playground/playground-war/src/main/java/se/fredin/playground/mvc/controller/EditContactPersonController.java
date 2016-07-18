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

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.mvc.bean.EditContactPersonBean;
import se.fredin.playground.services.PersonService;

@Controller
@RequestMapping("/editContactPerson/{id}.html")
public class EditContactPersonController {
	
	private static Logger log = Logger.getLogger(EditContactPersonController.class.getName());
	
	@Inject
	private PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@PathVariable long id) {
		Person person = null;
		
		if(id > 0) {
			person = getContactPersonService().getEntity(id);
		} else {
			person = new Person();
		}
		
		EditContactPersonBean editContactPersonBean = new EditContactPersonBean();
		editContactPersonBean.setContactPerson(person);
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
		
		Person person = bean.getContactPerson();
		long contactPersonId = person.getId();
		
		if(contactPersonId > 0) {
			Person dbGig = getContactPersonService().getEntity(contactPersonId);
			person.copyDataFromEntity(dbGig);
			getContactPersonService().updateEntity(dbGig);
		} else {
			getContactPersonService().createEntity(person);
		}
		
		return new ModelAndView("redirect:/index.html");
	}
	
	public void setContactPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public PersonService getContactPersonService() {
		return personService;
	}

}
