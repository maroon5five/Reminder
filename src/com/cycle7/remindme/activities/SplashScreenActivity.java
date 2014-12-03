package com.cycle7.remindme.activities;

import roboguice.fragment.RoboFragment;
import com.cycle7.remindme.fragments.SplashScreenFragment;

public class SplashScreenActivity extends SingleFragmentActivity {

	@Override
	protected RoboFragment createFragment() {
		return new SplashScreenFragment();
	}

}
