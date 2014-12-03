package com.cycle7.remindme.activities;

import net.cycle7.remindme.R;
import roboguice.activity.RoboFragmentActivity;
import roboguice.fragment.RoboFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends RoboFragmentActivity {
	
	protected abstract RoboFragment createFragment();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		FragmentManager fragmentManager = getSupportFragmentManager();
		RoboFragment fragment = (RoboFragment) fragmentManager.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = createFragment();
			fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
}
