package com.portingdeadmods.reopenedblocks.content.blockentities;

import com.portingdeadmods.portingdeadlibs.api.blockentities.ContainerBlockEntity;
import com.portingdeadmods.portingdeadlibs.utils.capabilities.HandlerUtils;
import com.portingdeadmods.reopenedblocks.content.menus.ExampleMenu;
import com.portingdeadmods.reopenedblocks.registries.RBBlockEntityTypes;
import com.portingdeadmods.reopenedblocks.registries.RBTranslations;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ExampleBlockEntity extends ContainerBlockEntity implements MenuProvider {
    public ExampleBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RBBlockEntityTypes.EXAMPLE.get(), blockPos, blockState);
        addItemHandler(HandlerUtils::newItemStackHandler, builder -> builder
                .slots(9)
                .onChange(slot -> this.updateData()));
    }

    @Override
    public Component getDisplayName() {
        return RBTranslations.EXAMPLE_SCREEN_TITLE.component();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new ExampleMenu(i, inventory, this);
    }
}