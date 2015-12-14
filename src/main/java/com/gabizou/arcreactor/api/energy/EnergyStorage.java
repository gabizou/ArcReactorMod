package com.gabizou.arcreactor.api.energy;

public interface EnergyStorage extends EnergySupplier {

    double supplyPower(double amount, PowerModifier mode);

    double getMaxPower();

    double getCurrentPower();

}
