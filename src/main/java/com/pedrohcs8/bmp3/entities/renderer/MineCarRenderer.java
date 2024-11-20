package com.pedrohcs8.bmp3.entities.renderer;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.entities.model.MineCarModel;
import com.pedrohcs8.bmp3.entities.MineCarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MineCarRenderer extends MobRenderer<MineCarEntity, MineCarModel<MineCarEntity>> {
    public static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/vehicles/car_texture.png");

    public MineCarRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MineCarModel<>(pContext.bakeLayer(MineCarModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(MineCarEntity pEntity) {
        return texture;
    }
}
