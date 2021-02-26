package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnOK;
    TextView textView;

   // private Model model = new Model();
    private LowerCasePresenter lowerCaseVM = new LowerCasePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       observerViewModel();

        editText = (EditText)findViewById(R.id.editText);
        editText.setText(lowerCaseVM.getPresentableData());
        btnOK = (Button)findViewById(R.id.btnOK);
        //textView = (TextView)findViewById(R.id.textView);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                lowerCaseVM.setData(inputText);
                textView.setText(lowerCaseVM.getPresentableData());
            }
        });
    }

   /* public void observer(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    String data = ((Model) o).getData();
                    TextView outputView = (TextView) findViewById(R.id.textView);
                    outputView.setText(data);
                }            }
        });
    }*/

    private void observerViewModel() {
        lowerCaseVM.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof LowerCasePresenter) {
                    String data = ((LowerCasePresenter) o).getPresentableData();
                    textView = (TextView) findViewById(R.id.textView);
                    textView.setText(data);
                }
            }
        });

    }

//        //final Observer<String> stringObserver = new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                textView = (TextView)findViewById(R.id.textView);
//                textView.setText(s);
//            }
//        };
//
//
//    }


}