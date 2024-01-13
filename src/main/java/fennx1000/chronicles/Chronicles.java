package fennx1000.chronicles;

import fennx1000.chronicles.block.ModBlocks;
import fennx1000.chronicles.block.custom.entity.ModBlockEntities;
import fennx1000.chronicles.item.ModItemGroups;
import fennx1000.chronicles.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronicles implements ModInitializer {
	// https://www.youtube.com/watch?v=gEYUeu_wraQ&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ&index=6&ab_channel=ModdingbyKaupenjoe
	// mod id \/
	public static final String MODID = "chronicles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlockEntities.registerBlockEntities();
		ModItems.registerModItems();

		LOGGER.info("Chronicles Initialized!");
	}
}