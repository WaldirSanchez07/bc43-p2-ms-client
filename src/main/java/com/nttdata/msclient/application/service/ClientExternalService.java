package com.nttdata.msclient.application.service;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ClientExternalService {

  Flowable<ObjectResponse> findAll();

  Maybe<ObjectResponse> findById(String id);

  Maybe<ObjectResponse> save(ClientSaveRequest request);

}
