package com.pedrohcs8.bmp3.init;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.entities.DirtBikeEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Bmp3.MOD_ID);

    public static final RegistryObject<EntityType<DirtBikeEntity>> dirt_bike_entity = entities.register("dirt_bike", () -> EntityType.Builder.<DirtBikeEntity>of(DirtBikeEntity::new, MobCategory.CREATURE)
            .sized(1.0f, 1.0f)
            .build(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "dirt_bike").toString())
    );
}
