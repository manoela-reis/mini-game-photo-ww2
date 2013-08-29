package com.example.fotoespiao;

import android.graphics.Rect;

public class Obstaculos {

	
	public static Rect createObstaculo(int positionX, int positionY, int width, int height){
		
		Rect rectObstaculo = new Rect(positionX, positionY, width, height);
		return rectObstaculo;
		
		
	}

}
