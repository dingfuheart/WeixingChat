package com.example.weixinchatview;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_home extends Fragment {
	View view;
    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 view=inflater.inflate(R.layout.fragment_home, container, false);
		 return view;
	}
	
	

}
