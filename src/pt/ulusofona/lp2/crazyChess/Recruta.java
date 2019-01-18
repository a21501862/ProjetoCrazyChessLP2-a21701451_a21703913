package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Recruta extends CrazyPiece {
    Recruta(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "1924";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Recruta";
        return tipo;
    }

    public int getPontos() {
        return 1924;
    }

    List<String> sugerirJogadasTurnoImpar(int xO, int yO,List<CrazyPiece> pecasJogo,int tamanhoTabuleiro){
        List<String> sugestaoRecruta = new ArrayList<>();
        int count = 0;
        for (CrazyPiece peca: pecasJogo){//cima direita
            if (peca.getY() == yO - 2 && peca.getX() == xO + 2){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO - 2 >= 0 && xO +2 < tamanhoTabuleiro){
                sugestaoRecruta.add(xO+2 + ", " + (yO-2));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//cima esquerda
            if (peca.getY() == yO - 2 && peca.getX() == xO - 2){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO - 2 >= 0 && xO - 2 >= 0){
                sugestaoRecruta.add(xO-2 + ", " + (yO-2));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo esquerda
            if (peca.getY() == yO + 2 && peca.getX() == xO - 2){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO + 2 < tamanhoTabuleiro && xO - 2 >= 0){
                sugestaoRecruta.add(xO-2 + ", " + (yO+2));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo direita
            if (peca.getY() == yO + 2 && peca.getX() == xO + 2){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO + 2 < tamanhoTabuleiro && xO + 2 < tamanhoTabuleiro){
                sugestaoRecruta.add(xO+2 + ", " + (yO+2));
            }
        }
        return sugestaoRecruta;
    }

    List<String> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo,int tamanhoTabuleiro){
        List<String> sugestaoRecruta = new ArrayList<>();
        int count = 0;
        for (CrazyPiece peca: pecasJogo){//direita
            if (peca.getX() == xO + 2 && peca.getY() == yO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && xO + 2 < tamanhoTabuleiro){
                sugestaoRecruta.add(xO+2 + ", " + yO);
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//esquerda
            if (peca.getX() == xO - 2 && peca.getY() == yO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && xO - 2 >= 0){
                sugestaoRecruta.add(xO-2 + ", " + yO);
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//cima
            if (peca.getY() == yO - 2 && peca.getX() == xO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && yO - 2 >= 0){
                sugestaoRecruta.add(xO + ", " + (yO-2));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo
            if (peca.getY() == yO + 2 && peca.getX() == xO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && yO + 2 < tamanhoTabuleiro){
                sugestaoRecruta.add(xO + ", " + (yO+2));
            }
        }
        return sugestaoRecruta;
    }


    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo){
        if(xD > xO + 2 || yD > yO + 2 || xD < xO - 2 || yD < yO - 2){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        if (jogo.getTurno()%2==0){
            int count = 0;
            if (abs(xO - xD) != 0 && abs(yO - yD) != 0){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            while (count < pecasJogo.size()) {
                for (CrazyPiece peca : pecasJogo) {
                    if (yO == yD){
                        if (peca.getX() == xD && peca.getY() == yO) {
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }if (xO == xD) {
                        if (peca.getY() == yD && peca.getX() == xO) {
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
            for (CrazyPiece peca : pecasJogo) {
                if (peca.getIdEquipa() != idEquipa && peca.getIdTipo() != idTipo){
                    if(xD<xO){
                        if(peca.getX() == xD + 1 && peca.getY()==yO){
                            peca.setIdEquipa(idEquipa);
                            jogo.setUltimaPecaRecrutada(peca);
                            if (idEquipa == 10) {
                                jogo.decrementaPecasBrancas();
                                jogo.incrementaPecasPretas();
                            } else {
                                jogo.decrementaPecasPretas();
                                jogo.incrementaPecasBrancas();
                            }
                        }
                    }
                    if(xD>xO){
                        if(peca.getX() == xD - 1 && peca.getY()==yO){
                            peca.setIdEquipa(idEquipa);
                            jogo.setUltimaPecaRecrutada(peca);
                            if (idEquipa == 10) {
                                jogo.decrementaPecasBrancas();
                                jogo.incrementaPecasPretas();
                            } else {
                                jogo.decrementaPecasPretas();
                                jogo.incrementaPecasBrancas();
                            }
                        }
                    }
                    if(yD<yO){
                        if(peca.getY() == yD + 1 && peca.getX()==xO){
                            peca.setIdEquipa(idEquipa);
                            jogo.setUltimaPecaRecrutada(peca);
                            if (idEquipa == 10) {
                                jogo.decrementaPecasBrancas();
                                jogo.incrementaPecasPretas();
                            } else {
                                jogo.decrementaPecasPretas();
                                jogo.incrementaPecasBrancas();
                            }
                        }
                    }
                    if(yD>yO){
                        if(peca.getY() == yD - 1 && peca.getX()==xO){
                            peca.setIdEquipa(idEquipa);
                            jogo.setUltimaPecaRecrutada(peca);
                            if (idEquipa == 10) {
                                jogo.decrementaPecasBrancas();
                                jogo.incrementaPecasPretas();
                            } else {
                                jogo.decrementaPecasPretas();
                                jogo.incrementaPecasBrancas();
                            }
                        }
                    }
                }
            }
        }else if (jogo.getTurno()%2!=0){
            int count = 0;
            if(abs(xO - xD) != abs(yO - yD) || abs(xO - xD) != 2 || abs(yO - yD) != 2){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            while (count < pecasJogo.size()) {
                for (CrazyPiece peca : pecasJogo) {
                    if (peca.getX() == xD && peca.getY() == yD) {
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
            for (CrazyPiece peca : pecasJogo) {
                if (peca.getIdEquipa() != idEquipa && peca.getIdTipo() != idTipo && (abs(peca.getX()- xD) == 1 && abs(peca.getY()- yD) == 1 )) {
                    peca.setIdEquipa(idEquipa);
                    jogo.setUltimaPecaRecrutada(peca);
                    if (idEquipa == 10) {
                        jogo.decrementaPecasBrancas();
                        jogo.incrementaPecasPretas();
                    } else {
                        jogo.decrementaPecasPretas();
                        jogo.incrementaPecasBrancas();
                    }
                }
            }
        }
        return true;
    }
}