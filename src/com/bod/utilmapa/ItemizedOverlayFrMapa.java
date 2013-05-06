package com.bod.utilmapa;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.google.android.maps.MapView;

public class ItemizedOverlayFrMapa extends BalloonItemizedOverlay<OverlayItemOpenDocs> {

	private List<OverlayItemOpenDocs> mOverlays ;
	
	
	
	public List<OverlayItemOpenDocs> getmOverlays() {
		return mOverlays;
	}

	public ItemizedOverlayFrMapa(Drawable markerDrawable, MapView mapView) {
		super(boundCenterBottom(markerDrawable), mapView);
		
		mOverlays = new ArrayList<OverlayItemOpenDocs>();
		
	}
	
	public void addOverlay(OverlayItemOpenDocs overlay,Drawable marker) {
		overlay.setMarker(boundCenterBottom(marker));
		mOverlays.add(overlay);
	}
	
	public void populateNow() {
		populate();
	}

	@Override
	protected OverlayItemOpenDocs createItem(int location) {
		return mOverlays.get(location);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}
}
