package com.example.demo_app;

public class HeaderModel implements Section {

    String header;
    private int section;

    public HeaderModel(int section) {
        this.section = section;
    }

    public void setheader(String header) {
        this.header = header;
    }

    @Override
    public boolean isHeader() {
        return true;
    }

    @Override
    public String getName() {
        return header;
    }

    @Override
    public int sectionPosition() {
        return section;
    }
}