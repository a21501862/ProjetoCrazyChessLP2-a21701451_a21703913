package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    int tamanhoTabuleiro;
    int numeroPecas;
    int idEquipaAtual;
    boolean terminou;
    int ultimoxO;
    int ultimoyO;
    int ultimoxD;
    int ultimoYD;
    List<CrazyPiece> pecas = new ArrayList<>();
    List<CrazyPiece> pecasJogo = new ArrayList<>();
    File ficheiro;
    Estatistica estatisticas;
    InfoJogo jogo;

    public Simulador(){
        this.idEquipaAtual = 10;
        this.terminou = false;
        this.estatisticas = new Estatistica();
        this.jogo = new InfoJogo();
    }

    public void setNumeroPecas(){
        for(CrazyPiece peca: pecasJogo ){
            if(peca.getIdEquipa() == 10){
                jogo.incrementaPecasPretas();
            }else{
                jogo.incrementaPecasBrancas();
            }
        }
    }

    public boolean iniciaJogo(File ficheiroInical){
        estatisticas.limpar();
        tamanhoTabuleiro = 0;
        numeroPecas = 0;
        idEquipaAtual = 10;
        pecas.clear();
        pecasJogo.clear();
        jogo.limpar();
        ficheiro = ficheiroInical;
        try {
            Scanner leitorFicheiro = new Scanner(ficheiro);
            int numLinha = 0;
            int linhaTabuleiro = 0;
            while(leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(":");
                numLinha ++;
                if (numLinha == 1){
                    int tamanho = Integer.parseInt(dados[0]);
                    if (tamanho < 4 || tamanho >12){
                        return false;
                    }else{
                        tamanhoTabuleiro = tamanho;
                    }
                }else if (numLinha == 2){
                    int numpecas = Integer.parseInt(dados[0]);
                    if (numpecas >= tamanhoTabuleiro*tamanhoTabuleiro){
                        return false;
                    }else{
                        numeroPecas = numpecas;
                    }
                }else if (numLinha >= 3 && numLinha <= numeroPecas + 2){
                    int idPeca = Integer.parseInt(dados[0]);
                    int tipoPeca = Integer.parseInt(dados[1]);
                    int idEquipa = Integer.parseInt(dados[2]);
                    String alcunha = dados[3];
                    if (tipoPeca == 0){
                        CrazyPiece peca = new Rei(idPeca,tipoPeca,idEquipa,alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if (tipoPeca == 1) {
                        CrazyPiece peca = new Rainha(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if (tipoPeca == 2) {
                        CrazyPiece peca = new PoneiMagico(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if (tipoPeca == 3) {
                        CrazyPiece peca = new PadreDaVila(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 4){
                        CrazyPiece peca = new TorreHor(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 5){
                        CrazyPiece peca = new TorreVert(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 6){
                        CrazyPiece peca = new Lebre(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }else if(tipoPeca == 7){
                        CrazyPiece peca = new Joker(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }
                }else if (numLinha >= numeroPecas + 3 && numLinha<= numeroPecas + 2 + tamanhoTabuleiro){
                    for (int colunaTabuleiro = 0; colunaTabuleiro < tamanhoTabuleiro; colunaTabuleiro++){
                        int id = Integer.parseInt(dados[colunaTabuleiro]);
                        for (CrazyPiece peca : pecas){
                            if (peca.getId() == id){
                                peca.definirCoordenadas(colunaTabuleiro,linhaTabuleiro);
                                pecasJogo.add(peca);
                            }
                        }
                    }
                    linhaTabuleiro ++;
                }else if(numLinha == numeroPecas + 3 + tamanhoTabuleiro){
                    idEquipaAtual = Integer.parseInt(dados[0]);
                    estatisticas.setJogadasValidasPretas(Integer.parseInt(dados[1]));
                    estatisticas.setCapturasPretas(Integer.parseInt(dados[2]));
                    estatisticas.setJogadasInvalidasPretas(Integer.parseInt(dados[3]));
                    estatisticas.setJogadasValidasBrancas(Integer.parseInt(dados[4]));
                    estatisticas.setCapturasBrancas(Integer.parseInt(dados[5]));
                    estatisticas.setJogadasInvalidasBrancas(Integer.parseInt(dados[6]));
                }
            }
            leitorFicheiro.close();
            if (pecasJogo.size() < numeroPecas){
                numeroPecas = pecasJogo.size();
            }
            setNumeroPecas();
            if ((numeroPecas == 2 && jogo.getPecasBrancas() == 0 && jogo.getPecasPretas() == 0) || (numeroPecas == 0)){
                terminou=true;
            }
            if (jogo.getPecasBrancas() == 0 || jogo.getPecasPretas() == 0){
                terminou=true;
            }
            return true;
        }
        catch(FileNotFoundException exception) {
            System.out.println("Erro: o ficheiro não foi encontrado.");
            return false;
        }
    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        int count = 0;
        if (terminou){
            return true;
        }
        while(!terminou) {
            if (xO < 0 || xO > tamanhoTabuleiro-1 || yO < 0 || yO > tamanhoTabuleiro-1 || xD < 0 || xD > tamanhoTabuleiro-1 || yD < 0
                    || yD > tamanhoTabuleiro-1) {
                if (idEquipaAtual == 10) {
                    estatisticas.adicionaJogadasInvalidasPretas();
                } else {
                    estatisticas.adicionaJogadasInvalidasBrancas();
                }
                return false;
            }
            for (CrazyPiece peca: pecasJogo) {
                if (peca.getIdEquipa() == idEquipaAtual && peca.getX() == xO && peca.getY() == yO) {
                    if (peca.movePeca(xO,yO,xD,yD,estatisticas,pecasJogo,jogo)){
                        peca.definirCoordenadas(xD, yD);
                        if (jogo.primeiraCapturaFoiEfetuada()) {
                            jogo.incrementaTurnoSemCapturas();
                        }
                        if (idEquipaAtual == 10) {
                            estatisticas.adicionaJogadasValidasPretas();
                            idEquipaAtual = 20;
                        } else {
                            estatisticas.adicionaJogadasValidasBrancas();
                            idEquipaAtual = 10;
                        }
                        jogo.incrementarTurno();
                        for (CrazyPiece verificaJoker : pecasJogo){
                            if (verificaJoker.getIdTipo() == 7){
                                ((Joker) verificaJoker).mudaTipoJoker();
                            }
                        }
                        ultimoxO = xO;
                        ultimoxD = xD;
                        ultimoyO = yO;
                        ultimoYD = yD;
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    count ++;
                    if (count == pecasJogo.size()) {
                        if (idEquipaAtual == 10) {
                            estatisticas.adicionaJogadasInvalidasPretas();
                        } else {
                            estatisticas.adicionaJogadasInvalidasBrancas();
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<CrazyPiece> getPecasMalucas(){
        return pecas;
    }

    public boolean jogoTerminado(){
        if (jogo.getPecasPretas() == 0 || jogo.getPecasBrancas()== 0 ||  jogo.getTurnosSemCapturas()== 10){
            terminou = true;
            return true;
        }else{
            return false;
        }
    }

    public List<String> getAutores(){
        List<String> autores = new ArrayList<>();
        String nomeFicheiro = "AUTHORS.txt";
        try {
            File ficheiro = new File(nomeFicheiro);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while(leitorFicheiro.hasNextLine()) {
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(";");
                String autor = dados[1];
                autores.add(autor);
            }
            leitorFicheiro.close();
        }
        catch(FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiro + " nao foi encontrado.";
            System.out.println(mensagem);
        }
        return autores;
    }

    public List<String> getResultados(){
        List<String> resultados = new ArrayList<>();
        resultados.add("JOGO DE CRAZY CHESS");
        if(jogo.getPecasBrancas() == 0){
            resultados.add("Resultado: VENCERAM AS PRETAS");
        }else if(jogo.getPecasPretas() == 0){
            resultados.add("Resultado: VENCERAM AS BRANCAS");
        }else{
            resultados.add("Resultado: EMPATE");
        }
        resultados.add("---");
        resultados.add("Equipa das Pretas");
        resultados.add(" Capturas: " + estatisticas.getCapturasPretas());
        resultados.add(" Jogadas válidas: " + estatisticas.getJogadasValidasPretas());
        resultados.add(" Tentativas inválidas:" + estatisticas.getJogadasInvalidasPretas());
        resultados.add("Equipa das Brancas");
        resultados.add(" Capturas: " + estatisticas.getCapturasBrancas());
        resultados.add(" Jogadas válidas: " + estatisticas.getJogadasValidasBrancas());
        resultados.add(" Tentativas inválidas:" + estatisticas.getJogadasInvalidasBrancas());
        return resultados;
    }

    public int getIDPeca(int x, int y){
        for (CrazyPiece peca: pecasJogo){
            if (peca.getX() == x &&  peca.getY() == y){
                return peca.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        return idEquipaAtual;
    }

    public List<String> obterSugestoesJogada(int xO, int yO) {
        List <String> sugestoes = new ArrayList<>();
        int count = 0;
        for (CrazyPiece peca: pecasJogo){
            if ((peca.getIdTipo() == 6 && jogo.getTurno()%2!= 0) || (peca.getIdTipo()==7 && ((Joker)peca).getTipoJoker().equals("Lebre") && jogo.getTurno()%2!= 0) ){
                break;
            }
            if (peca.getX() == xO && peca.getY() == yO && peca.getIdEquipa() == getIDEquipaAJogar()){
                sugestoes = peca.sugerirJogadas(xO,yO,pecasJogo,tamanhoTabuleiro);
                break;
            }
            count++;
            if (count == pecasJogo.size()){
                sugestoes.add("Pedido inválido");
            }
        }
        return sugestoes;
    }

    public void anularJogadaAnterior(){ //decrementarTurnosSemCapturas
        if (jogo.getTurno()!=0){
            if (idEquipaAtual ==  10){
                idEquipaAtual = 20;
            }else{
                idEquipaAtual = 10;
            }
            if(jogo.ultimaPecaRemovida == null){
                for (CrazyPiece peca: pecasJogo){
                    if(peca.getX() == ultimoxD && peca.getY() == ultimoYD){
                        processaJogada(ultimoxD,ultimoYD,ultimoxO,ultimoyO);
                    }
                }
                if (idEquipaAtual ==  10){
                    for(int i = 0; i<2; i++){
                        estatisticas.decrementaJogadasValidasBrancas();
                    }
                    idEquipaAtual = 20;
                }else{
                    for(int i = 0; i<2; i++){
                        estatisticas.decrementaJogadasValidasPretas();
                    }
                    idEquipaAtual = 10;
                }
                if (jogo.getTurnosSemCapturas() != 0 && jogo.primeiraCapturaEfetuada){
                    for(int i = 0; i<2; i++){
                        jogo.decrementaTurnoSemCapturas();
                    }
                }
            }else{
                CrazyPiece pecaRemovida = jogo.obterPeca();
                pecaRemovida.anularCaptura();
                pecasJogo.add(pecaRemovida);
                jogo.setUltimaPecaCapturada(null);
                for (CrazyPiece peca: pecasJogo){
                    if(peca.getX() == ultimoxD && peca.getY() == ultimoYD){
                        processaJogada(ultimoxD,ultimoYD,ultimoxO,ultimoyO);
                    }
                }
                if (idEquipaAtual ==  10){
                    for(int i = 0; i<2; i++){
                        estatisticas.decrementaJogadasValidasBrancas();
                    }
                    jogo.incrementaPecasPretas();
                    estatisticas.decrementaCapturasBrancas();
                    idEquipaAtual = 20;
                }else{
                    for(int i = 0; i<2; i++){
                        estatisticas.decrementaJogadasValidasPretas();
                    }
                    jogo.incrementaPecasBrancas();
                    estatisticas.decrementaCapturasPretas();
                    idEquipaAtual = 10;
                }
                if (jogo.primeiraCapturaFoiEfetuada() && jogo.getTurnoPrimeiraCaptura() == jogo.getTurno()-1){
                    jogo.setTurnoPrimeiraCaptura(-1);
                    jogo.anularPrimeiraCaptura();
                }else{
                    jogo.setTurnosSemCapturas(jogo.getTurnosAteCaptura());
                }
            }
            jogo.decrementaTurno();
        }
    }

    public boolean gravarJogo(File ficheiroDestino) {
        ficheiro = ficheiroDestino;
        String newLine = System.getProperty( "line.separator" );
        int numeroLinha = 1;
        int linhaTabuleiro = 0;
        try {
            FileWriter writer = new FileWriter(ficheiro);
            if (numeroLinha == 1){
                writer.write(tamanhoTabuleiro + "");
                writer.write(newLine);
                numeroLinha ++;
            }
            if(numeroLinha == 2){
                writer.write(numeroPecas + "");
                writer.write(newLine);
                numeroLinha ++;
            }
            while(numeroLinha >= 3 && numeroLinha <= numeroPecas + 2){
                for (CrazyPiece peca : pecas){
                    writer.write(peca.getId() + ":" + peca.getIdTipo() + ":" + peca.getIdEquipa() + ":" + peca.getAlcunha());
                    writer.write(newLine);
                    numeroLinha++;
                }
            }
            while (numeroLinha >= numeroPecas + 3 && numeroLinha<= numeroPecas + 2 + tamanhoTabuleiro){
                for (int colunaTabuleiro = 0; colunaTabuleiro < tamanhoTabuleiro; colunaTabuleiro++){
                    int count = 0;
                    for (CrazyPiece peca : pecasJogo){
                        if (peca.getX() == colunaTabuleiro && peca.getY()== linhaTabuleiro){
                            if (colunaTabuleiro == tamanhoTabuleiro - 1){
                                writer.write(peca.getId() + "");
                            }else{
                                writer.write(peca.getId() + ":");
                            }
                        }else{
                            count++;
                        }
                    }
                    if (count == pecasJogo.size()){
                        if (colunaTabuleiro == tamanhoTabuleiro - 1){
                            writer.write(Integer.toString(0));
                        }else{
                            writer.write("0:");
                        }
                    }
                }
                writer.write(newLine);
                linhaTabuleiro++;
                numeroLinha++;
            }
            if(numeroLinha== numeroPecas + 3 + tamanhoTabuleiro){
                writer.write(idEquipaAtual + ":" + estatisticas.getJogadasValidasPretas() + ":" + estatisticas.getCapturasPretas()
                        + ":" + estatisticas.getJogadasInvalidasPretas() + ":" + estatisticas.getJogadasValidasBrancas() + ":" + estatisticas.getCapturasBrancas() + ":" +
                        estatisticas.getJogadasInvalidasBrancas());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            return false;
        }
        return true;
    }
}