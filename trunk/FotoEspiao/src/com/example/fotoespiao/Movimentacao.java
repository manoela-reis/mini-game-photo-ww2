package com.example.fotoespiao;

import android.graphics.Rect;
import android.util.Log;

public class Movimentacao {

	int x;
	int y;
	public Rect Person = new Rect();

	public Movimentacao(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public void movimentar(int posX, int posY, Rect rect) {
		Log.i("foi", "down baby down !! ");
		if (rect.left + posX >= 0 && rect.top + posY >= 0
				&& rect.right + posX <= x && rect.bottom + posY <= y){
			rect.set(rect.left + posX, rect.top + posY, rect.right + posX,
					rect.bottom + posY);
		}

	}

}
