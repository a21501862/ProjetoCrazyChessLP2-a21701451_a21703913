//Estes testes destinam-se ao ficheiro de exemplo dado.
package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class TestSimulador {
    @Test
    public void test01processaJogada() {
        Simulador simulador = new Simulador();
        File ficheiro = new File("jogo.txt");
        simulador.iniciaJogo(ficheiro);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,0,1,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
}
