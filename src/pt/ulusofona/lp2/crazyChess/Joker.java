package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Joker extends CrazyPiece {

    public String tipoJoker;

    Joker(int idPeca, int tipo, int idEquipa, String alcunha){
        super(idPeca,tipo,idEquipa,alcunha);
        tipoJoker = "Rainha";
    }

    public String getValorRelativo() {
        valorRelativo = "4";
        return valorRelativo;
    }

    public int getPontos() {
        return 4;
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
            tipoJoker = "Padre da Vila";
        }else if (tipoJoker.equals("Padre da Vila")) {
            tipoJoker = "TorreH";
        }else if (tipoJoker.equals("TorreH")) {
            tipoJoker = "TorreV";
        }else if (tipoJoker.equals("TorreV")) {
            tipoJoker = "Lebre";
        }else if (tipoJoker.equals("Lebre")) {
            tipoJoker = "Rainha";
        }
    }

    List<Sugestao> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo, int tamanhoTabuleiro) {
        List<Sugestao> jogadaJoker = new ArrayList<>();
//        if (tipoJoker.equals("Rainha")){
//            int count = 0;
//            int valorX = xO;
//            int xRef = tamanhoTabuleiro - 1;
//            int idRef = idEquipa;
//            int tipoRef = -1;
//            String tipoJoker = "";
//            for (CrazyPiece peca: pecasJogo){//direita
//                if (peca.getX() > valorX && peca.getX() <= xRef && peca.getY() == yO){
//                    xRef = peca.getX();
//                    idRef = peca.getIdEquipa();
//                    tipoRef = peca.getIdTipo();
//                    if (tipoRef == 7){
//                        tipoJoker = ((Joker) peca).getTipoJoker();
//                    }
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    count = 0;
//                    if(xRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef !=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorX + 1 <= xRef && count<5){
//                            jogadaJoker.add(valorX+1 + ", " + yO);
//                            valorX++;
//                            count++;
//                        }
//                    }else if (xRef != tamanhoTabuleiro-1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))){
//                        while (valorX+1 < xRef && count<5) {
//                            jogadaJoker.add(valorX+1 + ", " + yO);
//                            valorX++;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getX()== tamanhoTabuleiro-1 && pecaFronteira.getY() == yO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorX + 1 < tamanhoTabuleiro -1 && count<5){
//                                    jogadaJoker.add(valorX + 1 + ", " + yO);
//                                    valorX++;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorX + 1 <= tamanhoTabuleiro -1 && count<5){
//                                    jogadaJoker.add(valorX + 1 + ", " + yO);
//                                    valorX++;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            valorX = xO;
//            count = 0;
//            xRef = 0;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca: pecasJogo){//esquerda
//                if (peca.getX() < valorX && peca.getX() >= xRef && peca.getY() == yO){
//                    xRef = peca.getX();
//                    idRef = peca.getIdEquipa();
//                    tipoRef = peca.getIdTipo();
//                    if (tipoRef == 7){
//                        tipoJoker = ((Joker) peca).getTipoJoker();
//                    }
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(xRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorX - 1 >= xRef && count < 5){
//                            jogadaJoker.add(valorX-1 + ", " + yO);
//                            valorX--;
//                            count++;
//                        }
//                    }else if (xRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorX-1 > xRef && count < 5) {
//                            jogadaJoker.add(valorX-1 + ", " + yO);
//                            valorX--;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == yO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorX - 1 > 0 && count<5){
//                                    jogadaJoker.add(valorX - 1 + ", " + yO);
//                                    valorX--;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorX - 1 >= 0 && count<5){
//                                    jogadaJoker.add(valorX - 1 + ", " + yO);
//                                    valorX--;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            int valorY = yO;
//            count = 0;
//            int yRef = 0;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca: pecasJogo){//cima
//                if (peca.getY() < valorY && peca.getY() >= yRef && peca.getX() == xO){
//                    yRef = peca.getY();
//                    idRef = peca.getIdEquipa();
//                    tipoRef = peca.getIdTipo();
//                    if (tipoRef == 7){
//                        tipoJoker = ((Joker) peca).getTipoJoker();
//                    }
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(yRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorY - 1 >= yRef && count < 5){
//                            jogadaJoker.add(xO + ", " + (valorY-1));
//                            valorY--;
//                            count++;
//                        }
//                    }else if (yRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY-1 > yRef && count < 5) {
//                            jogadaJoker.add(xO + ", " + (valorY-1));
//                            valorY--;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == xO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorY - 1 > 0 && count<5){
//                                    jogadaJoker.add(xO + ", " + (valorY-1));
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY - 1 >= 0 && count<5){
//                                    jogadaJoker.add(xO + ", " + (valorY-1));
//                                    valorY--;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorY = yO;
//            yRef = tamanhoTabuleiro - 1;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca: pecasJogo){//baixo
//                if (peca.getY() > valorY && peca.getY() <= yRef && peca.getX() == xO){
//                    yRef = peca.getY();
//                    idRef = peca.getIdEquipa();
//                    tipoRef = peca.getIdTipo();
//                    if (tipoRef == 7){
//                        tipoJoker = ((Joker) peca).getTipoJoker();
//                    }
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(yRef != tamanhoTabuleiro - 1 && idRef != idEquipa && tipoRef!=1 || tipoJoker.equals("Rainha")){
//                        while (valorY + 1 <= yRef && count < 5){
//                            jogadaJoker.add(xO + ", " + (valorY+1));
//                            valorY++;
//                            count++;
//                        }
//                    }else if (yRef != tamanhoTabuleiro - 1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY+1 < yRef && count < 5) {
//                            jogadaJoker.add(xO + ", " + (valorY+1));
//                            valorY++;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== tamanhoTabuleiro - 1 && pecaFronteira.getX() == xO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorY + 1 < tamanhoTabuleiro - 1 && count<5){
//                                    jogadaJoker.add(xO + ", " + (valorY+1));
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY + 1 <= tamanhoTabuleiro - 1 && count<5){
//                                    jogadaJoker.add(xO + ", " + (valorY+1));
//                                    valorY++;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = 0;
//            yRef = 0;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo){//diagonal cima esquerda
//                for(int posX = xO -1, posY = yO - 1; posX >= xRef && posY >= yRef; posX--, posY--){
//                    if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY < valorY){
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7){
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(xRef != 0 && yRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorY - 1 >= yRef  && valorX - 1>= xRef && count < 5){
//                            jogadaJoker.add(valorX - 1 + ", " + (valorY-1));
//                            valorX--;
//                            valorY--;
//                            count++;
//                        }
//                    }else if (yRef != 0 && xRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY-1 > yRef && valorX-1 > xRef && count < 5) {
//                            jogadaJoker.add(valorX-1 + ", " + (valorY-1));
//                            valorX--;
//                            valorY--;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == 0 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorY - 1 > 0 && valorX - 1 > 0 && count<5){
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY-1));
//                                    valorX--;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY - 1 >= 0 && valorX - 1 >= 0&& count<5){
//                                    jogadaJoker.add(valorX-1 + ", " + (valorY-1));
//                                    valorX--;
//                                    valorY--;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = tamanhoTabuleiro-1;
//            yRef = 0;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo){//diagonal cima direita
//                for(int posX = xO +1, posY = yO - 1; posX <= xRef && posY >= yRef; posX++, posY--){
//                    if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY < valorY){
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7){
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(xRef != tamanhoTabuleiro - 1 && yRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorY - 1 >= yRef  && valorX +1<= xRef && count < 5){
//                            jogadaJoker.add(valorX + 1 + ", " + (valorY-1));
//                            valorX++;
//                            valorY--;
//                            count++;
//                        }
//                    }else if (yRef != 0 && xRef != tamanhoTabuleiro - 1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY-1 > yRef && valorX+1 < xRef && count < 5) {
//                            jogadaJoker.add(valorX+1 + ", " + (valorY-1));
//                            valorX++;
//                            valorY--;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == tamanhoTabuleiro-1 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorY - 1 > 0 && valorX + 1 < tamanhoTabuleiro-1 && count<5){
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY-1));
//                                    valorX++;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY - 1 >= 0 && valorX + 1 <= tamanhoTabuleiro-1 && count<5){
//                                    jogadaJoker.add(valorX+ 1 + ", " + (valorY-1));
//                                    valorX++;
//                                    valorY--;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = tamanhoTabuleiro-1;
//            yRef = tamanhoTabuleiro-1;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo){//diagonal baixo direita
//                for(int posX = xO +1, posY = yO + 1; posX <= xRef && posY <= yRef; posX++, posY++){
//                    if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY > valorY){
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7){
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(xRef != tamanhoTabuleiro-1 && yRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorY + 1 <= yRef  && valorX +1<= xRef && count < 5){
//                            jogadaJoker.add(valorX + 1 + ", " + (valorY+1));
//                            valorX++;
//                            valorY++;
//                            count++;
//                        }
//                    }else if (yRef != tamanhoTabuleiro-1 && xRef != tamanhoTabuleiro-1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY+1 < yRef && valorX+1 < xRef && count < 5) {
//                            jogadaJoker.add(valorX+1 + ", " + (valorY+1));
//                            valorX++;
//                            valorY++;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorY + 1 < tamanhoTabuleiro-1 && valorX + 1 < tamanhoTabuleiro-1 && count<5){
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY+1));
//                                    valorX++;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX + 1 <= tamanhoTabuleiro-1 && count<5){
//                                    jogadaJoker.add(valorX+ 1 + ", " + (valorY+1));
//                                    valorX++;
//                                    valorY++;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = 0;
//            yRef = tamanhoTabuleiro-1;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo){//diagonal baixo esquerda
//                for(int posX = xO - 1, posY = yO + 1; posX >= xRef && posY <= yRef; posX--, posY++){
//                    if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY > valorY){
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7){
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()){
//                    count=0;
//                    if(xRef != 0 && yRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
//                        while (valorY + 1 <= yRef  && valorX -1>= xRef && count < 5){
//                            jogadaJoker.add(valorX - 1 + ", " + (valorY+1));
//                            valorX--;
//                            valorY++;
//                            count++;
//                        }
//                    }else if (yRef != tamanhoTabuleiro-1 && xRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY+1 < yRef && valorX-1 > xRef && count < 5) {
//                            jogadaJoker.add(valorX-1 + ", " + (valorY+1));
//                            valorX--;
//                            valorY++;
//                            count++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || ((Joker)pecaFronteira).getTipoJoker().equals("Rainha"))){
//                                while (valorY + 1 < tamanhoTabuleiro-1 && valorX - 1 > 0 && count<5){
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY+1));
//                                    valorX--;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX - 1 >= 0 && count<5){
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY+1));
//                                    valorX--;
//                                    valorY++;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }else if (tipoJoker.equals("Ponei Mágico")){
//            boolean valida = true;
//            int count = 0;
//            for (CrazyPiece peca: pecasJogo){//diagonal cima direita
//                if (xO+2 > tamanhoTabuleiro - 1 || yO-2 < 0){
//                    break;
//                }
//                if(peca.getX()==xO+2 && peca.getY()==yO-2 && peca.getIdEquipa()==idEquipa){
//                    break;
//                }
//                count++;
//                if(count == pecasJogo.size()){
//                    count = 0;
//                    for(CrazyPiece peca1 : pecasJogo){
//                        if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO-1 || peca1.getY() == yO-2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xO+2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getX() == xO+2 && peca3.getY() == yO-1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO+1 || peca1.getX() == xO+2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO-1 || peca2.getY() == yO-2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO+1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO+2 && peca1.getY() == yO-1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getY() == yO-1 || peca2.getY() == yO-2) && peca2.getX() == xO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO+1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO-2 && peca1.getX() == xO+1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getX() == xO + 1 || peca2.getX() == xO + 2) && peca2.getY() == yO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3 : pecasJogo) {
//                                        if (peca3.getIdTipo() == 0 && peca3.getX() == xO + 2 && peca3.getY() == yO - 1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        count++;
//                        if (count == pecasJogo.size() && valida){
//                            jogadaJoker.add(xO + 2 + ", " + (yO - 2));
//                        }
//                    }
//                }
//            }
//            count = 0;
//            for (CrazyPiece peca: pecasJogo){//diagonal cima esquerda
//                if (xO-2 < 0 || yO-2 < 0){
//                    break;
//                }
//                if(peca.getX()==xO-2 && peca.getY()==yO-2 && peca.getIdEquipa()==idEquipa){
//                    break;
//                }
//                count++;
//                if(count == pecasJogo.size()){
//                    count = 0;
//                    for(CrazyPiece peca1 : pecasJogo){
//                        if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO-1 || peca1.getY() == yO-2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO-1 || peca2.getX() == xO-2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getX() == xO-2 && peca3.getY() == yO-1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO-1 || peca1.getX() == xO-2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO-1 || peca2.getY() == yO-2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO-1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO-2 && peca1.getY() == yO-1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getY() == yO-1 || peca2.getY() == yO-2) && peca2.getX() == xO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO-2 && peca3.getX() == xO-1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO-2 && peca1.getX() == xO-1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2) && peca2.getY() == yO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3 : pecasJogo) {
//                                        if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO - 1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        count++;
//                        if (count == pecasJogo.size() && valida){
//                            jogadaJoker.add(xO - 2 + ", " + (yO - 2));
//                        }
//                    }
//                }
//            }
//            count = 0;
//            for (CrazyPiece peca: pecasJogo){//diagonal baixo esquerda
//                if (yO+2 > tamanhoTabuleiro - 1 || xO-2 < 0){
//                    break;
//                }
//                if(peca.getX()==xO-2 && peca.getY()==yO+2 && peca.getIdEquipa()==idEquipa){
//                    break;
//                }
//                count++;
//                if(count == pecasJogo.size()){
//                    count = 0;
//                    for(CrazyPiece peca1 : pecasJogo){
//                        if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO+1 || peca1.getY() == yO+2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3 : pecasJogo) {
//                                        if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO + 1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO-1 || peca1.getX() == xO-2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO+1 || peca2.getY() == yO+2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO-1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO-2 && peca1.getY() == yO+1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getY() == yO+1 || peca2.getY() == yO+2) && peca2.getX() == xO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO-1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO+2 && peca1.getX() == xO-1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getX() == xO - 1 || peca2.getX() == xO - 2) && peca2.getY() == yO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3 : pecasJogo) {
//                                        if (peca3.getIdTipo() == 0 && peca3.getX() == xO - 2 && peca3.getY() == yO + 1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        count++;
//                        if (count == pecasJogo.size() && valida){
//                            jogadaJoker.add(xO - 2 + ", " + (yO + 2));
//                        }
//                    }
//                }
//            }
//            count = 0;
//            for (CrazyPiece peca: pecasJogo){//diagonal baixo direita
//                if (xO+2 > tamanhoTabuleiro - 1 || yO+2 > tamanhoTabuleiro-1){
//                    break;
//                }
//                if(peca.getX()==xO+2 && peca.getY()==yO+2 && peca.getIdEquipa()==idEquipa){
//                    break;
//                }
//                count++;
//                if(count == pecasJogo.size()){
//                    count = 0;
//                    for(CrazyPiece peca1 : pecasJogo){
//                        if(peca1.getIdTipo() == 0 && peca1.getX() == xO && (peca1.getY() == yO+1 || peca1.getY() == yO+2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xO+2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getX() == xO+2 && peca3.getY() == yO+1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else  if(peca1.getIdTipo() == 0 && peca1.getY() == yO && (peca1.getX() == xO+1 || peca1.getX() == xO+2)){
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo){
//                                if(peca2.getIdTipo() == 0 && peca2.getX() == xO && (peca2.getY() == yO+1 || peca2.getY() == yO+2)) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()){
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO+1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getX() == xO+2 && peca1.getY() == yO+1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getY() == yO+1 || peca2.getY() == yO+2) && peca2.getX() == xO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3: pecasJogo){
//                                        if(peca3.getIdTipo() == 0 && peca3.getY() == yO+2 && peca3.getX() == xO+1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }else if(peca1.getIdTipo() == 0 && peca1.getY() == yO+2 && peca1.getX() == xO+1) {
//                            int count1 = 0;
//                            for (CrazyPiece peca2 : pecasJogo) {
//                                if (peca2.getIdTipo() == 0 && (peca2.getX() == xO + 1 || peca2.getX() == xO + 2) && peca2.getY() == yO) {
//                                    valida = false;
//                                    break;
//                                }
//                                count1++;
//                                if (count1 == pecasJogo.size()) {
//                                    for (CrazyPiece peca3 : pecasJogo) {
//                                        if (peca3.getIdTipo() == 0 && peca3.getX() == xO + 2 && peca3.getY() == yO + 1) {
//                                            valida = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        count++;
//                        if (count == pecasJogo.size() && valida){
//                            jogadaJoker.add(xO + 2 + ", " + (yO + 2));
//                        }
//                    }
//                }
//            }
//        }else if (tipoJoker.equals("Padre da Vila")) {
//            int count = 0;
//            int valorX = xO;
//            int valorY = yO;
//            int xRef = 0;
//            int yRef = 0;
//            int idRef = idEquipa;
//            int tipoRef = -1;
//            String tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo) {//diagonal cima esquerda
//                for (int posX = xO - 1, posY = yO - 1; posX >= xRef && posY >= yRef; posX--, posY--) {
//                    if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY < valorY) {
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7) {
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()) {
//                    count = 0;
//                    if (xRef != 0 && yRef != 0 && idRef != idEquipa && tipoRef != 1 && !(tipoJoker.equals("Rainha"))) {
//                        while (valorY - 1 >= yRef && valorX - 1 >= xRef && count < 3) {
//                            jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                            valorX--;
//                            valorY--;
//                            count++;
//                        }
//                    } else if (yRef != 0 && xRef != 0 && idRef != idEquipa && (tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY - 1 >= yRef && valorX - 1 >= xRef && count < 3) {
//                            if (!(valorY - 1 == yRef + 1 && valorX - 1 == xRef + 1)) {
//                                jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                            }
//                            valorX--;
//                            valorY--;
//                            count++;
//                        }
//                    } else if (yRef != 0 && xRef != 0 && idRef == idEquipa) {
//                        while (valorY - 1 > yRef && valorX - 1 > xRef && count < 3) {
//                            jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                            valorX--;
//                            valorY--;
//                            count++;
//                        }
//                    } else {
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo) {
//                            if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == 0 && idRef != idEquipa && (pecaFronteira.getIdTipo() != 1 && !((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY - 1 >= 0 && valorX - 1 >= 0 && count < 3) {
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                                    valorX--;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == 0 && idRef != idEquipa && (pecaFronteira.getIdTipo() == 1 && ((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY - 1 >= 0 && valorX - 1 >= 0 && count < 3) {
//                                    if (!(valorY - 1 == 1 && valorX - 1 == 1)) {
//                                        jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                                    }
//                                    valorX--;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == 0 && idRef == idEquipa) {
//                                while (valorY - 1 > 0 && valorX - 1 > 0 && count < 3) {
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                                    valorX--;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira++;
//                            if (verificarPecaFronteira == pecasJogo.size()) {
//                                while (valorY - 1 >= 0 && valorX - 1 >= 0 && count < 3) {
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY - 1));
//                                    valorX--;
//                                    valorY--;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = tamanhoTabuleiro-1;
//            yRef = 0;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo) {//diagonal cima direita
//                for (int posX = xO + 1, posY = yO - 1; posX <= xRef && posY >= yRef; posX++, posY--) {
//                    if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY < valorY) {
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7) {
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()) {
//                    count = 0;
//                    if (xRef != tamanhoTabuleiro-1 && yRef != 0 && idRef != idEquipa && tipoRef != 1 && !(tipoJoker.equals("Rainha"))) {
//                        while (valorY - 1 >= yRef && valorX + 1 <= xRef && count < 3) {
//                            jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                            valorX++;
//                            valorY--;
//                            count++;
//                        }
//                    } else if (yRef != 0 && xRef != tamanhoTabuleiro-1 && idRef != idEquipa && (tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY - 1 >= yRef && valorX + 1 <= xRef && count < 3) {
//                            if (!(valorY - 1 == yRef + 1 && valorX + 1 == xRef - 1)) {
//                                jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                            }
//                            valorX++;
//                            valorY--;
//                            count++;
//                        }
//                    } else if (yRef != 0 && xRef != tamanhoTabuleiro-1 && idRef == idEquipa) {
//                        while (valorY - 1 > yRef && valorX +1 < xRef && count < 3) {
//                            jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                            valorX++;
//                            valorY--;
//                            count++;
//                        }
//                    } else {
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo) {
//                            if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == tamanhoTabuleiro-1 && idRef != idEquipa && (pecaFronteira.getIdTipo() != 1 && !((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY - 1 >= 0 && valorX + 1 <= tamanhoTabuleiro-1 && count < 3) {
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                                    valorX++;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == tamanhoTabuleiro-1 && idRef != idEquipa && (pecaFronteira.getIdTipo() == 1 && ((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY - 1 >= 0 && valorX + 1 <= tamanhoTabuleiro-1 && count < 3) {
//                                    if (!(valorY - 1 == 1 && valorX + 1 == tamanhoTabuleiro-2)) {
//                                        jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                                    }
//                                    valorX++;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == 0 && idRef == idEquipa) {
//                                while (valorY - 1 > 0 && valorX + 1 < tamanhoTabuleiro-1 && count < 3) {
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                                    valorX++;
//                                    valorY--;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira++;
//                            if (verificarPecaFronteira == pecasJogo.size()) {
//                                while (valorY - 1 >= 0 && valorX + 1 <= tamanhoTabuleiro-1 && count < 3) {
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY - 1));
//                                    valorX++;
//                                    valorY--;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = tamanhoTabuleiro-1;
//            yRef = tamanhoTabuleiro-1;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo) {//diagonal baixo direita
//                for (int posX = xO + 1, posY = yO + 1; posX <= xRef && posY <= yRef; posX++, posY++) {
//                    if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY > valorY) {
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7) {
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()) {
//                    count = 0;
//                    if (xRef != tamanhoTabuleiro-1 && yRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef != 1 && !(tipoJoker.equals("Rainha"))) {
//                        while (valorY + 1 <= yRef && valorX + 1 <= xRef && count < 3) {
//                            jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                            valorX++;
//                            valorY++;
//                            count++;
//                        }
//                    } else if (yRef != tamanhoTabuleiro-1 && xRef != tamanhoTabuleiro-1 && idRef != idEquipa && (tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY + 1 <= yRef && valorX + 1 <= xRef && count < 3) {
//                            if (!(valorY + 1 == yRef - 1 && valorX + 1 == xRef - 1)) {
//                                jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                            }
//                            valorX++;
//                            valorY++;
//                            count++;
//                        }
//                    } else if (yRef != tamanhoTabuleiro-1 && xRef != tamanhoTabuleiro-1 && idRef == idEquipa) {
//                        while (valorY + 1 < yRef && valorX +1 < xRef && count < 3) {
//                            jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                            valorX++;
//                            valorY++;
//                            count++;
//                        }
//                    } else {
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo) {
//                            if (pecaFronteira.getY() == tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && idRef != idEquipa && (pecaFronteira.getIdTipo() != 1 && !((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX + 1 <= tamanhoTabuleiro-1 && count < 3) {
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                                    valorX++;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && idRef != idEquipa && (pecaFronteira.getIdTipo() == 1 && ((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX + 1 <= tamanhoTabuleiro-1 && count < 3) {
//                                    if (!(valorY - 1 == tamanhoTabuleiro-2 && valorX + 1 == tamanhoTabuleiro-2)) {
//                                        jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                                    }
//                                    valorX++;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && idRef == idEquipa) {
//                                while (valorY + 1 < tamanhoTabuleiro-1 && valorX + 1 < tamanhoTabuleiro-1 && count < 3) {
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                                    valorX++;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira++;
//                            if (verificarPecaFronteira == pecasJogo.size()) {
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX + 1 <= tamanhoTabuleiro-1 && count < 3) {
//                                    jogadaJoker.add(valorX + 1 + ", " + (valorY + 1));
//                                    valorX++;
//                                    valorY++;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            count = 0;
//            valorX = xO;
//            valorY = yO;
//            xRef = 0;
//            yRef = tamanhoTabuleiro-1;
//            idRef = idEquipa;
//            tipoRef = -1;
//            tipoJoker = "";
//            for (CrazyPiece peca : pecasJogo) {//diagonal baixo esquerda
//                for (int posX = xO - 1, posY = yO + 1; posX >= xRef && posY <= yRef; posX--, posY++) {
//                    if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY > valorY) {
//                        xRef = posX;
//                        yRef = posY;
//                        idRef = peca.getIdEquipa();
//                        tipoRef = peca.getIdTipo();
//                        if (tipoRef == 7) {
//                            tipoJoker = ((Joker) peca).getTipoJoker();
//                        }
//                    }
//                }
//                count++;
//                if (count == pecasJogo.size()) {
//                    count = 0;
//                    if (xRef != 0 && yRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef != 1 && !(tipoJoker.equals("Rainha"))) {
//                        while (valorY + 1 <= yRef && valorX - 1 >= xRef && count < 3) {
//                            jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                            valorX--;
//                            valorY++;
//                            count++;
//                        }
//                    } else if (yRef != tamanhoTabuleiro-1 && xRef != 0 && idRef != idEquipa && (tipoRef == 1 || tipoJoker.equals("Rainha"))) {
//                        while (valorY + 1 <= yRef && valorX - 1 >= xRef && count < 3) {
//                            if (!(valorY + 1 == yRef - 1 && valorX - 1 == xRef + 1)) {
//                                jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                            }
//                            valorX--;
//                            valorY++;
//                            count++;
//                        }
//                    } else if (yRef != tamanhoTabuleiro-1 && xRef != 0 && idRef == idEquipa) {
//                        while (valorY + 1 < yRef && valorX -1 > xRef && count < 3) {
//                            jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                            valorX--;
//                            valorY++;
//                            count++;
//                        }
//                    } else {
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo) {
//                            if (pecaFronteira.getY() == tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && idRef != idEquipa && (pecaFronteira.getIdTipo() != 1 && !((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX - 1 >= 0 && count < 3) {
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                                    valorX--;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == tamanhoTabuleiro-1 && pecaFronteira.getX() == 0 && idRef != idEquipa && (pecaFronteira.getIdTipo() == 1 && ((Joker) pecaFronteira).getTipoJoker().equals("Rainha"))) {
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX - 1 >= 0 && count < 3) {
//                                    if (!(valorY + 1 == tamanhoTabuleiro-2 && valorX - 1 == 1)) {
//                                        jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                                    }
//                                    valorX--;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            } else if (pecaFronteira.getY() == 0 && pecaFronteira.getX() == 0 && idRef == idEquipa) {
//                                while (valorY + 1 < tamanhoTabuleiro-1 && valorX - 1 > 0 && count < 3) {
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                                    valorX--;
//                                    valorY++;
//                                    count++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira++;
//                            if (verificarPecaFronteira == pecasJogo.size()) {
//                                while (valorY + 1 <= tamanhoTabuleiro-1 && valorX - 1 >= 0 && count < 3) {
//                                    jogadaJoker.add(valorX - 1 + ", " + (valorY + 1));
//                                    valorX--;
//                                    valorY++;
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }else if (tipoJoker.equals("TorreH")) {
//            int count = 0;
//            int valorX = xO;
//            int xRef = tamanhoTabuleiro - 1;
//            int idRef = idEquipa;
//            for (CrazyPiece peca: pecasJogo){//direita
//                if (peca.getX() > valorX && peca.getX() <= xRef && peca.getY() == yO){
//                    xRef = peca.getX();
//                    idRef = peca.getIdEquipa();
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    if(xRef != tamanhoTabuleiro-1 && idRef != idEquipa){
//                        while (valorX + 1 <= xRef){
//                            jogadaJoker.add(valorX+1 + ", " + yO);
//                            valorX++;
//                        }
//                    }else if (xRef != tamanhoTabuleiro-1 && idRef == idEquipa) {
//                        while (valorX+1 < xRef) {
//                            jogadaJoker.add(valorX+1 + ", " + yO);
//                            valorX++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getX()== tamanhoTabuleiro-1 && pecaFronteira.getY() == yO && idRef == idEquipa){
//                                while (valorX + 1 < tamanhoTabuleiro -1){
//                                    jogadaJoker.add(valorX + 1 + ", " + yO);
//                                    valorX++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorX + 1 <= tamanhoTabuleiro -1){
//                                    jogadaJoker.add(valorX + 1 + ", " + yO);
//                                    valorX++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            valorX = xO;
//            count = 0;
//            xRef = 0;
//            idRef = idEquipa;
//            for (CrazyPiece peca: pecasJogo){//esquerda
//                if (peca.getX() < valorX && peca.getX() >= xRef && peca.getY() == yO){
//                    xRef = peca.getX();
//                    idRef = peca.getIdEquipa();
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    if(xRef != 0 && idRef != idEquipa){
//                        while (valorX - 1 >= xRef){
//                            jogadaJoker.add(valorX-1 + ", " + yO);
//                            valorX--;
//                        }
//                    }else if (xRef != 0 && idRef == idEquipa) {
//                        while (valorX-1 > xRef) {
//                            jogadaJoker.add(valorX-1 + ", " + yO);
//                            valorX--;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == yO && idRef == idEquipa){
//                                while (valorX - 1 > 0){
//                                    jogadaJoker.add(valorX - 1 + ", " + yO);
//                                    valorX--;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorX - 1 >= 0){
//                                    jogadaJoker.add(valorX - 1 + ", " + yO);
//                                    valorX--;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }else if (tipoJoker.equals("TorreV")) {
//            int count = 0;
//            int valorY = yO;
//            int yRef = tamanhoTabuleiro - 1;
//            int idRef = idEquipa;
//            for (CrazyPiece peca: pecasJogo){//baixo
//                if (peca.getY() > valorY && peca.getY() <= yRef && peca.getX() == xO){
//                    yRef = peca.getY();
//                    idRef = peca.getIdEquipa();
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    if(yRef != tamanhoTabuleiro-1 && idRef != idEquipa){
//                        while (valorY + 1 <= yRef){
//                            jogadaJoker.add(xO + ", " + (valorY+1));
//                            valorY++;
//                        }
//                    }else if (yRef != tamanhoTabuleiro-1 && idRef == idEquipa) {
//                        while (valorY+1 < yRef) {
//                            jogadaJoker.add(xO + ", " + (valorY+1));
//                            valorY++;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== tamanhoTabuleiro-1 && pecaFronteira.getX() == xO && idRef == idEquipa){
//                                while (valorY + 1 < tamanhoTabuleiro -1){
//                                    jogadaJoker.add(xO + ", " + (valorY+1));
//                                    valorY++;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY + 1 <= tamanhoTabuleiro -1){
//                                    jogadaJoker.add(xO + ", " + (valorY+1));
//                                    valorY++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            valorY = yO;
//            count = 0;
//            yRef = 0;
//            idRef = idEquipa;
//            for (CrazyPiece peca: pecasJogo){//cima
//                if (peca.getY() < valorY && peca.getY() >= yRef && peca.getX() == xO){
//                    yRef = peca.getY();
//                    idRef = peca.getIdEquipa();
//                }
//                count ++;
//                if (count == pecasJogo.size()){
//                    if(yRef != 0 && idRef != idEquipa){
//                        while (valorY - 1 >= yRef){
//                            jogadaJoker.add(xO + ", " + (valorY-1));
//                            valorY--;
//                        }
//                    }else if (yRef != 0 && idRef == idEquipa) {
//                        while (valorY-1 > yRef) {
//                            jogadaJoker.add(xO + ", " + (valorY-1));
//                            valorY--;
//                        }
//                    }else{
//                        int verificarPecaFronteira = 0;
//                        for (CrazyPiece pecaFronteira : pecasJogo){
//                            if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == xO && idRef == idEquipa){
//                                while (valorY - 1 >0){
//                                    jogadaJoker.add(xO + ", " + (valorY-1));
//                                    valorY--;
//                                }
//                                break;
//                            }
//                            verificarPecaFronteira ++;
//                            if (verificarPecaFronteira == pecasJogo.size()){
//                                while (valorY - 1 >= 0){
//                                    jogadaJoker.add(xO + ", " + (valorY-1));
//                                    valorY--;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }else if (tipoJoker.equals("Lebre")) {
//            int count = 0;
//            for (CrazyPiece peca: pecasJogo){//cima direita
//                if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO + 1){
//                    jogadaJoker.add(xO+1 + ", " + (yO-1));
//                    break;
//                }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO+1){
//                    break;
//                }
//                count++;
//                if (count == pecasJogo.size() && yO - 1 >= 0 && xO + 1 < tamanhoTabuleiro){
//                    jogadaJoker.add(xO+1 + ", " + (yO-1));
//                }
//            }
//            count = 0;
//            for (CrazyPiece peca: pecasJogo){//cima esquerda
//                if (peca.getIdEquipa() != idEquipa && peca.getY() == yO - 1 && peca.getX() == xO - 1){
//                    jogadaJoker.add(xO-1 + ", " + (yO-1));
//                    break;
//                }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO - 1 && peca.getX() == xO-1){
//                    break;
//                }
//                count++;
//                if (count == pecasJogo.size() && yO - 1 >= 0 && xO - 1 >= 0){
//                    jogadaJoker.add(xO-1 + ", " + (yO-1));
//                }
//            }
//            count = 0;
//            for (CrazyPiece peca: pecasJogo){//baixo esquerda
//                if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO - 1){
//                    jogadaJoker.add(xO-1 + ", " + (yO+1));
//                    break;
//                }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO-1){
//                    break;
//                }
//                count++;
//                if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro && xO - 1 >= 0){
//                    jogadaJoker.add(xO-1 + ", " + (yO+1));
//                }
//            }
//            count = 0;
//            for (CrazyPiece peca: pecasJogo){//baixo direita
//                if (peca.getIdEquipa() != idEquipa && peca.getY() == yO + 1 && peca.getX() == xO + 1){
//                    jogadaJoker.add(xO+1 + ", " + (yO+1));
//                    break;
//                }else if(peca.getIdEquipa() == idEquipa && peca.getY() == yO + 1 && peca.getX() == xO+1){
//                    break;
//                }
//                count++;
//                if (count == pecasJogo.size() && yO + 1 < tamanhoTabuleiro && xO + 1 < tamanhoTabuleiro){
//                    jogadaJoker.add(xO+1 + ", " + (yO+1));
//                }
//            }
//        }
        return jogadaJoker;
    }

    boolean movePeca(int xO, int yO, int xD, int yD, Estatistica estatisticas, List<CrazyPiece> pecasJogo, InfoJogo jogo) {
        if (tipoJoker.equals("Rainha")) {
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
                if (((verificaJoker.getIdTipo() == 7 && ((Joker) verificaJoker).getTipoJoker().equals("Rainha")) || verificaJoker.getIdTipo() == 1)  && verificaJoker.getX() == xD && verificaJoker.getY() == yD){
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
            jogo.setUltimaPecaCapturada(pecaParaRemover);
        } else if (tipoJoker.equals("Ponei Mágico")) {
            int count = 0;
            if(abs(xO-xD) != 2|| abs(yO-yD) != 2 ){
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
                            int count1 = 0;
                            for (CrazyPiece peca2 : pecasJogo){
                                if(peca2.getIdTipo() == 0 && peca2.getY() == yO && (peca2.getX() == xO+1 || peca2.getX() == xD)) {
                                    if (idEquipa == 10) {
                                        estatisticas.adicionaJogadasInvalidasPretas();
                                    } else {
                                        estatisticas.adicionaJogadasInvalidasBrancas();
                                    }
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
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
            jogo.setUltimaPecaCapturada(pecaParaRemover);
        } else if(tipoJoker.equals("Padre da Vila")){
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
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
            jogo.setUltimaPecaCapturada(pecaParaRemover);
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
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
            jogo.setUltimaPecaCapturada(pecaParaRemover);
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
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
            jogo.setUltimaPecaCapturada(pecaParaRemover);
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
                    return false;
                }
            }
            pecasJogo.remove(pecaParaRemover);
            jogo.setUltimaPecaCapturada(pecaParaRemover);
        }
        return true;
    }
}