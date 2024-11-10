package com.pedrohcs8.bmp3.client.renderer;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.client.model.DirtBikeModel;
import com.pedrohcs8.bmp3.entities.DirtBikeEntity;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class DirtBikeRenderer extends MobRenderer<DirtBikeEntity, DirtBikeModel<DirtBikeEntity>> {
    public static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/item/moto_texture.png");

    public DirtBikeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DirtBikeModel<>(pContext.bakeLayer(DirtBikeModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(DirtBikeEntity pEntity) {
        return texture;
    }
}