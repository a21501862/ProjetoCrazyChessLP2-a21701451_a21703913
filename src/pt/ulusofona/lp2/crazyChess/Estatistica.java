package pt.ulusofona.lp2.crazyChess;

public class Estatistica {
    private int jogadasInvalidasPretas;
    private int jogadasInvalidasBrancas;
    private int jogadasValidasPretas;
    private int jogadasValidasBrancas;
    private int capturasPretas;
    private int capturasBrancas;

    Estatistica(){
        this.jogadasInvalidasPretas = 0;
        this.jogadasInvalidasBrancas = 0;
        this.jogadasValidasPretas = 0;
        this.jogadasValidasBrancas = 0;
        this.capturasPretas = 0;
        this.capturasBrancas = 0;
    }

    int getCapturasBrancas() {
        return capturasBrancas;
    }

    int getCapturasPretas() {
        return capturasPretas;
    }

    int getJogadasInvalidasBrancas() {
        return jogadasInvalidasBrancas;
    }

    int getJogadasInvalidasPretas() {
        return jogadasInvalidasPretas;
    }

    int getJogadasValidasBrancas() {
        return jogadasValidasBrancas;
    }

    int getJogadasValidasPretas() {
        return jogadasValidasPretas;
    }

    public void adicionaJogadasInvalidasPretas(){
        jogadasInvalidasPretas++;
    }

    public void adicionaJogadasInvalidasBrancas(){
        jogadasInvalidasBrancas++;
    }

    void adicionaJogadasValidasPretas(){
        jogadasValidasPretas++;
    }

    void adicionaJogadasValidasBrancas(){
        jogadasValidasBrancas++;
    }

    void decrementaJogadasValidasPretas(){
        jogadasValidasPretas--;
    }

    void decrementaJogadasValidasBrancas(){
        jogadasValidasBrancas--;
    }

    void capturarPretas(){
        capturasPretas++;
    }
    void setJogadasInvalidasPretas(int jogadasInvalidasPretas) {
        this.jogadasInvalidasPretas = jogadasInvalidasPretas;
    }

    void setJogadasInvalidasBrancas(int jogadasInvalidasBrancas) {
        this.jogadasInvalidasBrancas = jogadasInvalidasBrancas;
    }

    void setJogadasValidasPretas(int jogadasValidasPretas) {
        this.jogadasValidasPretas = jogadasValidasPretas;
    }

    void setJogadasValidasBrancas(int jogadasValidasBrancas) {
        this.jogadasValidasBrancas = jogadasValidasBrancas;
    }

    void setCapturasPretas(int capturasPretas) {
        this.capturasPretas = capturasPretas;
    }

    void setCapturasBrancas(int capturasBrancas) {
        this.capturasBrancas = capturasBrancas;
    }

    void capturarBrancas(){
        capturasBrancas++;
    }

    void decrementaCapturasBrancas(){
        capturasBrancas--;
    }

    void decrementaCapturasPretas(){
        capturasPretas--;
    }

    void limpar(){
        this.jogadasInvalidasPretas = 0;
        this.jogadasInvalidasBrancas = 0;
        this.jogadasValidasPretas = 0;
        this.jogadasValidasBrancas = 0;
        this.capturasPretas = 0;
        this.capturasBrancas = 0;
    }
}