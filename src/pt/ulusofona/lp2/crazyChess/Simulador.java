package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    int tamanhoTabuleiro;
    int numeroPecas;
    int idEquipaAtual;
    boolean terminou;
    List<CrazyPiece> pecas = new ArrayList<>();
    List<CrazyPiece> pecasJogo = new ArrayList<>();
    File ficheiro;
    Estatistica estatisticas;
    InfoJogo jogo;

    public Simulador(){
        this.idEquipaAtual = 10;
        this.terminou = false;
        this.estatisticas = new Estatistica();
        this.jogo = new InfoJogo();
    }

    public void setNumeroPecas(){
        for(CrazyPiece peca: pecasJogo ){
            if(peca.getIdEquipa() == 10){
                jogo.incrementaPecasPretas();
            }else{
                jogo.incrementaPecasBrancas();
            }
        }
    }

    public boolean iniciaJogo(File ficheiroInical){
        estatisticas.limpar();
        tamanhoTabuleiro = 0;
        numeroPecas = 0;
        idEquipaAtual = 10;
        pecas.clear();
        pecasJogo.clear();
        jogo.limpar();
        ficheiro = ficheiroInical;
        try {
            Scanner leitorFicheiro = new Scanner(ficheiro);
            int numLinha = 0;
            int linhaTabuleiro = 0;
            while(leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(":");
                numLinha ++;
                if (numLinha == 1){
                    int tamanho = Integer.parseInt(dados[0]);
                    if (tamanho < 4 || tamanho >12){
                        return false;
                    }else{
                        tamanhoTabuleiro = tamanho;
                    }
                }else if (numLinha == 2){
                    int numpecas = Integer.parseInt(dados[0]);
                    if (numpecas >= tamanhoTabuleiro*tamanhoTabuleiro){
                        return false;
                    }else{
                        numeroPecas = numpecas;
                    }
                }else if (numLinha >= 3 && numLinha <= numeroPecas + 2){
                    int idPeca = Integer.parseInt(dados[0]);
                    int tipoPeca = Integer.parseInt(dados[1]);
                    int idEquipa = Integer.parseInt(dados[2]);
                    String alcunha = dados[3];
                    if (tipoPeca == 0){
                        CrazyPiece peca = new Rei(idPeca,tipoPeca,idEquipa,alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if (tipoPeca == 1) {
                        CrazyPiece peca = new Rainha(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 4){
                        CrazyPiece peca = new TorreHor(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 5){
                        CrazyPiece peca = new TorreVert(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 6){
                        CrazyPiece peca = new Lebre(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }
                }else if (numLinha >= numeroPecas + 3 && numLinha<= numeroPecas + 2 + tamanhoTabuleiro){
                    for (int colunaTabuleiro = 0; colunaTabuleiro < tamanhoTabuleiro; colunaTabuleiro++){
                        int id = Integer.parseInt(dados[colunaTabuleiro]);
                        for (CrazyPiece peca : pecas){
                            if (peca.getId() == id){
                                peca.definirCoordenadas(colunaTabuleiro,linhaTabuleiro);
                                pecasJogo.add(peca);
                            }
                        }
                    }
                    linhaTabuleiro ++;
                }
            }
            leitorFicheiro.close();
            if (pecasJogo.size() < numeroPecas){
                numeroPecas = pecasJogo.size();
            }
            setNumeroPecas();
            if ((numeroPecas == 2 && jogo.getPecasBrancas() == 0 && jogo.getPecasPretas() == 0) || (numeroPecas == 0)){
                terminou=true;
            }
            if (jogo.getPecasBrancas() == 0 || jogo.getPecasPretas() == 0){
                terminou=true;
            }
            return true;
        }
        catch(FileNotFoundException exception) {
            System.out.println("Erro: o ficheiro não foi encontrado.");
            return false;
        }
    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        int count = 0;
        CrazyPiece pecaAtual = null;
        if (terminou){
            return true;
        }
        while(!terminou) {
            if (xO < 0 || xO > tamanhoTabuleiro || yO < 0 || yO > tamanhoTabuleiro || xD < 0 || xD > tamanhoTabuleiro || yD < 0
                    || yD > tamanhoTabuleiro) {
                if (idEquipaAtual == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            for (CrazyPiece peca: pecasJogo) {
                if (peca.getIdEquipa() == idEquipaAtual && peca.getX() == xO && peca.getY() == yO) {
                    if (peca.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo)){
                        peca.definirCoordenadas(xD, yD);
                        if (jogo.primeiraCapturaFoiEfetuada()) {
                            jogo.incrementaTurnoSemCapturas();
                        }
                        if (idEquipaAtual == 10) {
                            estatisticas.adicionaJogadasValidasPretas();
                            idEquipaAtual = 20;
                        } else {
                            estatisticas.adicionaJogadasValidasBrancas();
                            idEquipaAtual = 10;
                        }
                        jogo.incrementarTurno();
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    count ++;
                    if (count == pecasJogo.size()) {
                        if (idEquipaAtual == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<CrazyPiece> getPecasMalucas(){
        return pecas;
    }

    public boolean jogoTerminado(){
        if ((jogo.getPecasPretas() == 0 || jogo.getPecasBrancas()== 0) || (jogo.getPecasPretas() == 1 && jogo.getPecasBrancas() == 1) || jogo.getTurnosSemCapturas()== 10 || numeroPecas<=2){
            terminou = true;
            return true;
        }else{
            return false;
        }
    }

    public List<String> getAutores(){
        List<String> autores = new ArrayList<>();
        String nomeFicheiro = "AUTHORS.txt";
        try {
            File ficheiro = new File(nomeFicheiro);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while(leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(";");
                String autor = dados[1];
                autores.add(autor);
            }
            leitorFicheiro.close();
        }
        catch(FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiro + " nao foi encontrado.";
            System.out.println(mensagem);
        }
        return autores;
    }

    public List<String> getResultados(){
        List<String> resultados = new ArrayList<>();
        resultados.add("JOGO DE CRAZY CHESS");
        if(jogo.getPecasBrancas() == 0){
            resultados.add("Resultado: VENCERAM AS PRETAS");
        }else if(jogo.getPecasPretas() == 0){
            resultados.add("Resultado: VENCERAM AS BRANCAS");
        }else{
            resultados.add("Resultado: EMPATE");
        }
        resultados.add("---");
        resultados.add("Equipa das Pretas");
        resultados.add(" Capturas: " + estatisticas.getCapturasPretas());
        resultados.add(" Jogadas válidas: " + estatisticas.getJogadasValidasPretas());
        resultados.add(" Tentativas inválidas : " + estatisticas.getJogadasInvalidasPretas());
        resultados.add("Equipa das Brancas");
        resultados.add(" Capturas: " + estatisticas.getCapturasBrancas());
        resultados.add(" Jogadas válidas: " + estatisticas.getJogadasValidasBrancas());
        resultados.add(" Tentativas inválidas: " + estatisticas.getJogadasInvalidasBrancas());
        return resultados;
    }

    public int getIDPeca(int x, int y){
        for (CrazyPiece peca: pecasJogo){
            if (peca.getX() == x &&  peca.getY() == y){
                return peca.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        return idEquipaAtual;
    }

    public List<String> obterSugestoesJogada(int xO, int yO) {
        return null;
    }

    public void anularJogadaAnterior(){

    }

    public boolean gravarJogo(File ficheiroDestino){
        return true;
    }
}