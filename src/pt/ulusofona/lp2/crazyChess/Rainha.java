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

    public int getPontos() {
        return 8;
    }

    public List<Comparable> sugerirJogadas(int xO, int yO,List<CrazyPiece> pecasJogo,int tamanhoTabuleiro) {
        List <Comparable> jogadaRainha = new ArrayList<>();
        int count = 0;
        int valorX = xO;
        int xRef = tamanhoTabuleiro - 1;
        int idRef = idEquipa;
        int tipoRef = -1;
        int pontosRef = 0;
        String tipoJoker = "";
        for (CrazyPiece peca: pecasJogo){//direita
            if (peca.getX() > valorX && peca.getX() <= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
                pontosRef = peca.getPontos();
                if (tipoRef == 7){
                    tipoJoker = ((Joker) peca).getTipoJoker();
                }
            }
            count ++;
            if (count == pecasJogo.size()){
                count = 0;
                if(xRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef !=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorX + 1 <= xRef && count<5){
                        if(valorX+1 == xRef){
                            jogadaRainha.add(new Sugestao(valorX+1,yO,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(valorX+1,yO,0));
                        }
                        valorX++;
                        count++;
                    }
                }else if (xRef != tamanhoTabuleiro-1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))){
                    while (valorX+1 < xRef && count<5) {
                        jogadaRainha.add(new Sugestao(valorX+1,yO,0));
                        valorX++;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getX()== tamanhoTabuleiro-1 && pecaFronteira.getY() == yO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorX + 1 < tamanhoTabuleiro -1 && count<5){
                                jogadaRainha.add(new Sugestao(valorX + 1, yO,0));
                                valorX++;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getX()== tamanhoTabuleiro-1 && pecaFronteira.getY() == yO && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorX + 1 <= tamanhoTabuleiro-1 && count < 5){
                                if (valorX + 1 == tamanhoTabuleiro-1){
                                    jogadaRainha.add(new Sugestao(valorX+1,yO,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(valorX+1,yO,0));
                                }
                                valorX++;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorX + 1 <= tamanhoTabuleiro -1 && count<5){
                                jogadaRainha.add(new Sugestao(valorX + 1, yO,0));
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
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca: pecasJogo){//esquerda
            if (peca.getX() < valorX && peca.getX() >= xRef && peca.getY() == yO){
                xRef = peca.getX();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
                pontosRef = peca.getPontos();
                if (tipoRef == 7){
                    tipoJoker = ((Joker) peca).getTipoJoker();
                }
            }
            count ++;
            if (count == pecasJogo.size()){
                count=0;
                if(xRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorX - 1 >= xRef && count < 5){
                        if(valorX-1 == xRef){
                            jogadaRainha.add(new Sugestao(valorX-1,yO,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(valorX-1,yO,0));
                        }
                        valorX--;
                        count++;
                    }
                }else if (xRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorX-1 > xRef && count < 5) {
                        jogadaRainha.add(new Sugestao(valorX-1,yO,0));
                        valorX--;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == yO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorX - 1 > 0 && count<5){
                                jogadaRainha.add(new Sugestao(valorX-1,yO,0));
                                valorX--;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == yO && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorX - 1 >= 0 && count < 5){
                                if (valorX - 1 == 0){
                                    jogadaRainha.add(new Sugestao(valorX-1,yO,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(valorX-1,yO,0));
                                }
                                valorX--;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorX - 1 >= 0 && count<5){
                                jogadaRainha.add(new Sugestao(valorX-1,yO,0));
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
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca: pecasJogo){//cima
            if (peca.getY() < valorY && peca.getY() >= yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
                pontosRef = peca.getPontos();
                if (tipoRef == 7){
                    tipoJoker = ((Joker) peca).getTipoJoker();
                }
            }
            count ++;
            if (count == pecasJogo.size()){
                count=0;
                if(yRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorY - 1 >= yRef && count < 5){
                        if (valorY-1 == yRef){
                            jogadaRainha.add(new Sugestao(xO,valorY-1,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(xO,valorY-1,0));
                        }
                        valorY--;
                        count++;
                    }
                }else if (yRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorY-1 > yRef && count < 5) {
                        jogadaRainha.add(new Sugestao(xO,valorY-1,0));
                        valorY--;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == xO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorY - 1 > 0 && count<5){
                                jogadaRainha.add(new Sugestao(xO,valorY-1,0));
                                valorY--;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == xO && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorY - 1 >= 0 && count < 5){
                                if (valorY -1  == 0){
                                    jogadaRainha.add(new Sugestao(xO,valorY-1,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(xO,valorY-1,0));
                                }
                                valorY--;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY - 1 >= 0 && count<5){
                                jogadaRainha.add(new Sugestao(xO,valorY-1,0));
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
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca: pecasJogo){//baixo
            if (peca.getY() > valorY && peca.getY() <= yRef && peca.getX() == xO){
                yRef = peca.getY();
                idRef = peca.getIdEquipa();
                tipoRef = peca.getIdTipo();
                pontosRef = peca.getPontos();
                if (tipoRef == 7){
                    tipoJoker = ((Joker) peca).getTipoJoker();
                }
            }
            count ++;
            if (count == pecasJogo.size()){
                count=0;
                if(yRef != tamanhoTabuleiro - 1 && idRef != idEquipa && tipoRef!=1 || tipoJoker.equals("Rainha")){
                    while (valorY + 1 <= yRef && count < 5){
                        if (valorY + 1 == yRef){
                            jogadaRainha.add(new Sugestao(xO,valorY+1,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(xO,valorY+1,0));
                        }
                        valorY++;
                        count++;
                    }
                }else if (yRef != tamanhoTabuleiro - 1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorY+1 < yRef && count < 5) {
                        jogadaRainha.add(new Sugestao(xO,valorY+1,0));
                        valorY++;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== tamanhoTabuleiro - 1 && pecaFronteira.getX() == xO && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorY + 1 < tamanhoTabuleiro - 1 && count<5){
                                jogadaRainha.add(new Sugestao(xO,valorY+1,0));
                                valorY++;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getY()== tamanhoTabuleiro - 1 && pecaFronteira.getX() == xO && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorY + 1 <= yRef && count < 5){
                                if (valorY + 1 == yRef){
                                    jogadaRainha.add(new Sugestao(xO,valorY+1,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(xO,valorY+1,0));
                                }
                                valorY++;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY + 1 <= tamanhoTabuleiro - 1 && count<5){
                                jogadaRainha.add(new Sugestao(xO,valorY+1,0));
                                valorY++;
                                count++;
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
        yRef = 0;
        idRef = idEquipa;
        tipoRef = -1;
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca : pecasJogo){//diagonal cima esquerda
            for(int posX = xO -1, posY = yO - 1; posX >= xRef && posY >= yRef; posX--, posY--){
                if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY < valorY){
                    xRef = posX;
                    yRef = posY;
                    idRef = peca.getIdEquipa();
                    tipoRef = peca.getIdTipo();
                    pontosRef = peca.getPontos();
                    if (tipoRef == 7){
                        tipoJoker = ((Joker) peca).getTipoJoker();
                    }
                }
            }
            count++;
            if (count == pecasJogo.size()){
                count=0;
                if(xRef != 0 && yRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorY - 1 >= yRef  && valorX - 1>= xRef && count < 5){
                        if (valorY - 1 == yRef && valorX-1 == xRef){
                            jogadaRainha.add(new Sugestao(valorX-1,valorY-1,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(valorX-1,valorY-1,0));
                        }
                        valorX--;
                        valorY--;
                        count++;
                    }
                }else if (yRef != 0 && xRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorY-1 > yRef && valorX-1 > xRef && count < 5) {
                        jogadaRainha.add(new Sugestao(valorX-1,valorY-1,0));
                        valorX--;
                        valorY--;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == 0 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorY - 1 > 0 && valorX - 1 > 0 && count<5){
                                jogadaRainha.add(new Sugestao(valorX-1,valorY-1,0));
                                valorX--;
                                valorY--;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == 0 && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorX - 1 >= 0 && valorY - 1 >= 0 && count < 5){
                                if (valorX - 1 == 0 && valorY-1 == 0){
                                    jogadaRainha.add(new Sugestao(valorX-1,valorY-1,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(valorX-1,valorY-1,0));
                                }
                                valorX--;
                                valorY--;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY - 1 >= 0 && valorX - 1 >= 0&& count<5){
                                jogadaRainha.add(new Sugestao(valorX-1,valorY-1,0));
                                valorX--;
                                valorY--;
                                count++;
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
        tipoRef = -1;
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca : pecasJogo){//diagonal cima direita
            for(int posX = xO +1, posY = yO - 1; posX <= xRef && posY >= yRef; posX++, posY--){
                if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY < valorY){
                    xRef = posX;
                    yRef = posY;
                    idRef = peca.getIdEquipa();
                    tipoRef = peca.getIdTipo();
                    pontosRef = peca.getPontos();
                    if (tipoRef == 7){
                        tipoJoker = ((Joker) peca).getTipoJoker();
                    }
                }
            }
            count++;
            if (count == pecasJogo.size()){
                count=0;
                if(xRef != tamanhoTabuleiro - 1 && yRef != 0 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorY - 1 >= yRef  && valorX +1<= xRef && count < 5){
                        if (valorY-1 == yRef && valorX+1 == xRef){
                            jogadaRainha.add(new Sugestao(valorX+1,valorY-1,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(valorX+1,valorY-1,0));
                        }
                        valorX++;
                        valorY--;
                        count++;
                    }
                }else if (yRef != 0 && xRef != tamanhoTabuleiro - 1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorY-1 > yRef && valorX+1 < xRef && count < 5) {
                        jogadaRainha.add(new Sugestao(valorX+1,valorY-1,0));
                        valorX++;
                        valorY--;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == tamanhoTabuleiro-1 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorY - 1 > 0 && valorX + 1 < tamanhoTabuleiro-1 && count<5){
                                jogadaRainha.add(new Sugestao(valorX+1,valorY-1,0));
                                valorX++;
                                valorY--;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getY()== 0 && pecaFronteira.getX() == tamanhoTabuleiro - 1 && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorX + 1 <= tamanhoTabuleiro - 1 && valorY - 1 >= 0 && count < 5){
                                if (valorX + 1 == tamanhoTabuleiro - 1 && valorY-1 == 0){
                                    jogadaRainha.add(new Sugestao(valorX+1,valorY-1,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(valorX+1,valorY-1,0));
                                }
                                valorX++;
                                valorY--;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY - 1 >= 0 && valorX + 1 <= tamanhoTabuleiro-1 && count<5){
                                jogadaRainha.add(new Sugestao(valorX+1,valorY-1,0));
                                valorX++;
                                valorY--;
                                count++;
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
        tipoRef = -1;
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca : pecasJogo){//diagonal baixo direita
            for(int posX = xO +1, posY = yO + 1; posX <= xRef && posY <= yRef; posX++, posY++){
                if (peca.getX() == posX && peca.getY() == posY && posX > valorX && posY > valorY){
                    xRef = posX;
                    yRef = posY;
                    idRef = peca.getIdEquipa();
                    tipoRef = peca.getIdTipo();
                    pontosRef = peca.getPontos();
                    if (tipoRef == 7){
                        tipoJoker = ((Joker) peca).getTipoJoker();
                    }
                }
            }
            count++;
            if (count == pecasJogo.size()){
                count=0;
                if(xRef != tamanhoTabuleiro-1 && yRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorY + 1 <= yRef  && valorX +1<= xRef && count < 5){
                        if (valorY+1 == yRef && valorX+1 == xRef){
                            jogadaRainha.add(new Sugestao(valorX+1,valorY+1,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(valorX+1,valorY+1,0));
                        }
                        valorX++;
                        valorY++;
                        count++;
                    }
                }else if (yRef != tamanhoTabuleiro-1 && xRef != tamanhoTabuleiro-1 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorY+1 < yRef && valorX+1 < xRef && count < 5) {
                        jogadaRainha.add(new Sugestao(valorX+1,valorY+1,0));
                        valorX++;
                        valorY++;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorY + 1 < tamanhoTabuleiro-1 && valorX + 1 < tamanhoTabuleiro-1 && count<5){
                                jogadaRainha.add(new Sugestao(valorX+1,valorY+1,0));
                                valorX++;
                                valorY++;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getY()== tamanhoTabuleiro - 1 && pecaFronteira.getX() == tamanhoTabuleiro - 1 && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorX + 1 <= tamanhoTabuleiro - 1 && valorY + 1 <= tamanhoTabuleiro - 1 && count < 5){
                                if (valorX + 1 == tamanhoTabuleiro - 1 && valorY+1 == tamanhoTabuleiro - 1){
                                    jogadaRainha.add(new Sugestao(valorX+1,valorY+1,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(valorX+1,valorY+1,0));
                                }
                                valorX++;
                                valorY++;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY + 1 <= tamanhoTabuleiro-1 && valorX + 1 <= tamanhoTabuleiro-1 && count<5){
                                jogadaRainha.add(new Sugestao(valorX+1,valorY+1,0));
                                valorX++;
                                valorY++;
                                count++;
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
        tipoRef = -1;
        tipoJoker = "";
        pontosRef = 0;
        for (CrazyPiece peca : pecasJogo){//diagonal baixo esquerda
            for(int posX = xO - 1, posY = yO + 1; posX >= xRef && posY <= yRef; posX--, posY++){
                if (peca.getX() == posX && peca.getY() == posY && posX < valorX && posY > valorY){
                    xRef = posX;
                    yRef = posY;
                    idRef = peca.getIdEquipa();
                    tipoRef = peca.getIdTipo();
                    pontosRef = peca.getPontos();
                    if (tipoRef == 7){
                        tipoJoker = ((Joker) peca).getTipoJoker();
                    }
                }
            }
            count++;
            if (count == pecasJogo.size()){
                count=0;
                if(xRef != 0 && yRef != tamanhoTabuleiro-1 && idRef != idEquipa && tipoRef!=1 && !(tipoJoker.equals("Rainha"))){
                    while (valorY + 1 <= yRef  && valorX -1>= xRef && count < 5){
                        if (valorY+1 == yRef && valorX-1 == xRef){
                            jogadaRainha.add(new Sugestao(valorX-1,valorY+1,pontosRef));
                        }else{
                            jogadaRainha.add(new Sugestao(valorX-1,valorY+1,0));
                        }
                        valorX--;
                        valorY++;
                        count++;
                    }
                }else if (yRef != tamanhoTabuleiro-1 && xRef != 0 && (idRef == idEquipa || tipoRef == 1 || tipoJoker.equals("Rainha"))) {
                    while (valorY+1 < yRef && valorX-1 > xRef && count < 5) {
                        jogadaRainha.add(new Sugestao(valorX-1,valorY+1,0));
                        valorX--;
                        valorY++;
                        count++;
                    }
                }else{
                    int verificarPecaFronteira = 0;
                    for (CrazyPiece pecaFronteira : pecasJogo){
                        if(pecaFronteira.getY()== tamanhoTabuleiro-1 && pecaFronteira.getX() == tamanhoTabuleiro-1 && (idRef == idEquipa || pecaFronteira.getIdTipo()==1 || (pecaFronteira.getIdTipo() == 7 && ((Joker)pecaFronteira).getTipoJoker().equals("Rainha")))){
                            while (valorY + 1 < tamanhoTabuleiro-1 && valorX - 1 > 0 && count<5){
                                jogadaRainha.add(new Sugestao(valorX-1,valorY+1,0));
                                valorX--;
                                valorY++;
                                count++;
                            }
                            break;
                        }else if(pecaFronteira.getX()== 0 && pecaFronteira.getY() == tamanhoTabuleiro - 1 && idRef != idEquipa && pecaFronteira.getIdTipo()!=1 ){
                            while (valorY + 1 <= tamanhoTabuleiro - 1 && valorX - 1 >= 0 && count < 5){
                                if (valorY + 1 == tamanhoTabuleiro - 1 && valorX-1 == 0){
                                    jogadaRainha.add(new Sugestao(valorX-1,valorY+1,pecaFronteira.getPontos()));
                                }else{
                                    jogadaRainha.add(new Sugestao(valorX-1,valorY+1,0));
                                }
                                valorX--;
                                valorY++;
                                count++;
                            }
                            break;
                        }
                        verificarPecaFronteira ++;
                        if (verificarPecaFronteira == pecasJogo.size()){
                            while (valorY + 1 <= tamanhoTabuleiro-1 && valorX - 1 >= 0 && count<5){
                                jogadaRainha.add(new Sugestao(valorX-1,valorY+1,0));
                                valorX--;
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
            incrementaJogadasInvalidas();
            return false;
        }
        if (abs(xO - xD) != abs(yO - yD) && abs(xO - xD) != 0 && abs(yO - yD) != 0){
            if (idEquipa == 10) {
                estatisticas.adicionaJogadasInvalidasPretas();
            } else {
                estatisticas.adicionaJogadasInvalidasBrancas();
            }
            incrementaJogadasInvalidas();
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
                            incrementaJogadasInvalidas();
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
                            incrementaJogadasInvalidas();
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
                            incrementaJogadasInvalidas();
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
                            incrementaJogadasInvalidas();
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
                        incrementaJogadasInvalidas();
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
                        incrementaJogadasInvalidas();
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
                incrementaJogadasInvalidas();
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