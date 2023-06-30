package com.nttdata.msclient.application.service.impl;

import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.application.service.ProfileExternalService;
import com.nttdata.msclient.domain.service.ProfileService;
import io.reactivex.rxjava3.core.Flowable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileExternalServiceImpl implements ProfileExternalService {

  private final ProfileService profileService;

  @Override
  public Flowable<ObjectResponse> findAll() {
    return profileService
            .findAll()
            .map(obj -> new ObjectResponse(200, null, obj));
  }

}
