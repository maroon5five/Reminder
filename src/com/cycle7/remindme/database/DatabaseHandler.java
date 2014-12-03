package com.cycle7.remindme.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.cycle7.remindme.models.Bill;
import com.google.inject.Inject;

public class DatabaseHandler extends SQLiteOpenHelper implements IDatabaseHandler {
	private static final String CLASS_NAME = "Database Handler";
	
	private static final String DATABASE_NAME = "remindme";
	private static final String BILLS_TABLE = "bills";
	private static final int DATABASE_VERSION = 1;
	
	private static final String ID = "id",
								NAME = "name",
								AMOUNT = "amount",
								DUE_DATE = "dueDate",
								RECURRENCE = "recurrence";
	
	private Context context;
	private Cursor cursor;
	
	//Table creation scripts
	private static final String BILL_TABLE_CREATE = "create table "+BILLS_TABLE+" ("+ID+" integer primary key autoincrement, " +
																		   			 NAME+" text, " +
																		   			 AMOUNT+" real, " +
																		   			 DUE_DATE+" text, " +
																		   			 RECURRENCE+" text)";
	
	//Queries
	private static final String GET_ALL_BILLS = "SELECT * FROM "+BILLS_TABLE;

	@Inject
	public DatabaseHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(BILL_TABLE_CREATE);
		}catch(Exception e){
			Log.e(CLASS_NAME, "Error in onCreate");
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public long persistBill(Bill bill){
		long affectedRow = 0;
		try{
			SQLiteDatabase db = this.getWritableDatabase();
			
			ContentValues contentValues = new ContentValues();
            contentValues.put(NAME, bill.getName());
            contentValues.put(AMOUNT, bill.getAmount());
            contentValues.put(DUE_DATE, bill.getDueDate());
            contentValues.put(RECURRENCE, bill.getRecurrence());
           
            affectedRow = db.insert(BILLS_TABLE, null, contentValues);

            db.close();
		}catch(Exception e){
			Log.e(CLASS_NAME, "Error in addBill");
		}
		return affectedRow;
	}
	
	public List<Bill> getAllBills(){
		List<Bill> allBills = new ArrayList<Bill>();
		  
    	SQLiteDatabase db = this.getReadableDatabase();
    	cursor = db.rawQuery(GET_ALL_BILLS, null);

    	//Gets all of the column indexes to map the values to a bill object
    	int billIdIndex = cursor.getColumnIndex(ID);
    	int billNameIndex = cursor.getColumnIndex(NAME);
    	int billAmountIndex = cursor.getColumnIndex(AMOUNT);
    	int billDueDateIndex = cursor.getColumnIndex(DUE_DATE);
    	int billRecurrenceIndex = cursor.getColumnIndex(RECURRENCE);
    	
    	if (cursor != null && cursor.moveToFirst()) {         
    		do{
    			try{
                    //Maps all of the information to a bill object
    				Bill bill = new Bill();
    				bill.setId(cursor.getInt(billIdIndex));
    				bill.setName(cursor.getString(billNameIndex));
    				bill.setAmount(cursor.getDouble(billAmountIndex));
    				bill.setDueDate(cursor.getString(billDueDateIndex));
    				bill.setRecurrence(cursor.getString(billRecurrenceIndex));
    				allBills.add(bill);
    			}catch(Exception e){
                    e.printStackTrace();
    			}
    		}while(cursor.moveToNext());
    	}
    	db.close();

    	return allBills;
	}

}
