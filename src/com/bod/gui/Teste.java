package com.bod.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.bod.R;
import com.google.android.maps.MapView;

public class Teste extends Activity {
	
	private View mMapViewContainer;
	private MapView mMapView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.tela_container_busca);
		
		mMapViewContainer = LayoutInflater.from( this ).inflate( R.layout.tela_mapa_buscar_anuncio, null );
		mMapView = (MapView)mMapViewContainer.findViewById( R.id.mapview );
		
		
		
	}
	
}
