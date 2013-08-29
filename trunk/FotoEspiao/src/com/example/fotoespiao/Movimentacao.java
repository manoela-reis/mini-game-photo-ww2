package com.example.fotoespiao;

import java.util.ArrayList;

import android.graphics.Rect;
import android.util.Log;

public class Movimentacao {

	int x;
	int y;
	public static boolean andando = false;
	int positionX = 0;
	int positionY = 0;
	private Boolean colidiu = false;
	private Rect[] rectsObstaculos = new Rect[7];
	private ArrayList<Rect> rectpont = new ArrayList<Rect>();

	Boolean trr = true;
	Rect rectplayer;
	Rect Ponto;

	public Movimentacao(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public void setPlayer(Rect rect) {
		this.rectplayer = rect;
	}

	public void movimentar(int posX, int posY, Rect rect) {
		Log.i("foi", "down baby down !! ");
		this.positionX = posX;
		this.positionY = posY;
		// this.rectplayer=rect;
		// andando=true;
		if (rect.left + posX >= 0 && rect.top + posY >= 0
				&& rect.right + posX <= x && rect.bottom + posY <= y) {
			rect.set(rect.left + posX, rect.top + posY, rect.right + posX,
					rect.bottom + posY);
		}

	}

	public void movimentarInimigo(int posX, int posY, Rect rect) {
		Log.i("foi", "down baby down !! ");

		// this.rectplayer=rect;
		// andando=true;
		if (rect.left + posX >= 0 && rect.top + posY >= 0
				&& rect.right + posX <= x && rect.bottom + posY <= y) {
			rect.set(rect.left + posX, rect.top + posY, rect.right + posX,
					rect.bottom + posY);
		}

	}

	public void setXY(int x, int y) {
		this.positionX = x;
		this.positionY = y;
		andando = true;

	}

	public void andar(Rect Person) {
		// this.rectplayer=Person;
		if (Person.left + positionX >= 0 && Person.top + positionY >= 0
				&& Person.right + positionX <= x
				&& Person.bottom + positionY <= y) {
			Person.set(Person.left + positionX, Person.top + positionY,
					Person.right + positionX, Person.bottom + positionY);
		}
	}

	public ArrayList<Rect> getPonto() {
		return rectpont;
	}

	public Boolean colision(Rect[] rect, Rect currentRect) {
		colidiu = false;

		Rect rectp = new Rect();
		rectp.set(currentRect.left + positionX, currentRect.top + positionY,
				currentRect.right + positionX, currentRect.bottom + positionY);
		for (Rect rect2 : rect) {
			Ponto = rect2;
			trr = true;
			if (!getPonto().isEmpty()) {

				for (int i = 0; i < getPonto().size(); i++) {

					if (rect2 == getPonto().get(i)) {

						trr = false;
						break;
					}
				}
			}
			if (rect2.contains(currentRect.left + positionX, currentRect.top
					+ positionY)) {

				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);
				break;
			}
			if (rect2.contains(currentRect.right + positionX, currentRect.top
					+ positionY)) {
				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}

			if (rect2.contains(currentRect.right + positionX,
					currentRect.bottom + positionY)) {
				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}

			if (rect2.contains(currentRect.left + positionX, currentRect.bottom
					+ positionY)) {
				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}

			if (rectp.contains(rect2.left, rect2.top)) {

				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}
			if (rectp.contains(rect2.right, rect2.top)) {
				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}

			if (rectp.contains(rect2.right, rect2.bottom)) {
				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}

			if (rectp.contains(rect2.left, rect2.bottom)) {
				Log.i("OI", "Colidiu 1287218372bjs");
				colidiu = true;
				rectpont.add(rect2);

				break;
			}

		}

		return colidiu;
	}

}
