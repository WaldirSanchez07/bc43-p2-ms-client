package com.nttdata.msclient.domain.service;

import com.nttdata.msclient.domain.model.Profile;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ProfileService {

  Flowable<Profile> findAll();

  Maybe<Profile> findById(String id);

}
