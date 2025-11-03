package com.portingdeadmods.reopenedblocks.datagen;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.datagen.assets.RBBlockStateProvider;
import com.portingdeadmods.reopenedblocks.datagen.assets.RBEnUsLangProvider;
import com.portingdeadmods.reopenedblocks.datagen.assets.RBItemModelProvider;
import com.portingdeadmods.reopenedblocks.datagen.data.RBBlockLootTableProvider;
import com.portingdeadmods.reopenedblocks.datagen.data.RBRecipeProvider;
import com.portingdeadmods.reopenedblocks.datagen.data.RBTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ReopenedBlocks.MODID)
public final class RBDataGatherer {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new RBBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new RBItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new RBEnUsLangProvider(packOutput));

        RBTagsProvider.createTagProviders(generator, packOutput, lookupProvider, existingFileHelper, event.includeServer());
        generator.addProvider(event.includeServer(), new RBRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(RBBlockLootTableProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
    }
}
