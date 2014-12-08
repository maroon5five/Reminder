package com.cycle7.remindme.fragments;

import java.util.List;

import com.cycle7.remindme.models.Bill;
import com.cycle7.remindme.services.interfaces.IBillService;
import com.google.inject.Inject;

import net.cycle7.remindme.R;
import roboguice.RoboGuice;
import roboguice.fragment.RoboFragment;
import roboguice.fragment.RoboListFragment;
import roboguice.inject.InjectView;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BillListFragment extends RoboListFragment {
	@Inject LayoutInflater layoutInflater;
	@Inject IBillService billService;
	@InjectView(R.layout.bill_list_item) LinearLayout layout;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){;
		super.onCreateView(inflater, parent, savedInstanceState);

		return inflater.inflate(R.layout.activity_bill_list, parent, false);
	}
	/**
	 * Connects all the views from the page.  Called after the view is created
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
	    super.onViewCreated(view, savedInstanceState);
	    RoboGuice.getInjector(getActivity()).injectViewMembers(this);
	    
	    
		List<Bill> billList = billService.getAllBills();
		for(Bill bill : billList){
			TextView billNameTextView = (TextView) layout.findViewById(R.id.listBillName);
			billNameTextView.setText(bill.getName());
			TextView billAmountTextView = (TextView) layout.findViewById(R.id.listBillAmount);
			billAmountTextView.setText(Double.toString(bill.getAmount()));
			TextView billDueDateTextView = (TextView) layout.findViewById(R.id.ListBillDueDate);
			billDueDateTextView.setText(bill.getDueDate());
			layoutInflater.inflate(layout.getId(), layout);
		}
	}
}
