package br.com.comparapreo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private viewHolder viewHolder = new viewHolder();
    private SecurityPreferences securityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        securityPreferences = new SecurityPreferences(MainActivity.this);

        this.viewHolder.etanolEdt = (EditText) findViewById(R.id.etanolEdt);
        this.viewHolder.gasEdt = (EditText) findViewById(R.id.gasEdt);
        this.viewHolder.calcBtn = (Button) findViewById(R.id.calcBtn);

        this.viewHolder.calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etanol = MainActivity.this.viewHolder.etanolEdt.getText().toString();
                String gas = MainActivity.this.viewHolder.gasEdt.getText().toString();

                Combustivel combustivel = criaCombustivel(etanol, gas);
                insereInformacao(combustivel);
                lerDados();

            }
        });
    }

        public void insereInformacao(Combustivel combustivel){
            securityPreferences.guardaString("ETANOL", combustivel.getEtanol());
            securityPreferences.guardaString("GAS", combustivel.getGas());
        }
        public static class viewHolder{
            EditText etanolEdt;
            EditText gasEdt;
            Button calcBtn;
        }
        private Combustivel criaCombustivel(String etanol, String gas){
            Combustivel combustivel = new Combustivel();
            combustivel.setEtanol(etanol);
            combustivel.setGas(etanol);
            return combustivel;
        }

        public void calcular(double valorDoAlcool, double valorDagasolina){
            if(valorDoAlcool <= valorDagasolina*0.7){
                imprimir("Alcool é melhor");
            } else {
                imprimir("Gasolina é melhor");
            }

         }

         public void imprimir(String text){
             Toast.makeText(MainActivity.this,text, Toast.LENGTH_LONG).show();
         }

         public void lerDados(){
            String etanol = securityPreferences.recuperaString("ETANOL");
            String gas = securityPreferences.recuperaString("GAS");
            calcular(Double.parseDouble(etanol), Double.parseDouble(gas));
         }
}
