package com.portingdeadmods.reopenedblocks.registries;

import com.portingdeadmods.reopenedblocks.ReopenedBlocks;
import com.portingdeadmods.reopenedblocks.content.blocks.ExampleBlock;
import com.portingdeadmods.portingdeadlibs.api.utils.PDLDeferredRegisterBlocks;
import net.neoforged.neoforge.registries.DeferredBlock;

public final class RBBlocks {
    public static final PDLDeferredRegisterBlocks BLOCKS = PDLDeferredRegisterBlocks.createBlocksRegister(ReopenedBlocks.MODID, RBItems.ITEMS);

    public static final DeferredBlock<ExampleBlock> EXAMPLE_BLOCK = BLOCKS.registerBlockWithItem("example_block", ExampleBlock::new);

}
