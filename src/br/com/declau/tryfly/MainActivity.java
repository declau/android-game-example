package br.com.declau.tryfly;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import br.com.declau.tryfly.engine.Game;

public class MainActivity extends Activity {

   
	private Game game;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        
       game = new Game(this);
       container.addView(game);
    }
	
	@Override
	protected void onResume() {
		super.onResume();
		game.inicia();
		new Thread(game).start();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		game.pausa();
		
	}
}
