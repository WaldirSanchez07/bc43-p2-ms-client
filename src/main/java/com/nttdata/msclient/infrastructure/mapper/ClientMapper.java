package com.nttdata.msclient.infrastructure.mapper;

import com.nttdata.msclient.domain.model.Client;
import com.nttdata.msclient.domain.model.Profile;
import com.nttdata.msclient.infrastructure.dao.entity.ClientEntity;
import io.reactivex.rxjava3.core.Maybe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    default Client map(ClientEntity client) {
        return Client.builder()
                .id(client.getId())
                .dni(client.getDni())
                .profileId(client.getProfileId())
                .profile(Profile.builder()
                        .id(client.getProfile().getId())
                        .name(client.getProfile().getName())
                        .build())
                .firstName(client.getFirstName())
                .otherNames(client.getOtherNames())
                .firstSurname(client.getFirstSurname())
                .secondSurname(client.getSecondSurname())
                .date(client.getDate())
                .build();
    }

    default ClientEntity map(Client client) {
        return ClientEntity.builder()
                .profileId(client.getProfileId())
                .dni(client.getDni())
                .firstName(client.getFirstName())
                .otherNames(client.getOtherNames())
                .firstSurname(client.getFirstSurname())
                .secondSurname(client.getSecondSurname())
                .date(client.getDate())
                .build();
    }

}
