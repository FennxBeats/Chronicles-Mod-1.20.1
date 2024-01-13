package fennx1000.chronicles.block;

import fennx1000.chronicles.Chronicles;
import fennx1000.chronicles.block.custom.FishingRodStand;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block FISHING_ROD_STAND = registerBlock("fishing_rod_stand",
            new FishingRodStand(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Chronicles.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Chronicles.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Chronicles.LOGGER.info("Registering Mod Blocks for " + Chronicles.MODID);
    }

}
