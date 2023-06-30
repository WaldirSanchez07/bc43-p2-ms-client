package com.nttdata.msclient.domain.service.impl;

import com.nttdata.msclient.domain.model.Client;
import com.nttdata.msclient.domain.repository.ClientRepository;
import com.nttdata.msclient.domain.service.ClientService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Override
  public Flowable<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Maybe<Client> findById(String id) {
    return clientRepository.findById(id);
  }

  @Override
  public Maybe<String> findDniByDni(String dni) {
    return clientRepository.findDniByDni(dni);
  }

  @Override
  public Maybe<Client> save(Client client) {
    return clientRepository.save(client);
  }

}
