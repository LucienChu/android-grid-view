package com.example.myapplication.data;

public class Model {

    private String labelTitle;
    private boolean selected;
    private int counter;
    private String imageSrc;

    public Model(String name, int counter, boolean isChecked) {
        this.labelTitle = name;
        this.counter = counter;
        this.selected = isChecked;
        this.imageSrc = name.replaceAll(" ", "_").toLowerCase();
        this.imageSrc = this.imageSrc.replaceAll("-","_");
    }

    public String getLabelTitle() {
        return labelTitle;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getCounter() {
        return this.counter;
    }

    public void increment() {
        this.counter++;
    }

    public void decrement() {
        if (this.counter > 0) {
            this.counter--;
        }
    }

    public void setCounter(int counter) {
        if (counter >= 0) {
            this.counter = counter;
        }
    }

    public String getImageSrc() {
        return this.imageSrc;
    }

}