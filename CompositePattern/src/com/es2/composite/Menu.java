package com.es2.composite;

import java.util.ArrayList;

public abstract class Menu {
    private String label;

    public Menu()
    {

    }
    public String getLabel()
    {
        return label;
    }
    public void setLabel(String label)
    {
        this.label =  label;
    }
    public abstract void showOptions();
}
