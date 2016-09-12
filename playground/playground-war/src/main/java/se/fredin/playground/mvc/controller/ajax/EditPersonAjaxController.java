package se.fredin.playground.mvc.controller.ajax;


import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.mvc.bean.EditPersonBean;
import se.fredin.playground.services.PersonService;

/**
 * Experimental controller using jQuery/AJAX
 * @author johan
 *
 */
@Controller
public class EditPersonAjaxController {
	
	private static Logger log = Logger.getLogger(EditPersonAjaxController.class.getName());
	
	@Inject
	private PersonService personService;
	
	@RequestMapping(value="/editAjaxPerson/{id}.html", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable long id) {
		Person person = null;
		Address address = null;
		
		if(id > 0) {
			person = getPersonService().getEntity(id);
			address = person.getAddress();
		} else {
			person = new Person();
			address = new Address();
		}
		
		EditPersonBean editPersonBean = new EditPersonBean(person, address);
		ModelAndView mav = new ModelAndView("editAjaxPerson");
		mav.addObject("editPersonBean", editPersonBean);
		mav.addObject("isUniqueEmail", editPersonBean.isUniqueEmail());
		return mav;
	}
	
	@RequestMapping(value="/editAjaxPerson/{id}.html", method = RequestMethod.POST) 
	public ModelAndView handleSubmit(@Valid EditPersonBean editPersonBean, BindingResult bindingResult) {
		Person person = editPersonBean.getPerson();
		boolean isUniqueEmail = getPersonService().isUniqueEmail(person);
		
		if(bindingResult.hasErrors() || !isUniqueEmail) {
			ModelAndView mav = new ModelAndView("editAjaxPerson");
			mav.addObject("editPersonBean", editPersonBean);
			
			// Add custom errors if any
			if(!isUniqueEmail) {
				bindingResult.addError(new ObjectError("editPersonBean.isUniqueEmail", new String[]{"isUniqueEmail"}, null, "Email already exists"));
			}
			for(ObjectError error : bindingResult.getAllErrors()) {
				log.warning("Error " + error.getCode() + " " + error.getDefaultMessage() + " " + error.getObjectName());
			}
			
			return mav;
		}
		
		
		person.setAddress(editPersonBean.getAddress());
		person.setRelations();
			
		if(person.isExistingEntity()) {
			Person dbPerson = getPersonService().getEntity(person.getId());
			dbPerson.copyDataFromEntity(person);
			getPersonService().updateEntity(dbPerson);
		} else {
			getPersonService().createEntity(person);
		}
			
		return new ModelAndView("redirect:/index.html");
	}
	
	@RequestMapping(value="/getMatchingFirstName", method=RequestMethod.GET)
	public @ResponseBody List<Person> getMatchingFirstNames(@RequestParam("term") String query) {
		List<Person> result = getPersonService().getAllPersonsWithFirstNameLike(query);
		return result;
	}
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public PersonService getPersonService() {
		return personService;
	}

}
