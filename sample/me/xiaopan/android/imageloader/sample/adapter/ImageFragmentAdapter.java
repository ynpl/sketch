package me.xiaopan.android.imageloader.sample.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import me.xiaopan.android.imageloader.sample.fragment.ImageFragment;

public class ImageFragmentAdapter extends FragmentStatePagerAdapter {
	private String[] uris;
	
	public ImageFragmentAdapter(FragmentManager fm, String[] uris) {
		super(fm);
		this.uris = uris;
	}

	@Override
	public int getCount() {
		return uris.length;
	}

	@Override
	public Fragment getItem(int arg0) {
		ImageFragment imageFragment = new ImageFragment();
		Bundle bundle = new Bundle();
		bundle.putString(ImageFragment.PARAM_REQUIRED_IMAGE_URI, uris[arg0]);
		imageFragment.setArguments(bundle);
		return imageFragment;
	}
}