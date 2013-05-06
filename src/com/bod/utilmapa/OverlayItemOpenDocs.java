package com.bod.utilmapa;

import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public abstract class OverlayItemOpenDocs extends OverlayItem {

	public OverlayItemOpenDocs(GeoPoint point, String title, String snippet) {
		super(point, title, snippet);
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract void setData(Object set,View v);
	
	
	
}
