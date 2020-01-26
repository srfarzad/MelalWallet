package com.navin.melalwallet.di.context;


import android.content.Context;

import com.navin.melalwallet.ui.login.LoginActivity;

import dagger.Component;

@Component(modules = {MainActivityModule.class})
public interface ActivityComponent {

    Context  context();

    void inject(LoginActivity loginActivity);

}
