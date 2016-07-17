package com.pylonmusic.gigmanager.mvc.controller;

import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public abstract class EditEntityController<B> {

	@RequestMapping(method = RequestMethod.GET)
	public abstract ModelAndView index(@PathVariable long id);
	
	@RequestMapping(method = RequestMethod.POST) 
	public abstract ModelAndView handleSubmit(@Valid B bean, BindingResult bindingResult);
	
	/**
	 * @param id
	 * @return <code>true</code> if passed in {@link Id} > 0
	 */
	protected boolean isExistingEntity(long id) {
		return id > 0;
	}
	
	
}
