package com.es2.singleton;

public class Registry extends java.lang.Object{


    private Registry() {}
    private String path;
    private String connectionString;

    private static Registry instance = new Registry();


    public static Registry getInstance() {
        if (instance == null) {

            instance = new Registry();
    }
        return instance;
    }


    public void setPath(String path){
        this.path = path;
    }

    public java.lang.String getPath(){
        return path;
    }

    public java.lang.String getConnectionString(){
        return connectionString;
    }

    public void setConnectionString(String connectionString){

        this.connectionString = connectionString;
    }
}
