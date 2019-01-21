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

    public int getPontos() {
        return 3;
    }

    List<Comparable> sugerirJogadas(int xO, int yO, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <Comparable> jogadaTorreVer = new ArrayList<>();
        int count = 0;
        int valorY = yO;
        int yRef = tamanhoTabuleiro - 1;
        int idRef = idEquipa;
        int pontosRef = 0;
        for (CrazyPiece peca: pecasJogo){//baixo
            if (peca.getY() > valorY && peca.getY() <= yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
                pontosRef = peca.getPontos();
            }
            count ++;
            if (count == pecasJogo.size()){
                if(yRef != tamanhoTabuleiro-1 && idRef != idEquipa){
                    while (valorY + 1 <= yRef){
                        if (valorY+1 == yRef){
                            jogadaTorreVer.add(new Sugestao(xO, (valorY + 1), pontosRef));
                        }else{
                            jogadaTorreVer.add(new Sugestao(xO, (valorY + 1), 0));
                        }
                        valorY++;
                    }
                }else if (yRef != tamanhoTabuleiro-1 && idRef == idEquipa) {
                    while (valorY+1 < yRef) {
                        jogadaTorreVer.add(new Sugestao(xO ,(valorY+1),0));
                        valorY++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== tamanhoTabuleiro-1 && pecaFronteira.getX() == xO && idRef == idEquipa){
                            while (valorY + 1 < tamanhoTabuleiro -1){
                                jogadaTorreVer.add(new Sugestao(xO,(valorY+1),0));
                                valorY++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY + 1 <= tamanhoTabuleiro -1){
                                jogadaTorreVer.add(new Sugestao(xO,(valorY+1),0));
                                valorY++;
                            }
                        }
                    }
                }
            }
        }
        valorY = yO;
        count = 0;
        yRef = 0;
        idRef = idEquipa;
        pontosRef = 0;
        for (CrazyPiece peca: pecasJogo){//cima
            if (peca.getY() < valorY && peca.getY() >= yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
                pontosRef = peca.getPontos();
            }
            count ++;
            if (count == pecasJogo.size()){
                if(yRef != 0 && idRef != idEquipa){
                    while (valorY - 1 >= yRef){
                        jogadaTorreVer.add(new Sugestao(xO,(valorY-1), peca.getPontos()));
                        valorY--;
                    }
                }else if (yRef != 0 && idRef == idEquipa) {
                    while (valorY-1 > yRef) {
                        if (valorY-1 == yRef){
                            jogadaTorreVer.add(new Sugestao(xO, (valorY - 1), pontosRef));
                        }else{
                            jogadaTorreVer.add(new Sugestao(xO, (valorY - 1), 0));
                        }
                        valorY--;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == xO && idRef == idEquipa){
                            while (valorY - 1 >0){
                                jogadaTorreVer.add(new Sugestao(xO,(valorY-1),0));
                                valorY--;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY - 1 >= 0){
                                jogadaTorreVer.add(new Sugestao(xO,(valorY-1), 0));
                                valorY--;
                            }
                        }
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
            incrementaJogadasInvalidas();
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