package com.navin.melalwallet.di;


import com.navin.melalwallet.webservice.WebserviceCaller;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

    User provideUser();
    Contact provideContact();

    WebserviceCaller provideWebservice();


}
