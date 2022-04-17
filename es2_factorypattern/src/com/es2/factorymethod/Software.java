package com.es2.factorymethod;

public class Software extends java.lang.Object implements Product{
    private String brand;
    protected Software(){

    }
    public java.lang.String getBrand(){
        return brand;
    }
    public void setBrand(java.lang.String brand){
        this.brand = brand;
    }
}
