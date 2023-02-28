package com.example.fragment.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.FirstFragment;
import com.example.fragment.R;
import com.example.fragment.model.DataModel;

import java.util.List;

public class MovieAdopter extends RecyclerView.Adapter<MovieAdopter.MyViewHolder> {

    private int [] imageBack;

   // public MovieAdopter( int[] imageBack) {
       // this.imageBack = imageBack;

  //  }


    private List<DataModel> list;
    private ItemClickListener clickListener;

    public MovieAdopter(List<DataModel> list, FirstFragment clickListener) {

        this.clickListener = clickListener;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);

    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull MovieAdopter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {



        holder.titleTextView.setText(list.get(position).getTitle());
       // int imageBack_id=imageBack[position];
       // holder.imageCard.setImageResource(imageBack_id);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onItemClick(list.get(position));
            }
        });


    }
    @Override
    public int getItemCount() {
        return 6;

    }
    class MyViewHolder extends RecyclerView.ViewHolder {


       private ImageView imageCard;
        TextView titleTextView;

        public MyViewHolder(View view) {

            super(view);
            titleTextView = view.findViewById(R.id.workEveName);
            imageCard=view.findViewById(R.id.workCardEve);

        }

    }

    public interface ItemClickListener {

        public void onItemClick(DataModel dataModel);
    }

}