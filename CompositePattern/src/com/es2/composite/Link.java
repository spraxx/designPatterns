package com.es2.composite;



public class Link extends Menu{

   private String url;
   public Link()
    {

    }
   public String getURL()
    {

       return url;
    }

    public void setURL(String url)

    {
      this.url = url;
    }

    public void showOptions()

    {
        System.out.println(getLabel());
        System.out.println(url);

    }
}