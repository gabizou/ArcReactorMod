package com.gabizou.arcreactor.tile;

import com.gabizou.arcreactor.api.energy.EnergySupplier;
import com.gabizou.arcreactor.api.energy.PowerModifier;
import com.gabizou.arcreactor.util.NbtKeys;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

import java.util.Random;

// Note that for sponge integration, we simply have to use mixins, because well, mixins.
public class TileArcReactor extends TileEntity implements EnergySupplier, ITickable {

    private double outputCapacity = 10;
    private final Random random = new Random();

    public TileArcReactor() {
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.outputCapacity = compound.getDouble(NbtKeys.REACTOR_OUTPUT_CAPACITY);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setDouble(NbtKeys.REACTOR_OUTPUT_CAPACITY, this.outputCapacity);
    }

    @Override
    public String getTypeId() {
        return "ArcReactor";
    }

    @Override
    public double drawPower(double amount, PowerModifier powerModifier) {
        if (powerModifier == PowerModifier.STEADY) {
            return Math.min(this.outputCapacity, amount);
        } else {
            return Math.min(this.outputCapacity * this.random.nextDouble(), amount);
        }
    }

    @Override
    public void update() {

    }
}
