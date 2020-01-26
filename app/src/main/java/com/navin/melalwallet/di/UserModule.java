package com.navin.melalwallet.di;

import com.navin.melalwallet.webservice.WebserviceCaller;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {


    @Singleton
    @Provides
     User provideUser(){
        return new User(new Contact());
    }

    @Singleton
    @Provides
    Contact provideContact () {
        return  new Contact();
    }

    @Singleton
    @Provides
    WebserviceCaller provideWebservice () {
        return  new WebserviceCaller();
    }



}
