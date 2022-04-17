package com.es2.decorator;

import java.io.IOException;

public  class Decorator implements AuthInterface{
    AuthInterface auth;
    public Decorator(AuthInterface auth){
        this.auth = auth;
    }

    public void auth(String username, String password) throws AuthException, java.io.IOException
    {
        auth.auth(username, password);
    }
}
