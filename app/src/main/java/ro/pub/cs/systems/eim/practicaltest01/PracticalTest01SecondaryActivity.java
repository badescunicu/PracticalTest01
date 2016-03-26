package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private Button ok_button, cancel_button;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        Log.d("secondary_activity", "In onCreate second activity");

        ok_button = (Button) findViewById(R.id.ok_button);
        cancel_button = (Button) findViewById(R.id.cancel_button);
        editText3 = (EditText) findViewById(R.id.edit_text3);

        ok_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = getIntent();
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = getIntent();
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        int total_clicks = intent.getIntExtra("key_for_intent", 0);
        //String total_clicks = intent.getExtras().getString("key_for_intent");
        Log.d("secondary_activity", "total_clicks: "  + total_clicks);
        Log.d("secondary_activity", intent.getExtras().toString());
        editText3.setText(Integer.toString(total_clicks));

    }

}
