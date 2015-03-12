package br.com.declau.tryfly.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import br.com.declau.tryfly.graphic.Cores;
import br.com.declau.tryfly.graphic.Tela;

public class GameOver {
	
	private static final Paint vermelho = Cores.getCorDoGameOver();
	private final Tela tela;
	 
	 public GameOver(Tela tela) {
	 this.tela = tela;
	 }
	 public void desenhaNo(Canvas canvas) {
	   	 String gameOver = "Game Over";
	   	 int centroHorizontal = centralizaTexto(gameOver);
	   	 canvas.drawText(gameOver, centroHorizontal, tela.getAltura()/2, vermelho);
	   	 }
 	 
	    private int centralizaTexto(String texto) {
	        Rect limiteDoTexto = new Rect();
	        vermelho.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
	        
	        //agora podemos centralizar o texto...
	        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
	        
	        return centroHorizontal;
	    }
	    
	   
}
