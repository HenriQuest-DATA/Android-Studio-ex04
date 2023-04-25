package henrique.uniara.desenvolvimentomobile.atividade4;

public class DadosJuros {
    public float valorMensal;
    public float valorCiclo;
    public int qtdeMesesInvestimento;
    public int qtdeMesesCiclo;
    public float porcentagemRetorno;
    public float saldoInicial;

    public DadosJuros(
            float VM,
            float VC,
            int QMI,
            int QMC,
            float PR,
            float SI
    ) {
        valorMensal = VM;
        valorCiclo = VC;
        qtdeMesesInvestimento = QMI;
        qtdeMesesCiclo = QMC;
        porcentagemRetorno = PR;
        saldoInicial = SI;
    }
}
