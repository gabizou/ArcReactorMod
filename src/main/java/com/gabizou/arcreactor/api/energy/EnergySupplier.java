package com.gabizou.arcreactor.api.energy;

import com.gabizou.arcreactor.api.Identifiable;

public interface EnergySupplier extends Identifiable {

    double drawPower(double amount, PowerModifier powerModifier);

}
