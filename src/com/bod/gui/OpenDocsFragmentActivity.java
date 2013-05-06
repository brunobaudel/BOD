package com.bod.gui;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.bod.AtualizarFragment;
import com.bod.IAssyncTask;

public abstract class OpenDocsFragmentActivity extends Fragment implements AtualizarFragment{
	
	private TransactionTask task;
	private boolean primeira;
	
	
	
	public Status asyncTaskStatus(){
		return task.getStatus();
	}
	
	public abstract IAssyncTask getTransactionTask();

	protected void startTask(Bundle b) {
		
		task = new TransactionTask(getTransactionTask());
		primeira = true;
		
		
		if(b == null){
			b = new Bundle();
		}
		task.setParametros(b);
		if(asyncTaskStatus().equals(AsyncTask.Status.FINISHED)|| primeira){
			task.execute();
			primeira = false;
		}
	}
	
	class TransactionTask extends AsyncTask<Void, Void, Boolean> {
		private static final String TAG = "MobiTaxi";
		
		private final IAssyncTask transaction;
		private Bundle parametros;
		
				
		public TransactionTask(IAssyncTask transaction) {
			//this.context = context;
			this.transaction = transaction;
			
		}
		
		@Override
		// Antes de executar, vamos exibir uma janela de progresso
		protected void onPreExecute() {
			transaction.preExecute(parametros);
		}
		
		// Busca os Tempos em segundo plano dentro da thread
		protected Boolean doInBackground(Void... params) {
			try {
				transaction.execute(parametros);
				return true;
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
				
			} finally {
			}
			return false;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			try {
				if(result) {
					transaction.updateView(parametros);
				}
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
				
			} finally {
				//hideProgress();
			}
		}
		
		public Bundle getParametros() {
			return parametros;
		}

		public void setParametros(Bundle parametros) {
			this.parametros = parametros;
		}
	}

}
