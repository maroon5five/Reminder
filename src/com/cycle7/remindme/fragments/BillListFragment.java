package com.cycle7.remindme.fragments;

import java.util.ArrayList;
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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BillListFragment extends RoboListFragment {
	@Inject LayoutInflater layoutInflater;
	@Inject IBillService billService;
	@Override
	public void onCreate(Bundle savedInstanceState){;
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){;
		super.onCreateView(inflater, parent, savedInstanceState);
		View view = inflater.inflate(R.layout.activity_bill_list, parent, false);
		List<Bill> billList = billService.getAllBills();
		ArrayAdapter<Bill> adapter = new BillAdapter(billList);
		setListAdapter(adapter);
		return view;
	}
	
	private class BillAdapter extends ArrayAdapter<Bill> {
		public BillAdapter(List<Bill> bills){
			super(getActivity(), 0, bills);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			if(convertView == null){
				convertView = getActivity().getLayoutInflater().inflate(R.layout.bill_list_item, null);
			}
			Bill bill = getItem(position);
			
			TextView billNameTextView = (TextView) convertView.findViewById(R.id.listBillName);
			billNameTextView.setText(bill.getName());
			
			TextView billAmountTextView = (TextView) convertView.findViewById(R.id.listBillAmount);
			billAmountTextView.setText(Double.toString(bill.getAmount()));
			
			TextView billDueDateTextView = (TextView) convertView.findViewById(R.id.listBillDueDate);
			billDueDateTextView.setText(bill.getDueDate());
			
			return convertView;
		}
	}
}
