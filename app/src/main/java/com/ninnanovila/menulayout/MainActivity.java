package com.ninnanovila.menulayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText fullNameInput = findViewById(R.id.fullname_input);
        Button submitBtn = findViewById(R.id.submit_button);

        //CHECK 4 (10)
        //Ga harus sama, logicnya aja yg sama
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INISIALISASI
                FoodFragment foodFragment = new FoodFragment();
                Bundle data = new Bundle();

                //PUT STRING
                String message = fullNameInput.getText().toString();
                data.putString(FoodFragment.FULL_NAME, message);

                //REPLACE LAYOUT
                foodFragment.setArguments(data);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, foodFragment)
                        .commit();
            }
        });
    }
}