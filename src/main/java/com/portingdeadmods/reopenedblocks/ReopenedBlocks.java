package com.portingdeadmods.reopenedblocks;

import com.portingdeadmods.portingdeadlibs.api.blockentities.ContainerBlockEntity;
import com.portingdeadmods.reopenedblocks.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;

@Mod(ReopenedBlocks.MODID)
public final class ReopenedBlocks {
    public static final String MODID = "reopenedblocks";
    public static final String MODNAME = "ReopenedBlocks";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ReopenedBlocks(IEventBus modEventBus, ModContainer modContainer) {
        RBItems.ITEMS.register(modEventBus);
        RBBlocks.BLOCKS.register(modEventBus);
        RBTranslations.TRANSLATIONS.register(modEventBus);
        RBCreativeTabs.TABS.register(modEventBus);
        RBBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        RBMenuTypes.MENU_TYPES.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, ReopenedBlocksConfig.SPEC);

        modEventBus.addListener(this::registerCapabilities);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RBBlockEntityTypes.EXAMPLE.get(), ContainerBlockEntity::getItemHandlerOnSide);
    }
}
