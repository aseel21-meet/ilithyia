package com.example.ilithyia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MessageArrayAdapter extends ArrayAdapter<Message>{
    private Context mContext;
    private int mResource;

    public MessageArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Message> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        convertView=layoutInflater.inflate(mResource,parent, false);

        TextView textM=convertView.findViewById(R.id.textM);
        TextView ansM=convertView.findViewById(R.id.anstext);
        textM.setText(getItem(position).getMsg());
        if(getItem(position).getIsPublished()==true)
            ansM.setText("answer:"+getItem(position).getAnswer());

        return convertView;
    }
}

