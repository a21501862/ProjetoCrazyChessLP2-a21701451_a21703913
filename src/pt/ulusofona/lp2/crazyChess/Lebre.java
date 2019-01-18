package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Lebre extends CrazyPiece {
     Lebre(int idPeca, int tipo, int idEquipa, String alcunha){
         super(idPeca,tipo,idEquipa,alcunha);
     }

    public String getValorRelativo() {
        valorRelativo = "2";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Lebre";
        return tipo;
    }

    public int getPontos() {
        return 2;
    }

    List<String> sugerirJogadas(int xO, int yO, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <String> jogadaLebre = new ArrayList<>();
        int count = 0;
        for (CrazyPiece peca: pecasJogo){//cima direita
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO + 1){
                jogadaLebre.add(xO+1 + ", " + (yO-1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO+1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO - 1 >= 0 && xO + 1 < tamanhoTabuleiro){
                jogadaLebre.add(xO+1 + ", " + (yO-1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//cima esquerda
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO - 1){
                jogadaLebre.add(xO-1 + ", " + (yO-1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO-1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO - 1 >= 0 && xO - 1 >= 0){
                jogadaLebre.add(xO-1 + ", " + (yO-1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo esquerda
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO - 1){
                jogadaLebre.add(xO-1 + ", " + (yO+1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO-1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro && xO - 1 >= 0){
                jogadaLebre.add(xO-1 + ", " + (yO+1));
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//baixo direita
            if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO + 1){
                jogadaLebre.add(xO+1 + ", " + (yO+1));
                break;
            }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO+1){
                break;
            }
            count++;
            if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro && xO + 1 < tamanhoTabuleiro){
                jogadaLebre.add(xO+1 + ", " + (yO+1));
            }
        }
        return jogadaLebre;
     }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
         if (jogo.getTurno() %2 != 0){
             if (idEquipa == 10) {
                 estatisticas.adicionaJogadasInvalidasPretas();
             } else {
                 estatisticas.adicionaJogadasInvalidasBrancas();
             }
             incrementaJogadasInvalidas();
             return false;
         }
        if(abs(xO-xD) != 1 || abs(yO-yD) != 1){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            incrementaJogadasInvalidas();
            return false;
        }
        if(abs(xO - xD) != abs(yO - yD)) {
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            incrementaJogadasInvalidas();
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
                incrementaJogadasInvalidas();
                return false;
            }
        }
        pecasJogo.remove(pecaParaRemover);
        jogo.setUltimaPecaCapturada(pecaParaRemover);
        incrementaJogadasValidas();
        return true;
    }
}