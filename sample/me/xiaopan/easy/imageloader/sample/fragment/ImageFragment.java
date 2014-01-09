package me.xiaopan.easy.imageloader.sample.fragment;

import me.xiaoapn.easy.imageloader.ImageLoadListener;
import me.xiaoapn.easy.imageloader.ImageLoader;
import me.xiaoapn.easy.imageloader.R;
import me.xiaoapn.easy.imageloader.task.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ImageFragment extends Fragment {
	public static final String PARAM_REQUIRED_IMAGE_URI = "PARAM_REQUIRED_IMAGE_URI";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		String uri = null;
		Bundle bundle = getArguments();
		if(bundle != null){
			uri = bundle.getString(PARAM_REQUIRED_IMAGE_URI);
		}
		if(uri != null){
			View rootView = inflater.inflate(R.layout.fragment_image, null);
			ImageView imageView = (ImageView) rootView.findViewById(R.id.image_imageFragment_image);
			
			final ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress_imageFragment_progress);
			
			Options options = ImageLoader.getInstance().getConfiguration().getDefaultOptions().copy();
			options.setLoadingDrawable(null);
			
			ImageLoader.getInstance().display(uri, imageView, options, new ImageLoadListener() {
				@Override
				public void onStarted(String imageUri, ImageView imageView) {
					progressBar.setVisibility(View.VISIBLE);
				}
				
				@Override
				public void onFailed(String imageUri, ImageView imageView) {
					progressBar.setVisibility(View.GONE);
				}
				
				@Override
				public void onComplete(String imageUri, ImageView imageView, BitmapDrawable drawable) {
					progressBar.setVisibility(View.GONE);
				}
				
				@Override
				public void onCancelled(String imageUri, ImageView imageView) {
					progressBar.setVisibility(View.GONE);
				}
			});
			return rootView;
		}else{
			return null;
		}
	}
}