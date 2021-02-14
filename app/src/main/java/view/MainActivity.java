package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;

import model.Model;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnOK;
    TextView textView;

    private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        editText.setText(model.getData());
        btnOK = (Button)findViewById(R.id.btnOK);
        textView = (TextView)findViewById(R.id.textView);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                model.setData(inputText);
                textView.setText(model.getData());
            }
        });
    }
}