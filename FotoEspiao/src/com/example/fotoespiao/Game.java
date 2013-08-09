package com.example.fotoespiao;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Game  extends View implements Runnable{

public Movimentacao move;
public Rect rectPlayer;
private Paint paint;
private int contador = 0;

	public Game(Context context) {
		super(context);
		move = new Movimentacao();
		rectPlayer = new Rect();
		rectPlayer.set(0, 0, 30, 50);
		
		setFocusable(true);
		setClickable(true); 
		setLongClickable(true);
		
		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize(20);
		
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			
		contador ++;
		move.movimentar(20 + contador, 60 + contador, rectPlayer);
		postInvalidate();

	}
	}
	
	public void draw(Canvas canvas){
		super.draw(canvas);
		
		canvas.drawRect(rectPlayer, paint);
	}

}
