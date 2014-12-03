package com.cycle7.remindme.fragments;

import java.util.ArrayList;

import net.cycle7.remindme.R;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cycle7.remindme.services.interfaces.IBillService;
import com.cycle7.remindme.services.interfaces.IDateService;
import com.google.inject.Inject;

public class BillFormFragment extends RoboFragment {
	
	@InjectView(R.id.billNameEditText) 		private EditText billNameEditText;
	@InjectView(R.id.amountOfBillEditText) 	private EditText billAmountEditText;
	@InjectView(R.id.recurrenceSpinner)		private Spinner recurrenceSpinner;
	@InjectView(R.id.submitButton) 			private Button submitButton;
	@InjectView(R.id.dueDatePicker)			private Button dueDatePicker;
	
	@Inject private IBillService billService;
	@Inject private IDateService dateService;
	@Inject private DatePickerFragment datePickerFragment;
	@Inject private Bundle bundle;
	
	private ArrayList<String> recurrenceList;
	private String billName,
				   recurrence,
				   billAmount,
				   dueDate;	
	private int buttonYear,
				buttonMonth,
				buttonDay;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){;
		super.onCreateView(inflater, parent, savedInstanceState);
		View view = inflater.inflate(R.layout.activity_bill_form, parent, false);
		return view;
	}
	/**
	 * Connects all the views from the page.  Called after the view is created
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
	    super.onViewCreated(view, savedInstanceState);
		//Set the bill amount edit text to use a number keyboard
		billAmountEditText.setRawInputType(Configuration.KEYBOARD_12KEY);
		dateService.setCurrectDateOnDueDateButton(getActivity());
		setOnClickListeners();
		populateRecurrenceSpinner();
	}

	/**
	 * Populates the recurrence spinner
	 */
	private void populateRecurrenceSpinner() {
		recurrenceList = new ArrayList<String>();
		recurrenceList.add("Monthly");
		recurrenceList.add("One-time");
		ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, recurrenceList);
		recurrenceSpinner.setAdapter(adapter);	
	}

	/**
	 * Sets the OnClickListener for the due date edit text and the submit bill button
	 */
	private void setOnClickListeners() {
		dueDatePicker.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Adds the date that is currently on the button to a bundle and passes it to the date picker fragment.
				bundle.putInt("year", buttonYear);
				bundle.putInt("month", buttonMonth);
				bundle.putInt("day", buttonDay);
				datePickerFragment.setArguments(bundle);
				//Shows the due date picker dialog box
				datePickerFragment.show(getFragmentManager(), "datePicker");	
			}
		});
		submitButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				submitBill();
			}
		});
	}
	

	/**
	 * Submits the bill to the DB
	 */
	private void submitBill() {
		//Get all of the values from the page
		billName = billNameEditText.getText().toString();
		billAmount = billAmountEditText.getText().toString();
		recurrence = recurrenceSpinner.getSelectedItem().toString();
		//sends the bill information to the bill service to be persisted
		billService.persistBill(billName, billAmount, dueDate, recurrence, getActivity());
	}
	
	/**
	 * Sets the dueDate.  Called from the date picker dialog box
	 */
	public void setDueDate(int year, int month, int day) {
		buttonYear = year;
		buttonMonth = month;
		buttonDay = day;
		//Month is indexed at zero, hence the +1
		dueDatePicker.setText(month+1 + "/" + day + "/" + year);
	}

}
