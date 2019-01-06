package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestSimulador {
    Simulador simulador = new Simulador();
    File ficheiroRei = new File("test-files/rei.txt");
    File ficheiroRainha = new File("test-files/rainha.txt");
    File ficheiroPonei = new File("test-files/poneiMagico.txt");
    File ficheiroPadre = new File("test-files/padreDaVila.txt");
    File ficheiroTorreHor = new File("test-files/torreHor.txt");
    File ficheiroTorreVert = new File("test-files/torreVert.txt");
    File ficheiroLebre = new File("test-files/lebre.txt");
    File ficheiroJoker = new File("test-files/joker.txt");
    File ficheiroRecruta = new File("test-files/recruta.txt");

    //GERAL
    @Test
    public void test01processaJogadaEquipaPretaPecaInexistente() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,0,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaEquipaBrancaPecaInexistente() {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,0,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test02processaJogadaDestinoForaTabuleiro() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,simulador.tamanhoTabuleiro,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void sugestaoPedidoInvalido() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("Pedido inválido");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(0,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    
    //REI
    @Test
    public void test03processaJogadaValidaReiCima() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test04processaJogadaValidaReiCimaDireita() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test05processaJogadaValidaReiDireita() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test06processaJogadaValidaReiBaixo() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test07processaJogadaValidaReiBaixoDireita() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test08processaJogadaValidaReiBaixoEsquerda() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test09processaJogadaValidaReiEsquerda() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test10processaJogadaValidaReiCimaEsquerda() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaComerReiBranco() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(2,3,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test12processaJogadaInvalidaComerRei() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }

    @Test
    public void test13processaJogadaValidaReiBranco() {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,2,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test14processaJogadaInvalidaReiBranco() {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test15processaJogadaValidaComerReiPreto() {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaReiPretoMaiorQue1Casa() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaReiBrancoMaiorQue1Casa() {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(1,3,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaComerReiValido() {
        simulador.iniciaJogo(ficheiroRei);
        List<String> sugestoesEsperadas = Arrays.asList("3, 3", "3, 4", "3, 5", "4, 3", "4, 5", "5, 3", "5, 4", "5, 5");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(4,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaReiBranco() {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList();
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(6,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaReiBranco1() {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("4, 4");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(5,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //RAINHA
    @Test
    public void test03processaJogadaValidaRainhaCima() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test04processaJogadaValidaRainhaCimaDireita() { //não é valida porque tem uma rainha
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test05processaJogadaInvalidaRainhaDireita() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test06processaJogadaInvalidaRainhaBaixo() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test07processaJogadaValidaRainhaBaixoDireita() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test08processaJogadaValidaRainhaBaixoEsquerda() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test09processaJogadaValidaRainhaEsquerda() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test10processaJogadaValidaRainhaCimaEsquerda() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaRainhaBrancaComerReiPreto() {
        simulador.iniciaJogo(ficheiroRainha);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,2,4,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaRainhaComerRainha() {
        simulador.iniciaJogo(ficheiroRainha);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,4,4,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaValidaJokerRainhaComerRainha() {
        simulador.iniciaJogo(ficheiroRainha);
        simulador.jogo.turno = 0;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(6,4,7,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaVerticalPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaVerticalBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,5,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaHorizontalPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaHorizontalBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(1,2,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaBaixoEsquerdaPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,4,2,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaBaixoEsquerdaBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,3,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaBaixoDireitaPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,4,6,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorBaixoDireitaBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,7,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaEsquerdaPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(2,3,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaEsquerdaBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,5,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaDireitaPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,4,6,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaDireitaBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,7,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,3,7,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(2,1,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalMaisQue5CasasPreta() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,6,6,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalMaisQue5CasasBranca() {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(6,0,0,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }

    @Test
    public void test01obterSugestoesJogadaRainha() {
        simulador.iniciaJogo(ficheiroRainha);
        List<String> sugestoesEsperadas = Arrays.asList("2, 2", "3, 3");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(4,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaRainha() {
        simulador.iniciaJogo(ficheiroRainha);
        List<String> sugestoesEsperadas = Arrays.asList("3, 0", "4, 0", "5, 0", "1, 0", "0, 0", "3, 1", "4, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //PONEI
    @Test
    public void test13processaJogadaInvalidaPonei90Branca() {
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,5,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPonei90Preta() {
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,2,2,5);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaValidaPonei90BrancaComer() {
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = true;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaValidaPonei90PretaComer() {
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(6,4,4,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaPoneiValido() {
        simulador.iniciaJogo(ficheiroPonei);
        List<String> sugestoesEsperadas = Arrays.asList("2, 0", "2, 4");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(0,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaComerPoneiPreto() {
        simulador.iniciaJogo(ficheiroPonei);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("0, 6", "4, 2", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //PADRE
    @Test
    public void test16processaJogadaInvalidaPadrePretoMaiorQue3Casas() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,1,7,5);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaReiBrancoMaiorQue3Casas() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(0,1,4,5);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaPadrePretoMalDiagonal() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,1,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaPadreBrancoMalDiagonal() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaValidaPadrePretoComer() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(0,6,2,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaValidaPadreBrancoComer() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = true;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,0,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaPadrePretoComerMesmaCor() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,2,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaPadreBrancoComerMesmaCor() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,5,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaPadreBrancoPertoRainhaPreta() {
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,1,7,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaPadre() {
        simulador.iniciaJogo(ficheiroPadre);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("6, 6", "5, 5", "4, 4");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(7,7);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    
    //TORRE HORIZONTAL
    @Test
    public void test11processaJogadaValidaTorreHorPreta() {
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,2,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorPreta() {
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,2,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreHorBranca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,3,0,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorBranca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,1,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorPretaPassarPorCima() {
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,0,4,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorBrancaPassarPorCima() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreHorPretaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,2,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreHorBrancaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,2,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorPretaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,0,3,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorBrancaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    //Fronteira esquerda e peça à direita mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreHorPreta() {
        simulador.iniciaJogo(ficheiroTorreHor);
        List<String> sugestoesEsperadas = Arrays.asList("0, 0", "2, 0");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira direita e peça à esquerda mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreHorPreta() {
        simulador.iniciaJogo(ficheiroTorreHor);
        List<String> sugestoesEsperadas = Arrays.asList("2, 0", "4, 0");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(3,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira esquerda e peça à direita mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreHorBranca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("0, 3");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //Fronteira direita e peça à esquerda mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreHorBranca() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("3, 3", "4, 3");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorPretaComer() {
        simulador.iniciaJogo(ficheiroTorreHor);
        List<String> sugestoesEsperadas = Arrays.asList("0, 2", "2, 2", "3, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorBrancaComer() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("1, 2", "2, 2", "4, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(3,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorFronteiraMesmaEquipaDireita() {
        simulador.iniciaJogo(ficheiroTorreHor);
        List<String> sugestoesEsperadas = Arrays.asList("0, 1", "1, 1", "3, 1");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorFronteiraMesmaEquipaEsquerda() {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("1, 4", "3, 4", "4, 4");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //TORRE VERTICAL
    @Test
    public void test11processaJogadaValidaTorreVertPreta() {
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(0,3,0,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertPreta() {
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,3,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreVertBranca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertBranca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,4,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertPretaPassarPorCima() {
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,3,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertBrancaPassarPorCima() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreVertPretaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(2,3,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreVertBrancaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(2,1,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertPretaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,1,0,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertBrancaComerPeca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,2,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    //Fronteira baixo e peça em cima mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreVertPreta() {
        simulador.iniciaJogo(ficheiroTorreVert);
        List<String> sugestoesEsperadas = Arrays.asList("0, 4", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(0,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira cima e peça em baixo mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreVertPreta() {
        simulador.iniciaJogo(ficheiroTorreVert);
        List<String> sugestoesEsperadas = Arrays.asList("0, 0", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(0,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira baixo e peça em cima mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreVertBranca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("3, 4");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(3,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //Fronteira cima e peça em baixo mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreVertBranca() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("3, 0", "3, 1");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(3,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertPretaComer() {
        simulador.iniciaJogo(ficheiroTorreVert);
        List<String> sugestoesEsperadas = Arrays.asList("2, 4", "2, 2", "2, 1");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertBrancaComer() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("2, 0", "2, 2", "2, 3");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertFronteiraMesmaEquipaCima() {
        simulador.iniciaJogo(ficheiroTorreVert);
        List<String> sugestoesEsperadas = Arrays.asList("1, 1", "1, 3", "1, 4");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertFronteiraMesmaEquipaBaixo() {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<String> sugestoesEsperadas = Arrays.asList("4, 0", "4, 1", "4, 3");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(4,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //LEBRE
    @Test
    public void test03processaJogadaInvalidaLebreCima() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test04processaJogadaValidaLebreCimaDireita() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test05processaJogadaInvalidaLebreDireita() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test07processaJogadaValidaLebreBaixoDireita() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test06processaJogadaInvalidaLebreBaixo() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test08processaJogadaValidaLebreBaixoEsquerda() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test09processaJogadaInvalidaLebreEsquerda() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test10processaJogadaValidaLebreCimaEsquerda() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaComerLebreBranca() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(4,4,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test12processaJogadaInvalidaComerLebreMesmaEquipa() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,2,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test14processaJogadaInvalidaLebreBranca() {
        simulador.iniciaJogo(ficheiroLebre);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test15processaJogadaValidaComerLebrePreta() {
        simulador.iniciaJogo(ficheiroLebre);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaLebrePretoMaiorQue1Casa() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,5,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaLebreBrancoMaiorQue1Casa() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,5,7,7);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaLebre() {
        simulador.iniciaJogo(ficheiroLebre);
        List<String> sugestoesEsperadas = Arrays.asList("0, 0", "2, 0", "2, 2", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaComerLebreValido() {
        simulador.iniciaJogo(ficheiroLebre);
        List<String> sugestoesEsperadas = Arrays.asList("0, 5", "0, 7","2, 5", "2, 7");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,6);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaComerLebreInvalido() {
        simulador.iniciaJogo(ficheiroLebre);
        List<String> sugestoesEsperadas = Arrays.asList();
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(6,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaLebreValida() {
        simulador.iniciaJogo(ficheiroLebre);
        List<String> sugestoesEsperadas = Arrays.asList("0, 0", "2, 0","2, 2","0, 2");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(1,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01processaJogadaLebreInvalidaDiagonaisDiferentes() {
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaLebreInvalidaTurnoImparPreto() {
        simulador.iniciaJogo(ficheiroLebre);
        simulador.jogo.turno = 1;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaLebreInvalidaTurnoImparBranco() {
        simulador.iniciaJogo(ficheiroLebre);
        simulador.jogo.turno = 1;
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }

    //JOKER
    @Test
    public void test01processaJogadaJokerRainha() {
        simulador.iniciaJogo(ficheiroJoker);
        simulador.jogo.turno = 1;
        simulador.idEquipaAtual = 10;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,0,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaJokerLebre() {
        simulador.iniciaJogo(ficheiroJoker);
        for (CrazyPiece verificaJoker : simulador.pecasJogo){
            if (verificaJoker.getIdTipo() == 7){
                ((Joker) verificaJoker).tipoJoker = "Lebre";
            }
        }
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,4,1,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaJokerTorreV() {
        simulador.iniciaJogo(ficheiroJoker);
        simulador.jogo.turno = 4;
        simulador.idEquipaAtual = 10;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,2,1,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestaoJoker() {
        simulador.iniciaJogo(ficheiroJoker);
        simulador.idEquipaAtual = 20;
        for (CrazyPiece verificaJoker : simulador.pecasJogo){
            if (verificaJoker.getIdTipo() == 7){
                ((Joker) verificaJoker).mudaTipoJoker();
            }
        }
        List<String> sugestoesEsperadas = Arrays.asList("0, 1", "4, 1");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(2,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //RECRUTA
    @Test
    public void test01processaJogadaRecrutaPretoInvalido() {
        simulador.iniciaJogo(ficheiroRecruta);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,6,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaBrancoInvalido() {
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 20;
        simulador.jogo.turno = 1;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,2,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaBrancoInvalidoTurno0() {
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,2,4,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaTrocaEquipaPreta() {
        simulador.iniciaJogo(ficheiroRecruta);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(5,3,5,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaTrocaEquipaBranco() {
        simulador.iniciaJogo(ficheiroRecruta);
        boolean jogadaEsperada = true;
        simulador.idEquipaAtual = 20;
        simulador.jogo.turno = 1;
        boolean jogadaObtida  = simulador.processaJogada(3,2,1,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestaoTurnoImpar() {
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 20;
        simulador.jogo.turno = 1;
        List<String> sugestoesEsperadas = Arrays.asList("2, 1", "6, 1", "6, 5", "2, 5");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(4,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestaoTurnoPar() {
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 10;
        List<String> sugestoesEsperadas = Arrays.asList("3, 3", "7, 3", "5, 1", "5, 5");
        Collections.sort(sugestoesEsperadas);
        List<String> sugestoesObtidas  = simulador.obterSugestoesJogada(5,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
}

