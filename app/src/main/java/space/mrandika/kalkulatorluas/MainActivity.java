package space.mrandika.kalkulatorluas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button C_ke_K, C_ke_F, btn_result;
    TextView txt_result;

    private int req_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        C_ke_K = findViewById(R.id.C_ke_K);
        C_ke_F = findViewById(R.id.C_ke_F);
        btn_result = findViewById(R.id.btn_result);

        txt_result = findViewById(R.id.txt_result);

        C_ke_K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, KelvinActivity.class);
                startActivity(i);
            }
        });

        C_ke_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FahrenheitActivity.class);
                startActivity(i);
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, KelvinActivity.class);
                startActivityForResult(data, req_code);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == req_code) {
            if (resultCode == RESULT_OK) {
                txt_result.setText(text(data));
            }
        }
    }

    String text(Intent a) {
        return Objects.requireNonNull(a.getData()).toString().trim();
    }
}
