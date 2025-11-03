package com.portingdeadmods.reopenedblocks.datagen.assets;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.registries.RBBlocks;
import com.portingdeadmods.reopenedblocks.registries.RBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class RBItemModelProvider extends ItemModelProvider {
    public RBItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ReopenedBlocks.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        RBBlocks.BLOCKS.getBlockItems().stream().map(Supplier::get).map(BlockItem::getBlock).forEach(this::simpleBlockItem);

        basicItem(RBItems.EXAMPLE_ITEM.get());
    }
}
