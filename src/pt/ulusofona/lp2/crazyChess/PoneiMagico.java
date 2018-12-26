package pt.ulusofona.lp2.crazyChess;

import java.util.List;

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

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        if(xD > xO + 2 || xD < xO - 2 || yD > yO + 2 || yD < yO - 2){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        CrazyPiece pecaParaRemover = null;
        for (CrazyPiece peca : pecasJogo) {
            //Corrigir
            if ((peca.getX() == xO && peca.getY() < yO && peca.getY() > yD) || (peca.getY() == yO && peca.getX() < xO && peca.getX() > xD)
                    || (peca.getX() == xO && peca.getY() > yO && peca.getY() < yD) || (peca.getY() == yO && peca.getX() > xO && peca.getX() < xD)){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            if (peca.getIdEquipa() != idEquipa && (peca.getX() > xD && peca.getY() == yD) ) {
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
