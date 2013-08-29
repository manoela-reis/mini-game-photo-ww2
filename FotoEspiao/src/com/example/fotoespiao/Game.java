package com.example.fotoespiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Game extends View implements Runnable {

	public Movimentacao move;
	public Rect rectPlayer;
	private Paint paint;
	private Rect[] setas = new Rect[4];
	private Queue<MotionEvent> fila;
	private Rect[] rectsObstaculos = new Rect[11];
	private Rect rectInimigo = new Rect();

	private Rect foto = new Rect();
	private Rect[] rectPontos = new Rect[3];
	Inimigo inimigo;

	Boolean Foto = false;

	// private Rect rectObstaculo1;
	// private Rect rectObstaculo2;
	// private Rect rectObstaculo3;
	// private Rect rectObstaculo4;
	// private Rect rectObstaculo5;
	// private Rect rectObstaculo6;
	// private Rect rectObstaculo7;

	public Game(Context context) {
		super(context);
		rectPlayer = new Rect();
		rectPlayer.set(0, 0, 10, 10);
		rectInimigo.set(60, 0, 69, 10);
		fila = new LinkedList<MotionEvent>();

		// rectSino = new Rect(); // fazer

		setFocusable(true);
		setClickable(true);
		setLongClickable(true);

		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize(20);
		Thread processo = new Thread(this);
		processo.start();
		initializeTeclas();

	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		setTeclas(getWidth(), getHeight());

		rectsObstaculos[0] = Obstaculos.createObstaculo(getWidth() / 6,
				2 * getHeight() / 16, 5 * getWidth() / 6, 3 * getHeight() / 16);
		rectsObstaculos[1] = Obstaculos.createObstaculo(getWidth() / 10,
				3 * getHeight() / 4, getWidth() / 10
						+ (3 * getHeight() / 16 - 2 * getHeight() / 16),
				getHeight());
		rectsObstaculos[2] = Obstaculos.createObstaculo(9 * getWidth() / 10
				- (3 * getHeight() / 16 - 2 * getHeight() / 16),
				3 * getHeight() / 4, 9 * getWidth() / 10, getHeight());
		rectsObstaculos[3] = Obstaculos.createObstaculo(2 * getWidth() / 6,
				10 * getHeight() / 32, 4 * getWidth() / 6,
				11 * getHeight() / 32);
		rectsObstaculos[4] = Obstaculos.createObstaculo(2 * getWidth() / 6,
				10 * getHeight() / 32, 2 * getWidth() / 6
						+ (11 * getHeight() / 32 - 10 * getHeight() / 32),
				20 * getHeight() / 32);
		rectsObstaculos[5] = Obstaculos.createObstaculo(4 * getWidth() / 6
				- (11 * getHeight() / 32 - 10 * getHeight() / 32),
				10 * getHeight() / 32, 4 * getWidth() / 6,
				16 * getHeight() / 32);
		rectsObstaculos[6] = Obstaculos.createObstaculo(2 * getWidth() / 6, 20
				* getHeight() / 32
				- (11 * getHeight() / 32 - 10 * getHeight() / 32),
				4 * getWidth() / 6, 20 * getHeight() / 32);

		rectsObstaculos[7] = rectInimigo;
		for (int i = 0; i < rectPontos.length; i++) {
			rectPontos[i] = new Rect();

		}
		rectPontos[0].set(0, 0, getWidth() / 10, getHeight() / 6);
		rectPontos[1].set(0, 6 * getHeight() / 7, getWidth() / 12, getHeight());
		rectPontos[2].set(8 * getWidth() / 20, 6 * getHeight() / 15,
				10 * getWidth() / 20, 8 * getHeight() / 15);
		rectsObstaculos[8] = rectPontos[0];

		rectsObstaculos[9] = rectPontos[1];

		rectsObstaculos[10] = rectPontos[2];

		rectPlayer.set(getWidth() / 2 - 10, getHeight() - 10, getWidth() / 2,
				getHeight());

		foto.set(2 * getWidth() / 20, 2 * getHeight() / 16,
				18 * getWidth() / 20, 14 * getHeight() / 16);
		move = new Movimentacao(getWidth(), getHeight());
		move.setPlayer(rectPlayer);
		inimigo = new Inimigo(getWidth(), getHeight(), rectInimigo);
		inimigo.andando = true;

	}

	public void initializeTeclas() {
		for (int i = 0; i < setas.length; i++) {
			setas[i] = new Rect();
		}
	}

	public void setTeclas(int width, int height) {

		setas[0].set(0, height / 6, width / 4, 5 * height / 6);
		setas[1].set(3 * width / 4, height / 6, width, 5 * height / 6);
		setas[2].set(width / 4, 0, 3 * width / 4, height / 4);
		setas[3].set(width / 4, 3 * height / 4, 3 * width / 4, height);

	}

	public boolean onTouchEvent(MotionEvent event) {

		int action = MotionEventCompat.getActionMasked(event);

		if (action == MotionEvent.ACTION_DOWN) {
			Log.i("foi", "down baby down !! ");
			int id = event.getPointerId(event.getActionIndex());

			int x = (int) event.getX(id);
			int y = (int) event.getY(id);
			if (Foto) {
				if (foto.contains(x, y)) {

					Foto = false;
				}
			}
			for (int i = 0; i < setas.length; i++) {
				if (setas[i].contains(x, y)) {
					if (i == 0) {

						move.setXY(-3, 0);

					}
					if (i == 1) {

						move.setXY(3, 0);

					}
					if (i == 2) {

						move.setXY(0, -3);

					}
					if (i == 3) {

						move.setXY(0, 3);

					}

				}
			}

		}

		if (action == MotionEvent.ACTION_MOVE) {

		}
		if (action == MotionEvent.ACTION_UP) {
			Log.i("foi", "UP !!!");
			int id = event.getPointerId(event.getActionIndex());

			int x = (int) event.getX(id);
			int y = (int) event.getY(id);

			for (int i = 0; i < setas.length; i++) {
				if (setas[i].contains(x, y)) {
					if (i == 0) {
						move.movimentar(0, 0, rectPlayer);
					}
					if (i == 1) {
						move.movimentar(0, 0, rectPlayer);
					}
					if (i == 2) {
						move.movimentar(0, 0, rectPlayer);
					}
					if (i == 3) {
						move.movimentar(0, 0, rectPlayer);
					}

				}
			}

		}

		return super.onTouchEvent(event);

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

			Update();
			postInvalidate();

		}
	}

	public void Update() {

		if (move.andando) {
			if (!move.colision(rectsObstaculos, rectPlayer)) {

				move.andar(rectPlayer);
			}

			if (move.colision(rectPontos, rectPlayer)) {
				if(move.trr){
				Foto=true;
				}
				
			}
		}

		if (inimigo.andando) {
			if (!inimigo.colision(rectsObstaculos, rectInimigo)) {
				inimigo.movimentarInimigo(3, 0, rectInimigo);
			}
		}

	}

	public void draw(Canvas canvas) {
		super.draw(canvas);
		paint.setColor(Color.BLACK);

		for (int i = 0; i < rectsObstaculos.length; i++) {

			canvas.drawRect(rectsObstaculos[i], paint);
		}

		paint.setColor(Color.RED);
		canvas.drawRect(rectPlayer, paint);

		paint.setColor(Color.MAGENTA);
		canvas.drawRect(rectInimigo, paint);
		for (int i = 0; i < rectPontos.length; i++) {
			canvas.drawRect(rectPontos[i], paint);
		}
		if (Foto) {
			canvas.drawRect(foto, paint);
		}

	}

}
