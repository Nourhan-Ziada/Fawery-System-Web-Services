package com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile;

import com.fci.advanced.se.personsmanagement.ProviderEntity.Mobile.MobileProviderEntity;
import lombok.AllArgsConstructor;

public class VodafoneMobileProviderEntity extends MobileProviderEntity {
  private String nationalID;

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    @Override
    public float retrieveAmount() {

        return getRechargeAmount();
    }
}
