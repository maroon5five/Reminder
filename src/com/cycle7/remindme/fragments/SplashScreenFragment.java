package com.cycle7.remindme.fragments;

import net.cycle7.remindme.R;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.cycle7.remindme.activities.BillFormActivity;
import com.cycle7.remindme.activities.BillListActivity;

public class SplashScreenFragment extends RoboFragment {
	
	@InjectView(R.id.addBillButton) 	private Button addBillButton;
	@InjectView(R.id.billListButton) 	private Button billListButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		super.onCreateView(inflater, parent, savedInstanceState);
		View view = inflater.inflate(R.layout.activity_splash_screen, parent, false);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
	    super.onViewCreated(view, savedInstanceState);
	    addBillButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), BillFormActivity.class);
				startActivity(intent);
			}
		});
	    billListButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), BillListActivity.class);
				startActivity(intent);
			}
	    });
	}
}
