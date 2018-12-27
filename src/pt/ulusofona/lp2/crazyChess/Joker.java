package pt.ulusofona.lp2.crazyChess;

import java.util.List;

import static java.lang.Math.abs;

public class Joker extends CrazyPiece {

    String tipoJoker;

    Joker(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
        tipoJoker = "Rainha";
    }

    public String getValorRelativo() {
        valorRelativo = "4";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Joker";
        return tipo;
    }

    public String getTipoJoker(){
        return tipoJoker;
    }

    public String toString(){
        if (capturada){
            return idPeca + " | " + getTipo() + "/" + getTipoJoker() + " | " + getValorRelativo() + " | " + idEquipa + " | " + alcunha + " @ (n/a)";
        }else{
            return idPeca + " | " + getTipo() + "/" + getTipoJoker() + " | " + getValorRelativo() + " | " + idEquipa + " | " + alcunha + " @ (" + x + ", " + y + ")";
        }    }

    public void mudaTipoJoker(){
        if (tipoJoker.equals("Rainha")){
            tipoJoker = "Ponei Mágico";
        }else if (tipoJoker.equals("Ponei Mágico")){
            tipoJoker = "Padre Da Vila";
        }else if (tipoJoker.equals("Padre Da Vila")) {
            tipoJoker = "TorreH";
        }else if (tipoJoker.equals("TorreH")) {
            tipoJoker = "TorreV";
        }else if (tipoJoker.equals("TorreV")) {
            tipoJoker = "Lebre";
        }else if (tipoJoker.equals("Lebre")) {
            tipoJoker = "Rainha";
        }
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        if (tipoJoker.equals("Rainha")) {
            int count = 0;
            if (xD > xO + 5 || yD > yO + 5 || xD < xO - 5 || yD < yO - 5) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            if (abs(xO - xD) != abs(yO - yD) && abs(xO - xD) != 0 && abs(yO - yD) != 0) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            while (count < pecasJogo.size()) {
                for (CrazyPiece peca : pecasJogo) {
                    if (xO < xD && yO > yD) { // diagonal cima direita
                        for (int posX = xO + 1, posY = yO - 1; posX < xD && posY > yD; posX++, posY--) {
                            if (peca.getX() == posX && peca.getY() == posY) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                    if (xO > xD && yO > yD) { // diagonal cima esquerda
                        for (int posX = xO - 1, posY = yO - 1; posX > xD && posY > yD; posX--, posY--) {
                            if (peca.getX() == posX && peca.getY() == posY) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                    if (xO < xD && yO < yD) { // diagonal baixo direita
                        for (int posX = xO + 1, posY = yO + 1; posX < xD && posY < yD; posX++, posY++) {
                            if (peca.getX() == posX && peca.getY() == posY) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                    if (xO > xD && yO < yD) { // diagonal baixo esquerda
                        for (int posX = xO - 1, posY = yO + 1; posX > xD && posY < yD; posX--, posY++) {
                            if (peca.getX() == posX && peca.getY() == posY) {
                                if (idEquipa == 10) {
                                    estatisticas.adicionaJogadasInvalidasPretas();
                                } else {
                                    estatisticas.adicionaJogadasInvalidasBrancas();
                                }
                                return false;
                            }
                        }
                    }
                    if (yO == yD) { // movimento horizontal
                        if ((peca.getX() > xO && peca.getX() < xD && peca.getY() == yO) || (peca.getX() < xO && peca.getX() > xD && peca.getY() == yO)) {
                            if (idEquipa == 10) {
                                estatisticas.adicionaJogadasInvalidasPretas();
                            } else {
                                estatisticas.adicionaJogadasInvalidasBrancas();
                            }
                            return false;
                        }
                    }
                    if (xO == xD) { // movimento vertical
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
        } else if (tipoJoker.equals("Ponei Mágico")) {
            int count = 0;
            if((abs(xO-xD) != 2) || abs(yO-yD) != 2 ){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            if(abs(xO - xD) != abs(yO - yD)) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            while(count<pecasJogo.size()){
                if(xO < xD && yO > yD){//cima direita
                    for(CrazyPiece peca : pecasJogo){
                        if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO-1 || peca.getY() == yD)){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO+1){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                }
                if(xO > xD && yO > yD){//cima esquerda
                    for(CrazyPiece peca : pecasJogo){
                        if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO-1 || peca.getY() == yD)){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO-1){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO-1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                }
                if(xO < xD && yO < yD){//baixo direita
                    for(CrazyPiece peca : pecasJogo){
                        if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO+1 || peca.getY() == yD)){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO+1){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                }
                if(xO > xD && yO < yD){//baixo esquerda
                    for(CrazyPiece peca : pecasJogo){
                        if(peca.getIdTipo() == 0 && peca.getX() == xO && (peca.getY() == yO+1 || peca.getY() == yD)){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }
                            }
                        }else if(peca.getIdTipo() == 0 && peca.getY() == yD && peca.getX() == xO-1){
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
                                }else if(peca.getIdTipo() == 0 && peca.getX() == xD && peca.getY() == yO+1){
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
                                    return false;
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
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
        } else if(tipoJoker.equals("Padre Da Vila")){
            int count = 0;
            if(xD > xO + 3 || xD < xO - 3 || yD > yO + 3 || yD < yO - 3){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            if(abs(xO - xD) != abs(yO - yD)) {
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
                    if (peca.getIdTipo() == 1 && (abs(peca.getX() - xD) > 2 || abs(peca.getY() - yD) > 2)){
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                    count++;
                }
            }
            CrazyPiece pecaParaRemover = null;
            for (CrazyPiece peca : pecasJogo) {
                if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
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
                if (peca.getIdEquipa() == idEquipa && peca.getX() == xD && peca.getY() == yD) {
                    if (idEquipa == 10) {
                        estatisticas.adicionaJogadasInvalidasPretas();
                    } else {
                        estatisticas.adicionaJogadasInvalidasBrancas();
                    }
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
        } else if(tipoJoker.equals("TorreH")){
            int count = 0;
            if (yD != yO){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            while (count < pecasJogo.size()){
                for (CrazyPiece peca : pecasJogo) {
                    if ((peca.getX() > xO && peca.getX() < xD && peca.getY() == yO) || (peca.getX() < xO && peca.getX() > xD && peca.getY() == yO)) {
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                    count++;
                }
            }
            CrazyPiece pecaParaRemover = null;
            for (CrazyPiece peca : pecasJogo) {
                if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
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
                if (peca.getIdEquipa() == idEquipa && peca.getX() == xD && peca.getY() == yD) {
                    if (idEquipa == 10) {
                        estatisticas.adicionaJogadasInvalidasPretas();
                    } else {
                        estatisticas.adicionaJogadasInvalidasBrancas();
                    }
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
        }else if(tipoJoker.equals("TorreV")){
            int count = 0;
            if (xD != xO){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            while (count < pecasJogo.size()){
                for (CrazyPiece peca : pecasJogo) {
                    if ((peca.getY() > yO && peca.getY() < yD && peca.getX() == xO) || (peca.getY() < yO && peca.getY() > yD && peca.getX() == xO)) {
                        if (idEquipa == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                    count++;
                }
            }
            CrazyPiece pecaParaRemover = null;
            for (CrazyPiece peca : pecasJogo) {
                if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
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
                if (peca.getIdEquipa() == idEquipa && peca.getX() == xD && peca.getY() == yD) {
                    if (idEquipa == 10) {
                        estatisticas.adicionaJogadasInvalidasPretas();
                    } else {
                        estatisticas.adicionaJogadasInvalidasBrancas();
                    }
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
        }else if(tipoJoker.equals("Lebre")){
            if (jogo.getTurno() %2 != 0){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            if(abs(xO-xD) != 1 || abs(yO-yD) != 1){
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            if(abs(xO - xD) != abs(yO - yD)) {
                if (idEquipa == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            CrazyPiece pecaParaRemover = null;
            for (CrazyPiece peca : pecasJogo) {
                if (peca.getIdEquipa() != idEquipa && peca.getX() == xD && peca.getY() == yD) {
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
                if (peca.getIdEquipa() == idEquipa && peca.getX() == xD && peca.getY() == yD) {
                    if (idEquipa == 10) {
                        estatisticas.adicionaJogadasInvalidasPretas();
                    } else {
                        estatisticas.adicionaJogadasInvalidasBrancas();
                    }
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
        }
        return true;

    }

    @Override
    List<String> sugerirJogadas(int xO, int yO, CrazyPiece peca, List<CrazyPiece> pecasJogo, int tamanhoTabuleiro) {
        return null;
    }
}