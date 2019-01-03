package pt.ulusofona.lp2.crazyChess;

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

    List<String> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo,int tamanhoTabuleiro){

        return null;
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
                if (peca.getIdEquipa() != idEquipa && peca.getIdTipo() != idTipo && ((abs(peca.getX()- xD) == 1 && peca.getY() == yD) || ((abs(peca.getY()- yD) == 1 && peca.getX() == xD)))) {
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
        }else if (jogo.getTurno()%2!=0){
            int count = 0;
            if(abs(xO - xD) != abs(yO - yD)){
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
