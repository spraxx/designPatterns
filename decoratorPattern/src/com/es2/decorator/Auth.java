package com.es2.decorator;

public class Auth implements AuthInterface {
    public Auth(){

    }
    public void auth(String username, String password) throws AuthException
    {
        if (username != "admin" || password != "admin")
        {
            throw new AuthException();
        }
    }
}
