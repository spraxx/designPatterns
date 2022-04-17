package com.es2.objectpool;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.ArrayList;

public class ReusablePool extends java.lang.Object {

    int size = 10;
    private static ReusablePool instance;
    ArrayList<HttpURLConnection> inUse = new ArrayList<>();
    ArrayList<HttpURLConnection> isAvailable = new ArrayList<>();




    private  ReusablePool()
    {
    }

    public synchronized static ReusablePool getInstance()
    {
       if (instance == null)
       {
           instance = new ReusablePool();
       }
       return instance;
    }

    public synchronized HttpURLConnection acquire() throws IOException, PoolExhaustedException
    {
        URL  url = new URL("http://www.ipv.pt/");

        if (inUse.size() >= size)
        {
            throw new PoolExhaustedException();
        }

        HttpURLConnection httpConn = null; //inicição do objeto

        if(isAvailable.isEmpty()){
            httpConn = (HttpURLConnection) url.openConnection();

        }else{
            httpConn = isAvailable.get(0);
            isAvailable.remove(0);
            httpConn.connect();

        }
        inUse.add(httpConn);
        return httpConn;

    }

    public synchronized void release(java.net.HttpURLConnection conn) throws ObjectNotFoundException
    {
            if(!inUse.contains(conn)) {
                throw new ObjectNotFoundException();
            }
            conn.disconnect();
            isAvailable.add(conn);
            inUse.remove(conn);
    }


    public synchronized void resetPool()
    {
        isAvailable.clear();
        for(HttpURLConnection connection : inUse){
            connection.disconnect();
        }
        inUse.clear();
    }
    public synchronized void setMaxPoolSize(int size)
    {
        this.size = size;
    }
}
