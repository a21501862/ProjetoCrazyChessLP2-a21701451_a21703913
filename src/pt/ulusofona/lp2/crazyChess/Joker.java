package pt.ulusofona.lp2.crazyChess;

import java.util.List;

public class Joker extends CrazyPiece {

    String tipoJoker;

    Joker(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
        tipoJoker = "Rainha";
    }

    public String getValorRelativo() {
        valorRelativo = "4";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Joker";
        return tipo;
    }

    public String getTipoJoker(){
        return tipoJoker;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        return true;
    }
}
