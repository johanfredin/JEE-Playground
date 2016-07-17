package com.pylonmusic.gigmanager.mvc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.services.GigService;

@Controller
public class IndexController implements ServiceWrapper<GigService> {
	
	@Inject
	private GigService gigService;

	@RequestMapping("/index.html")
	public ModelAndView index() {
		List<Gig> gigs = gigService.getAllGigs();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("gigs", gigs);
		return mav;
	}

	@Override
	public void setService(GigService service) {
		this.gigService = service;
	}

	@Override
	public GigService getService() {
		return this.gigService;
	}
	
	
	
}
