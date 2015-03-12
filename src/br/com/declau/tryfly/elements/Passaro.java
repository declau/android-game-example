package br.com.declau.tryfly.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.declau.tryfly.R;
import br.com.declau.tryfly.engine.Som;
import br.com.declau.tryfly.graphic.Cores;
import br.com.declau.tryfly.graphic.Tela;

public class Passaro {
	
	public static final float X = 100;
	public static final int RAIO = 35;
	private static final Paint VERMELHO = Cores.getCorDoPassaro();
	private float altura;
	private Tela tela;
	private Bitmap passaro;
	private Som som;
	
	public Passaro(Tela tela, Context context, Som som){
		this.tela = tela;
		this.som = som;
		this.altura = 100;
		Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
		this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
	}

	public void desenhaNo(Canvas canvas){
		//canvas.drawCircle(X, altura, RAIO, VERMELHO);
		canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
	}

	public void cai() {
		
		this.altura += 2;
		
		/*boolean chegouNoChao = altura + RAIO > tela.getAltura();
		if (!chegouNoChao) {
		this.altura += 2;
		}*/
		 
		
	}

	public void pula() {
		
		if (altura - RAIO > 0) {
			som.toca(som.PULO);
		this.altura -= 125;	
		}

		
	}

	public float getAltura() {
		return this.altura;
	}

}
