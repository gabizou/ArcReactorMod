package com.gabizou.arcreactor;

import com.gabizou.arcreactor.block.BlockArcReactor;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArcReactor {

    public static final Block ARC_REACTOR;


    static {
        ARC_REACTOR = new BlockArcReactor();
        GameRegistry.registerBlock(ARC_REACTOR, "arc_reactor");

    }
}
