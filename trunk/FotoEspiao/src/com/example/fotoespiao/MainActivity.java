package com.example.fotoespiao;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	Game game ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		/*game = new Game(this);
		setContentView(game);*/
		
		
	}
	
	public void iniciar (View v){
		game = new Game(this);
		setContentView(game);
	}

	
}
