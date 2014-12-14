package com.cycle7.remindme.activities;

import net.cycle7.remindme.R;
import roboguice.activity.RoboFragmentActivity;
import roboguice.fragment.RoboFragment;
import roboguice.fragment.RoboListFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.cycle7.remindme.fragments.BillListFragment;

public class BillListActivity extends RoboFragmentActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_fragment);
		FragmentManager fragmentManager = getSupportFragmentManager();
		RoboListFragment fragment = (RoboListFragment) fragmentManager.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = new BillListFragment();
			fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
}
