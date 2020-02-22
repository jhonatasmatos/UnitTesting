import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Aluno.class)
public class AlunoTest {

    private double mediaUm;
    private double mediaDois;
    private double mediaTres;
    private double mediaQuatro;

    @Test
    public void testCalculaMediaBimestre(){
        //Preparaçao
        Aluno aluno = new Aluno();
        double expect = 5;
        double resultado;

        //Execuçao
        resultado = aluno.calcularMediaBimestre(1, 5, 5, 5, 5);

        //Comparaçao
        Assert.assertEquals(expect,resultado, 0);
    }

    @Test
    public void testAlunoSemMediaNoBimestre(){
        //Preparaçao
        Aluno aluno = new Aluno();
        double expect = 0;
        double resultado;

        //Execuçao
        resultado = aluno.calcularMediaBimestre(0, 0, 0, 0, 0);

        //Comparaçao
        Assert.assertEquals(expect,resultado, 0);
    }

    @Test
    public void testeAlunoAprovadoNotaMaiorQueSete() throws Exception {

        //Preparaçao
        Aluno aluno = new Aluno();
        String expect = "APROVADO";
        String resultado;

        //Execuçao
        mediaUm = aluno.calcularMediaBimestre(1, 6, 6, 6, 10);
        mediaDois = aluno.calcularMediaBimestre(2, 10, 10, 8, 0);
        mediaTres = aluno.calcularMediaBimestre(3, 5, 7, 10, 6);
        mediaQuatro = aluno.calcularMediaBimestre(4, 0, 10, 8, 10);

        resultado = aluno.calcularAprovacaoDoAluno(mediaUm, mediaDois, mediaTres, mediaQuatro);

        //Comparaçao
        Assert.assertEquals(expect,resultado);
    }

    @Test
    public void testeAlunoAprovadoNotaIgualSete() throws Exception {

        //Preparaçao
        Aluno aluno = new Aluno();
        String expect = "APROVADO";
        String resultado;

        //Execuçao
        mediaUm = aluno.calcularMediaBimestre(1, 5, 5, 5, 5);
        mediaDois = aluno.calcularMediaBimestre(2, 8, 10, 9, 10);
        mediaTres = aluno.calcularMediaBimestre(3, 9, 4, 9, 8);
        mediaQuatro = aluno.calcularMediaBimestre(4, 5, 7, 7, 8);

        resultado = aluno.calcularAprovacaoDoAluno(mediaUm, mediaDois, mediaTres, mediaQuatro);

        //Comparaçao
        Assert.assertEquals(expect,resultado);
    }

    @Test
    public void testCalculaRecuperacaoDoAluno() throws Exception {

        //Preparaçao
        Aluno aluno = new Aluno();
        String expect = "RECUPERACAO";
        String resultado;

        //Execuçao
        mediaUm = aluno.calcularMediaBimestre(1, 3, 3, 4, 5);
        mediaDois = aluno.calcularMediaBimestre(2, 8, 10, 9, 10);
        mediaTres = aluno.calcularMediaBimestre(3, 9, 4, 9, 8);
        mediaQuatro = aluno.calcularMediaBimestre(4, 5, 7, 7, 8);

        resultado = aluno.calcularAprovacaoDoAluno(mediaUm, mediaDois, mediaTres, mediaQuatro);

        //Comparaçao
        Assert.assertEquals(expect,resultado);
    }

    @Test
    public void testCalculaRecuperacaoDoAlunoNotaCinco() throws Exception {

        //Preparaçao
        Aluno aluno = new Aluno();
        String expect = "RECUPERACAO";
        String resultado;

        //Execuçao
        mediaUm = aluno.calcularMediaBimestre(1, 5, 5, 5, 5);
        mediaDois = aluno.calcularMediaBimestre(2, 10, 10, 0, 0);
        mediaTres = aluno.calcularMediaBimestre(3, 10, 5, 5, 0);
        mediaQuatro = aluno.calcularMediaBimestre(4, 10, 0, 9, 1);

        resultado = aluno.calcularAprovacaoDoAluno(mediaUm, mediaDois, mediaTres, mediaQuatro);

        //Comparaçao
        Assert.assertEquals(expect,resultado);
    }

    @Test
    public void testMediaBimestreComZero() throws Exception {

        //Preparaçao
        Aluno aluno = new Aluno();
        String expect = "REPROVADO";
        String resultado;

        //Execuçao
        mediaUm = aluno.calcularMediaBimestre(1, 0, 0, 0, 0);
        mediaDois = aluno.calcularMediaBimestre(2, 0, 0, 0, 0);
        mediaTres = aluno.calcularMediaBimestre(3, 0, 0, 0, 0);
        mediaQuatro = aluno.calcularMediaBimestre(4, 0, 0, 0, 0);

        resultado = aluno.calcularAprovacaoDoAluno(mediaUm, mediaDois, mediaTres, mediaQuatro);

        //Comparaçao
        Assert.assertEquals(expect,resultado);
    }

    @Test
    public void testAlunoReprovadoDireto() throws Exception {

        //Preparaçao
        Aluno aluno = new Aluno();
        String expect = "REPROVADO";
        String resultado;

        //Execuçao
        mediaUm = aluno.calcularMediaBimestre(1, 3, 3, 4, 5);
        mediaDois = aluno.calcularMediaBimestre(2, 1, 2, 1, 10);
        mediaTres = aluno.calcularMediaBimestre(3, 5, 4, 3, 8);
        mediaQuatro = aluno.calcularMediaBimestre(4, 5, 2, 7, 8);

        resultado = aluno.calcularAprovacaoDoAluno(mediaUm, mediaDois, mediaTres, mediaQuatro);

        //Comparaçao
        Assert.assertEquals(expect,resultado);
    }

    @Test
    public void testAlunoAprovadoReforcoNotaSete() throws Exception {

        //Preparaçao
        Aluno alunoMock =  new Aluno();
        double expect = 7;
        double actual = 0;
        final String METHOD="getMediaFinal";

        Aluno spy = PowerMockito.spy(alunoMock);
        PowerMockito.when(spy, METHOD).thenReturn(7.0);

        //Execuçao
        actual = spy.realizarReforco(7.0);

        //Comparação
        Assert.assertEquals(expect, actual, 0);
        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke("getMediaFinal");
    }

    @Test
    public void testAlunoAprovadoReforcoNotaMaiorQueSete() throws Exception {

        //Preparaçao
        Aluno alunoMock =  new Aluno();
        double expect = 10;
        double actual = 0;
        final String METHOD="getMediaFinal";

        Aluno spy = PowerMockito.spy(alunoMock);
        PowerMockito.when(spy, METHOD).thenReturn(10.0);

        //Execuçao
        actual = spy.realizarReforco(10.0);

        //Comparação
        Assert.assertEquals(expect, actual, 0);
        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke("getMediaFinal");
    }

    @Test
    public void testAlunoReprovadoReforco() throws Exception {

        //Preparaçao
        Aluno alunoMock =  new Aluno();
        double expect = 6;
        double actual = 0;
        final String METHOD="getMediaFinal";

        Aluno spy = PowerMockito.spy(alunoMock);
        PowerMockito.when(spy, METHOD).thenReturn(6.0);

        //Execuçao
        actual = spy.realizarReforco(6.0);

        //Comparação
        Assert.assertEquals(expect, actual, 0);
        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke("getMediaFinal");
    }

}