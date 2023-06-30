package com.nttdata.msclient.infrastructure.repository;

import com.nttdata.msclient.domain.model.Client;
import com.nttdata.msclient.domain.repository.ClientRepository;
import com.nttdata.msclient.infrastructure.dao.repository.ClientRepositoryRM;
import com.nttdata.msclient.infrastructure.mapper.ClientAfterSaveMapper;
import com.nttdata.msclient.infrastructure.mapper.ClientMapper;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientRepositoryRM clientRepositoryRM;

    @Override
    public Flowable<Client> findAll() {
        return clientRepositoryRM
                .customFindAll()
                .map(ClientMapper.INSTANCE::map);
    }

    @Override
    public Maybe<Client> findById(String id) {
        ObjectId objectId = new ObjectId(id);
        return clientRepositoryRM
                .customFindById(objectId)
                .map(ClientMapper.INSTANCE::map);
    }

    @Override
    public Maybe<String> findDniByDni(String dni) {
        return clientRepositoryRM.findDniByDni(dni);
    }

    @Override
    public Maybe<Client> save(Client client) {
        Mono<Client> mono = clientRepositoryRM
                .save(ClientMapper.INSTANCE.map(client))
                .map(ClientAfterSaveMapper.INSTANCE::map);

        return Maybe.fromPublisher(mono);
    }
}
