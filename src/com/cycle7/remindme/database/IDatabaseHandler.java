package com.cycle7.remindme.database;

import java.util.List;

import com.cycle7.remindme.models.Bill;

import android.database.sqlite.SQLiteDatabase;

public interface IDatabaseHandler {
	public void onCreate(SQLiteDatabase db);
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2);	
	/**
	 * Persists a bill to the DB
	 * @param bill
	 * @return
	 */
	public long persistBill(Bill bill);
	
	/**
	 * Returns all of the bills from the DB
	 * @return
	 */
	public List<Bill> getAllBills();
}
