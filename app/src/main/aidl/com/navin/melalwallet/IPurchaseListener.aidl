// IPurchaseListener.aidl
package com.navin.melalwallet;

// Declare any non-default types here with import statements

interface IPurchaseListener {


    boolean isLoggedIn();
    void payment(String price);
    void login(String username,String password);

}
