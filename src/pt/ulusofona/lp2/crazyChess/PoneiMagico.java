package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class PoneiMagico extends CrazyPiece {
    PoneiMagico(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "5";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Ponei Mágico";
        return tipo;
    }

    public int getPontos() {
        return 5;
    }

    List<String> sugerirJogadas(int xO, int yO, List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <String> jogadaPonei = new ArrayList<>();
        boolean valida = true;
        int count = 0;
        for (CrazyPiece peca: pecasJogo){//diagonal cima direita
            if (xO+2 > tamanhoTabuleiro - 1 || yO-2 < 0){
                break;
            }
            if(peca.getX()==xO+2 && peca.getY()==yO-2 && peca.getIdEquipa()==idEquipa){
                break;
            }
            count++;
            if(count == pecasJogo.size()){
                count = 0;
                for(CrazyPiece peca1 : pecasJogo){
                    if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO-1 || peca1.getY() == yO-2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xO+2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getX() == xO+2 && peca3.getY() == yO-1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO+1 || peca1.getX() == xO+2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO-1 || peca2.getY() == yO-2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO+1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO+2 && peca1.getY() == yO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO-1 || peca2.getY() == yO-2) && peca2.getX() == xO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO+1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO-2 && peca1.getX() == xO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO + 1 || peca2.getX() == xO + 2) && peca2.getY() == yO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO + 2 && peca3.getY() == yO - 1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    count++;
                    if (count == pecasJogo.size() && valida){
                        jogadaPonei.add(xO + 2 + ", " + (yO - 2));
                    }
                }
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//diagonal cima esquerda
            if (xO-2 < 0 || yO-2 < 0){
                break;
            }
            if(peca.getX()==xO-2 && peca.getY()==yO-2 && peca.getIdEquipa()==idEquipa){
                break;
            }
            count++;
            if(count == pecasJogo.size()){
                count = 0;
                for(CrazyPiece peca1 : pecasJogo){
                    if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO-1 || peca1.getY() == yO-2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xO-2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getX() == xO-2 && peca3.getY() == yO-1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO-1 || peca1.getX() == xO-2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO-1 || peca2.getY() == yO-2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO-1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO-2 && peca1.getY() == yO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO-1 || peca2.getY() == yO-2) && peca2.getX() == xO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO-1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO-2 && peca1.getX() == xO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2) && peca2.getY() == yO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO - 1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    count++;
                    if (count == pecasJogo.size() && valida){
                        jogadaPonei.add(xO - 2 + ", " + (yO - 2));
                    }
                }
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//diagonal baixo esquerda
            if (yO+2 > tamanhoTabuleiro - 1 || xO-2 < 0){
                break;
            }
            if(peca.getX()==xO-2 && peca.getY()==yO+2 && peca.getIdEquipa()==idEquipa){
                break;
            }
            count++;
            if(count == pecasJogo.size()){
                count = 0;
                for(CrazyPiece peca1 : pecasJogo){
                    if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO+1 || peca1.getY() == yO+2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO + 1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO-1 || peca1.getX() == xO-2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO+1 || peca2.getY() == yO+2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO-1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO-2 && peca1.getY() == yO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO+1 || peca2.getY() == yO+2) && peca2.getX() == xO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO-1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO+2 && peca1.getX() == xO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2) && peca2.getY() == yO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO + 1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    count++;
                    if (count == pecasJogo.size() && valida){
                        jogadaPonei.add(xO - 2 + ", " + (yO + 2));
                    }
                }
            }
        }
        count = 0;
        for (CrazyPiece peca: pecasJogo){//diagonal baixo direita
            if (xO+2 > tamanhoTabuleiro - 1 || yO+2 > tamanhoTabuleiro-1){
                break;
            }
            if(peca.getX()==xO+2 && peca.getY()==yO+2 && peca.getIdEquipa()==idEquipa){
                break;
            }
            count++;
            if(count == pecasJogo.size()){
                count = 0;
                for(CrazyPiece peca1 : pecasJogo){
                    if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO+1 || peca1.getY() == yO+2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xO+2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getX() == xO+2 && peca3.getY() == yO+1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO+1 || peca1.getX() == xO+2)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO+1 || peca2.getY() == yO+2)) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO+1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO+2 && peca1.getY() == yO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO+1 || peca2.getY() == yO+2) && peca2.getX() == xO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO+1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO+2 && peca1.getX() == xO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO + 1 || peca2.getX() == xO + 2) && peca2.getY() == yO) {
                                valida = false;
                                break;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO + 2 && peca3.getY() == yO + 1) {
                                        valida = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    count++;
                    if (count == pecasJogo.size() && valida){
                        jogadaPonei.add(xO + 2 + ", " + (yO + 2));
                    }
                }
            }
        }
        return jogadaPonei;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        int count = 0;
        if(abs(xO-xD) != 2|| abs(yO-yD) != 2 ){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            incrementaJogadasInvalidas();
            return false;
        }
        if(abs(xO - xD) != abs(yO - yD)) {
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            incrementaJogadasInvalidas();
            return false;
        }
        while(count<pecasJogo.size()){
            if(xO < xD && yO > yD){//cima direita
                for(CrazyPiece peca : pecasJogo){
                    if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO-1 || peca.getY() == yD)){
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo){
                            if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()){
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getX() == xD && peca3.getY() == yO-1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yO && (peca.getX() == xO+1 || peca.getX() == xD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO - 1 || peca2.getY() == yD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getY() == yD && peca3.getX() == xO + 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getX() == xO+2 && peca.getY() == yO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO-1 || peca2.getY() == yO-2) && peca2.getX() == xO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO+1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yO-2 && peca.getX() == xO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO + 1 || peca2.getX() == xO + 2) && peca2.getY() == yO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO + 2 && peca3.getY() == yO - 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(xO > xD && yO > yD) {//cima esquerda
                for (CrazyPiece peca : pecasJogo) {
                    if (peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO - 1 || peca.getY() == yD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO - 1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xD && peca3.getY() == yO - 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (peca.getIdTipo() == 0 && peca.getY() == yO && (peca.getX() == xO - 1 || peca.getX() == xD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO - 1 || peca2.getY() == yD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getY() == yD && peca3.getX() == xO - 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if(peca.getIdTipo() == 0 && peca.getX() == xO-2 && peca.getY() == yO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO-1 || peca2.getY() == yO-2) && peca2.getX() == xO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO-1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yO-2 && peca.getX() == xO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2) && peca2.getY() == yO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO - 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(xO > xD && yO < yD) {//baixo esquerda
                for (CrazyPiece peca : pecasJogo) {
                    if (peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO + 1 || peca.getY() == yD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO - 1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xD && peca3.getY() == yO + 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (peca.getIdTipo() == 0 && peca.getY() == yO && (peca.getX() == xO - 1 || peca.getX() == xD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO + 1 || peca2.getY() == yD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getY() == yD && peca3.getX() == xO - 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if(peca.getIdTipo() == 0 && peca.getX() == xO-2 && peca.getY() == yO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO+1 || peca2.getY() == yO+2) && peca2.getX() == xO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO-1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yO+2 && peca.getX() == xO-1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2) && peca2.getY() == yO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO + 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(xO < xD && yO < yD) {//baixo direita
                for (CrazyPiece peca : pecasJogo) {
                    if (peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO + 1 || peca.getY() == yD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO + 1 || peca2.getX() == xD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xD && peca3.getY() == yO + 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (peca.getIdTipo() == 0 && peca.getY() == yO && (peca.getX() == xO + 1 || peca.getX() == xD)) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO + 1 || peca2.getY() == yD)) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getY() == yD && peca3.getX() == xO + 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if(peca.getIdTipo() == 0 && peca.getX() == xO+2 && peca.getY() == yO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getY() == yO+1 || peca2.getY() == yO+2) && peca2.getX() == xO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3: pecasJogo){
                                    if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO+1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }else if(peca.getIdTipo() == 0 && peca.getY() == yO+2 && peca.getX() == xO+1) {
                        int count1 = 0;
                        for (CrazyPiece peca2 : pecasJogo) {
                            if (peca2.getIdTipo() == 0 && (peca2.getX() == xO + 1 || peca2.getX() == xO + 2) && peca2.getY() == yO) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                incrementaJogadasInvalidas();
                                return false;
                            }
                            count1++;
                            if (count1 == pecasJogo.size()) {
                                for (CrazyPiece peca3 : pecasJogo) {
                                    if (peca3.getIdTipo() == 0 && peca3.getX() == xO + 2 && peca3.getY() == yO + 1) {
                                        if (idEquipa == 10) {
                                            estatisticas.adicionaJogadasInvalidasPretas();
                                        } else {
                                            estatisticas.adicionaJogadasInvalidasBrancas();
                                        }
                                        incrementaJogadasInvalidas();
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }
        CrazyPiece pecaParaRemover = null;
        for (CrazyPiece peca : pecasJogo) {
            if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
                pecaParaRemover = peca;
                peca.capturar();
                jogo.primeiraCapturaFeita();
                incrementaNrCaptura();
                incrementaNrPontos(peca.getPontos());
                if (jogo.getTurnoPrimeiraCaptura() == -1){
                    jogo.setTurnoPrimeiraCaptura(jogo.getTurno());
                }
                jogo.setTurnosAteCaptura(jogo.getTurnosSemCapturas());
                jogo.resetTurnosSemCapturas();
                if (idEquipa == 10) {
                    jogo.decrementaPecasBrancas();
                    estatisticas.capturarPretas();
                } else {
                    jogo.decrementaPecasPretas();
                    estatisticas.capturarBrancas();
                }
            }
            if (peca.getIdEquipa() == idEquipa && peca.getX() == xD && peca.getY() == yD) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                incrementaJogadasInvalidas();
                return false;
            }
        }
        pecasJogo.remove(pecaParaRemover);
        jogo.setUltimaPecaCapturada(pecaParaRemover);
        incrementaJogadasValidas();
        return true;
    }
}