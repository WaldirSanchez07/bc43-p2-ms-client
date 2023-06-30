package com.nttdata.msclient.application.service.impl;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.application.mapper.ClientRequestMapper;
import com.nttdata.msclient.application.mapper.ClientResponseMapper;
import com.nttdata.msclient.application.service.ClientExternalService;
import com.nttdata.msclient.domain.service.ClientService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientExternalServiceImpl implements ClientExternalService {

    private final ClientService clientService;

    @Override
    public Flowable<ObjectResponse> findAll() {
        return clientService.findAll()
                .map(ClientResponseMapper.INSTANCE::map)
                .map(obj -> new ObjectResponse(200, null, obj));
    }

    @Override
    public Maybe<ObjectResponse> findById(String id) {
        return clientService.findById(id)
                .map(ClientResponseMapper.INSTANCE::map)
                .map(obj -> new ObjectResponse(200, null, obj));
    }

    @Override
    public Maybe<ObjectResponse> save(ClientSaveRequest request) {
        return clientService
                .save(ClientRequestMapper.INSTANCE.map(request))
                .map(ClientResponseMapper.INSTANCE::map)
                .map(obj -> new ObjectResponse(200, null, obj));
    }

}
