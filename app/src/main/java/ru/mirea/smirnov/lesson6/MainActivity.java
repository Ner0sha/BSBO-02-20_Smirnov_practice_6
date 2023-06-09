package ru.mirea.smirnov.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.smirnov.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPref = getSharedPreferences("Smirnov_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if(!sharedPref.getString("group", "unknown").equals("unknown") || !sharedPref.getString("number", "unknown").equals("unknown") || !sharedPref.getString("film", "unknown").equals("unknown"))
        {
            binding.editTextText.setText(sharedPref.getString("group", "unknown"));
            binding.editTextText2.setText(sharedPref.getString("number", "unknown"));
            binding.editTextText3.setText(sharedPref.getString("film", "unknown"));
        }


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("group", binding.editTextText.getText().toString());
                editor.putString("number", binding.editTextText2.getText().toString());
                editor.putString("film", binding.editTextText3.getText().toString());
                editor.apply();
            }
        });
    }
}