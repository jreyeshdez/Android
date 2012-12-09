package conversor.principal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ConversorMoneda extends Activity {
    /** Called when the activity is first created. */
	private EditText cantidad;
	private Button botonE, botonP;
	private TextView etiquetaE, etiquetaP;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cantidad=(EditText)findViewById(R.id.cantidad); //public View findViewById (int R.layout.main) --> import android.view.View;
        botonE=(Button)findViewById(R.id.botonE);
        botonP=(Button)findViewById(R.id.botonP);
        etiquetaE=(TextView)findViewById(R.id.etiquetaE);
        etiquetaP=(TextView)findViewById(R.id.etiquetaP);
        
        botonE.setOnClickListener(new 
        		View.OnClickListener(){
        			public void onClick(View view){
        				try{
        					String aux=cantidad.getText().toString();
        					double valor=Double.parseDouble(aux);
        					valor=valor/166.386;
        					etiquetaE.setText("Euros: "+valor);
        				}catch (NumberFormatException nfe){
        					cantidad.setText("");
        				}
        				
        			}
        		});
        botonP.setOnClickListener(new 
        		View.OnClickListener(){
        			public void onClick(View view){
        				try{
        					String aux=cantidad.getText().toString();
        					double valor=Double.parseDouble(aux);
        					valor=valor*166.386;
        					etiquetaP.setText("Pesetas: "+valor);
        				}catch(NumberFormatException nfe){
        					cantidad.setText("");
        				}
        		
        			}
        		});
    }
    @Override
    public void onPause(){
    	super.onPause();
    	setResult(RESULT_OK);
    	finish();
    }
}