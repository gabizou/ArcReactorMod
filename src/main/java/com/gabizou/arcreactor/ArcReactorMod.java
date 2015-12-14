package com.gabizou.arcreactor;

import com.gabizou.arcreactor.tile.TileArcBattery;
import com.gabizou.arcreactor.tile.TileArcReactor;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ArcReactorMod.MODID, version = ArcReactorMod.VERSION)
public class ArcReactorMod
{
    public static final String MODID = "arcreactor";
    public static final String VERSION = "0.0.1";
    
    @EventHandler
    public void init(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(ArcReactor.ARC_REACTOR, "arc_reactor");
        TileEntity.addMapping(TileArcReactor.class, "ArcReactor");
        TileEntity.addMapping(TileArcBattery.class, "ArcBattery");

    }
}
