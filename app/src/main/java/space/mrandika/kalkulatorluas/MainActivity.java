package space.mrandika.kalkulatorluas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button C_ke_K, C_ke_F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        C_ke_K = findViewById(R.id.C_ke_K);
        C_ke_F = findViewById(R.id.C_ke_F);

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
    }
}
