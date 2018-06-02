package com.suhas.dbo;

import java.util.LinkedHashMap;

public class Appointment {

	private String name;
	private int phone;
	private String email;
	private String description;
	private String date;
	private String time;

	private LinkedHashMap<String, String> timeSlots;

	public Appointment() {

		timeSlots = new LinkedHashMap<>();
		timeSlots.put("10am", "10am - 10:30am");
		timeSlots.put("10:30am", "10:30am - 11:00am");
		timeSlots.put("11:00am", "11:00am - 11:30am");
		timeSlots.put("11:30am", "11:30am - 12:00pm");
		timeSlots.put("12:00pm", "12:00pm - 12:30pm");
		timeSlots.put("12:30pm", "12:30pm - 1:00pm");
		timeSlots.put("5:00pm", "5pm - 5:30pm");
		timeSlots.put("5:30pm", "5:30pm - 6:00pm");
		timeSlots.put("6:00pm", "6:00pm - 6:30pm");
		timeSlots.put("6:30pm", "6:30pm - 7:00pm");

	}

	public String getName() {
		return name;
	}

	public int getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LinkedHashMap<String, String> getTimeSlots() {
		return timeSlots;
	}

	@Override
	public String toString() {
		return "Appointment [name=" + name + ", phone=" + phone + ", email=" + email + ", description=" + description
				+ ", date=" + date + ", time=" + time + ", timeSlots=" + timeSlots + "]";
	}

	
	
}
