public class Aluno {
    private double mediaBimestre;
    private double mediaFinal;
    private String aprovado;


    public double calcularMediaBimestre(int bimestre, double notaUm, double notaDois, double notaTres, double notaQuatro) {
        double media = 0;

        media = (notaUm + notaDois + notaTres + notaQuatro)/4;

        if(media != 0){
            setMediaBimestre(media);
            System.out.print(" Média do bimestre " + bimestre + " : " + media);
        } else {
            setMediaBimestre(media);
            System.out.print(" Aluno sem média no bimestre " + bimestre + " : " + media);
        }

        return getMediaBimestre();
    }

    public String calcularAprovacaoDoAluno(double notaPrimeiroBimestre,
                                           double notaSegundoBimestre,
                                           double notaTerceiroBimestre,
                                           double notaQuartoBimestre){

        mediaFinal = (notaPrimeiroBimestre + notaSegundoBimestre + notaTerceiroBimestre + notaQuartoBimestre)/4;
        setMediaFinal(mediaFinal);

        if (mediaFinal >= 7){
            aprovado = "APROVADO";
            System.out.print(" Aluno aprovado direto ");
        } else if (mediaFinal >= 5 && mediaFinal < 7){
            aprovado = "RECUPERACAO";
            System.out.print(" Aluno está de recuperação ");
        } else {
            aprovado = "REPROVADO";
            System.out.print(" Aluno reprovado direto ");
        }
        return aprovado;
    }

    public double realizarReforco(double notaRecuperacao){
        double media = 0;

        media = (notaRecuperacao + getMediaFinal())/2;

        if (media >= 7){
            System.out.print("APROVADO");
        } else {
            System.out.print("REPROVADO");
        }
        return media;
    }


    public double getMediaBimestre() {
        return mediaBimestre;
    }

    public void setMediaBimestre(double mediaBimestre) {
        this.mediaBimestre = mediaBimestre;
    }

    public double getMediaFinal() {
        return mediaBimestre;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaBimestre = mediaBimestre;
    }
}