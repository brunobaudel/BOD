package com.bod.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bod.IAssyncTask;
import com.bod.R;

public class ListaParadasFR   extends OpenDocsFragmentActivity  {
	
	private ListView lstView;
	
	
	public ListaParadasFR(){
		super();
	}
	
	@Override
	public void onAttach(Activity arg0) {
		// TODO Auto-generated method stub
		super.onAttach(arg0);
	}
	
	@Override
    public void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            
    	  //Recupera a view do mapa
    	  View mainView = inflater.inflate(R.layout.tela_lista_buscar_anuncio , null);
    	  //******************
    	  
    	  //lstView = (ListView) mainView.findViewById(R.id.listBuscarAnuncios);
    	  
    	  
    	  //lstView.setAdapter(adpListaAnuncio);
 		  
          return mainView;
    }
    
    
    
    
    @Override
	public void onResume() {
		super.onResume();
		
	}

	@Override
	public IAssyncTask getTransactionTask() {
		return null;
	}

	@Override
	public void startAtt() {
		
		
	}
}
