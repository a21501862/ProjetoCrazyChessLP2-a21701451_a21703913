package pt.ulusofona.lp2.crazyChess;

import java.util.List;

public abstract class CrazyPiece{
    int idPeca;
    int idTipo;
    String tipo;
    String valorRelativo;
    int idEquipa;
    int x;
    int y;
    String alcunha;
    boolean capturada;
    int nrPontos;
    int nrCapturas;
    int jogadasInvalidas;
    int jogadasValidas;

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
                return "ponei_magico_black.png";
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
            }else if(idTipo==8){
                return "box-water-2.png";
            }
        }else {
            if (idTipo == 0) {
                return "crazy_emoji_white.png";
            } else if (idTipo == 1) {
                return "rainha_white.png";
            } else if (idTipo == 2) {
                return "ponei_magico_white.png";
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
            }else if(idTipo==8){
                return "bird.png";
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

    void definirCoordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    void setIdEquipa(int idEquipa){
        this.idEquipa = idEquipa;
    }

    void capturar(){
        capturada = true;
    }

    void anularCaptura(){
        capturada = false;
    }

    int getIdTipo(){
        return idTipo;
    }

    int getNrPontos(){
        return nrPontos;
    }

    int getNrCapturas(){
        return nrCapturas;
    }

    void incrementaNrCaptura(){
        nrCapturas++;
    }

    void incrementaNrPontos(int valor){
        nrPontos += valor;
    }

    String getAlcunha() {
        return alcunha;
    }

    public int getJogadasInvalidas() {
        return jogadasInvalidas;
    }

    public int getJogadasValidas() {
        return jogadasValidas;
    }

    public void incrementaJogadasInvalidas() {
        jogadasInvalidas++;
    }

    public void incrementaJogadasValidas() {
        jogadasValidas++;
    }

    abstract boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo);

    abstract List<Sugestao> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo,int tamanhoTabuleiro);

    abstract int getPontos();

    public String toString5(){
        return idEquipa + ":" + alcunha + ":" + nrPontos + ":" + nrCapturas;
    }
    public String toStringPecasMaisBaralhadas(){
        return idEquipa + ":" + alcunha + ":" + jogadasInvalidas + ":" + jogadasValidas;
    }

    public String toStringTiposPecaCapturados(){
        return idTipo + ":" + nrCapturas;
    }

}