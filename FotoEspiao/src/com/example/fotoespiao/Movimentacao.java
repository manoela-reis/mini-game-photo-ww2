package com.example.fotoespiao;

import android.graphics.Rect;

public class Movimentacao {

	int x;
	int y;

	public Movimentacao() {

	}

	public void movimentar(int posX, int posY, Rect rect) {

		this.x = posX;
		this.y = posY;
		rect.set(posX, posY, posX + rect.width(), posY + rect.height());
	}

}
