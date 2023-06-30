package com.nttdata.msclient.infrastructure.mapper;

import com.nttdata.msclient.domain.model.Profile;
import com.nttdata.msclient.infrastructure.dao.entity.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {

  ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

  default Profile map(ProfileEntity profile) {
    return Profile.builder()
            .id(profile.getId())
            .name(profile.getName())
            .build();
  }

}
