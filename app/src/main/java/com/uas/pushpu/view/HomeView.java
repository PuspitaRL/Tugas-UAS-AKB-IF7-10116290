package com.uas.pushpu.view;

import com.uas.pushpu.data.model.User;



public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
