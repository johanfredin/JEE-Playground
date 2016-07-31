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
import se.fredin.playground.mvc.bean.EditPersonBean;
import se.fredin.playground.services.PersonService;

@Controller
@RequestMapping("/editPerson/{id}.html")
public class EditPersonController {
	
	private static Logger log = Logger.getLogger(EditPersonController.class.getName());
	
	@Inject
	private PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@PathVariable long id) {
		Person person = null;
		
		if(id > 0) {
			person = getPersonService().getEntity(id);
		} else {
			person = new Person();
		}
		
		EditPersonBean eridPersonBean = new EditPersonBean();
		eridPersonBean.setPerson(person);
		ModelAndView mav = new ModelAndView("editPerson");
		mav.addObject("editPersonBean", eridPersonBean);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ModelAndView handleSubmit(@Valid EditPersonBean editPersonBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("editPerson");
			mav.addObject("editPersonBean", editPersonBean);
			for(ObjectError error : bindingResult.getAllErrors()) {
				log.info("Error " + error.getCode() + " " + error.getDefaultMessage() + " " + error.getObjectName());
			}
			return mav;
		}
		
		Person person = editPersonBean.getPerson();
		person.setRelations();
		long personId = person.getId();
		
		if(personId > 0) {
			Person dbPerson = getPersonService().getEntity(personId);
			dbPerson.copyDataFromEntity(person);
			getPersonService().updateEntity(dbPerson);
		} else {
			getPersonService().createEntity(person);
		}
		
		return new ModelAndView("redirect:/index.html");
	}
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public PersonService getPersonService() {
		return personService;
	}

}
