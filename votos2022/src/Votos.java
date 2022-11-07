public class Votos {
    private float totalEleitores;

    private float votosValidos;

    private float votosBrancos;

    private float votosNulos;

    public Votos(float votosNulos, float votosBrancos, float votosValidos){
        this.votosNulos = votosNulos;
        this.votosBrancos = votosBrancos;
        this.votosValidos = votosValidos;

        this.totalEleitores = votosBrancos + votosNulos + votosValidos;
    }

    public float calcPercentualVotosValidos(){
        return votosValidos * 100 / totalEleitores;
    }

    public float calcPercentualVotosBrancos(){
        return votosBrancos * 100 / totalEleitores;
    }

    public float calcPercentualVotosNulos(){
        return votosNulos * 100 / totalEleitores;
    }


}
