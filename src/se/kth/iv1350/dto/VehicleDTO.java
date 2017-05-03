package se.kth.iv1350.dto;

/**
 * Created by Emil on 2017-04-27.
 */
public class VehicleDTO {

    private String registrationNumber;

    /**
     * Creates a vehicle DTO that currently only holds its registration number
     * @param registrationNumber The vehicles registration number
     */
    public VehicleDTO(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VehicleDTO))
            return false;
        VehicleDTO vehicleToCompare = (VehicleDTO) obj;
        if(vehicleToCompare.getRegistrationNumber().equalsIgnoreCase(this.registrationNumber))
            return true;
        return false;
    }
}
