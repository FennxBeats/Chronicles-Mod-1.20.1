package fennx1000.chronicles.item;

import fennx1000.chronicles.Chronicles;
import fennx1000.chronicles.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CHRONICLES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Chronicles.MODID, "chronicles_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chronicles_group"))
                    .icon(() -> new ItemStack(ModItems.CHRONOS_PAGE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CHRONOS_BOOK);
                        entries.add(ModItems.CHRONOS_PAGE);
                        entries.add(ModBlocks.FISHING_ROD_STAND);
                    }).build());

    public static void registerItemGroups() {
        Chronicles.LOGGER.info("Registering Item groups for " + Chronicles.MODID);
    }

}
