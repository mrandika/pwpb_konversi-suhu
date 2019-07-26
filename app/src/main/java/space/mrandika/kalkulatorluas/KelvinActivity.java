package space.mrandika.kalkulatorluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KelvinActivity extends AppCompatActivity {

    private EditText input_celcius;
    private Button button_konversi;
    private TextView text_hasil;

    private boolean isEmpty = false;
    private boolean isInvalidDouble = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelvin);

        input_celcius = findViewById(R.id.input_celcius);
        button_konversi = findViewById(R.id.button_konversi);
        text_hasil = findViewById(R.id.text_hasil);

        button_konversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = text(input_celcius);
                Double dCelcius = parseDouble(c);

                isValidated(c);
                isInvalid(dCelcius);

                if (!isEmpty && !isInvalidDouble) {
                    double hasil = dCelcius + 273.15;
                    text_hasil.setText(String.format("%s °K", String.valueOf(hasil)));
                }
            }
        });
    }

    String text(EditText editText) {
        return editText.getText().toString().trim();
    }

    Double parseDouble(String string) {
        try {
            return Double.valueOf(string);
        } catch (NumberFormatException err) {
            return null;
        }
    }

    void isValidated(String string) {
        if (string.isEmpty()) {
            isEmpty = true;
            input_celcius.setError("Tidak boleh kosong");
        }
    }

    void isInvalid(Double d) {
        if (d == null) {
            isInvalidDouble = true;
            input_celcius.setError("Invalid Format");
        }
    }
}
