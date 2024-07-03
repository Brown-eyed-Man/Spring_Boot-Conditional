package ru.netology.springbootdemo.profile;

import ru.netology.springbootdemo.profile.interfaces.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
