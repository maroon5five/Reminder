package com.cycle7.remindme.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.cycle7.remindme.activities.BillFormActivity;
import com.google.inject.Inject;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
	@Inject private Bundle bundle;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//Get the date out of the passed arguments to populate the picker
		bundle = this.getArguments();
		int year = bundle.getInt("year");
		int month = bundle.getInt("month");
		int day = bundle.getInt("day");
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}
	public void onDateSet(DatePicker view, int year, int month, int day) {
		((BillFormActivity) getActivity()).setDueDate(year, month, day);
	}
}
