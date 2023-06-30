package com.nttdata.msclient.domain.service;

import com.nttdata.msclient.domain.model.Client;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ClientService {

  Flowable<Client> findAll();

  Maybe<Client> findById(String id);

  Maybe<String> findDniByDni(String dni);

  Maybe<Client> save(Client client);

}
