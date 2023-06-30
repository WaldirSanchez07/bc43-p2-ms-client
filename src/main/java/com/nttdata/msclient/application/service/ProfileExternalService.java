package com.nttdata.msclient.application.service;

import com.nttdata.msclient.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;

public interface ProfileExternalService {

  Flowable<ObjectResponse> findAll();

}
