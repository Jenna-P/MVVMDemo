package view;

import androidx.lifecycle.MutableLiveData;

import java.util.Observable;
import java.util.Observer;

import model.Model;

public class AndroidLowerCaseViewModel {
    private Model model = new Model();
    private MutableLiveData<String> pd = new MutableLiveData<>();

    public AndroidLowerCaseViewModel() {
        observeModel(model);
        pd.setValue(getTransformedData(model.getData()));


    }

    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    String data = ((Model) o).getData();
                    pd.setValue(getTransformedData(data));
                }
            }
        });
    }

    private String getTransformedData(String data) {
        return data.toLowerCase();
    }

    public MutableLiveData<String> getPd() {
        return pd;
    }

    public void setPd(MutableLiveData<String> pd) {
        this.pd = pd;
    }
}
