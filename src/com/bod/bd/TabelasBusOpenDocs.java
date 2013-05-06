package com.bod.bd;

public class TabelasBusOpenDocs {

	
	//codigo_da_parada, logradouro,bairro,cidade,latiitude,longitude
	//Nome da tabela do buffer
		public final static String TBL_Paradas      = "tbl_Paradas_Onibus";
		//Campos da tabela
		
		public final static String CAMPO_TB_CODIGOPARADA  = "codigo_da_parada";
		public final static String CAMPO_TB_LOGRADOURO    = "logradouro";
		public final static String CAMPO_TB_BAIRRO    	  = "bairro";
		public final static String CAMPO_TB_CIDADE 		  = "cidade";
		public final static String CAMPO_TB_LATITUDE   	  = "latiitude";
		public final static String CAMPO_TB_LONGITUDE 	  = "longitude";
		
		
		
		private static final String CRIAR_TABELA_PARADAS  = "CREATE TABLE " + TBL_Paradas + "("
																			+ "codigo INTEGER PRIMARY KEY AUTOINCREMENT,"
																			+ CAMPO_TB_CODIGOPARADA   				 + " TEXT  NULL,"
																			+ CAMPO_TB_LOGRADOURO   				 + " TEXT  NULL,"
																			+ CAMPO_TB_BAIRRO    				     + " TEXT  NULL,"
																			+ CAMPO_TB_CIDADE         				 + " TEXT  NULL,"
																			+ CAMPO_TB_LATITUDE       				 + " TEXT  NULL,"
																			+ CAMPO_TB_LONGITUDE                     + " TEXT  NULL)";
		
		public final static String TBL_LogAtualizacao = "tbl_log_atualizacao";
		
		public final static String CAMPO_NOME_TABELA            = "tabela";
		public final static String CAMPO_DT_ULTIMA_ATUALIZACAO  = "dt_ultima_att";
		public final static String CAMPO_DETERMINAR_ATUALIZACAO = "atualizar";
		
		private static final String CRIAR_TABELA_ATUALIZACAO  = "CREATE TABLE " + TBL_LogAtualizacao + "("
				+ "codigo INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ CAMPO_NOME_TABELA   				     + " TEXT     NULL,"
				+ CAMPO_DT_ULTIMA_ATUALIZACAO   	     + " NUMERIC  NULL,"
				+ CAMPO_DETERMINAR_ATUALIZACAO   	     + " TEXT     NULL)";

		
		
		public static String[] getTables(){
			String[] retorno = {CRIAR_TABELA_PARADAS,CRIAR_TABELA_ATUALIZACAO};
			
			return retorno;
		}
	
}
