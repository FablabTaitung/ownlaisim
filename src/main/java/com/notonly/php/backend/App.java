package com.notonly.php.backend;

import com.notonly.php.backend.model.AmazingObjectStore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AmazingObjectStore store = AmazingObjectStore.getInstance();
        store.getUser("");
    }
}
