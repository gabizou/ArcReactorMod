package com.gabizou.arcreactor.block;

import com.gabizou.arcreactor.tile.TileArcReactor;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockArcReactor extends Block implements ITileEntityProvider {

    public BlockArcReactor() {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileArcReactor();
    }
}
