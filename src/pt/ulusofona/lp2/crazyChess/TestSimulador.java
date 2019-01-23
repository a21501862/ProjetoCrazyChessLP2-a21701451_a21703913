package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
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
    public void test01processaJogadaEquipaPretaPecaInexistente() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,0,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaEquipaBrancaPecaInexistente() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,0,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test02processaJogadaDestinoForaTabuleiro() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,simulador.tamanhoTabuleiro,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void sugestaoPedidoInvalido() throws IOException {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList();
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(0,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //REI
    @Test
    public void test03processaJogadaValidaReiCima() throws IOException {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test04processaJogadaValidaReiCimaDireita() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test05processaJogadaValidaReiDireita() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test06processaJogadaValidaReiBaixo() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test07processaJogadaValidaReiBaixoDireita() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test08processaJogadaValidaReiBaixoEsquerda() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test09processaJogadaValidaReiEsquerda() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test10processaJogadaValidaReiCimaEsquerda() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaComerReiBranco()throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(2,3,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test12processaJogadaInvalidaComerRei() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }

    @Test
    public void test13processaJogadaValidaReiBranco() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,2,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test14processaJogadaInvalidaReiBranco() throws IOException {
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test15processaJogadaValidaComerReiPreto() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaReiPretoMaiorQue1Casa() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaReiBrancoMaiorQue1Casa() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(1,3,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaComerReiValido() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        List<Comparable> sugestoesEsperadas = Arrays.asList("3, 3", "3, 4", "3, 5", "4, 3", "4, 5", "5, 3", "5, 4", "5, 5");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(4,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaReiBranco() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList();
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(6,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaReiBranco1() throws IOException{
        simulador.iniciaJogo(ficheiroRei);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(5,4);
        String sugestao = sugestoesObtidas.get(0).toString();
        assertEquals("4, 4, (infinito)", sugestao);
    }

    //RAINHA
    @Test
    public void test03processaJogadaValidaRainhaCima() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test04processaJogadaValidaRainhaCimaDireita() throws IOException{ //não é valida porque tem uma rainha
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test05processaJogadaInvalidaRainhaDireita() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test06processaJogadaInvalidaRainhaBaixo() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test07processaJogadaValidaRainhaBaixoDireita() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test08processaJogadaValidaRainhaBaixoEsquerda() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test09processaJogadaValidaRainhaEsquerda() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test10processaJogadaValidaRainhaCimaEsquerda() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaRainhaBrancaComerReiPreto() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,2,4,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaRainhaComerRainha() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,4,4,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaValidaJokerRainhaComerRainha() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        simulador.jogo.turno = 0;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(6,4,7,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaVerticalPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaVerticalBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,5,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaHorizontalPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaHorizontalBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(1,2,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaBaixoEsquerdaPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,4,2,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaBaixoEsquerdaBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,3,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaBaixoDireitaPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,4,6,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorBaixoDireitaBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,7,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaEsquerdaPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(2,3,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaEsquerdaBranca() throws IOException {
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,5,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaDireitaPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,4,6,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPassarPorCimaCimaDireitaBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,4,7,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,3,7,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(2,1,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalMaisQue5CasasPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,6,6,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaDiagonalMaisQue5CasasBranca() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(6,0,0,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }

    @Test
    public void test01obterSugestoesJogadaRainha() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        List<Comparable> sugestoesEsperadas = Arrays.asList("2, 2, 0", "3, 3, 0");
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(4,4);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);




//        simulador.iniciaJogo(ficheiroRei);
//        simulador.idEquipaAtual = 20;
//        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(5,4);
//        String sugestao = sugestoesObtidas.get(0).toString();
//        assertEquals("4, 4, (infinito)", sugestao);
    }
    @Test
    public void test02obterSugestoesJogadaRainha() throws IOException{
        simulador.iniciaJogo(ficheiroRainha);
        List<Comparable> sugestoesEsperadas = Arrays.asList("3, 0", "4, 0", "5, 0", "1, 0", "0, 0", "3, 1", "4, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //PONEI
    @Test
    public void test13processaJogadaInvalidaPonei90Branca() throws IOException{
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,5,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaInvalidaPonei90Preta() throws IOException{
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,2,2,5);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaValidaPonei90BrancaComer() throws IOException{
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = true;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test13processaJogadaValidaPonei90PretaComer() throws IOException{
        simulador.iniciaJogo(ficheiroPonei);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(6,4,4,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaPoneiValido() throws IOException{
        simulador.iniciaJogo(ficheiroPonei);
        List<Comparable> sugestoesEsperadas = Arrays.asList("2, 0", "2, 4");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(0,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaComerPoneiPreto() throws IOException {
        simulador.iniciaJogo(ficheiroPonei);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 6", "4, 2", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //PADRE
    @Test
    public void test16processaJogadaInvalidaPadrePretoMaiorQue3Casas() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,1,7,5);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaReiBrancoMaiorQue3Casas() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(0,1,4,5);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaPadrePretoMalDiagonal() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,1,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaPadreBrancoMalDiagonal() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaValidaPadrePretoComer() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(0,6,2,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaValidaPadreBrancoComer() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = true;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,0,6);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaPadrePretoComerMesmaCor() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,2,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaPadreBrancoComerMesmaCor() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(2,4,5,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaPadreBrancoPertoRainhaPreta() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,1,7,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaPadre() throws IOException{
        simulador.iniciaJogo(ficheiroPadre);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("6, 6", "5, 5", "4, 4");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(7,7);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //TORRE HORIZONTAL
    @Test
    public void test11processaJogadaValidaTorreHorPreta() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,2,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorPreta() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,2,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreHorBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,3,0,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,1,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorPretaPassarPorCima() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,0,4,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorBrancaPassarPorCima() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreHorPretaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,2,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreHorBrancaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,2,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorPretaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,0,3,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreHorBrancaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    //Fronteira esquerda e peça à direita mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreHorPreta() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 0", "2, 0");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira direita e peça à esquerda mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreHorPreta() throws IOException {
        simulador.iniciaJogo(ficheiroTorreHor);
        List<Comparable> sugestoesEsperadas = Arrays.asList("2, 0", "4, 0");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(3,0);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira esquerda e peça à direita mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreHorBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 3");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //Fronteira direita e peça à esquerda mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreHorBranca()  throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("3, 3", "4, 3");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorPretaComer() throws IOException {
        simulador.iniciaJogo(ficheiroTorreHor);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 2", "2, 2", "3, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorBrancaComer() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("1, 2", "2, 2", "4, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(3,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorFronteiraMesmaEquipaDireita() throws IOException{
        simulador.iniciaJogo(ficheiroTorreHor);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 1", "1, 1", "3, 1");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreHorFronteiraMesmaEquipaEsquerda() throws IOException {
        simulador.iniciaJogo(ficheiroTorreHor);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("1, 4", "3, 4", "4, 4");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //TORRE VERTICAL
    @Test
    public void test11processaJogadaValidaTorreVertPreta() throws IOException {
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(0,3,0,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertPreta() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,3,1,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreVertBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,4,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertPretaPassarPorCima() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,3,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertBrancaPassarPorCima() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreVertPretaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(2,3,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaTorreVertBrancaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(2,1,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertPretaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(0,1,0,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaInvalidaTorreVertBrancaComerPeca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,2,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    //Fronteira baixo e peça em cima mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreVertPreta() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 4", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(0,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira cima e peça em baixo mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreVertPreta()throws IOException {
        simulador.iniciaJogo(ficheiroTorreVert);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 0", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(0,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //Fronteira baixo e peça em cima mesma equipa
    @Test
    public void test01obterSugestoesJogadaTorreVertBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("3, 4");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(3,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //Fronteira cima e peça em baixo mesma equipa
    @Test
    public void test02obterSugestoesJogadaTorreVertBranca() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("3, 0", "3, 1");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(3,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertPretaComer() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        List<Comparable> sugestoesEsperadas = Arrays.asList("2, 4", "2, 2", "2, 1");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertBrancaComer()throws IOException {
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("2, 0", "2, 2", "2, 3");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertFronteiraMesmaEquipaCima() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        List<String> sugestoesEsperadas = Arrays.asList("1, 1", "1, 3", "1, 4");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test02obterSugestoesJogadaTorreVertFronteiraMesmaEquipaBaixo() throws IOException{
        simulador.iniciaJogo(ficheiroTorreVert);
        simulador.idEquipaAtual = 20;
        List<Comparable> sugestoesEsperadas = Arrays.asList("4, 0", "4, 1", "4, 3");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(4,2);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }

    //LEBRE
    @Test
    public void test03processaJogadaInvalidaLebreCima() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test04processaJogadaValidaLebreCimaDireita() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test05processaJogadaInvalidaLebreDireita() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test07processaJogadaValidaLebreBaixoDireita() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test06processaJogadaInvalidaLebreBaixo() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,1,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test08processaJogadaValidaLebreBaixoEsquerda() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test09processaJogadaInvalidaLebreEsquerda() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test10processaJogadaValidaLebreCimaEsquerda() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,1,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test11processaJogadaValidaComerLebreBranca() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(4,4,3,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test12processaJogadaInvalidaComerLebreMesmaEquipa() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(4,2,3,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test14processaJogadaInvalidaLebreBranca() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,3,3,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test15processaJogadaValidaComerLebrePreta() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test16processaJogadaInvalidaLebrePretoMaiorQue1Casa() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,5,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test17processaJogadaInvalidaLebreBrancoMaiorQue1Casa() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        simulador.idEquipaAtual = 20;
        boolean jogadaObtida  = simulador.processaJogada(5,5,7,7);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestoesJogadaLebre() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 0", "2, 0", "2, 2", "0, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaComerLebreValido()throws IOException {
        simulador.iniciaJogo(ficheiroLebre);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 5", "0, 7","2, 5", "2, 7");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,6);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaComerLebreInvalido() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        List<Comparable> sugestoesEsperadas = Arrays.asList();
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(6,4);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestoesJogadaLebreValida() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 0", "2, 0","2, 2","0, 2");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,1);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01processaJogadaLebreInvalidaDiagonaisDiferentes() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaLebreInvalidaTurnoImparPreto() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        simulador.jogo.turno = 1;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,1,2,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaLebreInvalidaTurnoImparBranco() throws IOException{
        simulador.iniciaJogo(ficheiroLebre);
        simulador.jogo.turno = 1;
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(1,3,2,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }

//    //JOKER
    @Test
    public void test01processaJogadaJokerRainha()throws IOException {
        simulador.iniciaJogo(ficheiroJoker);
        simulador.jogo.turno = 1;
        simulador.idEquipaAtual = 10;
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,0,0,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaJokerLebre() throws IOException{
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
    public void test01processaJogadaJokerTorreV() throws IOException{
        simulador.iniciaJogo(ficheiroJoker);
        for (CrazyPiece verificaJoker : simulador.pecasJogo){
            if (verificaJoker.getIdTipo() == 7){
                ((Joker) verificaJoker).tipoJoker = "TorreV";
            }
        }
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(1,2,1,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestaoJokerPoneiMagico() throws IOException{
        simulador.iniciaJogo(ficheiroJoker);
        simulador.idEquipaAtual = 20;
        for (CrazyPiece verificaJoker : simulador.pecasJogo){
            if (verificaJoker.getIdTipo() == 7){
                ((Joker) verificaJoker).tipoJoker = "Ponei Mágico";
            }
        }
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 1", "4, 1");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(2,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestaoJokerTorreH() throws IOException{
        simulador.iniciaJogo(ficheiroJoker);
        simulador.idEquipaAtual = 20;
        for (CrazyPiece verificaJoker : simulador.pecasJogo){
            if (verificaJoker.getIdTipo() == 7){
                ((Joker) verificaJoker).tipoJoker = "TorreH";
            }
        }
        List<Comparable> sugestoesEsperadas = Arrays.asList("0, 3");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(1,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    //RECRUTA
    @Test
    public void test01processaJogadaRecrutaPretoInvalido() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,0,6,0);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaBrancoInvalido() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 20;
        simulador.jogo.turno = 1;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,2,4,2);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaBrancoInvalidoTurno0() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 20;
        boolean jogadaEsperada = false;
        boolean jogadaObtida  = simulador.processaJogada(3,2,4,3);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaTrocaEquipaPreta() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        boolean jogadaEsperada = true;
        boolean jogadaObtida  = simulador.processaJogada(5,3,5,1);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01processaJogadaRecrutaTrocaEquipaBranco() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        boolean jogadaEsperada = true;
        simulador.idEquipaAtual = 20;
        simulador.jogo.turno = 1;
        boolean jogadaObtida  = simulador.processaJogada(3,2,1,4);
        assertEquals(jogadaEsperada,jogadaObtida);
    }
    @Test
    public void test01obterSugestaoTurnoImpar() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 20;
        simulador.jogo.turno = 1;
        List<Comparable> sugestoesEsperadas = Arrays.asList("2, 1", "6, 1", "6, 5", "2, 5");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(4,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
    @Test
    public void test01obterSugestaoTurnoPar() throws IOException{
        simulador.iniciaJogo(ficheiroRecruta);
        simulador.idEquipaAtual = 10;
        List<Comparable> sugestoesEsperadas = Arrays.asList("3, 3", "7, 3", "5, 1", "5, 5");
        Collections.sort(sugestoesEsperadas);
        List<Comparable> sugestoesObtidas  = simulador.obterSugestoesJogada(5,3);
        Collections.sort(sugestoesObtidas);
        assertEquals(sugestoesEsperadas, sugestoesObtidas);
    }
}

