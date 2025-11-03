package com.portingdeadmods.reopenedblocks;

import com.portingdeadmods.reopenedblocks.client.screens.ExampleScreen;
import com.portingdeadmods.reopenedblocks.registries.RBMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = ReopenedBlocks.MODID, dist = Dist.CLIENT)
public final class ReopenedBlocksClient {
    public ReopenedBlocksClient(IEventBus modEventBus, ModContainer container) {
        modEventBus.addListener(this::registerMenuScreens);

        container.registerConfig(ModConfig.Type.CLIENT, ReopenedBlocksClientConfig.SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    private void registerMenuScreens(RegisterMenuScreensEvent event) {
        event.register(RBMenuTypes.EXAMPLE.get(), ExampleScreen::new);
    }
}
