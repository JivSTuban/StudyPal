package com.example.studypal;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<String> id, title, description, subject;

    CustomAdapter(Activity activity, Context context, ArrayList<String> id, ArrayList<String> title, ArrayList<String> description, ArrayList<String> subject) {
        this.activity = activity;
        this.context = context;
        //my rows to show
        this.id = id;
        this.title = title;
        this.description = description;
        this.subject = subject;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.noteIDtxt.setText(String.valueOf(id.get(position)));
        holder.noteTitletxt.setText(String.valueOf(title.get(position)));
        holder.noteSubjecttxt.setText(String.valueOf(subject.get(position)));
        holder.noteDescription.setText(String.valueOf(description.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("title", String.valueOf(title.get(position)));
                intent.putExtra("author", String.valueOf(subject.get(position)));
                intent.putExtra("pages", String.valueOf(description.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView noteIDtxt, noteSubjecttxt, noteTitletxt, noteDescription;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            noteIDtxt = itemView.findViewById(R.id.book_id_txt);
            noteSubjecttxt = itemView.findViewById(R.id.book_title_txt);
            noteTitletxt = itemView.findViewById(R.id.book_author_txt);
            noteDescription = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            // Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            //mainLayout.setAnimation(translate_anim);
        }

    }
}