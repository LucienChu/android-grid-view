package com.example.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.data.Model;
import com.example.myapplication.R;

import java.util.List;

public class LabelListViewAdapter extends ArrayAdapter<Model> {
    private final List<Model> list;
    private final Activity context;

    public LabelListViewAdapter(Activity context, int xmlFileId, List<Model> list) {
        super(context, xmlFileId, list);
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.list_row, parent, false);
        TextView title = row.findViewById(R.id.labelTitleTextView);
        TextView counter = row.findViewById(R.id.labelCounterTextView);
        CheckBox checkBox = row.findViewById(R.id.labelCheckBox);

        title.setText(list.get(position).getLabelTitle());
        counter.setText(String.valueOf(list.get(position).getCounter()));
        checkBox.setChecked(list.get(position).isSelected());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setSelected(!list.get(position).isSelected());
                notifyDataSetChanged();
            }
        });
        return row;
    }

    private void checkModel() {
        int a = 40;
    }

    class ViewHolder {
        protected TextView titleTextView;
        protected TextView counterTextView;
        protected CheckBox checkbox;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        int a = 40;
    }

//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            View view = null;
//            if (convertView == null) {
//                LayoutInflater inflator = MainActivity.this.getLayoutInflater();
//                view = inflator.inflate(R.layout.list_row, null);
//                final ViewHolder viewHolder = new ViewHolder();
//                viewHolder.titleTextView = (TextView) view.findViewById(R.id.labelTitleTextView);
//                viewHolder.counterTextView = (TextView) view.findViewById(R.id.labelCounterTextView);
//                viewHolder.checkbox = (CheckBox) view.findViewById(R.id.labelCheckBox);
//                viewHolder.checkbox
//                        .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//                            @Override
//                            public void onCheckedChanged(CompoundButton buttonView,
//                                                         boolean isChecked) {
//                                Model element = (Model) viewHolder.checkbox
//                                        .getTag();
//                                element.setSelected(buttonView.isChecked());
//
//                            }
//                        });
//                view.setTag(viewHolder);
//                viewHolder.checkbox.setTag(list.get(position));
//            } else {
//                view = convertView;
//                ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
//            }
//            ViewHolder holder = (ViewHolder) view.getTag();
//            holder.titleTextView.setText(list.get(position).getLabelTitle());
//            holder.counterTextView.setText(String.valueOf(list.get(position).getCounter()));
//            holder.checkbox.setChecked(list.get(position).isSelected());
//            view.setOnClickListener(v -> {
//                boolean isCheck = holder.checkbox.isChecked();
//                holder.checkbox.setChecked(!isCheck);
//
//                int currentCount = Integer.parseInt(holder.counterTextView.getText().toString());
//                if (isCheck) {
//                    currentCount--;
//                } else {
//                    currentCount++;
//                }
//                models.get(position).setCounter(currentCount);
//                holder.counterTextView.setText(String.valueOf(currentCount));
//                checkModel();
//            });
//            return view;
//        }
}
