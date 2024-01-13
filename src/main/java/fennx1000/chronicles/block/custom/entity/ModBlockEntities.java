package fennx1000.chronicles.block.custom.entity;

import fennx1000.chronicles.Chronicles;
import fennx1000.chronicles.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<FishingRodStandEntity> FISHING_ROD_STAND_BLOCK_ENTITY =
            Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Chronicles.MODID, "fishing_rod_stand_be"),
            FabricBlockEntityTypeBuilder.create(FishingRodStandEntity::new,
                    ModBlocks.FISHING_ROD_STAND).build());
    public static void registerBlockEntities() {
        Chronicles.LOGGER.info("Registering Block Entities for " + Chronicles.MODID);
    }
}
