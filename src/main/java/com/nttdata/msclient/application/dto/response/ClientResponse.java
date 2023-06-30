package com.nttdata.msclient.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nttdata.msclient.domain.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponse {

  private String id;
  private String dni;
  private String firstName;
  private String otherNames;
  private String firstSurname;
  private String secondSurname;
  private Profile profile;

}
