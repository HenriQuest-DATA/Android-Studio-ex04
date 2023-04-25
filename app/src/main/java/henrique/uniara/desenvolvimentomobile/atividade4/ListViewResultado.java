package henrique.uniara.desenvolvimentomobile.atividade4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_resultado);

        carregarListView();
    }

    public void carregarListView(){
        ArrayList<String> dados = (ArrayList<String>) getIntent().getSerializableExtra("dados");
        ListView listResultados = findViewById(R.id.listArrayJurosMeses);

        ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, dados
        );

        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listResultados.setAdapter(dateAdapter);


    }
}