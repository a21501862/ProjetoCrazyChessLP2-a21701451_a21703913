package pt.ulusofona.lp2.crazyChess;

import java.util.List;

import static java.lang.Math.abs;

public class PoneiMagico extends CrazyPiece {
    PoneiMagico(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "5";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Ponei Mágico";
        return tipo;
    }

    List<String> sugerirJogadas(int xO, int yO, CrazyPiece peca, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        return null;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        int count = 0;
        if(abs(xO-xD) != 2|| abs(yO-yD) != 2 ){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        if(abs(xO - xD) != abs(yO - yD)) {
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        while(count<pecasJogo.size()){
            if(xO < xD && yO > yD){//cima direita
                for(CrazyPiece peca : pecasJogo){
                    if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO-1 || peca.getY() == yD)){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO+1){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                }
            }
            if(xO > xD && yO > yD){//cima esquerda
                for(CrazyPiece peca : pecasJogo){
                    if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO-1 || peca.getY() == yD)){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO-1){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                }
            }
            if(xO < xD && yO < yD){//baixo direita
                for(CrazyPiece peca : pecasJogo){
                    if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO+1 || peca.getY() == yD)){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO+1){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                }
            }
            if(xO > xD && yO < yD){//baixo esquerda
                for(CrazyPiece peca : pecasJogo){
                    if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO+1 || peca.getY() == yD)){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO-1){
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                }
            }
            count++;
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