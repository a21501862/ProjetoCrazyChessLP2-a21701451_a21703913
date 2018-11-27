package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    int tamanhoTabuleiro;
    int numeroPecas;
    List<CrazyPiece> pecas = new ArrayList<>();
    List<CrazyPiece> pecasJogo = new ArrayList<>();
    File ficheiro;
    int idEquipaAtual;
    int jogadasInvalidasPretas;
    int jogadasInvalidasBrancas;
    int jogadasValidasPretas;
    int jogadasValidasBrancas;
    int reisPretos;
    int reisBrancos;
    int capturasPretas;
    int capturasBrancas;
    int turnosSemCapturas;
    boolean primeiraCapturaEfetuada;
    boolean terminou;

    public Simulador(){
        this.idEquipaAtual = 0;
        this.jogadasInvalidasPretas = 0;
        this.jogadasInvalidasBrancas = 0;
        this.jogadasValidasPretas = 0;
        this.jogadasValidasBrancas = 0;
        this.capturasBrancas = 0;
        this.capturasPretas = 0;
        this.primeiraCapturaEfetuada = false;
        this.terminou = false;
    }

    public void setNumeroReis(){
        for(CrazyPiece peca: pecas ){
            if(peca.getIdEquipa() == 0){
                reisPretos++;
            }else{
                reisBrancos++;
            }
        }
    }

    public boolean iniciaJogo(File ficheiroInical){
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
                    CrazyPiece peca = new CrazyPiece(idPeca,tipoPeca,idEquipa,alcunha);
                    pecas.add(peca);
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
            setNumeroReis();
            if ((numeroPecas == 2 && reisBrancos == 0 && reisPretos == 0) || (numeroPecas == 0)){
                terminou=true;
            }
            if (reisBrancos == 0 || reisPretos == 0){
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

    public boolean processaJogada(int xO, int yO, int xD, int Yd){
        if (terminou){
            return true;
        }
        while(!terminou){
            int count = 0;
            CrazyPiece pecaParaRemover = null;
            if (xO < 0 || xO >tamanhoTabuleiro || yO <0 || yO >tamanhoTabuleiro || xD < 0 || xD >tamanhoTabuleiro || Yd <0
                    || Yd >tamanhoTabuleiro || xD > xO + 1 || xD < xO - 1 || Yd > yO + 1 || Yd < yO - 1){
                if (idEquipaAtual == 0){
                    jogadasInvalidasPretas ++;
                }else{
                    jogadasInvalidasBrancas ++;
                }
                return false;
            }
            for (CrazyPiece peca: pecasJogo){
                if (peca.getIdEquipa() == idEquipaAtual && peca.getX() == xO && peca.getY() == yO){
                    for (CrazyPiece peca2 : pecasJogo){
                        if (peca2.getIdEquipa() != idEquipaAtual && peca2.getX() == xD && peca2.getY() == Yd){
                            pecaParaRemover = peca2;
                            peca2.capturar();
                            primeiraCapturaEfetuada = true;
                            turnosSemCapturas = -1;
                            if (idEquipaAtual == 0) {
                                reisBrancos--;
                                capturasPretas++;
                            } else {
                                reisPretos--;
                                capturasBrancas++;
                            }
                        }
                        if (peca2.getIdEquipa() == idEquipaAtual && peca2.getX() == xD && peca2.getY() == Yd){
                            if (idEquipaAtual == 0) {
                                jogadasInvalidasPretas++;
                            } else {
                                jogadasInvalidasBrancas++;
                            }
                            return false;
                        }
                    }
                    peca.definirCoordenadas(xD,Yd);
                    pecasJogo.remove(pecaParaRemover);
                    if (primeiraCapturaEfetuada){
                        turnosSemCapturas ++;
                    }
                    if (idEquipaAtual == 0){
                        jogadasValidasPretas++;
                        idEquipaAtual = 1;
                    }else{
                        jogadasValidasBrancas++;
                        idEquipaAtual = 0;
                    }
                    return true;
                }else{
                    count ++;
                    if (count == pecasJogo.size()) {
                        if (idEquipaAtual == 0) {
                            jogadasInvalidasPretas++;
                        } else {
                            jogadasInvalidasBrancas++;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<CrazyPiece> getPecasMalucas(){
        return pecasJogo;
    }

    public boolean jogoTerminado(){
        if ((reisPretos == 0 || reisBrancos == 0) || (reisPretos == 1 && reisBrancos == 1) || turnosSemCapturas == 10 || numeroPecas<=2){
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
        if(reisBrancos == 0){
            resultados.add("Resultado: VENCERAM AS PRETAS");
        }else if(reisPretos == 0){
            resultados.add("Resultado: VENCERAM AS BRANCAS");
        }else{
            resultados.add("Resultado: EMPATE");
        }
        resultados.add("---");
        resultados.add("Equipa das Pretas");
        resultados.add(String.valueOf(capturasPretas));
        resultados.add(String.valueOf(jogadasValidasPretas));
        resultados.add(String.valueOf(jogadasInvalidasPretas));
        resultados.add("Equipa das Brancas");
        resultados.add(String.valueOf(capturasBrancas));
        resultados.add(String.valueOf(jogadasValidasBrancas));
        resultados.add(String.valueOf(jogadasInvalidasBrancas));
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
}