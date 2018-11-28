package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSimulador {
    @Test
    public void test01processaJogada() {
        CrazyPiece peca = new CrazyPiece(1,0,0,"Teste");
        peca.definirCoordenadas(0,0);
        Simulador simulador = new Simulador();
        simulador.tamanhoTabuleiro = 4;
        simulador.pecasJogo.add(peca);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(peca.getX(),peca.getY(),1,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test02processaJogada() {
        CrazyPiece peca = new CrazyPiece(1,0,0,"Teste");
        peca.definirCoordenadas(0,0);
        Simulador simulador = new Simulador();
        simulador.tamanhoTabuleiro = 4;
        simulador.pecasJogo.add(peca);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(peca.getX(),peca.getY(),-1,-1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
}
