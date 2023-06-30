package com.nttdata.msclient.infrastructure.dao.repository;

import com.nttdata.msclient.infrastructure.dao.entity.ProfileEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProfileRepositoryRM extends ReactiveMongoRepository<ProfileEntity, String> {

  @Query("{}")
  Flowable<ProfileEntity> customFindAll();

  @Query("{ _id: ?0 }")
  Maybe<ProfileEntity> customFindById(String id);

}
