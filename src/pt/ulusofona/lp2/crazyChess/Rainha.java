package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Rainha extends CrazyPiece {

    Rainha(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "8";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Rainha";
        return tipo;
    }

    List<String> sugerirJogadas(int xO, int yO, CrazyPiece ref, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <String> jogadaRainha = new ArrayList<>();
        int count = 0;
        int valorX = xO;
        int xRef = tamanhoTabuleiro - 1;
        int idRef = idEquipa;
        int tipoRef = -1;
        for (CrazyPiece peca: pecasJogo){//direita
            if (peca.getX() > valorX && peca.getX() <= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
            }
            count ++;
            if (count == pecasJogo.size()){
                count = 0;
                if(xRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef !=1){
                    while (valorX + 1 <= xRef && count<5){
                        jogadaRainha.add(valorX+1 + ", " + yO);
                        valorX++;
                        count++;
                    }
                }else if (xRef != tamanhoTabuleiro-1 && (idRef == idEquipa || tipoRef == 1)){
                    while (valorX+1 < xRef && count<5) {
                        jogadaRainha.add(valorX+1 + ", " + yO);
                        valorX++;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getX()== tamanhoTabuleiro-1 && pecaFronteira.getY() == yO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1)){
                            while (valorX + 1 < tamanhoTabuleiro -1 && count<5){
                                jogadaRainha.add(valorX + 1 + ", " + yO);
                                valorX++;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorX + 1 <= tamanhoTabuleiro -1 && count<5){
                                jogadaRainha.add(valorX + 1 + ", " + yO);
                                valorX++;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        valorX = xO;
        count = 0;
        xRef = 0;
        idRef = idEquipa;
        tipoRef = -1;
        for (CrazyPiece peca: pecasJogo){//esquerda
            if (peca.getX() < valorX && peca.getX() >= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
            }
            count ++;
            if (count == pecasJogo.size()){
                count=0;
                if(xRef != 0 && idRef != idEquipa && tipoRef!=1){
                    while (valorX - 1 >= xRef && count < 5){
                        jogadaRainha.add(valorX-1 + ", " + yO);
                        valorX--;
                        count++;
                    }
                }else if (xRef != 0 && (idRef == idEquipa || tipoRef == 1)) {
                    while (valorX-1 > xRef && count < 5) {
                        jogadaRainha.add(valorX-1 + ", " + yO);
                        valorX--;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == yO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1)){
                            while (valorX - 1 > 0 && count<5){
                                jogadaRainha.add(valorX - 1 + ", " + yO);
                                valorX--;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorX - 1 >= 0 && count<5){
                                jogadaRainha.add(valorX - 1 + ", " + yO);
                                valorX--;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        int valorY = yO;
        count = 0;
        int yRef = 0;
        idRef = idEquipa;
        tipoRef = -1;
        for (CrazyPiece peca: pecasJogo){//cima
            if (peca.getY() < valorY && peca.getY() >= yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
            }
            count ++;
            if (count == pecasJogo.size()){
                count=0;
                if(yRef != 0 && idRef != idEquipa && tipoRef!=1){
                    while (valorY - 1 >= yRef && count < 5){
                        jogadaRainha.add(xO + ", " + (valorY-1));
                        valorY--;
                        count++;
                    }
                }else if (yRef != 0 && (idRef == idEquipa || tipoRef == 1)) {
                    while (valorY-1 > yRef && count < 5) {
                        jogadaRainha.add(xO + ", " + (valorY-1));
                        valorY--;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == xO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1)){
                            while (valorY - 1 > 0 && count<5){
                                jogadaRainha.add(xO + ", " + (valorY-1));
                                valorY--;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY - 1 >= 0 && count<5){
                                jogadaRainha.add(xO + ", " + (valorY-1));
                                valorY--;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        count = 0;
        valorY = yO;
        yRef = tamanhoTabuleiro - 1;
        idRef = idEquipa;
        tipoRef = -1;
        for (CrazyPiece peca: pecasJogo){//baixo
            if (peca.getY() > valorY && peca.getY() <= yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
            }
            count ++;
            if (count == pecasJogo.size()){
                count=0;
                if(yRef != tamanhoTabuleiro - 1 && idRef != idEquipa && tipoRef!=1){
                    while (valorY + 1 <= yRef && count < 5){
                        jogadaRainha.add(xO + ", " + (valorY+1));
                        valorY++;
                        count++;
                    }
                }else if (yRef != tamanhoTabuleiro - 1 && (idRef == idEquipa || tipoRef == 1)) {
                    while (valorY+1 < yRef && count < 5) {
                        jogadaRainha.add(xO + ", " + (valorY+1));
                        valorY++;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== tamanhoTabuleiro - 1 && pecaFronteira.getX() == xO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1)){
                            while (valorY + 1 < tamanhoTabuleiro - 1 && count<5){
                                jogadaRainha.add(xO + ", " + (valorY+1));
                                valorY++;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY + 1 <= tamanhoTabuleiro - 1 && count<5){
                                jogadaRainha.add(xO + ", " + (valorY+1));
                                valorY++;
                                count++;
                            }
                        }
                    }
                }
            }
        }

        return jogadaRainha;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo){
        int count = 0;
        if(xD > xO + 5 || yD > yO + 5 || xD < xO - 5 || yD < yO - 5){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        if (abs(xO - xD) != abs(yO - yD) && abs(xO - xD) != 0 && abs(yO - yD) != 0){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            return false;
        }
        while (count < pecasJogo.size()){
            for (CrazyPiece peca: pecasJogo){
                if (xO < xD && yO>yD){ // diagonal cima direita
                    for (int posX = xO + 1, posY = yO - 1; posX < xD && posY > yD; posX++, posY--){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (xO > xD && yO>yD){ // diagonal cima esquerda
                    for (int posX = xO -1, posY = yO - 1; posX > xD && posY > yD; posX--, posY--){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (xO < xD && yO<yD){ // diagonal baixo direita
                    for (int posX = xO + 1, posY = yO + 1; posX < xD && posY < yD; posX++, posY++){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (xO > xD && yO<yD){ // diagonal baixo esquerda
                    for (int posX = xO - 1, posY = yO + 1; posX > xD && posY < yD; posX--, posY++){
                        if (peca.getX() == posX && peca.getY() == posY){
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                }
                if (yO == yD){ // movimento horizontal
                    if ((peca.getX() > xO && peca.getX() < xD && peca.getY() == yO) || (peca.getX() < xO && peca.getX() > xD && peca.getY() == yO)) {
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                }
                if (xO == xD){ // movimento vertical
                    if ((peca.getY() > yO && peca.getY() < yD && peca.getX() == xO) || (peca.getY() < yO && peca.getY() > yD && peca.getX() == xO)) {
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                }
                count++;
            }
        }
        for (CrazyPiece verificaJoker : pecasJogo){
            if (verificaJoker.getIdTipo() == 7 && ((Joker) verificaJoker).getTipoJoker().equals("Rainha") && verificaJoker.getX() == xD && verificaJoker.getY() == yD){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
        }
        CrazyPiece pecaParaRemover = null;
        for (CrazyPiece peca : pecasJogo) {
            if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD && peca.getIdTipo() != idTipo) {
                pecaParaRemover = peca;
                peca.capturar();
                jogo.primeiraCapturaFeita();
                jogo.resetTurnosSemCapturas();
                if (idEquipa == 10) {
                    jogo.decrementaPecasBrancas();
                    estatisticas.capturarPretas();
                } else {
                    jogo.decrementaPecasPretas();
                    estatisticas.capturarBrancas();
                }
            }
            if ((peca.getIdEquipa() == idEquipa || peca.getIdTipo() == idTipo) && peca.getX() == xD && peca.getY() == yD) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
        }
        pecasJogo.remove(pecaParaRemover);
        return true;
    }


}