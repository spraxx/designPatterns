package com.es2.decorator;

public class Auth {
    public Auth() {
    }
    public void auth(String username, String password) throws AuthException
    {
        if(! username.equals("admin") || !password.equals("admin"))
            throw new AuthException();
    }
}
