package fennx1000.chronicles;

import fennx1000.chronicles.item.ModItemGroups;
import fennx1000.chronicles.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronicles implements ModInitializer {

	// mod id \/
	public static final String MODID = "chronicles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		LOGGER.info("Chronicles Initialized!");
	}
}