package com.cycle7.remindme.models;

import java.io.Serializable;

public class Bill implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private double amount;
	private String dueDate;
	private String recurrence;
	
	/*
	 * ---------- Constructors ----------
	 */
	/**
	 * Default no-args constructor
	 */
	public Bill(){}
	
	/**
	 * Set values for a bill
	 */
	public void setValues(String name, double amount, String dueDate, String recurrence){
		this.name = name;
		this.amount = amount;
		this.dueDate = dueDate;
		this.recurrence = recurrence;
	}
	
	
	/*
	 * ---------- Getters/Setters ----------
	 */
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the recurrence
	 */
	public String getRecurrence() {
		return recurrence;
	}
	/**
	 * @param recurrence the recurrence to set
	 */
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	
}
