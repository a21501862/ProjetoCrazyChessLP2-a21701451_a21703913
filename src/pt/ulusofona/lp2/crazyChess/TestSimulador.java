//Estes testes destinam-se ao ficheiro de exemplo dado.
package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

public class TestSimulador {
    @Test
    public void test01processaJogada() {
        Simulador simulador = new Simulador();
        File ficheiro = new File("jogo.txt");
        simulador.iniciaJogo(ficheiro);
        boolean jogada  = simulador.processaJogada(1,0,1,1);
        assertTrue(jogada);
    }
}
