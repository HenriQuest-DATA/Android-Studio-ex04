package henrique.uniara.desenvolvimentomobile.atividade4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBotaoLoginClickListener();
    }

    public void addBotaoLoginClickListener() {
        Button btnLogin = (Button) findViewById(R.id.btnCalcular);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                EditText valorMensalContent = findViewById(R.id.editTextValorMensal);
                Float valorMensal = Float.parseFloat(getValueFromInput(valorMensalContent));

                EditText valorCicloContent = findViewById(R.id.editTextValorCiclo);
                Float valorCiclo = Float.parseFloat(getValueFromInput(valorCicloContent));

                EditText qtdeMesesInvestimentoContent = findViewById(R.id.editTextQtdeMesesInvestimento);
                Integer qtdeMesesInvestimento = Integer.parseInt(getValueFromInput(qtdeMesesInvestimentoContent));

                EditText qtdeMesesCicloContent = findViewById(R.id.editTextQtdeMesesCiclo);
                Integer qtdeMesesCiclo = Integer.parseInt(getValueFromInput(qtdeMesesCicloContent));

                EditText porcentagemRetornoContent = findViewById(R.id.editTextPorcentagemRetorno);
                Float porcentagemRetorno = Float.parseFloat(getValueFromInput(porcentagemRetornoContent));

                EditText saldoInicialContent = findViewById(R.id.editTextSaldoInicial);
                Float saldoInicial = Float.parseFloat(getValueFromInput(saldoInicialContent));

                DadosJuros dadosJuros = new DadosJuros(
                        valorMensal,
                        valorCiclo,
                        qtdeMesesInvestimento,
                        qtdeMesesCiclo,
                        porcentagemRetorno,
                        saldoInicial
                );

                ArrayList<String> Resultado = calcularJurosPorMeses(dadosJuros);

                setContentView(R.layout.list_view_resultado);

                abrirNovaAtividadeCarregandoLista(Resultado);

            }

        });
    };

    public String getValueFromInput(EditText CampoTexto) {
        return CampoTexto.getText().toString();
    };

    public ArrayList calcularJurosPorMeses(DadosJuros dados) {
        float jurosCalc = (dados.porcentagemRetorno / 100);
        float saldo = 0;
        ArrayList<String> ListaMeses = new ArrayList<>();
        for (int i = 0; i < dados.qtdeMesesCiclo; i++) {
            if(i == 0) { saldo = dados.saldoInicial; }
            float juros = saldo * jurosCalc;
            saldo = saldo + (saldo * juros);
            String result = "Mês: "+(i+1)+" - Juros sobre Saldo: R$ "+juros+" - Saldo: "+saldo;
            ListaMeses.add(result);

        }

        return ListaMeses;

    };

    public void abrirNovaAtividadeCarregandoLista(ArrayList<String> Resultado) {
        Intent intent = new Intent(this, ListViewResultado.class);
        intent.putExtra("dados", Resultado);
        startActivity(intent);

    }

}