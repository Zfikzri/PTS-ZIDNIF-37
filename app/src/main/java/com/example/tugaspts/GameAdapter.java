package com.example.tugaspts;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private ArrayList<Game> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvJudulname;
        private final TextView tvRatings;
        private final TextView tvGenre;
        private  final TextView tvDescgame;
        private final ImageView tvPoster;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvJudulname =  view.findViewById(R.id.tv_judulgame);
            tvRatings = view.findViewById(R.id.tv_ratings);
            tvGenre = view.findViewById(R.id.tv_genregame);
            tvDescgame = view.findViewById(R.id.game_desc);
            tvPoster = view.findViewById(R.id.game_poster);



        }

    }
    public GameAdapter(ArrayList<Game> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.game_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        String nama=(localDataSet.get(position).getName());
        String rate=(localDataSet.get(position).getRatings());
        String genre=(localDataSet.get(position).getGenre());
        String desc=(localDataSet.get(position).getDesc());
        int poster=(localDataSet.get(position).getPoster());

        viewHolder.tvJudulname.setText(localDataSet.get(position).getName());
        viewHolder.tvRatings.setText(localDataSet.get(position).getRatings());
        viewHolder.tvGenre.setText(localDataSet.get(position).getGenre());
        viewHolder.tvPoster.setImageResource(localDataSet.get(position).getPoster());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(viewHolder.itemView.getContext(),GameDetail.class);
                intent.putExtra("judul",nama);
                intent.putExtra("rating",rate);
                intent.putExtra("poster", poster);
                intent.putExtra("genre", genre);
                intent.putExtra(GameDetail.EXTRA_DESC, desc);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
