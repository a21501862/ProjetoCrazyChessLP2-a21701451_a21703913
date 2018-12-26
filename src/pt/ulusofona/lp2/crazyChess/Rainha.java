package pt.ulusofona.lp2.crazyChess;

import java.util.List;

import static java.lang.Math.abs;

public class Rainha extends CrazyPiece {

    Rainha(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "8";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Rainha";
        return tipo;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo){
        int count = 0;
        if(xD > xO + 5 || yD > yO + 5 || xD < xO - 5 || yD < yO - 5){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        if (abs(xO - xD) != abs(yO - yD) && abs(xO - xD) != 0 && abs(yO - yD) != 0){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        while (count < pecasJogo.size()){
            for (CrazyPiece peca: pecasJogo){
                if (xO < xD && yO>yD){ // diagonal cima direita
                    for (int posX = xO + 1, posY = yO - 1; posX < xD && posY > yD; posX++, posY--){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (xO > xD && yO>yD){ // diagonal cima esquerda
                    for (int posX = xO -1, posY = yO - 1; posX > xD && posY > yD; posX--, posY--){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (xO < xD && yO<yD){ // diagonal baixo direita
                    for (int posX = xO + 1, posY = yO + 1; posX < xD && posY < yD; posX++, posY++){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (xO > xD && yO<yD){ // diagonal baixo esquerda
                    for (int posX = xO - 1, posY = yO + 1; posX > xD && posY < yD; posX--, posY++){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (yO == yD){ // movimento horizontal
                    if ((peca.getX() > xO && peca.getX() < xD && peca.getY() == yO) || (peca.getX() < xO && peca.getX() > xD && peca.getY() == yO)) {
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                }
                if (xO == xD){ // movimento vertical
                    if ((peca.getY() > yO && peca.getY() < yD && peca.getX() == xO) || (peca.getY() < yO && peca.getY() > yD && peca.getX() == xO)) {
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                }
                count++;
            }
        }
        CrazyPiece pecaParaRemover = null;
        for (CrazyPiece peca : pecasJogo) {
            if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD && peca.getIdTipo() != idTipo) {
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
            if ((peca.getIdEquipa() == idEquipa || peca.getIdTipo() == idTipo) && peca.getX() == xD && peca.getY() == yD) {
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

    @Override
    List<String> sugerirJogadas(int xO, int yO, CrazyPiece peca, List<CrazyPiece> pecasJogo) {
        return null;
    }
}