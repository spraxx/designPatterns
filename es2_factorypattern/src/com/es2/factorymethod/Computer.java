package com.es2.factorymethod;

public class Computer extends java.lang.Object implements Product {
    private String brand;

    protected  Computer(){
    };
    @Override
    public void setBrand(java.lang.String brand){
            this.brand = brand;
    }
    public java.lang.String getBrand(){
        return brand;
    }
}
