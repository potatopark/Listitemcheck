package com.example.user.a4_listitemcheckexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.a4_listitemcheckexam.R;
import com.example.user.a4_listitemcheckexam.model.Flower;

import java.util.List;

/**
 * Created by user on 2017-08-19.
 */

public class FlowerAdapter extends ArrayAdapter<Flower> {

    Activity activity;
    int resource;

    public FlowerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Flower> objects) {
        super(context, resource, objects);

        activity = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null){
            itemView = this.activity.getLayoutInflater().inflate(this.resource,null);
        }
        final Flower item = getItem(position);

        if(item != null){
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            TextView textView1 = (TextView) itemView.findViewById(R.id.textView1);
            TextView textView2 = (TextView) itemView.findViewById(R.id.textView2);
            CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());

            checkBox.setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            item.setCheck(isChecked);
                        }

                    });
            checkBox.setChecked(item.isCheck());

        }
        return itemView;
    }
}
