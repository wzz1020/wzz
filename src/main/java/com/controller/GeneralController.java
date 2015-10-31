package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.LoginMessage;

@Controller
public class GeneralController {
	
	@RequestMapping(value="/login_input", method = {RequestMethod.GET})
	public String login_input(Model model){
		
		/*if(!model.containsAttribute("loginMessage")){
			model.addAttribute("loginMessage", new LoginMessage());
		}*/
		model.addAttribute("loginMessage", new LoginMessage());
		return "login";
	}

	@RequestMapping(value="/login_input", method = {RequestMethod.POST})
	public String login_save(@Valid @ModelAttribute("loginMessage") LoginMessage loginMessage, BindingResult bindingresult, Model model){
		if(bindingresult.hasErrors()){
			return "login";
		}
		return "success";
	}
}


