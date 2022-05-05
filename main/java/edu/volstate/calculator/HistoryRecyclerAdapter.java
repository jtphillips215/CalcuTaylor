package edu.volstate.calculator;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.MyViewHolder> {

    // instance variables
    Context context;
    ArrayList<String> calcHistory;

    // constructor
    public HistoryRecyclerAdapter(Context context, ArrayList<String> calcHistory) {
        this.context = context;
        this.calcHistory = calcHistory;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating layout and giving look to rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.history_recycler_row, parent, false);
        return new HistoryRecyclerAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // assigning values to the rows created in the layout
        // based on the position of the recycler view
        holder.textHistory.setText(calcHistory.get(position));
    }

    @Override
    public int getItemCount() {
        // the view wants to know the number of items displayed
        return calcHistory.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // grabbing views from our row layout file
        TextView textHistory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textHistory = itemView.findViewById(R.id.textHistory);
        }
    }
}
