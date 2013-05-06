package com.bod;

import android.os.Bundle;

public interface IAssyncTask {
	public void preExecute(Bundle parametro);
	public void execute(Bundle parametro) throws Exception;
	public void updateView(Bundle parametro);
}
