
package pt.ulusofona.lp2.crazyChess;

import java.util.List;

public abstract class CrazyPiece {
    int idPeca;
    int idTipo;
    String tipo;
    String valorRelativo;
    int idEquipa;
    int x;
    int y;
    String alcunha;
    boolean capturada;

    CrazyPiece (int idPeca, int idTipo, int idEquipa, String alcunha){
        this.idPeca = idPeca;
        this.idTipo = idTipo;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;
        this.capturada = false;
    }

    public int getId(){
        return idPeca;
    }

    public String getImagePNG(){
        if (idEquipa == 10){
            if(idTipo==0){
                return "crazy_emoji_black.png";
            }else if(idTipo==1){
                return "rainha_black.png";
            }else if(idTipo==2){
                return "ponei_magico_black.pngg";
            }else if(idTipo==3){
                return "padre_vila_black.png";
            }else if(idTipo==4){
                return "torre_h_black.png";
            }else if(idTipo==5){
                return "torre_v_black.png";
            }else if(idTipo==6){
                return "lebre_black.png";
            }else if(idTipo==7){
                return "joker_black.png";
            }
        }else {
            if (idTipo == 0) {
                return "crazy_emoji_white.png";
            } else if (idTipo == 1) {
                return "rainha_white.png";
            } else if (idTipo == 2) {
                return "ponei_magico_white.pngg";
            } else if (idTipo == 3) {
                return "padre_vila_white.png";
            } else if (idTipo == 4) {
                return "torre_h_white.png";
            } else if (idTipo == 5) {
                return "torre_v_white.png";
            } else if (idTipo == 6) {
                return "lebre_white.png";
            } else if (idTipo == 7) {
                return "joker_white.png";
            }
        }
        return null;
    }

    public String toString(){
        if (capturada){
            return idPeca + " | " + getTipo() + " | " + getValorRelativo() + " | " + idEquipa + " | " + alcunha + " @ (n/a)";
        }else{
            return idPeca + " | " + getTipo() + " | " + getValorRelativo() + " | " + idEquipa + " | " + alcunha + " @ (" + x + ", " + y + ")";
        }
    }

    public abstract String getValorRelativo();

    public abstract String getTipo();

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void definirCoordenadas (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void capturar(){
        capturada = true;
    }

    int getIdTipo(){
        return idTipo;
    }

    abstract boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo);
}