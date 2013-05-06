package com.bod.gui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;

import com.bod.R;
import com.google.android.maps.MapView;

public class ContainerBusca extends FragmentActivity implements
		OnClickListener, OnCheckedChangeListener, OnDrawerCloseListener {

	private View mMapViewContainer;
	private MapView mMapView;
	private SlidingDrawer sd;
	private OpenDocsFragmentActivity f;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tela_container_busca);
		
		mMapViewContainer = LayoutInflater.from( this ).inflate( R.layout.tela_mapa_buscar_anuncio, null );
		mMapView = (MapView)mMapViewContainer.findViewById( R.id.mapview );
		   

		
		updateFr("telaMapa");

		((RadioGroup) findViewById(R.id.rgMapaLista))
				.setOnCheckedChangeListener(this);

		sd = (SlidingDrawer) findViewById(R.id.sdFiltro);
		sd.setOnDrawerCloseListener(this);
	}

	private void updateFr(String tabId) {
		FragmentManager fm = getSupportFragmentManager();
		if (fm.findFragmentByTag(tabId) == null) {

			f = FactoryFragment.getFragment(tabId);

			fm.beginTransaction().replace(R.id.container_tela, f, tabId)
					.commit();

		}
	}

	public void setMapViewContainer(View mMapViewContainer) {
		this.mMapViewContainer = mMapViewContainer;
	}

	public View getMapViewContainer() {
		return mMapViewContainer;
	}

	public void setMapView(MapView mMapView) {
		this.mMapView = mMapView;
	}

	public MapView getMapView() {

		return mMapView;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {

		case R.id.rbMapa:
			updateFr("telaMapa");
			break;
		case R.id.rbLista:
			updateFr("telaLista");
			break;

		}
	}

	@Override
	public void onDrawerClosed() {
		sd.setVisibility(View.GONE);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	
}





