package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;
import java.io.File;

import static junit.framework.TestCase.assertFalse;

public class TestSimulador {
    @Test
    public void test01processaJogada() {
        Simulador simulador = new Simulador();
        File ficheiro = new File("jogo.txt") ;
        simulador.iniciaJogo(ficheiro);
        boolean jogadaObtida = simulador.processaJogada(0,1,1,2);
        assertFalse(jogadaObtida);
    }
}

