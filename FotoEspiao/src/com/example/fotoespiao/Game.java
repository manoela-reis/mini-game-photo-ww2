package com.example.fotoespiao;

import java.util.LinkedList;
import java.util.Queue;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Game extends View implements Runnable {

	public Movimentacao move;
	public Rect rectPlayer;
	private Paint paint;
	private int contador = 0;
	private Rect[] setas = new Rect[4];
	private Queue<MotionEvent> fila;
	private boolean andando;


	public Game(Context context) {
		super(context);
		move = new Movimentacao(30,50);
		rectPlayer = new Rect();
		rectPlayer.set(0, 0, 30, 50);
		fila = new LinkedList<MotionEvent>();

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
	}
	public void initializeTeclas(){
		for(int i =0;i<setas.length;i++){
			setas[i]= new Rect();
		}
	}
	public void setTeclas(int width, int height) {
	
			setas[0].set(0, height/6, width/4, 5*height/6);
			setas[1].set(3*width/4, height/6, width, 5*height/6);
			setas[2].set(width/4, 0, 3*width/4, height/4);
			setas[3].set(width/4, 3*height/4, 3*width/4, height);

		
	}
	public boolean onTouchEvent(MotionEvent event) {
	
		

			int action = MotionEventCompat.getActionMasked(event);

			if (action == MotionEvent.ACTION_DOWN) {
				Log.i("foi", "down baby down !! ");
				int id = event.getPointerId(event.getActionIndex());

			
				int x = (int) event.getX(id);
				int y = (int) event.getY(id);
				for(int i =0;i<setas.length;i++){
					if(setas[i].contains(x, y)){
						if(i==0){
							move.movimentar(-3, 0, rectPlayer);
							
							
						}
						if(i==1){
							move.movimentar(3, 0, rectPlayer);
						}
						if(i==2){
							move.movimentar(0, -3, rectPlayer);
						}
						if(i==3){
							move.movimentar(0, 3, rectPlayer);
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

			//contador++;
			//move.movimentar(20 + contador, 60 + contador, rectPlayer);
			
			
			postInvalidate();

		}
	}
	public void draw(Canvas canvas) {
		super.draw(canvas);

		
		canvas.drawRect(rectPlayer, paint);
	}

}
