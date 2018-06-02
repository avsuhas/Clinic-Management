package com.suhas.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.suhas.dao.AppointmentDao;
import com.suhas.dao.AvailableTimeSlot;
import com.suhas.dbo.Appointment;
import java.lang.reflect.Type;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(){
		return "welcome";
	}
	
	@RequestMapping("/make_appointment")
	public String bookAppointment(){
		
		return "confirmation";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model){

		//Creating patient object to pre-populate contact form on the view
		Appointment apt = new Appointment();
		
		//Adding to the model
		model.addAttribute("appointment",apt);

		//Use "appointment" on the view form  
		return "contact";
	}
	
	@RequestMapping("/activeSlots")
	@ResponseBody
	public String getTime(@RequestParam("date") String date){
		
		AvailableTimeSlot ts = new AvailableTimeSlot();
		List<String> bookedTime = ts.getInfo(date);
		LinkedHashMap<String,String> availTimeSlots = ts.availTime(bookedTime);
	
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(availTimeSlots);
		
		return json;
	}
	
	@RequestMapping("/confirm")
	public String confirm(@ModelAttribute("appointment") Appointment apt, Model model){
			
		AppointmentDao aptDao = new AppointmentDao();
		int apt_no = aptDao.insert(apt);
		model.addAttribute("appointment", apt_no);
		return "confirmation";
	}
	@RequestMapping("/Clinic-Mgmt/welcome")
	public String redirect(){
		return "welcome";
	}
}
