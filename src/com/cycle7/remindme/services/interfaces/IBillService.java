package com.cycle7.remindme.services.interfaces;

import java.util.List;

import com.cycle7.remindme.models.Bill;

import android.content.Context;

public interface IBillService {
	/**
	 * Persists a bill to the database
	 * @param billName
	 * @param billAmount
	 * @param dueDate
	 * @param recurrence
	 * @param context
	 * @return
	 */
	public boolean persistBill(String billName, String billAmount, String dueDate, String recurrence, Context context);
	/**
	 * Returns a list of all the bills that are in the database
	 * @return
	 */
	public List<Bill> getAllBills();
}
