package com.testing.t1;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText editTextAppName;
    private Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAppName = findViewById(R.id.editTextAppName);
        buttonSearch = findViewById(R.id.buttonSearch);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String appName = editTextAppName.getText().toString().trim();

                if (!appName.isEmpty()) {

                    String playStoreQuery = "maret://search?q=" + appName;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(playStoreQuery));
                    intent.setPackage("com.android.vending"); // Membuka di Play Store


                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Play Store tidak tersedia.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Masukkan nama aplikasi terlebih dahulu.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
