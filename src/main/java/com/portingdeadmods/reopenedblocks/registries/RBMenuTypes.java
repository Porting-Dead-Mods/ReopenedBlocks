package com.portingdeadmods.reopenedblocks.registries;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.content.menus.ExampleMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class RBMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, ReopenedBlocks.MODID);

    public static final Supplier<MenuType<ExampleMenu>> EXAMPLE = MENU_TYPES.register("example", () -> IMenuTypeExtension.create(ExampleMenu::new));
}
