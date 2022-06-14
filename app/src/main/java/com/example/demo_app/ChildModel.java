package com.example.demo_app;

public class ChildModel implements Section {

    String child;
    private int section;

    public ChildModel(int section) {
        this.section = section;
    }

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public String getName() {
        return child;
    }

    @Override
    public int sectionPosition() {
        return section;
    }
}