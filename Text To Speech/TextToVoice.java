package texttovoice.principal;
import texttovoice.principal.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
public class TextToVoice extends Activity implements OnInitListener {
    /** Called when the activity is first created. */
	private EditText text;
	private Button texttovoice;
	private TextToSpeech talker;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text=(EditText)findViewById(R.id.text); //public View findViewById (int R.layout.main) --> import android.view.View;
        text.setGravity(0x01);
        texttovoice=(Button)findViewById(R.id.texttovoice);
        texttovoice.setGravity(0x01);
        talker=new TextToSpeech (this, this);
        texttovoice.setOnClickListener(new View.OnClickListener(){
        			public void onClick(View view){
        				try{
        					String aux=text.getText().toString();
        					talker.speak(aux, TextToSpeech.QUEUE_FLUSH, null);     					
         				}catch (NumberFormatException nfe){
        					text.setText("");
        				}
        			}
        		});
    }
	@Override
    public void onDestroy(){
    	if (talker !=null){
    		talker.stop();
    		talker.shutdown();
    	}
    	super.onDestroy();
    }
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
}