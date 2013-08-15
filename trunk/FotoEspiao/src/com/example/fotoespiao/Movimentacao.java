package com.example.fotoespiao;

import android.graphics.Rect;
import android.util.Log;


public class Movimentacao {

	int x;
	int y;
	public Rect Person = new Rect();
	public Movimentacao(int x, int y) {

		
	}

	public void movimentar(int posX, int posY, Rect rect) {
		Log.i("foi", "down baby down !! ");
		rect.set(rect.left+posX, rect.top+posY, rect.right+posX, rect.bottom+posY);
		
	}
	public Rect getPosition(){
		return Person;
	}

}
