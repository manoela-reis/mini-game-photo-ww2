package com.example.fotoespiao;

import java.util.Random;

import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

public class Inimigo {

	int x = 0;;
	int y = 0;
	public static boolean andando = false;
	int positionX = 0;
	int positionY = 0;
	private Boolean colidiu = false;
	private Rect[] rectsObstaculos = new Rect[7];

	Random rnd=new Random();
	private Rect rectinimigo;

	public Inimigo(int x, int y,Rect rect) {

		this.x = x;
		this.y = y;
		this.rectinimigo = rect;
	}

	

	public void movimentarInimigo(int posX, int posY, Rect rect) {
		
		Log.i("foi", "down baby down !! ");
	
		this.positionX=posX;
		this.positionY=posY;
		this.rectinimigo = rect;
		
		if (rect.left + posX >= 0 && rect.top + posY >= 0
				&& rect.right + posX <= x && rect.bottom + posY <= y) {
			rect.set(rect.left + posX, rect.top + posY, rect.right + posX,
					rect.bottom + posY);
		}
		else{
			rand();
		}
	}

	public void rand(){
		
		int oi = 0;
		if(oi==0){
			positionX=-3;
			positionY=0;
		}
		if(oi==1){
			positionX=3;
			positionY=0;
		}
		if(oi==2){
			positionY=-3;
			positionX=0;
		}
		if(oi==3){
			positionY=3;
			positionX=0;
		}
	}
	public Boolean colision(Rect[] rect, Rect currentRect) {
		colidiu = false;

		Rect rectp = new Rect();
		rectp.set(currentRect.left + positionX, currentRect.top + positionY,
				currentRect.right + positionX, currentRect.bottom + positionY);
		for (Rect rect2 : rect) {

			if (rect2 != rectinimigo) {
				if (rect2.contains(currentRect.left + positionX,
						currentRect.top + positionY)) {

					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}
				if (rect2.contains(currentRect.right + positionX,
						currentRect.top + positionY)) {
					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}

				if (rect2.contains(currentRect.right + positionX,
						currentRect.bottom + positionY)) {
					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}

				if (rect2.contains(currentRect.left + positionX,
						currentRect.bottom + positionY)) {
					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}

				if (rectp.contains(rect2.left, rect2.top)) {

					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}
				if (rectp.contains(rect2.right, rect2.top)) {
					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}

				if (rectp.contains(rect2.right, rect2.bottom)) {
					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}

				if (rectp.contains(rect2.left, rect2.bottom)) {
					Log.i("OI", "Colidiu 1287218372bjs");
					colidiu = true;
					break;
				}
			}

		}

		return colidiu;
	}

}
