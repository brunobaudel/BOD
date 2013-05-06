package com.bod.parsers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.bod.bd.FactoryRepositorios;
import com.bod.bd.IRepositorio;
import com.bod.bd.RepParada;

public class ParserArquivoToInsertBD {

	//getResources().openRawResource(R.raw.insettbl_paradas)
	
	private static IRepositorio<?, Iterator<?>, Cursor> repositorios;
	
	
	
	public static void execParse(int res,Context c){
	
	     try
	     {
	     	BufferedReader br = new BufferedReader(new InputStreamReader(c.getResources().openRawResource(res)));
	         //efetua uma leitura linha a linha do arquivo a carrega 
	         //a caixa de texto com a informação lida
	     	StringBuilder total = new StringBuilder();
	     	String line;
	     	while ((line = br.readLine()) != null) {
	     	    total.append(line);
	     	}
	     	
	     	
	     	//Inserir bd 
	     	repositorios = FactoryRepositorios.createBuffer(RepParada.REPOSITORIO_PARADA, c);
	     	
	     	
	     	String[] listaStrings = total.toString().split(";");
	     	
	     	List<String> listInserts = new ArrayList<String>(Arrays.asList(listaStrings));
	     	
	     	for (String string : listInserts) {
	     		repositorios.inserirItemSQL(string);
			}
	     	  
	     } catch (Exception e) {
	        
	     }        
	}
	
	
}
