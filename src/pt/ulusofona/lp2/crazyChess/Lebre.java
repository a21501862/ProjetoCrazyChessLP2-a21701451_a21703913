package pt.ulusofona.lp2.crazyChess;

import java.util.List;

public class Lebre extends CrazyPiece {
     Lebre(int idPeca, int tipo, int idEquipa, String alcunha){
         super(idPeca,tipo,idEquipa,alcunha);
     }

    @Override
    public String getValorRelativo() {
        return null;
    }

    @Override
    public String getTipo() {
        return null;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
         if (jogo.getTurno() %2 != 0){
             if (idEquipa == 10) {
                 estatisticas.adicionaJogadasInvalidasPretas();
             } else {
                 estatisticas.adicionaJogadasInvalidasBrancas();
             }
             return false;
         }
        if(xD > xO + 1 || xD < xO - 1 || yD > yO + 1 || yD < yO - 1){
            return false;
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
