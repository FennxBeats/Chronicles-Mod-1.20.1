package fennx1000.chronicles;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronicles implements ModInitializer {
	public static final String MODID = "chronicles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Chronicles Initialized!");
	}
}