package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class reminderAdapter extends RecyclerView.Adapter{
    private ArrayList<Reminder> reminderData;
    private View.OnClickListener mOnItemClickListener;
    private Context parentContext;

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle;
        public TextView textDescription;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitleName2);
            textDescription = itemView.findViewById(R.id.textDescriptionName2);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);

        }

        public TextView getTitleTextView() { return textTitle; }
        public TextView getDescriptionTextView() { return textDescription; }

    }

    public reminderAdapter(ArrayList<Reminder> arrayList, Context context) {
        reminderData = arrayList;
        parentContext = context;
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ContactViewHolder cvh = (ContactViewHolder) holder;
        cvh.getTitleTextView().setText(reminderData.get(position).getTitle());
        cvh.getDescriptionTextView().setText(reminderData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return reminderData.size();
    }
}
