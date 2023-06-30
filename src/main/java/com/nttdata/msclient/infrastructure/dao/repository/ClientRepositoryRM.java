package com.nttdata.msclient.infrastructure.dao.repository;

import com.nttdata.msclient.infrastructure.dao.entity.ClientEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepositoryRM extends ReactiveMongoRepository<ClientEntity, String> {

  @Aggregation(value = {
          "{ $lookup: {from: 'profiles', localField: 'profileId', foreignField: '_id', as: 'profile'}}",
          "{ $unwind: {path: '$profile', preserveNullAndEmptyArrays: false}}",
  })
  Flowable<ClientEntity> customFindAll();

  @Aggregation(value = {
          "{ $match: {_id: ?0 }}",
          "{ $lookup: {from: 'profiles', localField: 'profileId', foreignField: '_id', as: 'profile'}}",
          "{ $unwind: {path: '$profile', preserveNullAndEmptyArrays: false}}",
  })
  Maybe<ClientEntity> customFindById(ObjectId id);

  @Query(value = "{ 'dni' : ?0 }", fields = "{ 'dni' : 1 }")
  Maybe<String> findDniByDni(String dni);

}