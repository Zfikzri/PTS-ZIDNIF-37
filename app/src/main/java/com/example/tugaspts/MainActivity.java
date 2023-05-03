package com.example.tugaspts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.tugaspts.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View Tampil=binding.getRoot();
        setContentView(Tampil);

        binding.tvQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.changeQuote.setText("Enjoyy film recommendation dari saya");
            }
        });


        ArrayList<Game> games=getListGame();

        GameAdapter gameAdapter=new GameAdapter(games);
        binding.recylerview.setLayoutManager(new GridLayoutManager(this,2));
        binding.recylerview.setAdapter(gameAdapter);


    }
    private ArrayList<Game>getListGame(){
        String[]name=getResources().getStringArray(R.array.judul_game);
        String[]rating=getResources().getStringArray(R.array.rating_game);
        String[]genre=getResources().getStringArray(R.array.genre_game);
        String[]desc=getResources().getStringArray(R.array.desc_game);
        TypedArray poster=getResources().obtainTypedArray(R.array.poster_game);

        ArrayList<Game> games=new ArrayList<>();

        for (int i=0;i< name.length;i++){

            Game game=new Game();
            game.setName(name[i]);
            game.setRatings(rating[i]);
            game.setGenre(genre[i]);
            game.setDesc(desc[i]);
            game.setPoster(poster.getResourceId(i,-1));

            games.add(game);
        }
        return games;
    }
}