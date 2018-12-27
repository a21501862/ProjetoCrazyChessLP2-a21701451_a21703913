package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public class TorreVert extends CrazyPiece {

    TorreVert(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "3";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "TorreV";
        return tipo;
    }

    List<String> sugerirJogadas(int xO, int yO, CrazyPiece ref, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <String> jogadaTorreVer = new ArrayList<>();
        int count = 0;
        int yRef = tamanhoTabuleiro - 1;
        int idRef = idEquipa;
        for (CrazyPiece peca: pecasJogo){//baixo
            if (peca.getY() > yO && peca.getY() < yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
            }
            count ++;
            if (count == pecasJogo.size()){
                if(yRef != yO && idRef != idEquipa){
                    while (yO + 1 <= yRef){
                        jogadaTorreVer.add(xO + ", " + (yO+1));
                        yO++;
                    }
                }else if (yRef != yO && idRef == idEquipa) {
                    while (yO+1 < yRef) {
                        jogadaTorreVer.add(xO + ", " + (yO+1));
                        yO++;
                    }
                }else{
                    while (yO + 1<tamanhoTabuleiro){
                        jogadaTorreVer.add(xO + ", " + (yO+1));
                        yO++;
                    }
                }
            }
        }
        count = 0;
        yRef = 0;
        idRef = idEquipa;
        for (CrazyPiece peca: pecasJogo){//cima
            if (peca.getY() < yO && peca.getY() >yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
            }
            count ++;
            if (count == pecasJogo.size()){
                if(yRef != yO && idRef != idEquipa){
                    while (yO - 1 >= yRef){
                        jogadaTorreVer.add(xO + ", " + (yO-1));
                        yO--;
                    }
                }else if (yRef != yO && idRef == idEquipa) {
                    while (yO-1 > yRef) {
                        jogadaTorreVer.add(xO + ", " + (yO-1));
                        yO--;
                    }
                }else{
                    while (yO - 1>=0){
                        jogadaTorreVer.add(xO + ", " + (yO-1));
                        yO--;
                    }
                }
            }
        }
        return jogadaTorreVer;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        int count = 0;
        if (xD != xO){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        while (count < pecasJogo.size()){
            for (CrazyPiece peca : pecasJogo) {
                if ((peca.getY() > yO && peca.getY() < yD && peca.getX() == xO) || (peca.getY() < yO && peca.getY() > yD && peca.getX() == xO)) {
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