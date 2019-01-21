package pt.ulusofona.lp2.crazyChess;

public class Sugestao implements Comparable<Sugestao> {

    int x;
    int y;
    int nrPontos;

    Sugestao(int x, int y, int nrPontos){
        this.x = x;
        this.y = y;
        this.nrPontos = nrPontos;
    }

    public int compareTo(Sugestao sugestao) {
        if(this.nrPontos == sugestao.nrPontos){
            return 0;
        }

        if (this.nrPontos < sugestao.nrPontos){
            return 1;
        }else{
            return -1;
        }
    }

    public String toString() {
        if(nrPontos == 1000){
            return x + ", " + y + ", (infinito)";
        }else{
            return x + ", " + y + ", " + nrPontos;
        }
    }
}
