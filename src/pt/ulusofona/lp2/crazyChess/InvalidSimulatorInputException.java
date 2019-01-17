package pt.ulusofona.lp2.crazyChess;

import java.io.IOException;

public class InvalidSimulatorInputException extends IOException {
    int linhaErro;
    int dadosObtidos;
    int dadosEsperados;

    InvalidSimulatorInputException(int linhaErro, int dadosObtidos, int dadosEsperados) {
        this.linhaErro = linhaErro;
        this.dadosObtidos = dadosObtidos;
        this.dadosEsperados = dadosEsperados;
    }

    public int getLinhaErro() {
        return linhaErro;
    }

    public String getDescricaoProblema() {
        if (dadosEsperados > dadosObtidos){
            return "DADOS A MENOS (Esperava: " + dadosEsperados + " ; Obtive: " + dadosObtidos + ")";
        }else{
            return "DADOS A MAIS (Esperava: " + dadosEsperados + " ; Obtive: " + dadosObtidos + ")";
        }
    }


}
