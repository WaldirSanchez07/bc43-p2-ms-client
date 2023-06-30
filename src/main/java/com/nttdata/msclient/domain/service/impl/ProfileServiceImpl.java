package com.nttdata.msclient.domain.service.impl;

import com.nttdata.msclient.domain.model.Profile;
import com.nttdata.msclient.domain.repository.ProfileRepository;
import com.nttdata.msclient.domain.service.ProfileService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {

  private final ProfileRepository profileRepository;

  @Override
  public Flowable<Profile> findAll() {
    return profileRepository.findAll();
  }

  @Override
  public Maybe<Profile> findById(String id) {
    return profileRepository.findById(id);
  }

}
