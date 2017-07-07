package com.example.testtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Resident on 06.07.2017.
 */

@Component
public class ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public Profile getProfile(int personId) {
        return profileDao.getProfileById(personId);
    }
}
