package com.gabizou.arcreactor.tile;

import com.gabizou.arcreactor.api.energy.EnergyStorage;
import com.gabizou.arcreactor.api.energy.PowerModifier;
import com.gabizou.arcreactor.util.NbtKeys;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

import java.util.Random;

public class TileArcBattery extends TileEntity implements EnergyStorage, ITickable {

    private double currentPower = 0;
    private double maxPower = 1000;
    private double maxOutPut;
    private final Random random = new Random();

    @Override
    public double supplyPower(double amount, PowerModifier mode) {
        if (this.currentPower >= this.maxPower) {
            return 0;
        }
        if (mode == PowerModifier.STEADY) {
            this.currentPower += amount;
            if (this.currentPower > this.maxPower) {
                final double diff = this.currentPower - this.maxPower;
                this.currentPower = this.maxPower;
                return amount - diff;
            }
            return amount;
        } else {
            final double rand = this.random.nextDouble();
            final double accepted = amount * rand;
            this.currentPower += accepted;
            if (this.currentPower > this.maxPower) {
                final double diff = this.currentPower - this.maxPower;
                this.currentPower = this.maxPower;
                return accepted - diff;
            }
            return accepted;
        }
    }

    @Override
    public double getMaxPower() {
        return this.maxPower;
    }

    @Override
    public double getCurrentPower() {
        return this.currentPower;
    }

    @Override
    public double drawPower(double amount, PowerModifier powerModifier) {
        return 0;
    }

    @Override
    public String getTypeId() {
        return "ArcBattery";
    }

    @Override
    public void update() {

    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.currentPower = compound.getDouble(NbtKeys.BATTERY_CHARGE);
        this.maxPower = compound.getDouble(NbtKeys.BATTERY_MAX_CHARGE);
        this.maxOutPut = compound.getDouble(NbtKeys.BATTERY_MAX_OUTPUT);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setDouble(NbtKeys.BATTERY_CHARGE, this.currentPower);
        compound.setDouble(NbtKeys.BATTERY_MAX_CHARGE, this.maxPower);
        compound.setDouble(NbtKeys.BATTERY_MAX_OUTPUT, this.maxOutPut);
    }
}
