package com.bod.gui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.bod.R;
import com.bod.parsers.ParserArquivoToInsertBD;

public class HomeAct extends Activity implements OnClickListener{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 //ParserArquivoToInsertBD.execParse(R.raw.insettbl_paradas, this);
	       
		
		 ((Button)findViewById(R.id.btAbrirMapa)).setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View v) {
		Intent it = new Intent(this, ContainerBusca.class);
		startActivity(it);
		
	}

}
