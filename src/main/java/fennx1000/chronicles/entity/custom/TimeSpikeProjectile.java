package fennx1000.chronicles.entity.custom;

import fennx1000.chronicles.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class TimeSpikeProjectile extends ThrownItemEntity {

    private static final float DAMAGE_AMOUNT = 20.0F;
    private ServerPlayerEntity shooter;

    public TimeSpikeProjectile(LivingEntity livingEntity, World world) {
        super(ModEntities.TIME_SPIKE, livingEntity, world);
    }

    public TimeSpikeProjectile(EntityType<TimeSpikeProjectile> timeSpikeProjectileEntityType, World world) {
        super(timeSpikeProjectileEntityType, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.POINTED_DRIPSTONE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if(!this.getWorld().isClient()) {
            // Apply damage to the hit entity
            if (entityHitResult.getEntity() instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) entityHitResult.getEntity();
                target.damage(this.getDamageSources().playerAttack(this.getEntityWorld().getClosestPlayer(this, 1)), DAMAGE_AMOUNT);
                this.discard();
            }

            // You can add more effects or logic here as needed

            // Send entity status to update clients
            this.getWorld().sendEntityStatus(this, (byte)3);
        }
        super.onEntityHit(entityHitResult);
    }
}
