package com.portingdeadmods.reopenedblocks.registries;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.content.blockentities.ExampleBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class RBBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ReopenedBlocks.MODID);

    public static final Supplier<BlockEntityType<ExampleBlockEntity>> EXAMPLE = BLOCK_ENTITY_TYPES.register("example", () -> BlockEntityType.Builder.of(ExampleBlockEntity::new, RBBlocks.EXAMPLE_BLOCK.get())
            .build(null));
}
