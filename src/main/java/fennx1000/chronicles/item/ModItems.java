package fennx1000.chronicles.item;

import fennx1000.chronicles.Chronicles;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item CHRONOS_PAGE = registerItem("chronos_page", new Item(new FabricItemSettings().maxCount(16).fireproof().rarity(Rarity.EPIC)));

    private static void addItemsToInventoryTabItemGroup(FabricItemGroupEntries entries) {
        // entries.add(CHRONOS_PAGE);
    }

    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Chronicles.MODID, name), item);
    }

    public static void registerModItems() {
        Chronicles.LOGGER.info("Registering Mod Items for " + Chronicles.MODID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INVENTORY).register(ModItems::addItemsToInventoryTabItemGroup);
    }

}
