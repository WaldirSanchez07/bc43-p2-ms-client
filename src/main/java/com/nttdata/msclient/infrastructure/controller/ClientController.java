package com.nttdata.msclient.infrastructure.controller;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.application.service.ClientExternalService;
import com.nttdata.msclient.application.service.ProfileExternalService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/clients")
public class ClientController {

  private final ClientExternalService clientService;
  private final ProfileExternalService profileService;

  @GetMapping(value = "/profiles", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> findAllProfiles() {
    return profileService.findAll();
  }

  @GetMapping(value = "/list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> findAllClients() {
    return clientService.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> findClientById(@PathVariable String id) {
    return clientService.findById(id);
  }

  @PostMapping(value = "/create", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> saveClient(@Valid @RequestBody ClientSaveRequest request) {
    return clientService.save(request);
  }

}
