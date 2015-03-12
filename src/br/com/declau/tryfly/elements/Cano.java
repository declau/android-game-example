package br.com.declau.tryfly.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.declau.tryfly.R;
import br.com.declau.tryfly.graphic.Cores;
import br.com.declau.tryfly.graphic.Tela;

public class Cano {
	
	private Tela tela;
	private int alturaDoCanoInferior;
	private static final int TAMANHO_DO_CANO = 150;
	private static final int LARGURA_DO_CANO = 100;
	private static final Paint VERDE = Cores.getCorDoCano();
	private int posicao;
	private int alturaDoCanoSuperior;
	private Bitmap canoInferior;
	private Bitmap canoSuperior;

	public Cano(Tela tela, int posicao, Context context) {
		this. tela = tela;
		this.posicao = posicao;
		alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
		alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
		Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
		canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoInferior, false);
	    canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoSuperior, false);
	}

	private int valorAleatorio() {
		
		return (int)(Math.random() * 200);
	}

	public void desenhaNo(Canvas canvas) {
		desenhaCanoSuperiorNo(canvas);
		desenhaCanoInferiorNo(canvas);
		
	}
	private void desenhaCanoSuperiorNo(Canvas canvas) {
		//canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
		canvas.drawBitmap(canoSuperior, posicao, 0 , null);
	}

	private void desenhaCanoInferiorNo(Canvas canvas) {
		//canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
		canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
	}
	
	public void move() {
		this.posicao -= 2;
		
	}

	public boolean saiuDaTela() {
		return posicao + LARGURA_DO_CANO < 0;
	}

	public int getPosicao() {
		return posicao;
	}
	
	public boolean temColisaoVerticalCom(Passaro passaro) {
	    return passaro.getAltura() - Passaro.RAIO < this.alturaDoCanoSuperior 
	            || passaro.getAltura() + Passaro.RAIO > this.alturaDoCanoInferior;
	}
	
	public boolean temColisaoHorizontalCom(Passaro passaro) {
	    return this.posicao < Passaro.X + Passaro.RAIO;
	}
	

}
