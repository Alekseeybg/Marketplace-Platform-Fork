package com.platform.marketplace.Marketplace.Platform.mapper;

import com.platform.marketplace.Marketplace.Platform.dto.OrganisationDTO;
import com.platform.marketplace.Marketplace.Platform.model.Location;
import com.platform.marketplace.Marketplace.Platform.model.Organisation;
import com.platform.marketplace.Marketplace.Platform.model.User;
import com.platform.marketplace.Marketplace.Platform.repository.LocationRepository;
import com.platform.marketplace.Marketplace.Platform.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@RequiredArgsConstructor
@Component
public class OrganisationRegDTOToOrganisation implements Function<OrganisationDTO, Organisation> {
    OrganisationRegDtoToUser userConverter = new OrganisationRegDtoToUser();
//    LocationMapper locationMapper = new LocationMapper();

    private final LocationRepository locationRepository;


    @Override
    public Organisation apply(OrganisationDTO organisationDTO) {
        if(Utility.passwordConfirmation(organisationDTO.getPassword() , organisationDTO.getConfirmPassword())) {
            User user = userConverter.apply(organisationDTO);
            List<Location> cities = locationRepository.findLocationsByValue(organisationDTO.getLocations());

            return new Organisation( organisationDTO.getName(), user,  cities);
        } else {
            throw new RuntimeException("Паролата за потвърждение не отговаря на горе подадената.");
        }
    }
}
