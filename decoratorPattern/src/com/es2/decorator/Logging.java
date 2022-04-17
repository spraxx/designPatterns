package com.es2.decorator;

import java.io.IOException;

public class Logging extends Decorator implements AuthInterface{
    public Logging(AuthInterface auth)
    {
        super (auth);
    }
    public void auth(String username, String password) throws AuthException, java.io.IOException
    {
        System.out.printf("(%d),auth()", System.currentTimeMillis());
        super.auth(username, password);
    }
}
