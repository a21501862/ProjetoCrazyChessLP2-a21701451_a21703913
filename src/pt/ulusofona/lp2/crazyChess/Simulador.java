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
    List<String> autores = new ArrayList<>();
    List<String> resultados = new ArrayList<>();
    File ficheiro;
    int idEquipaAtual;
    int jogadasInvalidasPretas;
    int jogadasInvalidasBrancas;
    int jogadasValidasPretas;
    int jogadasValidasBrancas;
    boolean terminou;

    public Simulador(){
        this.idEquipaAtual = 0;
        this.jogadasInvalidasPretas = 0;
        this.jogadasInvalidasBrancas = 0;
        this.jogadasValidasPretas = 0;
        this.jogadasValidasBrancas = 0;
        this.terminou = false;
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
                            }
                        }
                    }
                    linhaTabuleiro ++;
                }
            }
            leitorFicheiro.close();
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
        if (xO < 0 || xO >tamanhoTabuleiro || yO <0 || yO >tamanhoTabuleiro || xD < 0 || xD >tamanhoTabuleiro || Yd <0 || Yd >tamanhoTabuleiro){
            if (idEquipaAtual == 0){
                jogadasInvalidasPretas ++;
            }else{
                jogadasInvalidasBrancas ++;
            }
            return false;
        }
        return true;
    }

    public List<CrazyPiece> getPecasMalucas(){
        return pecas;
    }

    public boolean jogoTerminado(){
        if (terminou){
            return true;
        }else{
            return false;
        }
    }

    public List<String> getAutores(){
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
        return resultados;
    }

    public int getIDPeca(int x, int y){
        for (CrazyPiece peca: pecas){
            if (peca.getX() == x && peca.getY() == y){
                return peca.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        return idEquipaAtual;
    }
}
