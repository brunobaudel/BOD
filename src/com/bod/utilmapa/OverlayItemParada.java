package com.bod.utilmapa;


import android.view.View;
import android.widget.TextView;

import com.bod.R;
import com.bod.entidades.Parada;
import com.google.android.maps.GeoPoint;


public class OverlayItemParada extends OverlayItemOpenDocs{
	
	
	Parada parada;

	public OverlayItemParada(GeoPoint point, Parada parada) {
		super(point, parada.getBairro(), parada.getCidade());
		this.parada = parada;
	}

	@Override
	public void setData(Object set, View v) {
		v.setVisibility(View.VISIBLE);
		
		((TextView)v.findViewById(R.id.tvNumParada)).setText(parada.getCodigoParada());
		((TextView)v.findViewById(R.id.tvBairro)).setText(parada.getBairro());
		((TextView)v.findViewById(R.id.tvEnderecoParada)).setText(parada.getLogradouro());
		
		
		
	}
	
	

}
