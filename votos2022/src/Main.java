public class Main {
    public static void main(String[] args) {
        Votos votos = new Votos(50, 150, 800);
        float calcPercentualVotosValidos = votos.calcPercentualVotosValidos();
        float calcPercentualVotosBrancos = votos.calcPercentualVotosBrancos();
        float calcPercentualVotosNulos = votos.calcPercentualVotosNulos();

        System.out.println("O percentual de votos válidos é de: "+ calcPercentualVotosValidos + "%");
        System.out.println("O percentual de votos brancos é de: "+ calcPercentualVotosBrancos+ "%");
        System.out.println("O percentual de votos nulos é de: "+ calcPercentualVotosNulos+ "%");
    }
}
