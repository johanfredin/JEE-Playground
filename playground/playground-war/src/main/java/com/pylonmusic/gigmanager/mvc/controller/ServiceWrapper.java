package com.pylonmusic.gigmanager.mvc.controller;

public interface ServiceWrapper<F>  {
	
	void setService(F service);
	
	F getService();

}
