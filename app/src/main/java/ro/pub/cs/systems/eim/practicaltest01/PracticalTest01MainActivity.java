package ro.pub.cs.systems.eim.practicaltest01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button button1, button2;
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

        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);

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
