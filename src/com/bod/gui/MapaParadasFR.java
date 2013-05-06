package com.bod.gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.bod.ConvertToLatLong;
import com.bod.IAssyncTask;
import com.bod.LastLocationFinder;
import com.bod.R;
import com.bod.bd.FactoryRepositorios;
import com.bod.bd.IRepositorio;
import com.bod.bd.RepParada;
import com.bod.entidades.Parada;
import com.bod.utilmapa.ItemizedOverlayFrMapa;
import com.bod.utilmapa.OverlayItemParada;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapaParadasFR extends OpenDocsFragmentActivity implements
		TextWatcher, OnClickListener, OnItemClickListener, LocationListener,
		OnTouchListener, IAssyncTask, Observer , Runnable{

	private MapView mapView;
	private MapController mapCtrl;
	private AutoCompleteTextView autoCompleteLocais;
	
	private Bundle parametrosLoader;
	

	private LastLocationFinder lastLicationFinder;
	private Location locationUsuario;
	private GeoPoint pontoUsuario;
	private GeoPoint pontoUsuarioAlvo;

	// **** Controle do id para solicitacao de busca dos anuncios

	private static int CodConsulta;

	Iterator<Parada> paradas;

	IRepositorio repositorios;
	// ****
	
	ItemizedOverlayFrMapa listaPontosParadas;
	
	
	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		// Pega a instancia do mapa, atribui o listner para quando o mapa se
		// mover e pega o controle do mapa
		mapView = (MapView) ((ContainerBusca) getActivity()).getMapView();
		
		mapView.setOnTouchListener(this);

		mapCtrl = mapView.getController();
		// *********
		parametrosLoader = new Bundle();

		// Tenta pegar a ultima localizacao do sistema de localizacao do celular
		lastLicationFinder = new LastLocationFinder(getActivity());

		// Registra a classe para escutar as mudancas do sistema de localizacao
		// se ele n for encontrado
		lastLicationFinder.setChangedLocationListener(this);

		locationUsuario = lastLicationFinder.getLastBestLocation(1, 120);
		if (locationUsuario != null) {
			setMyLocation(locationUsuario);

		}

		// inicialisa o codigo da busca do anuncio
		CodConsulta = 0;
		repositorios = FactoryRepositorios.createBuffer(RepParada.REPOSITORIO_PARADA, getActivity());
		paradas = (Iterator<Parada>) repositorios.recuperarRegistro();
		
		
		listaPontosParadas = new ItemizedOverlayFrMapa(getResources().getDrawable(R.drawable.mk_parada), mapView);
		
		startTask(parametrosLoader);
		
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Recupera a view do mapa
		View mainView = ((ContainerBusca) getActivity()).getMapViewContainer();
		// ******************
		View v = (View) mainView.getParent();
		if (v != null) {
			ViewGroup parent = (ViewGroup) v;
			parent.removeView(mainView);
		}

		((Button) mainView.findViewById(R.id.btLocation))
				.setOnClickListener(this);

		// Setar valores do autocomplete para o passageiro configurar a sua
		// posicao pelo endereco
		autoCompleteLocais = ((AutoCompleteTextView) mainView
				.findViewById(R.id.actvEndereco));
		
		autoCompleteLocais.addTextChangedListener(this);
		autoCompleteLocais.setOnItemClickListener(this);

		// ******************

		return mainView;
	}
	

	@Override
	public void onResume() {
		super.onResume();

	}

	@Override
	public void afterTextChanged(Editable s) {
		
		
		
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

	@Override
	public void onItemClick(AdapterView<?> adpt, View arg1, int arg2, long arg3) {
		
		
	}

//	@Override
//	public IAssyncTask getTransactionTask() {
//		return this;
//	}

	@Override
	public void preExecute(Bundle parametro) {
		
		
		
	}

	@Override
	public void execute(Bundle parametro) throws Exception {
		
		
		
		while(paradas.hasNext()){
			Parada parada = paradas.next();

			
			Double lat = ConvertToLatLong.convert( parada.getLatitude()) * -1E6;//Double.valueOf(parada.getLatitude().replaceAll(" ", ""))  / 1E6;
			Double log = ConvertToLatLong.convert(parada.getLongitude()) * -1E6;//Double.valueOf(parada.getLongitude().replaceAll(" ", "")) / 1E6;
			
			GeoPoint point = new GeoPoint(lat.intValue(), 
					                      log.intValue());
			
			float distanciaTela   = ConvertToLatLong.getDistanciaCentroToTopLeftMap(mapView);
			float distanciaParada = calcularDistanciaCentroMapa(point);
			if( distanciaParada < distanciaTela){
				OverlayItemParada oItemParada = new OverlayItemParada(point, parada);
				listaPontosParadas.addOverlay(oItemParada, getResources().getDrawable(R.drawable.mk_parada));
			}
		}
		

	}
	
	
	private float calcularDistanciaCentroMapa(GeoPoint point){
		
		Location centroLocation = new Location("CentroLocation");
		GeoPoint center = mapView.getMapCenter();
		centroLocation.setLatitude(center.getLatitudeE6()/ 1E6);
		centroLocation.setLongitude(center.getLongitudeE6()/ 1E6);
		
		Location p = new Location("p");
		p.setLatitude(point.getLatitudeE6() / 1E6);
		p.setLongitude(point.getLongitudeE6() / 1E6);
		
		float result = p.distanceTo(centroLocation);
		
		
		
		
		return result;
		
		
	}

	@Override
	public void updateView(Bundle parametro) {
		listaPontosParadas.populateNow();
		mapView.getOverlays().clear();
		mapView.getOverlays().add(listaPontosParadas);
		mapView.invalidate();
	}

//	@Override
//	public void startAtt() {
//		if (autoCompleteLocais.getVisibility() == View.VISIBLE) {
//			autoCompleteLocais.setVisibility(View.INVISIBLE);
//		} else {
//			autoCompleteLocais.setVisibility(View.VISIBLE);
//		}
//
//	}

	@Override
	public void onLocationChanged(Location location) {
		if (locationUsuario != null) {
			setMyLocation(locationUsuario);

		} else {
			Toast.makeText(getActivity(),
					"Nao foi possivel recuperar a sua posicao exata.",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(getActivity(),
				"Seu GPS esta desabilitado.A posicao pode n estar exata",
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(getActivity(), "teste2", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Toast.makeText(getActivity(), "teste3", Toast.LENGTH_SHORT).show();

	}

	private void setMyLocation(Location myLocation) {

		Double lat = myLocation.getLatitude() * 1E6;
		Double lon = myLocation.getLongitude() * 1E6;

		pontoUsuario = new GeoPoint(lat.intValue(), lon.intValue());
		pontoUsuarioAlvo = pontoUsuario;
		mapCtrl.animateTo(pontoUsuario,this);

		mapCtrl.setZoom(17);
		
		if (lastLicationFinder != null)
			lastLicationFinder.cancel(this);
		
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// Quando o mapa e movimentado para posicionar sua posicao correta entao
		// e atualizado o ponto que vai ficar o anuncio(a posicao central e
		// atualizada para isso)
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			pontoUsuario = mapView.getMapCenter();
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			
			getTopLeftCenterMapPoints();
			

//			ConsultaAnuncioMapa criteriosConsulta = new ConsultaAnuncioMapa();
//			criteriosConsulta.setCodConsulta(CodConsulta);
////
//			AnuncioRecuperar ar = new AnuncioRecuperar(criteriosConsulta,
//					getActivity(),this);
//			
			

			// controleBuffer.inserirInformacoesBuffer(criteriosConsulta);

		}

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			CodConsulta++;

		}

		return false;
	}

	@Override
	public void onClick(View v) {

		

	}

	@Override
	public void update(Observable observable, Object data) {
		
		
		
	}

	@Override
	public void run() {
		
		getTopLeftCenterMapPoints();
		
		
		
	}
	
	
	
	private void getTopLeftCenterMapPoints(){
		
		
	}
	
	private static final String URL_SCHEME = "https";
	
	public static Uri buildUri(String authority, String path, Bundle parameters) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(URL_SCHEME);
        builder.authority(authority);
        builder.path(path);
        for (String key : parameters.keySet()) {
            Object parameter = parameters.get(key);
            if (parameter instanceof String) {
                builder.appendQueryParameter(key, (String) parameter);
            }
        }
        return builder.build();
    }
	
	
	 static Map<String, Object> convertJSONObjectToHashMap(JSONObject jsonObject) {
	        HashMap<String, Object> map = new HashMap<String, Object>();
	        JSONArray keys = jsonObject.names();
	        for (int i = 0; i < keys.length(); ++i) {
	            String key;
	            try {
	                key = keys.getString(i);
	                Object value = jsonObject.get(key);
	                if (value instanceof JSONObject) {
	                    value = convertJSONObjectToHashMap((JSONObject) value);
	                }
	                map.put(key, value);
	            } catch (JSONException e) {
	            }
	        }
	        return map;
	    }
	 
	 public static Object getStringPropertyAsJSON(JSONObject jsonObject, String key, String nonJSONPropertyKey)
	            throws JSONException {
	        Object value = jsonObject.opt(key);
	        if (value != null && value instanceof String) {
	            JSONTokener tokener = new JSONTokener((String) value);
	            value = tokener.nextValue();
	        }

	        if (value != null && !(value instanceof JSONObject || value instanceof JSONArray)) {
	            if (nonJSONPropertyKey != null) {
	                // Facebook sometimes gives us back a non-JSON value such as
	                // literal "true" or "false" as a result.
	                // If we got something like that, we present it to the caller as
	                // a GraphObject with a single
	                // property. We only do this if the caller wants that behavior.
	                jsonObject = new JSONObject();
	                jsonObject.putOpt(nonJSONPropertyKey, value);
	                return jsonObject;
	            } else {
	                //throw new FacebookException("Got an unexpected non-JSON object.");
	            }
	        }

	        return value;

	    }

	@Override
	public IAssyncTask getTransactionTask() {
		// TODO Auto-generated method stub
		return this;
	}



	@Override
	public void startAtt() {
		// TODO Auto-generated method stub
		
	}
	
	

}
