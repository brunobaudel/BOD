package com.bod.bd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.bod.entidades.Parada;

public class RepParada implements IRepositorio<Parada, Iterator<?>, Cursor> {

	public static final int REPOSITORIO_PARADA = 001100;

	private CriarBD db;

	RepParada(Context c) {
		db = CriarBD.getBD(c);

	}

	@Override
	public long inserir(Parada it) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String recuperarJson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Parada> recuperarRegistro() {

		String query = "SELECT * FROM %s ";

		query = String.format(query, TabelasBusOpenDocs.TBL_Paradas);

		Cursor c = db.execSql(query);

		List<Parada> listaParadas = new ArrayList<Parada>();

		if (c.getCount() > 0) {
			while (c.moveToNext()) {
				Parada parada = new Parada();
				parada.setCodigoParada(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_CODIGOPARADA)));
				parada.setLogradouro(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_LOGRADOURO)));
				parada.setCidade(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_CIDADE)));
				parada.setBairro(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_BAIRRO)));
				parada.setLatitude(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_LATITUDE)));
				parada.setLongitude(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_LONGITUDE)));
				
				listaParadas.add(parada);			}
		}
		
		return listaParadas.iterator();
	}

	@Override
	public Cursor executarSql(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarItem(String codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Parada recuperarItem(String codigo) {

		String query = "SELECT * FROM %s WHERE %s = %s";

		query = String.format(query, TabelasBusOpenDocs.TBL_Paradas,
				TabelasBusOpenDocs.CAMPO_TB_CODIGOPARADA, codigo);

		Cursor c = db.execSql(query);

		Parada parada = new Parada();

		if (c.getCount() > 0) {
			while (c.moveToNext()) {

				parada.setCodigoParada(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_CODIGOPARADA)));
				parada.setLogradouro(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_LOGRADOURO)));
				parada.setCidade(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_CIDADE)));
				parada.setBairro(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_BAIRRO)));
				parada.setLatitude(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_LATITUDE)));
				parada.setLongitude(c.getString(c
						.getColumnIndex(TabelasBusOpenDocs.CAMPO_TB_LONGITUDE)));

			}
		}

		return parada;
	}

	@Override
	public void inserirItemSQL(String comando) {

		db.execSqlInsert(comando);
	}

}
