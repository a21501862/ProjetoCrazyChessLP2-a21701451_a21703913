package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public class Rei extends CrazyPiece {

    Rei(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "(infinito)";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Rei";
        return tipo;
    }

    public int getPontos() {
        return 1000;
    }

    List<String> sugerirJogadas(int xO,int yO,List<CrazyPiece> pecasJogo, int tamanhoTabuleiro) {
        List <String> jogadaRei = new ArrayList<>();
        int count = 0;
        for (CrazyPiece peca: pecasJogo){//direita
           if (peca.getIdEquipa() != idEquipa && peca.getX() == xO + 1 && peca.getY() == yO){
               jogadaRei.add(xO+1 + ", " + yO);
               break;
           }else if(peca.getIdEquipa() == idEquipa && peca.getX() == xO + 1 && peca.getY() == yO){
               break;
           }
           count ++;
           if (count == pecasJogo.size() && xO + 1 < tamanhoTabuleiro){
               jogadaRei.add(xO+1 + ", " + yO);
           }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//esquerda
            if (peca.getIdEquipa() != idEquipa && peca.getX() == xO - 1 && peca.getY() == yO){
                jogadaRei.add(xO-1 + ", " + yO);
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getX() == xO - 1 && peca.getY() == yO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && xO - 1 >= 0){
                jogadaRei.add(xO-1 + ", " + yO);
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//cima
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO){
                jogadaRei.add(xO + ", " + (yO-1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && yO - 1 >= 0){
                jogadaRei.add(xO + ", " + (yO-1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO){
                jogadaRei.add(xO + ", " + (yO+1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO){
                break;
            }
            count ++;
            if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro){
                jogadaRei.add(xO + ", " + (yO+1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//cima direita
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO + 1){
                jogadaRei.add(xO+1 + ", " + (yO-1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO+1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO - 1 >= 0 && xO + 1 < tamanhoTabuleiro){
                jogadaRei.add(xO+1 + ", " + (yO-1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//cima esquerda
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO - 1){
                jogadaRei.add(xO-1 + ", " + (yO-1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO-1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO - 1 >= 0 && xO - 1 >= 0){
                jogadaRei.add(xO-1 + ", " + (yO-1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo esquerda
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO - 1){
                jogadaRei.add(xO-1 + ", " + (yO+1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO-1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro && xO - 1 >= 0){
                jogadaRei.add(xO-1 + ", " + (yO+1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo direita
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO + 1){
                jogadaRei.add(xO+1 + ", " + (yO+1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO+1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro && xO + 1 < tamanhoTabuleiro){
                jogadaRei.add(xO+1 + ", " + (yO+1));
            }
        }
        return jogadaRei;
    }

    boolean movePeca(int xO, int yO, int xD, int yD,Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        if(xD > xO + 1 || xD < xO - 1 || yD > yO + 1 || yD < yO - 1){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        CrazyPiece pecaParaRemover = null;
        for (CrazyPiece peca : pecasJogo) {
            if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
                pecaParaRemover = peca;
                peca.capturar();
                jogo.primeiraCapturaFeita();
                incrementaNrCaptura();
                incrementaNrPontos(peca.getPontos());
                if (jogo.getTurnoPrimeiraCaptura() == -1){
                    jogo.setTurnoPrimeiraCaptura(jogo.getTurno());
                }
                jogo.setTurnosAteCaptura(jogo.getTurnosSemCapturas());
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
        jogo.setUltimaPecaCapturada(pecaParaRemover);
        return true;
    }
}