// View Holder pattern: https://www.youtube.com/watch?v=W2fTwpAiteE
package com.example.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.data.Model;
import com.example.myapplication.R;

import java.util.List;

public class LabelListViewAdapter extends ArrayAdapter<Model> {
    private final int ACTIVE_COLOR = Color.parseColor("#e92e4f");
    private final int DEFAULT_COLOR = Color.BLACK;

    private final List<Model> list;
    private final Activity context;

    public LabelListViewAdapter(Activity context, int xmlFileId, List<Model> list) {
        super(context, xmlFileId, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View labelView;
        TextView title;
        TextView counter;
        ImageView imageView;
        // need to inflate a labelView, which would be expensive
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            labelView = layoutInflater.inflate(R.layout.list_row, parent, false);
            title = labelView.findViewById(R.id.labelTitleTextView);
            counter = labelView.findViewById(R.id.labelCounterTextView);
            imageView = labelView.findViewById(R.id.labelImage);

            LabelViewHolder labelViewHolder = new LabelViewHolder(title, counter, imageView);
            labelView.setTag(labelViewHolder);
        } else {
            labelView = convertView;
        }
        Model model = list.get(position);

        LabelViewHolder labelViewHolder = (LabelViewHolder) labelView.getTag();
        title = labelViewHolder.titleTextView;
        counter = labelViewHolder.counterTextView;
        imageView = labelViewHolder.labelImageView;
        title.setText(model.getLabelTitle());
        counter.setText(String.valueOf(model.getCounter()));
        labelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean toBeChecked = !model.isSelected();
                model.setSelected(toBeChecked);
                if (toBeChecked) {
                    model.increment();
                } else {
                    model.decrement();
                }
                notifyDataSetChanged();
            }
        });
        imageView.setImageResource(context.getResources().getIdentifier(model.getImageSrc(), "drawable", context.getPackageName()));

        changeColor(title, counter, imageView, model.isSelected());
        return labelView;
    }

    private void changeColor(TextView titleTextView, TextView counterTextView, ImageView imageView, Boolean isSelected) {
        if (isSelected) {
            imageView.setColorFilter(ACTIVE_COLOR);
            titleTextView.setTextColor(ACTIVE_COLOR);
            counterTextView.setTextColor(ACTIVE_COLOR);
        } else {
            imageView.setColorFilter(DEFAULT_COLOR);
            titleTextView.setTextColor(DEFAULT_COLOR);
            counterTextView.setTextColor(DEFAULT_COLOR);
        }
    }


    private static class LabelViewHolder {
        private final TextView titleTextView;
        private final TextView counterTextView;
        private final ImageView labelImageView;

        public LabelViewHolder(TextView titleTextView, TextView counterTextView, ImageView labelImageView) {
            this.titleTextView = titleTextView;
            this.counterTextView = counterTextView;
            this.labelImageView = labelImageView;
        }
    }
}
