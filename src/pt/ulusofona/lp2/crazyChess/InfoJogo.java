package pt.ulusofona.lp2.crazyChess;

public class InfoJogo {

    int pecasPretas;
    int pecasBrancas;
    int reisPretos;
    int reisBrancos;
    int turnosSemCapturas;
    int turno;
    boolean primeiraCapturaEfetuada;

    InfoJogo(){
        this.pecasPretas = 0;
        this.pecasBrancas = 0;
        this.turno = 0;
        this.turnosSemCapturas = -1;
        this.primeiraCapturaEfetuada = false;
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

    void incrementaReisBrancos(){
        reisBrancos++;
    }

    void incrementaReisPretos(){
        reisPretos++;
    }

    void decrementaReisBrancos(){
        reisBrancos--;
    }

    void decrementaReisPretos(){
        reisPretos--;
    }

    int getPecasPretas(){
        return pecasPretas;
    }

    int getPecasBrancas(){
        return pecasBrancas;
    }

    int getReisPretos(){
        return reisPretos;
    }

    int getReisBrancos(){
        return reisBrancos;
    }

    int getTurno(){
        return turno;
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

    void incrementaTurnoSemCapturas(){
        turnosSemCapturas++;
    }

    void resetTurnosSemCapturas(){
        turnosSemCapturas = -1;
    }

    void incrementarTurno(){
        turno++;
    }

    void limpar(){
        this.pecasPretas = 0;
        this.pecasBrancas = 0;
        this.turno = 0;
        this.turnosSemCapturas = -1;
        this.primeiraCapturaEfetuada = false;
    }

}
