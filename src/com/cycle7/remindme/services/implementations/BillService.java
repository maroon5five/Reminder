package com.cycle7.remindme.services.implementations;

import java.util.List;

import android.content.Context;
import android.widget.Toast;

import com.cycle7.remindme.database.IDatabaseHandler;
import com.cycle7.remindme.models.Bill;
import com.cycle7.remindme.services.interfaces.IBillService;
import com.google.inject.Inject;

public class BillService implements IBillService {
	@Inject IDatabaseHandler db;
	@Inject Bill bill;
	
	public boolean persistBill(String billName, String billAmount, String dueDate, String recurrence, Context context){
		boolean success = false;
		double parsedBillAmount = 0.0;
		try{
			parsedBillAmount = Double.parseDouble(billAmount);
		}catch(Exception e){
			
		}
		bill.setValues(billName, parsedBillAmount, dueDate, recurrence);		
		long affectedRow = db.persistBill(bill);
		if(affectedRow >= 1){
			Toast.makeText(context, "Bill added successfully", Toast.LENGTH_LONG).show();
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	@Override
	public List<Bill> getAllBills() {
		return db.getAllBills();
	}
}
