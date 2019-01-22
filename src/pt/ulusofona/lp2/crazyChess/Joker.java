package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Joker extends CrazyPiece {

    public String tipoJoker;

    Joker(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
        tipoJoker = "Rainha";
    }

    public String getValorRelativo() {
        valorRelativo = "4";
        return valorRelativo;
    }

    public int getPontos() {
        return 4;
    }

    public String getTipo() {
        tipo = "Joker";
        return tipo;
    }

    public String getTipoJoker(){
        return tipoJoker;
    }

    public String toString(){
        if (capturada){
            return idPeca + " | " + getTipo() + "/" + getTipoJoker() + " | " + getValorRelativo() + " | " + idEquipa + " | " + alcunha + " @ (n/a)";
        }else{
            return idPeca + " | " + getTipo() + "/" + getTipoJoker() + " | " + getValorRelativo() + " | " + idEquipa + " | " + alcunha + " @ (" + x + ", " + y + ")";
        }    }

    public void mudaTipoJoker(){
        if (tipoJoker.equals("Rainha")){
            tipoJoker = "Ponei Mágico";
        }else if (tipoJoker.equals("Ponei Mágico")){
            tipoJoker = "Padre da Vila";
        }else if (tipoJoker.equals("Padre da Vila")) {
            tipoJoker = "TorreH";
        }else if (tipoJoker.equals("TorreH")) {
            tipoJoker = "TorreV";
        }else if (tipoJoker.equals("TorreV")) {
            tipoJoker = "Lebre";
        }else if (tipoJoker.equals("Lebre")) {
            tipoJoker = "Rainha";
        }
    }

    public List<Comparable> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo, int tamanhoTabuleiro) {
        List<Comparable> jogadaJoker = new ArrayList<>();
        if (tipoJoker.equals("Rainha")) {
            CrazyPiece rainhaJoker = new Rainha(idPeca,idTipo,idEquipa,alcunha);
            return rainhaJoker.sugerirJogadas(xO,yO,pecasJogo, tamanhoTabuleiro);
        } else if (tipoJoker.equals("Ponei Mágico")) {
            CrazyPiece poneiJoker = new PoneiMagico(idPeca,idTipo,idEquipa,alcunha);
            return poneiJoker.sugerirJogadas(xO,yO,pecasJogo,tamanhoTabuleiro);
        } else if(tipoJoker.equals("Padre da Vila")){
            CrazyPiece padreJoker = new PadreDaVila(idPeca,idTipo,idEquipa,alcunha);
            return padreJoker.sugerirJogadas(xO,yO,pecasJogo,tamanhoTabuleiro);
        } else if(tipoJoker.equals("TorreH")){
            CrazyPiece torreHJoker = new TorreHor(idPeca,idTipo,idEquipa,alcunha);
            return torreHJoker.sugerirJogadas(xO,yO,pecasJogo,tamanhoTabuleiro);
        }else if(tipoJoker.equals("TorreV")){
            CrazyPiece torreVJoker = new TorreVert(idPeca,idTipo,idEquipa,alcunha);
            return torreVJoker.sugerirJogadas(xO,yO,pecasJogo,tamanhoTabuleiro);
        }else if(tipoJoker.equals("Lebre")){
            CrazyPiece lebreJoker = new Lebre(idPeca,idTipo,idEquipa,alcunha);
            return lebreJoker.sugerirJogadas(xO,yO,pecasJogo,tamanhoTabuleiro);
        }
        return jogadaJoker;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        if (tipoJoker.equals("Rainha")) {
            CrazyPiece rainhaJoker = new Rainha(idPeca,idTipo,idEquipa,alcunha);
            return rainhaJoker.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
        } else if (tipoJoker.equals("Ponei Mágico")) {
            CrazyPiece poneiJoker = new PoneiMagico(idPeca,idTipo,idEquipa,alcunha);
            return poneiJoker.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
        } else if(tipoJoker.equals("Padre da Vila")){
            CrazyPiece padreJoker = new PadreDaVila(idPeca,idTipo,idEquipa,alcunha);
            return padreJoker.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
        } else if(tipoJoker.equals("TorreH")){
            CrazyPiece torreHJoker = new TorreHor(idPeca,idTipo,idEquipa,alcunha);
            return torreHJoker.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
        }else if(tipoJoker.equals("TorreV")){
            CrazyPiece torreVJoker = new TorreVert(idPeca,idTipo,idEquipa,alcunha);
            return torreVJoker.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
        }else if(tipoJoker.equals("Lebre")){
            CrazyPiece lebreJoker = new Lebre(idPeca,idTipo,idEquipa,alcunha);
            return lebreJoker.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo);
        }
        return true;
    }
}