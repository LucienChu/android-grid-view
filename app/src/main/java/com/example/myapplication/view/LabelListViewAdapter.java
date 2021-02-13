// View Holder pattern: https://www.youtube.com/watch?v=W2fTwpAiteE
package com.example.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.data.LabelModel;
import com.example.myapplication.R;

import java.util.List;

public class LabelListViewAdapter extends ArrayAdapter<LabelModel> {
    private final List<LabelModel> list;
    private final Activity context;

    public LabelListViewAdapter(Activity context, int xmlFileId, List<LabelModel> list) {
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
        ConstraintLayout labelViewWrapper;
        TextView title;
        TextView counter;
        ImageView imageView;
        // need to inflate a labelView, which would be expensive
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            labelView = layoutInflater.inflate(R.layout.label_grid_item, parent, false);
            labelViewWrapper = labelView.findViewById(R.id.labelViewWrapper);
            title = labelView.findViewById(R.id.labelTitleTextView);
            counter = labelView.findViewById(R.id.labelCounterTextView);
            imageView = labelView.findViewById(R.id.labelImage);

            LabelViewHolder labelViewHolder = new LabelViewHolder(labelViewWrapper, title, counter, imageView);
            labelView.setTag(labelViewHolder);
        } else {
            labelView = convertView;
        }
        LabelModel labelModel = list.get(position);

        LabelViewHolder labelViewHolder = (LabelViewHolder) labelView.getTag();
        labelViewWrapper = labelViewHolder.labelViewWrapper;
        title = labelViewHolder.titleTextView;
        counter = labelViewHolder.counterTextView;
        imageView = labelViewHolder.labelImageView;
        title.setText(labelModel.getLabelTitle());
        counter.setText(String.valueOf(labelModel.getCounter()));
        labelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean toBeChecked = !labelModel.isSelected();
                labelModel.setSelected(toBeChecked);
                if (toBeChecked) {
                    labelModel.increment();
                } else {
                    labelModel.decrement();
                }
                notifyDataSetChanged();
            }
        });
        imageView.setImageResource(context.getResources().getIdentifier(labelModel.getImageSrc(), "drawable", context.getPackageName()));

//        changeColor(title, counter, imageView, model.getCounter(), model.isSelected());
        changeColor(labelViewWrapper, title, counter, imageView, labelModel);
        return labelView;
    }

    private void changeColor(ConstraintLayout labelWrapper, TextView titleTextView, TextView counterTextView, ImageView labelImageView, LabelModel labelModel) {


        boolean isSelected = labelModel.isSelected();
        int counter = labelModel.getCounter();

        int activeColor = context.getResources().getColor(R.color.theme_red);
        int textColorDefault = context.getResources().getColor(R.color.theme_text_color_black);
        int whiteColor = Color.WHITE;

        // 0 state, red bg, black font and label image color
        if(counter == 0) {
            labelWrapper.setBackgroundResource(R.drawable.label_view_background_grey);
            titleTextView.setTextColor(textColorDefault);
            counterTextView.setTextColor(textColorDefault);
            labelImageView.setColorFilter(textColorDefault);
        }
        else {
            // selected red background, white font and label image
            if (isSelected) {
                labelWrapper.setBackgroundResource(R.drawable.label_view_background_red);
                labelImageView.setColorFilter(whiteColor);
                titleTextView.setTextColor(whiteColor);
                counterTextView.setTextColor(whiteColor);
            } else {
                labelWrapper.setBackgroundResource(R.drawable.label_view_background_grey);
                labelImageView.setColorFilter(activeColor);
                titleTextView.setTextColor(activeColor);
                counterTextView.setTextColor(activeColor);
            }
        }
    }

    private void changeColor(TextView titleTextView, TextView counterTextView, ImageView imageView, int counter, Boolean isSelected) {
        int activeColor = context.getResources().getColor(R.color.theme_red);
        int defaultColor = Color.BLACK;
        if (isSelected) {
            imageView.setColorFilter(activeColor);
            titleTextView.setTextColor(activeColor);
            counterTextView.setTextColor(activeColor);
        } else {
            imageView.setColorFilter(defaultColor);
            titleTextView.setTextColor(defaultColor);
            counterTextView.setTextColor(defaultColor);
        }
    }


    private static class LabelViewHolder {
        private final ConstraintLayout labelViewWrapper;
        private final TextView titleTextView;
        private final TextView counterTextView;
        private final ImageView labelImageView;

        public LabelViewHolder(ConstraintLayout labelViewWrapper, TextView titleTextView, TextView counterTextView, ImageView labelImageView) {
            this.labelViewWrapper = labelViewWrapper;
            this.titleTextView = titleTextView;
            this.counterTextView = counterTextView;
            this.labelImageView = labelImageView;
        }
    }
}
