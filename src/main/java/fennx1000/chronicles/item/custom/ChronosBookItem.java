package fennx1000.chronicles.item.custom;

import fennx1000.chronicles.entity.ModEntities;
import fennx1000.chronicles.entity.custom.TimeSpikeProjectile;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
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

            // Convert pitch and yaw to radians
            double pitchRad = Math.toRadians(pitch);
            double yawRad = Math.toRadians(yaw);

            // Calculate the direction vector
            double x = -Math.sin(yawRad) * Math.cos(pitchRad);
            double y = -Math.sin(pitchRad);
            double z = Math.cos(yawRad) * Math.cos(pitchRad);

            // Set the entity's velocity based on the player's view direction
            TimeSpikeProjectile timeSpike = new TimeSpikeProjectile(ModEntities.TIME_SPIKE, world);
            timeSpike.setPosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
            timeSpike.setVelocity(x, y, z, 1.5F, 0.0F); // Adjust the last parameter as needed

            // Spawn the entity in the world
            world.spawnEntity(timeSpike);
        }

        return super.use(world, user, hand);
    }

}
