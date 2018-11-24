package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    int idPeca;
    int tipo;
    int idEquipa;
    String alcunha;
    String imagem;
    int x;
    int y;
    boolean capturada;

    CrazyPiece (int idPeca, int tipo, int idEquipa, String alcunha){
        this.idPeca = idPeca;
        this.tipo = tipo;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;
        this.capturada = false;
    }

    public int getId(){
        return idPeca;
    }

    public String getImagePNG(){
        return null;
    }

    public String toString(){
        if (capturada){
            return idPeca + " | " + tipo + " | " + idEquipa + " | " + alcunha + " @ (n/a)";
        }else{
            return idPeca + " | " + tipo + " | " + idEquipa + " | " + alcunha + " @ (" + x + ", " + y + ")";
        }
    }

    public void definirCoordenadas (int x, int y){
        this.x = x;
        this.y = y;
    }
}
