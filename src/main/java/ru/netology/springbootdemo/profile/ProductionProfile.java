package ru.netology.springbootdemo.profile;

import ru.netology.springbootdemo.profile.interfaces.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
