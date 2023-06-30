package com.nttdata.msclient.infrastructure.dao.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class ClientEntity {

  @Id
  private String id;
  private String profileId;
  private String dni;
  private String firstName;
  private String otherNames;
  private String firstSurname;
  private String secondSurname;
  private LocalDateTime date;

  private ProfileEntity profile;

}
