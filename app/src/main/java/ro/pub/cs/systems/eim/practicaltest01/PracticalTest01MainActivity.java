package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button button1, button2, startIntentButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        public void onClick(View view) {
            Button b = (Button)view;
            if (b == button1) {
                int value = Integer.parseInt(editText1.getText().toString());
                editText1.setText(Integer.toString(value + 1));
            } else if (b == button2) {
                int value = Integer.parseInt(editText2.getText().toString());
                editText2.setText(Integer.toString(value + 1));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        editText1 = (EditText)findViewById(R.id.edit_text1);
        editText2 = (EditText)findViewById(R.id.edit_text2);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        startIntentButton = (Button)findViewById(R.id.start_intent_button);

        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);

        startIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nrClicks1 = Integer.parseInt(editText1.getText().toString());
                int nrClicks2 = Integer.parseInt(editText2.getText().toString());

                //Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01");
                Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01");

                Log.d("secondary_activity", "before starting second activity: " + (nrClicks1 + nrClicks2));
                intent.putExtra("key_for_intent", nrClicks1 + nrClicks2);
                startActivityForResult(intent, 123);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(getApplicationContext(), "Result code is: " + resultCode, Toast.LENGTH_LONG).show();
    }

    /* If you want to store persistent data, even if you click back, check
    Shared Preferences
     */
    protected void onSaveInstanceState(Bundle toSaveInstance) {
        toSaveInstance.putString("editText1", editText1.getText().toString());
        toSaveInstance.putString("editText2", editText2.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle toRestore) {
        editText1.setText(toRestore.getString("editText1"));
        editText2.setText(toRestore.getString("editText2"));
    }
}
