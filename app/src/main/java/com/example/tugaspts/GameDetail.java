package com.example.tugaspts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tugaspts.databinding.ActivityGameDetailBinding;
import com.example.tugaspts.databinding.ActivityMainBinding;

public class GameDetail extends AppCompatActivity {

    public static final String EXTRA_DESC = "EXTRA_DESC";
    private ActivityGameDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityGameDetailBinding.inflate(getLayoutInflater());
        View Tampil=binding.getRoot();
        setContentView(Tampil);

        Intent intent=getIntent();
        String nama=intent.getStringExtra("judul");
        String rate=intent.getStringExtra("rating");
        String genre=intent.getStringExtra("genre");
        String desc=intent.getStringExtra(EXTRA_DESC);
        int poster = intent.getIntExtra("poster", 0);

        binding.gameName.setText(nama);
        binding.gameRating.setText(rate);
        binding.gameGenr.setText(genre);
        binding.gameDesc.setText(desc);
        binding.gamePoster.setImageResource(poster);
    }
}