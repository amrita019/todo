package com.amrita.to_do;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListModel> todoList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        ListModel todoItem = todoList.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.todoTextView;
        textView.setText(todoItem.getName());

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public ListAdapter(List<ListModel> list){
        this.todoList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView todoTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            todoTextView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
