package com.cycle7.remindme.activities;

import roboguice.fragment.RoboFragment;
import com.cycle7.remindme.fragments.BillListFragment;

public class BillListActivity extends SingleFragmentActivity{

	@Override
	protected RoboFragment createFragment() {
		return new BillListFragment();
	}
}
