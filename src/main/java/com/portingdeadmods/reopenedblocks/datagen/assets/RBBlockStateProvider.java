package com.portingdeadmods.reopenedblocks.datagen.assets;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.registries.RBBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class RBBlockStateProvider extends BlockStateProvider {
    public RBBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ReopenedBlocks.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(RBBlocks.EXAMPLE_BLOCK.get());
    }
}
