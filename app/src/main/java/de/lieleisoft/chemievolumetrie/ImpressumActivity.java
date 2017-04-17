package de.lieleisoft.chemievolumetrie;


import android.app.Activity;
import android.os.Bundle;
import de.lieleisoft.chemievolumetrie.R;

public class ImpressumActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.impressum);	  
     	
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);     	
    }	
    
	@Override
	public void onResume() 
	{
		super.onResume();
	}
}