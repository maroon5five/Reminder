package com.cycle7.remindme.activities;

import android.support.v4.app.Fragment;

import com.cycle7.remindme.fragments.BillListFragment;

public class BillListActivity extends SingleFragmentActivity{

	@Override
	protected Fragment createFragment() {
		return new BillListFragment();
	}
}
