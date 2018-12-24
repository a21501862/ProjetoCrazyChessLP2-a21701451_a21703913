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
        if (tipoJoker.equals("Rainha")){
            int tipoTemp = 1;
            CrazyPiece temp = new Rainha(idPeca,tipoTemp,idEquipa,alcunha);
            temp.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
            tipoJoker = "Ponei Mágico";
        }else if (tipoJoker.equals("Ponei Mágico")){
            int tipoTemp = 2;
            CrazyPiece temp = new PoneiMagico(idPeca,tipoTemp,idEquipa,alcunha);
            temp.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
            tipoJoker = "Padre Da Vila";
        }else if (tipoJoker.equals("Padre Da Vila")) {
            int tipoTemp = 3;
            CrazyPiece temp = new PadreDaVila(idPeca, tipoTemp, idEquipa, alcunha);
            temp.movePeca(xO, yO, xD, yD, estatisticas, pecasJogo, jogo);
            tipoJoker = "TorreH";
        }else if (tipoJoker.equals("TorreH")) {
            int tipoTemp = 4;
            CrazyPiece temp = new TorreHor(idPeca, tipoTemp, idEquipa, alcunha);
            temp.movePeca(xO, yO, xD, yD, estatisticas, pecasJogo, jogo);
            tipoJoker = "TorreV";
        }else if (tipoJoker.equals("TorreV")) {
            int tipoTemp = 5;
            CrazyPiece temp = new TorreVert(idPeca, tipoTemp, idEquipa, alcunha);
            temp.movePeca(xO, yO, xD, yD, estatisticas, pecasJogo, jogo);
            tipoJoker = "Lebre";
        }else if (tipoJoker.equals("Lebre")) {
            int tipoTemp = 6;
            CrazyPiece temp = new Lebre(idPeca, tipoTemp, idEquipa, alcunha);
            temp.movePeca(xO, yO, xD, yD, estatisticas, pecasJogo, jogo);
            tipoJoker = "Rainha";
        }
        return true;
    }
}
