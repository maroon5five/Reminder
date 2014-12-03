package com.cycle7.remindme.activities;

import roboguice.fragment.RoboFragment;

import com.cycle7.remindme.fragments.BillFormFragment;

public class BillFormActivity extends SingleFragmentActivity {

	private BillFormFragment addBillFragment;
	
	@Override
	protected RoboFragment createFragment(){
		addBillFragment = new BillFormFragment();
		return addBillFragment;
	}
	
	/**
	 * Sets the dueDate.  Called from the date picker dialog box
	 */
	public void setDueDate(int year, int month, int day) {
		addBillFragment.setDueDate(year, month, day);
	}
}
