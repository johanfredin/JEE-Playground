package com.pylonmusic.gigmanager.mvc.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.mvc.bean.EditGigBean;
import com.pylonmusic.gigmanager.services.GigService;

@Controller
@RequestMapping("/editGig/{id}.html")
public class EditGigController extends EditEntityController<EditGigBean> implements ServiceWrapper<GigService> {
	
	private static Logger log = Logger.getLogger(EditEntityController.class.getName());
	
	@Inject
	private GigService gigService;
	
//	@Inject
//	private VenueService venueService;
	
	@Override
	public ModelAndView index(@PathVariable long id) {
		Gig gig = null;
		
		if(id > 0) {
			gig = getService().getEntity(id);
		} else {
			gig = new Gig();
		}
		
		EditGigBean editGigBean = new EditGigBean();
		editGigBean.setGig(gig);
		ModelAndView mav = new ModelAndView("editGig");
		mav.addObject("editGigBean", editGigBean);
		return mav;
	}
	
	public ModelAndView handleSubmit(EditGigBean bean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("editGig");
			mav.addObject("editGigBean", bean);
			for(ObjectError error : bindingResult.getAllErrors()) {
				log.info("Error " + error.getCode() + " " + error.getDefaultMessage() + " " + error.getObjectName());
			}
			return mav;
		}
		
		Gig gig = bean.getGig();
//		Venue venue = gig.getVenue();
		long gigId = gig.getId();
		
		if(gigId > 0) {
			Gig dbGig = getService().getEntity(gigId);
			gig.copyDataFromEntity(dbGig);
//			getVenueService().updateEntity(venue);
			getService().updateEntity(dbGig);
		} else {
//			getVenueService().createEntity(venue);
			getService().createEntity(gig);
		}
		
		return new ModelAndView("redirect:/index.html");
	}
	
	public void setService(GigService service) {
		this.gigService = service;
	}

	public GigService getService() {
		return this.gigService;
	}
	
//	public void setVenueService(VenueService venueService) {
//		this.venueService = venueService;
//	}
//	
//	public VenueService getVenueService() {
//		return venueService;
//	}

}
