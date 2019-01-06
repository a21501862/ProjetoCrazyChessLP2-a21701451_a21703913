package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class PadreDaVila extends CrazyPiece {
    PadreDaVila(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
    }

    public String getValorRelativo() {
        valorRelativo = "3";
        return valorRelativo;
    }

    public String getTipo() {
        tipo = "Padre da Vila";
        return tipo;
    }

    List<String> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List<String> jogadaPadre = new ArrayList<>();
        int rainhas = 0;
        for (CrazyPiece peca : pecasJogo){
            if (peca.getIdTipo()==1 || (peca.getIdTipo()==7 && ((Joker)peca).getTipoJoker().equals("Rainha"))){
                rainhas++;
            }
        }
        int count = 0;
        int valorX = xO;
        int valorY = yO;
        int xRef = 0;
        int yRef = 0;
        int idRef = idEquipa;
        for (CrazyPiece peca : pecasJogo) {//diagonal cima esquerda
            if ((peca.getIdTipo() == 1 || (peca.getIdTipo() == 7 && ((Joker) peca).getTipoJoker().equals("Rainha"))) && peca.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                int verificaRainhas = 0;
                for (CrazyPiece verificaPecaChegada : pecasJogo) {
                    if ((verificaPecaChegada.getIdTipo() == 1 || (verificaPecaChegada.getIdTipo() == 7 && ((Joker) verificaPecaChegada).getTipoJoker().equals("Rainha"))) && verificaPecaChegada.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                        verificaRainhas++;
                    }
                }
                if (verificaRainhas == rainhas) {
                    break;
                } else {
                    for (int posX = xO - 1, posY = yO - 1; posX >= xRef && posY >= yRef; posX--, posY--) {
                        if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY < valorY) {
                            xRef = posX;
                            yRef = posY;
                            idRef = peca.getIdEquipa();
                        }
                    }
                    count++;
                    if (count == pecasJogo.size()) {
                        count = 0;
                        if (xRef != 0 && yRef != 0 && idRef != idEquipa) {
                            while (valorY - 1 >= yRef && valorX - 1 >= xRef && count < 3) {
                                jogadaPadre.add(valorX - 1 + ", " + (valorY - 1));
                                valorX--;
                                valorY--;
                                count++;
                            }
                        } else if (yRef != 0 && xRef != 0 && idRef == idEquipa) {
                            while (valorY - 1 > yRef && valorX - 1 > xRef && count < 3) {
                                jogadaPadre.add(valorX - 1 + ", " + (valorY - 1));
                                valorX--;
                                valorY--;
                                count++;
                            }
                        } else {
                            int verificarPecaFronteira = 0;
                            for (CrazyPiece pecaFronteira : pecasJogo) {
                                if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == 0 && idRef == idEquipa) {
                                    while (valorY - 1 > 0 && valorX - 1 > 0 && count < 3) {
                                        jogadaPadre.add(valorX - 1 + ", " + (valorY - 1));
                                        valorX--;
                                        valorY--;
                                        count++;
                                    }
                                    break;
                                }
                                verificarPecaFronteira++;
                                if (verificarPecaFronteira == pecasJogo.size()) {
                                    while (valorY - 1 >= 0 && valorX - 1 >= 0 && count < 3) {
                                        jogadaPadre.add(valorX - 1 + ", " + (valorY - 1));
                                        valorX--;
                                        valorY--;
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        count = 0;
        valorX = xO;
        valorY = yO;
        xRef = tamanhoTabuleiro-1;
        yRef = 0;
        idRef = idEquipa;
        for (CrazyPiece peca : pecasJogo) {//diagonal cima direita
            if ((peca.getIdTipo() == 1 || (peca.getIdTipo() == 7 && ((Joker) peca).getTipoJoker().equals("Rainha"))) && peca.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                int verificaRainhas = 0;
                for (CrazyPiece verificaPecaChegada : pecasJogo) {
                    if ((verificaPecaChegada.getIdTipo() == 1 || (verificaPecaChegada.getIdTipo() == 7 && ((Joker) verificaPecaChegada).getTipoJoker().equals("Rainha"))) && verificaPecaChegada.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                        verificaRainhas++;
                    }
                }
                if (verificaRainhas == rainhas) {
                    break;
                } else {
                    for (int posX = xO + 1, posY = yO - 1; posX <= xRef && posY >= yRef; posX++, posY--) {
                        if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY < valorY) {
                            xRef = posX;
                            yRef = posY;
                            idRef = peca.getIdEquipa();
                        }
                    }
                    count++;
                    if (count == pecasJogo.size()) {
                        count = 0;
                        if (xRef != tamanhoTabuleiro - 1 && yRef != 0 && idRef != idEquipa) {
                            while (valorY - 1 >= yRef && valorX + 1 <= xRef && count < 3) {
                                jogadaPadre.add(valorX + 1 + ", " + (valorY - 1));
                                valorX++;
                                valorY--;
                                count++;
                            }
                        } else if (yRef != 0 && xRef != tamanhoTabuleiro - 1 && idRef == idEquipa) {
                            while (valorY - 1 > yRef && valorX + 1 < xRef && count < 3) {
                                jogadaPadre.add(valorX + 1 + ", " + (valorY - 1));
                                valorX++;
                                valorY--;
                                count++;
                            }
                        } else {
                            int verificarPecaFronteira = 0;
                            for (CrazyPiece pecaFronteira : pecasJogo) {
                                if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == tamanhoTabuleiro - 1 && idRef == idEquipa) {
                                    while (valorY - 1 > 0 && valorX + 1 < tamanhoTabuleiro - 1 && count < 3) {
                                        jogadaPadre.add(valorX + 1 + ", " + (valorY - 1));
                                        valorX++;
                                        valorY--;
                                        count++;
                                    }
                                    break;
                                }
                                verificarPecaFronteira++;
                                if (verificarPecaFronteira == pecasJogo.size()) {
                                    while (valorY - 1 >= 0 && valorX + 1 <= tamanhoTabuleiro - 1 && count < 3) {
                                        jogadaPadre.add(valorX + 1 + ", " + (valorY - 1));
                                        valorX++;
                                        valorY--;
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        count = 0;
        valorX = xO;
        valorY = yO;
        xRef = tamanhoTabuleiro-1;
        yRef = tamanhoTabuleiro-1;
        idRef = idEquipa;
        for (CrazyPiece peca : pecasJogo) {//diagonal baixo direita
            if ((peca.getIdTipo() == 1 || (peca.getIdTipo() == 7 && ((Joker) peca).getTipoJoker().equals("Rainha"))) && peca.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                int verificaRainhas = 0;
                for (CrazyPiece verificaPecaChegada : pecasJogo) {
                    if ((verificaPecaChegada.getIdTipo() == 1 || (verificaPecaChegada.getIdTipo() == 7 && ((Joker) verificaPecaChegada).getTipoJoker().equals("Rainha"))) && verificaPecaChegada.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                        verificaRainhas++;
                    }
                }
                if (verificaRainhas == rainhas) {
                    break;
                } else {
                    for (int posX = xO + 1, posY = yO + 1; posX <= xRef && posY <= yRef; posX++, posY++) {
                        if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY > valorY) {
                            xRef = posX;
                            yRef = posY;
                            idRef = peca.getIdEquipa();
                        }
                    }
                    count++;
                    if (count == pecasJogo.size()) {
                        count = 0;
                        if (xRef != tamanhoTabuleiro - 1 && yRef != tamanhoTabuleiro - 1 && idRef != idEquipa) {
                            while (valorY + 1 <= yRef && valorX + 1 <= xRef && count < 3) {
                                jogadaPadre.add(valorX + 1 + ", " + (valorY + 1));
                                valorX++;
                                valorY++;
                                count++;
                            }
                        } else if (yRef != tamanhoTabuleiro - 1 && xRef != tamanhoTabuleiro - 1 && idRef == idEquipa) {
                            while (valorY + 1 < yRef && valorX + 1 < xRef && count < 3) {
                                jogadaPadre.add(valorX + 1 + ", " + (valorY + 1));
                                valorX++;
                                valorY++;
                                count++;
                            }
                        } else {
                            int verificarPecaFronteira = 0;
                            for (CrazyPiece pecaFronteira : pecasJogo) {
                                if (pecaFronteira.getY() == tamanhoTabuleiro - 1 && pecaFronteira.getX() == tamanhoTabuleiro - 1 && idRef == idEquipa) {
                                    while (valorY + 1 < tamanhoTabuleiro - 1 && valorX + 1 < tamanhoTabuleiro - 1 && count < 3) {
                                        jogadaPadre.add(valorX + 1 + ", " + (valorY + 1));
                                        valorX++;
                                        valorY++;
                                        count++;
                                    }
                                    break;
                                }
                                verificarPecaFronteira++;
                                if (verificarPecaFronteira == pecasJogo.size()) {
                                    while (valorY + 1 <= tamanhoTabuleiro - 1 && valorX + 1 <= tamanhoTabuleiro - 1 && count < 3) {
                                        jogadaPadre.add(valorX + 1 + ", " + (valorY + 1));
                                        valorX++;
                                        valorY++;
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        count = 0;
        valorX = xO;
        valorY = yO;
        xRef = 0;
        yRef = tamanhoTabuleiro-1;
        idRef = idEquipa;
        for (CrazyPiece peca : pecasJogo) {//diagonal baixo esquerda
            if ((peca.getIdTipo() == 1 || (peca.getIdTipo() == 7 && ((Joker) peca).getTipoJoker().equals("Rainha"))) && peca.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                int verificaRainhas = 0;
                for (CrazyPiece verificaPecaChegada : pecasJogo) {
                    if ((verificaPecaChegada.getIdTipo() == 1 || (verificaPecaChegada.getIdTipo() == 7 && ((Joker) verificaPecaChegada).getTipoJoker().equals("Rainha"))) && verificaPecaChegada.getIdEquipa() != idEquipa && (abs(peca.getX() - (xO + 1)) > 2 || abs(peca.getY() - (yO + 1)) > 2 || abs(peca.getX() - (xO + 2)) > 2 || abs(peca.getY() - (yO + 2)) > 2 || abs(peca.getX() - (xO + 3)) > 2 || abs(peca.getY() - (yO + 3)) > 2)) {
                        verificaRainhas++;
                    }
                }
                if (verificaRainhas == rainhas) {
                    break;
                } else {
                    for (int posX = xO - 1, posY = yO + 1; posX >= xRef && posY <= yRef; posX--, posY++) {
                        if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY > valorY) {
                            xRef = posX;
                            yRef = posY;
                            idRef = peca.getIdEquipa();
                        }
                    }
                    count++;
                    if (count == pecasJogo.size()) {
                        count = 0;
                        if (xRef != 0 && yRef != tamanhoTabuleiro - 1 && idRef != idEquipa) {
                            while (valorY + 1 <= yRef && valorX - 1 >= xRef && count < 3) {
                                jogadaPadre.add(valorX - 1 + ", " + (valorY + 1));
                                valorX--;
                                valorY++;
                                count++;
                            }
                        } else if (yRef != tamanhoTabuleiro - 1 && xRef != 0 && idRef == idEquipa) {
                            while (valorY + 1 < yRef && valorX - 1 > xRef && count < 3) {
                                jogadaPadre.add(valorX - 1 + ", " + (valorY + 1));
                                valorX--;
                                valorY++;
                                count++;
                            }
                        } else {
                            int verificarPecaFronteira = 0;
                            for (CrazyPiece pecaFronteira : pecasJogo) {
                                if (pecaFronteira.getY() == tamanhoTabuleiro - 1 && pecaFronteira.getX() == tamanhoTabuleiro - 1 && idRef == idEquipa) {
                                    while (valorY + 1 < tamanhoTabuleiro - 1 && valorX - 1 > 0 && count < 3) {
                                        jogadaPadre.add(valorX - 1 + ", " + (valorY + 1));
                                        valorX--;
                                        valorY++;
                                        count++;
                                    }
                                    break;
                                }
                                verificarPecaFronteira++;
                                if (verificarPecaFronteira == pecasJogo.size()) {
                                    while (valorY + 1 <= tamanhoTabuleiro - 1 && valorX - 1 >= 0 && count < 3) {
                                        jogadaPadre.add(valorX - 1 + ", " + (valorY + 1));
                                        valorX--;
                                        valorY++;
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return jogadaPadre;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
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
                if ((peca.getIdTipo() == 1 || (peca.getIdTipo()==7 && ((Joker) peca).getTipoJoker().equals("Rainha"))) && peca.getIdEquipa() != idEquipa && ((abs(peca.getX() - xD) == 1 && peca.getY() == yD) || (abs(peca.getY() - yD) == 1 && peca.getX()==xD) || (abs(peca.getY() - yD) == 1 && abs(peca.getX() - xD) == 1))){
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
                return false;
            }
        }
        pecasJogo.remove(pecaParaRemover);
        jogo.setUltimaPecaCapturada(pecaParaRemover);
        return true;
    }
}