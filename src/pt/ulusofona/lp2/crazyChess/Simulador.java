package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

public class Simulador {
    int tamanhoTabuleiro;
    private int numeroPecas;
    int idEquipaAtual;
    private boolean terminou;
    private int ultimoxO;
    private int ultimoyO;
    private int ultimoxD;
    private int ultimoYD;
    private List<CrazyPiece> pecas = new ArrayList<>();
    List<CrazyPiece> pecasJogo = new ArrayList<>();
    private File ficheiro;
    Estatistica estatisticas;
    InfoJogo jogo;

    public Simulador(){
        this.idEquipaAtual = 10;
        this.terminou = false;
        this.estatisticas = new Estatistica();
        this.jogo = new InfoJogo();
    }

    private void setNumeroPecas(){
        for(CrazyPiece peca: pecasJogo ){
            if(peca.getIdEquipa() == 10){
                jogo.incrementaPecasPretas();
                if (peca.getIdTipo() == 0){
                    jogo.incrementaReisPretos();
                }
            }else{
                jogo.incrementaPecasBrancas();
                if (peca.getIdTipo() == 0){
                    jogo.incrementaReisBrancos();
                }
            }
        }
    }

    public void iniciaJogo(File ficheiroInical) throws IOException {
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
                    if (dados.length != 1){
                        throw new InvalidSimulatorInputException(numLinha, dados.length, 1);
                    }
                    int tamanho = Integer.parseInt(dados[0]);
                    if (tamanho < 4 || tamanho >12){
                        throw new IOException();
                    }else{
                        tamanhoTabuleiro = tamanho;
                    }
                }else if (numLinha == 2){
                    if (dados.length != 1){
                        throw new InvalidSimulatorInputException(numLinha, dados.length, 1);
                    }
                    int numpecas = Integer.parseInt(dados[0]);
                    if (numpecas >= tamanhoTabuleiro*tamanhoTabuleiro){
                        throw new IOException();
                    }else{
                        numeroPecas = numpecas;
                    }
                }else if (numLinha >= 3 && numLinha <= numeroPecas + 2){
                    if (dados.length != 4){
                        throw new InvalidSimulatorInputException(numLinha, dados.length, 4);
                    }
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
                    }else if(tipoPeca == 8) {
                        CrazyPiece peca = new Recruta(idPeca, tipoPeca, idEquipa, alcunha);
                        peca.getValorRelativo();
                        peca.getTipo();
                        pecas.add(peca);
                    }
                }else if (numLinha >= numeroPecas + 3 && numLinha<= numeroPecas + 2 + tamanhoTabuleiro){
                    if (dados.length != tamanhoTabuleiro){
                        throw new InvalidSimulatorInputException(numLinha, dados.length, tamanhoTabuleiro);
                    }
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
                    if (dados.length != 8){
                        throw new InvalidSimulatorInputException(numLinha, dados.length, 8);
                    }
                    idEquipaAtual = Integer.parseInt(dados[0]);
                    estatisticas.setJogadasValidasPretas(Integer.parseInt(dados[1]));
                    estatisticas.setCapturasPretas(Integer.parseInt(dados[2]));
                    estatisticas.setJogadasInvalidasPretas(Integer.parseInt(dados[3]));
                    estatisticas.setJogadasValidasBrancas(Integer.parseInt(dados[4]));
                    estatisticas.setCapturasBrancas(Integer.parseInt(dados[5]));
                    estatisticas.setJogadasInvalidasBrancas(Integer.parseInt(dados[6]));
                    jogo.setTurnosSemCapturas(Integer.parseInt(dados[7]));
                    if (Integer.parseInt(dados[2]) > 0 || Integer.parseInt(dados[5]) > 0){
                        jogo.primeiraCapturaFeita();
                    }
                }
            }
            leitorFicheiro.close();
            setNumeroPecas();
        }
        catch(FileNotFoundException exception) {
            throw new IOException();
        }
    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        int count = 0;
        while(!terminou) {
            if (xO < 0 || xO > tamanhoTabuleiro-1 || yO < 0 || yO > tamanhoTabuleiro-1 || xD < 0 || xD > tamanhoTabuleiro-1 || yD < 0
                    || yD > tamanhoTabuleiro-1 || (xO == xD && yO == yD)) {
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
                        if (jogo.ultimaPecaRemovida != null && jogo.ultimaPecaRemovida.getIdTipo() == 0){
                            if(idEquipaAtual == 10){
                                jogo.decrementaReisBrancos();
                            }else{
                                jogo.decrementaReisPretos();
                            }
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
        if (jogo.getReisPretos() == 0 || jogo.getReisBrancos()== 0 ||(jogo.getPecasBrancas() + jogo.getPecasPretas() == 2 && jogo.getReisBrancos() == 1 && jogo.getReisPretos() == 1) || jogo.getTurnosSemCapturas()== 10){
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
        if(jogo.getReisBrancos() == 0 && jogo.getReisPretos()!=0){
            resultados.add("Resultado: VENCERAM AS PRETAS");
        }else if(jogo.getReisPretos() == 0 && jogo.getReisBrancos()!=0){
            resultados.add("Resultado: VENCERAM AS BRANCAS");
        }else{
            resultados.add("Resultado: EMPATE");
        }
        resultados.add("---");
        resultados.add("Equipa das Pretas");
        resultados.add(" Capturas: " + estatisticas.getCapturasPretas());
        resultados.add(" Jogadas válidas: " + estatisticas.getJogadasValidasPretas());
        resultados.add(" Tentativas inválidas: " + estatisticas.getJogadasInvalidasPretas());
        resultados.add("Equipa das Brancas");
        resultados.add(" Capturas: " + estatisticas.getCapturasBrancas());
        resultados.add(" Jogadas válidas: " + estatisticas.getJogadasValidasBrancas());
        resultados.add(" Tentativas inválidas: " + estatisticas.getJogadasInvalidasBrancas());
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

    List<Comparable> obterSugestoesJogada(int xO, int yO) {
        return null;
    }

    public void anularJogadaAnterior(){ //decrementarTurnosSemCapturas
        if (jogo.getTurno()!=0){
            if (idEquipaAtual ==  10){
                idEquipaAtual = 20;
            }else{
                idEquipaAtual = 10;
            }
            jogo.decrementaTurno();
            if(jogo.ultimaPecaRemovida == null){
                for (CrazyPiece peca: pecasJogo){
                    if(peca.getX() == ultimoxD && peca.getY() == ultimoYD){
                        processaJogada(ultimoxD,ultimoYD,ultimoxO,ultimoyO);
                    }
                }
                if (jogo.obterPecaRecrutada()!= null){
                    jogo.obterPecaRecrutada().setIdEquipa(idEquipaAtual);
                    jogo.setUltimaPecaRecrutada(null);
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
                    if(pecaRemovida.getIdTipo() == 0){
                        jogo.incrementaReisPretos();
                    }
                    for(int i = 0; i<2; i++){
                        estatisticas.decrementaJogadasValidasBrancas();
                    }
                    jogo.incrementaPecasPretas();
                    estatisticas.decrementaCapturasBrancas();
                    idEquipaAtual = 20;
                }else{
                    if(pecaRemovida.getIdTipo() == 0){
                        jogo.incrementaReisBrancos();
                    }
                    for(int i = 0; i<2; i++){
                        estatisticas.decrementaJogadasValidasPretas();
                    }
                    jogo.incrementaPecasBrancas();
                    estatisticas.decrementaCapturasPretas();
                    idEquipaAtual = 10;
                }
                if (jogo.primeiraCapturaFoiEfetuada() && jogo.getTurnoPrimeiraCaptura() == jogo.getTurno()){
                    jogo.setTurnoPrimeiraCaptura(-1);
                    jogo.anularPrimeiraCaptura();
                }else{
                    jogo.setTurnosSemCapturas(jogo.getTurnosAteCaptura());
                }
            }
        }
        jogo.decrementaTurno();
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
                        estatisticas.getJogadasInvalidasBrancas() + ":" + jogo.getTurnosSemCapturas());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            return false;
        }
        return true;
    }

    public Map<String, List<String>> getEstatisticas(){
        Map<String, List<String>> estatisticas = new HashMap<>();
        List<String> listaTop5Capturas =
                pecas.stream()
                        .filter(peca -> peca.getJogadasInvalidas() != 0 || peca.getJogadasValidas() != 0)
                        .sorted(Comparator.comparing(CrazyPiece::getNrCapturas)
                                .reversed()
                                .thenComparing(CrazyPiece::getAlcunha))
                        .limit(5)
                        .map(peca -> peca.toString5())
                        .collect(toList());
        estatisticas.put("top5Capturas", listaTop5Capturas);

        List<String> listaTop5Pontos =
                pecas.stream()
                        .filter(peca -> peca.getJogadasInvalidas() != 0 || peca.getJogadasValidas() != 0)
                        .sorted(Comparator.comparing(CrazyPiece::getNrPontos)
                                .reversed()
                                .thenComparing(CrazyPiece::getAlcunha))
                        .limit(5)
                        .map(peca -> peca.toString5())
                        .collect(toList());
        estatisticas.put("top5Pontos", listaTop5Pontos);

        List<String> listaPecasMais5Capturas =
                pecas.stream()
                        .filter(peca -> peca.getNrCapturas() > 5)
                        .map(peca -> peca.toString5())
                        .collect(toList());
        estatisticas.put("pecasMais5Capturas", listaPecasMais5Capturas);

        List<String> listaPecasMaisBaralhadas =
                pecas.stream()
                        .filter(peca -> peca.getJogadasInvalidas() != 0 || peca.getJogadasValidas() != 0)
                        .sorted((peca1 , peca2) -> (peca2.getJogadasInvalidas()/(peca2.getJogadasValidas() + peca2.getJogadasInvalidas())) - (peca1.getJogadasInvalidas()/(peca1.getJogadasValidas() + peca1.getJogadasInvalidas())))
                        .limit(3)
                        .map(peca -> peca.toStringPecasMaisBaralhadas())
                        .collect(toList());
        estatisticas.put("3PecasMaisBaralhadas", listaPecasMaisBaralhadas);

        List<String> listatiposPecaCapturados =
                pecas.stream()
                        .filter(peca -> peca.getNrCapturas() > 0)
                        .map(peca -> peca.toStringTiposPecaCapturados())
                        .collect(toList());
        estatisticas.put("tiposPecaCapturados", listatiposPecaCapturados);
        return estatisticas;
    }
}