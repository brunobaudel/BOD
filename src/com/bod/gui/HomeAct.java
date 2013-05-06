package com.bod.gui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.bod.IAssyncTask;
import com.bod.R;

public class HomeAct extends BODActivity implements OnClickListener, IAssyncTask{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	       
		
		 ((Button)findViewById(R.id.btAbrirMapa)).setOnClickListener(this);
		 startTask(new Bundle());
	}
	
	
	@Override
	public void onClick(View v) {
		Intent it = new Intent(this, ContainerBusca.class);
		startActivity(it);
		
	}


	@Override
	public void preExecute(Bundle parametro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void execute(Bundle parametro) throws Exception {
		 //ParserArquivoToInsertBD.execParse(R.raw.insettbl_paradas, this);
		
	}


	@Override
	public void updateView(Bundle parametro) {
		Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
		
	}


	


	@Override
	public IAssyncTask getTransactionTask() {
		// TODO Auto-generated method stub
		return this;
	}


	@Override
	public void initComponentes() {
		// TODO Auto-generated method stub
		
	}

}
