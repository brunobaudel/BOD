package com.bod.gui;


public class FactoryFragment {

	public static OpenDocsFragmentActivity getFragment(String fragmentName){
		
		OpenDocsFragmentActivity fr = null;
		
		if("telaMapa".equals(fragmentName)){
			
			fr = new MapaParadasFR();
			
		}else if("telaLista".equals(fragmentName)){
			fr = new ListaParadasFR();
		}else{
			
		}
		
		return fr;
	}
	
}
