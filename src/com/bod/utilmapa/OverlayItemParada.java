package com.bod.utilmapa;

import android.view.View;

import com.bod.entidades.Parada;
import com.google.android.maps.GeoPoint;


public class OverlayItemParada extends OverlayItemOpenDocs{
	

	public OverlayItemParada(GeoPoint point, Parada parada) {
		super(point, parada.getBairro(), parada.getCidade());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setData(Object set, View v) {
		v.setVisibility(View.VISIBLE);
		
	}
	
	

}
