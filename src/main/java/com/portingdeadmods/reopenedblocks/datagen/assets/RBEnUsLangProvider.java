package com.portingdeadmods.reopenedblocks.datagen.assets;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.registries.RBBlocks;
import com.portingdeadmods.reopenedblocks.registries.RBItems;
import com.portingdeadmods.reopenedblocks.registries.RBTranslations;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class RBEnUsLangProvider extends LanguageProvider {
    public RBEnUsLangProvider(PackOutput output) {
        super(output, ReopenedBlocks.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        RBTranslations.TRANSLATIONS.getDefaultTranslations().forEach(this::add);

        addItem(RBItems.EXAMPLE_ITEM, "Example Item");

        addBlock(RBBlocks.EXAMPLE_BLOCK, "Example Block");
    }

}
