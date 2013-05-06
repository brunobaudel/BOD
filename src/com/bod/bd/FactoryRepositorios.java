package com.bod.bd;

import java.util.Iterator;

import android.content.Context;
import android.database.Cursor;

public class FactoryRepositorios {

	
	public static IRepositorio<?, Iterator<?>, Cursor> createBuffer(int tipoBuffer,Context c){
		
		IRepositorio<?, Iterator<?>, Cursor> repositorio = null;
		
		switch (tipoBuffer) {
		
		case RepParada.REPOSITORIO_PARADA :
			
			repositorio = new RepParada(c);
			

		default:
			break;
		}
		
		return repositorio;
		
		
	}
	
}
