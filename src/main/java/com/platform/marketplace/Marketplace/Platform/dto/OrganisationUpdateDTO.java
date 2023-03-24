package com.platform.marketplace.Marketplace.Platform.dto;

import com.platform.marketplace.Marketplace.Platform.utility.annotations.EmailExtended;
import com.platform.marketplace.Marketplace.Platform.utility.annotations.OrganisationName;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationUpdateDTO {

    @OrganisationName
    @NotBlank
    private String name;
    @EmailExtended
    private String email;

    private List<String> locations;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
