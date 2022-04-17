package com.es2.factorymethod;

public abstract class FactoryProduct extends java.lang.Object{



    public  FactoryProduct(){

    }

    public static Product makeProduct(java.lang.String type) throws UndefinedProductException{
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Computer")){
            return new Computer();
        }
        if (type.equalsIgnoreCase("Software")){
            return new Software();
        }

         throw new UndefinedProductException();


    }
}
