package pt.ulusofona.lp2.crazyChess;

public class InfoJogo {

    private int pecasPretas;
    private int pecasBrancas;
    private int reisBrancos;
    private int reisPretos;
    private int turnosSemCapturas;
    int turno;
    private int turnoPrimeiraCaptura;
    private int turnosAteCaptura;
    CrazyPiece ultimaPecaRemovida;
    private CrazyPiece ultimaPecaRecrutada;
    boolean primeiraCapturaEfetuada;

    InfoJogo(){
        this.pecasPretas = 0;
        this.pecasBrancas = 0;
        this.reisPretos = 0;
        this.reisBrancos = 0;
        this.turno = 0;
        this.turnoPrimeiraCaptura = -1;
        this.turnosSemCapturas = -1;
        this.turnosAteCaptura = 0;
        this.primeiraCapturaEfetuada = false;
        this.ultimaPecaRemovida = null;
        this.ultimaPecaRecrutada = null;
    }

    void incrementaPecasBrancas(){
        pecasBrancas++;
    }

    void incrementaPecasPretas(){
        pecasPretas++;
    }

    void decrementaPecasBrancas(){
        pecasBrancas--;
    }

    void decrementaPecasPretas(){
        pecasPretas--;
    }

    void incrementaReisBrancos(){ reisBrancos++; }

    void incrementaReisPretos(){ reisPretos++; }

    void decrementaReisBrancos(){ reisBrancos--;
    }

    void decrementaReisPretos(){
        reisPretos--;
    }

    int getReisBrancos() {
        return reisBrancos;
    }

    int getReisPretos() {
        return reisPretos;
    }

    int getPecasPretas(){
        return pecasPretas;
    }

    int getPecasBrancas(){
        return pecasBrancas;
    }

    int getTurno(){
        return turno;
    }

    void decrementaTurno(){
        turno--;
    }

    void setUltimaPecaCapturada(CrazyPiece peca){
        ultimaPecaRemovida = peca;
    }

    void setUltimaPecaRecrutada(CrazyPiece peca){
        ultimaPecaRecrutada = peca;
    }

    CrazyPiece obterPeca(){
        return ultimaPecaRemovida;
    }

    CrazyPiece obterPecaRecrutada(){
        return ultimaPecaRecrutada;
    }

    void primeiraCapturaFeita(){
        primeiraCapturaEfetuada = true;
    }

    boolean primeiraCapturaFoiEfetuada(){
        return primeiraCapturaEfetuada;
    }

    int getTurnosSemCapturas(){
        return turnosSemCapturas;
    }

    void setTurnosSemCapturas(int turnosSemCapturas){
        this.turnosSemCapturas = turnosSemCapturas;
    }

    void anularPrimeiraCaptura(){
        primeiraCapturaEfetuada = false;
    }

    void incrementaTurnoSemCapturas(){
        turnosSemCapturas++;
    }

    void decrementaTurnoSemCapturas(){
        turnosSemCapturas--;
    }

    void resetTurnosSemCapturas(){
        turnosSemCapturas = -1;
    }

    void incrementarTurno(){
        turno++;
    }


    public int getTurnoPrimeiraCaptura() {
        return turnoPrimeiraCaptura;
    }

    public void setTurnoPrimeiraCaptura(int turnoPrimeiraCaptura) {
        this.turnoPrimeiraCaptura = turnoPrimeiraCaptura;
    }


    int getTurnosAteCaptura() {
        return turnosAteCaptura;
    }

    void setTurnosAteCaptura(int turnosAteCaptura) {
        this.turnosAteCaptura = turnosAteCaptura;
    }

    void limpar(){
        this.pecasPretas = 0;
        this.pecasBrancas = 0;
        this.reisPretos = 0;
        this.reisBrancos = 0;
        this.turno = 0;
        this.turnoPrimeiraCaptura = -1;
        this.turnosSemCapturas = -1;
        this.turnosAteCaptura = 0;
        this.ultimaPecaRemovida = null;
        this.ultimaPecaRecrutada = null;
        this.primeiraCapturaEfetuada = false;
    }
}