package com.example.colorfulcircle;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.colorfulcircle.databinding.ActivityMainBinding;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private GradientDrawable generateRandomColorDrawable() {
        Random random = new Random();
        int color = 0xff000000 | random.nextInt(0xffffff + 1);  // Add the alpha channel
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(color);
        return drawable;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.circle.setOnClickListener(v -> binding.circle.setBackground(generateRandomColorDrawable()));

        setContentView(binding.getRoot());
    }
}
