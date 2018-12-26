package pt.ulusofona.lp2.crazyChess;

public class Estatistica {
    int jogadasInvalidasPretas;
    int jogadasInvalidasBrancas;
    int jogadasValidasPretas;
    int jogadasValidasBrancas;
    int capturasPretas;
    int capturasBrancas;

    Estatistica(){
        this.jogadasInvalidasPretas = 0;
        this.jogadasInvalidasBrancas = 0;
        this.jogadasValidasPretas = 0;
        this.jogadasValidasBrancas = 0;
        this.capturasPretas = 0;
        this.capturasBrancas = 0;
    }

    public int getCapturasBrancas() {
        return capturasBrancas;
    }

    public int getCapturasPretas() {
        return capturasPretas;
    }

    public int getJogadasInvalidasBrancas() {
        return jogadasInvalidasBrancas;
    }

    public int getJogadasInvalidasPretas() {
        return jogadasInvalidasPretas;
    }

    public int getJogadasValidasBrancas() {
        return jogadasValidasBrancas;
    }

    public int getJogadasValidasPretas() {
        return jogadasValidasPretas;
    }

    public void adicionaJogadasInvalidasPretas(){
        jogadasInvalidasPretas++;
    }

    public void adicionaJogadasInvalidasBrancas(){
        jogadasInvalidasBrancas++;
    }

    public void adicionaJogadasValidasPretas(){
        jogadasValidasPretas++;
    }

    public void adicionaJogadasValidasBrancas(){
        jogadasValidasBrancas++;
    }

    public void capturarPretas(){
        capturasPretas++;
    }
    public void setJogadasInvalidasPretas(int jogadasInvalidasPretas) {
        this.jogadasInvalidasPretas = jogadasInvalidasPretas;
    }

    public void setJogadasInvalidasBrancas(int jogadasInvalidasBrancas) {
        this.jogadasInvalidasBrancas = jogadasInvalidasBrancas;
    }

    public void setJogadasValidasPretas(int jogadasValidasPretas) {
        this.jogadasValidasPretas = jogadasValidasPretas;
    }

    public void setJogadasValidasBrancas(int jogadasValidasBrancas) {
        this.jogadasValidasBrancas = jogadasValidasBrancas;
    }

    public void setCapturasPretas(int capturasPretas) {
        this.capturasPretas = capturasPretas;
    }

    public void setCapturasBrancas(int capturasBrancas) {
        this.capturasBrancas = capturasBrancas;
    }

    public void capturarBrancas(){
        capturasBrancas++;
    }

    public void limpar(){
        this.jogadasInvalidasPretas = 0;
        this.jogadasInvalidasBrancas = 0;
        this.jogadasValidasPretas = 0;
        this.jogadasValidasBrancas = 0;
        this.capturasPretas = 0;
        this.capturasBrancas = 0;
    }
}