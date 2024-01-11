package fennx1000.chronicles.entity;

import fennx1000.chronicles.Chronicles;
import fennx1000.chronicles.entity.custom.TimeSpikeProjectile;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<TimeSpikeProjectile> TIME_SPIKE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Chronicles.MODID, "time_spike"),
            FabricEntityTypeBuilder.<TimeSpikeProjectile>create(SpawnGroup.MISC, TimeSpikeProjectile::new)
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

}
