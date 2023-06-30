package com.nttdata.msclient.domain.model;

import java.time.LocalDateTime;
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
public class Client {

  private String id;
  private String profileId;
  private String dni;
  private String firstName;
  private String otherNames;
  private String firstSurname;
  private String secondSurname;
  private LocalDateTime date;

  private Profile profile;

}
