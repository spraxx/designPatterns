package com.es2.decorator;

import java.io.IOException;

public interface AuthInterface
{
    default void auth(String username, String password) throws AuthException, java.io.IOException
    {
        if (username != "admin" || password != "admin")
        {
            throw new AuthException();
        }
        throw new IOException();

    }
}
