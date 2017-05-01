package se.kth.iv1350.dto;

/**
 * Created by Emil on 2017-04-27.
 */
public class VehicleDTO {

    private String registrationNumber;

    public VehicleDTO(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
