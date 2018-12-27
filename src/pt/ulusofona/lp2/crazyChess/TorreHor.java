package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public class TorreHor extends CrazyPiece {

    TorreHor(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "3";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "TorreH";
        return tipo;
    }

    List<String> sugerirJogadas(int xO, int yO, CrazyPiece ref, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <String> jogadaTorreHor = new ArrayList<>();
        int count = 0;
        int valorX = xO;
        int xRef = tamanhoTabuleiro - 1;
        int idRef = idEquipa;
        for (CrazyPiece peca: pecasJogo){//direita
            if (peca.getX() > valorX && peca.getX() <= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
            }
            count ++;
            if (count == pecasJogo.size()){
                if(xRef != tamanhoTabuleiro-1 && idRef != idEquipa){
                    while (valorX + 1 <= xRef){
                        jogadaTorreHor.add(valorX+1 + ", " + yO);
                        valorX++;
                    }
                }else if (xRef != tamanhoTabuleiro-1 && idRef == idEquipa) {
                    while (valorX+1 < xRef) {
                        jogadaTorreHor.add(valorX+1 + ", " + yO);
                        valorX++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getX()== tamanhoTabuleiro-1 && pecaFronteira.getY() == yO && idRef == idEquipa){
                            while (valorX + 1 < tamanhoTabuleiro -1){
                                jogadaTorreHor.add(valorX + 1 + ", " + yO);
                                valorX++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorX + 1 <= tamanhoTabuleiro -1){
                                jogadaTorreHor.add(valorX + 1 + ", " + yO);
                                valorX++;
                            }
                        }
                    }
                }
            }
        }
        valorX = xO;
        count = 0;
        xRef = 0;
        idRef = idEquipa;
        for (CrazyPiece peca: pecasJogo){//esquerda
            if (peca.getX() < valorX && peca.getX() >= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
            }
            count ++;
            if (count == pecasJogo.size()){
                if(xRef != 0 && idRef != idEquipa){
                    while (valorX - 1 >= xRef){
                        jogadaTorreHor.add(valorX-1 + ", " + yO);
                        valorX--;
                    }
                }else if (xRef != 0 && idRef == idEquipa) {
                    while (valorX-1 < xRef) {
                        jogadaTorreHor.add(valorX-1 + ", " + yO);
                        valorX--;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == yO && idRef == idEquipa){
                            while (valorX - 1 > tamanhoTabuleiro -1){
                                jogadaTorreHor.add(valorX - 1 + ", " + yO);
                                valorX--;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorX - 1 >= 0){
                                jogadaTorreHor.add(valorX - 1 + ", " + yO);
                                valorX--;
                            }
                        }
                    }
                }
            }
        }
        return jogadaTorreHor;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        int count = 0;
        if (yD != yO){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        while (count < pecasJogo.size()){
            for (CrazyPiece peca : pecasJogo) {
                if ((peca.getX() > xO && peca.getX() < xD && peca.getY() == yO) || (peca.getX() < xO && peca.getX() > xD && peca.getY() == yO)) {
                    if (idEquipa == 10) {
                        estatisticas.adicionaJogadasInvalidasPretas();
                    } else {
                        estatisticas.adicionaJogadasInvalidasBrancas();
                    }
                    return false;
                }
                count++;
            }
        }
        CrazyPiece pecaParaRemover = null;
        for (CrazyPiece peca : pecasJogo) {
            if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
                pecaParaRemover = peca;
                peca.capturar();
                jogo.primeiraCapturaFeita();
                jogo.resetTurnosSemCapturas();
                if (idEquipa == 10) {
                    jogo.decrementaPecasBrancas();
                    estatisticas.capturarPretas();
                } else {
                    jogo.decrementaPecasPretas();
                    estatisticas.capturarBrancas();
                }
            }
            if (peca.getIdEquipa() == idEquipa && peca.getX() == xD && peca.getY() == yD) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
        }
        pecasJogo.remove(pecaParaRemover);
        return true;
    }
}