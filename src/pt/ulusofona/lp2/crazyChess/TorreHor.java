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

    public int getPontos() {
        return 3;
    }

    public List<Comparable> sugerirJogadas(int xO, int yO, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <Comparable> jogadaTorreHor = new ArrayList<>();
        int count = 0;
        int valorX = xO;
        int xRef = tamanhoTabuleiro - 1;
        int idRef = idEquipa;
        int pontosRef = 0;
        boolean encontrouPeca = false;
        for (CrazyPiece peca: pecasJogo){//direita
            if (peca.getX() > valorX && peca.getX() <= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
                pontosRef = peca.getPontos();
                encontrouPeca = true;
            }
            count ++;
            if (count == pecasJogo.size()){
                if(encontrouPeca && idRef != idEquipa){
                    while (valorX + 1 <= xRef){
                        if (valorX+1 == xRef){
                            jogadaTorreHor.add(new Sugestao(valorX+1, yO, pontosRef));
                        }else{
                            jogadaTorreHor.add(new Sugestao(valorX+1, yO, 0));
                        }
                        valorX++;
                    }
                }else if (encontrouPeca && idRef == idEquipa) {
                    while (valorX+1 < xRef) {
                        jogadaTorreHor.add(new Sugestao(valorX+1, yO, 0));
                        valorX++;
                    }
                }else{
                    while (valorX+1 <= tamanhoTabuleiro - 1) {
                        jogadaTorreHor.add(new Sugestao(valorX+1, yO, 0));
                        valorX++;
                    }
                }
            }
        }
        valorX = xO;
        count = 0;
        xRef = 0;
        idRef = idEquipa;
        pontosRef = 0;
        encontrouPeca = false;
        for (CrazyPiece peca: pecasJogo){//esquerda
            if (peca.getX() < valorX && peca.getX() >= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
                pontosRef = peca.getPontos();
                encontrouPeca = true;
            }
            count ++;
            if (count == pecasJogo.size()){
                if(encontrouPeca && idRef != idEquipa){
                    while (valorX - 1 >= xRef){
                        if (valorX-1 == xRef){
                            jogadaTorreHor.add(new Sugestao(valorX-1, yO, pontosRef));
                        }else{
                            jogadaTorreHor.add(new Sugestao(valorX-1, yO, 0));
                        }
                        valorX--;
                    }
                }else if (encontrouPeca && idRef == idEquipa) {
                    while (valorX-1 > xRef) {
                        jogadaTorreHor.add(new Sugestao(valorX-1, yO, 0));
                        valorX--;
                    }
                }else{
                    while (valorX-1 >= 0) {
                        jogadaTorreHor.add(new Sugestao(valorX-1, yO, 0));
                        valorX--;
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
            incrementaJogadasInvalidas();
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
                    incrementaJogadasInvalidas();
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