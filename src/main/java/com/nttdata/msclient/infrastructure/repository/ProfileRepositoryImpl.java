package com.nttdata.msclient.infrastructure.repository;

import com.nttdata.msclient.domain.model.Profile;
import com.nttdata.msclient.domain.repository.ProfileRepository;
import com.nttdata.msclient.infrastructure.dao.repository.ProfileRepositoryRM;
import com.nttdata.msclient.infrastructure.mapper.ProfileMapper;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepository {

  private final ProfileRepositoryRM profileRepository;

  @Override
  public Flowable<Profile> findAll() {
    return profileRepository
            .customFindAll()
            .map(ProfileMapper.INSTANCE::map);
  }

  @Override
  public Maybe<Profile> findById(String id) {
    return profileRepository
            .customFindById(id)
            .map(ProfileMapper.INSTANCE::map);
  }

}
