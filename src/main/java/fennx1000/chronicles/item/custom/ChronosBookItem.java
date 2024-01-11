package fennx1000.chronicles.item.custom;

import fennx1000.chronicles.entity.ModEntities;
import fennx1000.chronicles.entity.custom.TimeSpikeProjectile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ChronosBookItem extends Item {
    public ChronosBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            // Calculate the direction the player is looking
            float pitch = user.getPitch();
            float yaw = user.getYaw();
            double x = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
            double y = -Math.sin(Math.toRadians(pitch));
            double z = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));

            // Set the arrow's velocity based on the player's view direction
            TimeSpikeProjectile timeSpike = new TimeSpikeProjectile(ModEntities.TIME_SPIKE, world);
            timeSpike.setVelocity(x, y, z, 1.5F, 1.0F);
            // Spawn the arrow in the world
            world.spawnEntity(timeSpike);
        }

        return super.use(world, user, hand);
    }
}
