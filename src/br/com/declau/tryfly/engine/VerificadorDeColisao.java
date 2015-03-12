package br.com.declau.tryfly.engine;

import br.com.declau.tryfly.elements.Canos;
import br.com.declau.tryfly.elements.Passaro;

public class VerificadorDeColisao {
	
	private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }
    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }

}
