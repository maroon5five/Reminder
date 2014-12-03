package com.cycle7.remindme.services.implementations;

import java.util.Calendar;

import android.app.Activity;

import com.cycle7.remindme.activities.BillFormActivity;
import com.cycle7.remindme.services.interfaces.IDateService;

public class DateService implements IDateService {

	@Override
	public void setCurrectDateOnDueDateButton(Activity activity) {
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		((BillFormActivity) activity).setDueDate(year, month, day);
	}
}
