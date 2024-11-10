package com.pedrohcs8.bmp3.client.model;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.entities.DirtBikeEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class DirtBikeModel<T extends DirtBikeEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "dirt_bike"), "main");
	private final ModelPart Motocicleta;
	private final ModelPart RodaFrente;
	private final ModelPart RodaTraz;
	private final ModelPart Body;
	private final ModelPart Motor;
	private final ModelPart Paralama;
	private final ModelPart Banco;
	private final ModelPart Guidao;

	public DirtBikeModel(ModelPart root) {
		this.Motocicleta = root.getChild("Motocicleta");
		this.RodaFrente = this.Motocicleta.getChild("RodaFrente");
		this.RodaTraz = this.Motocicleta.getChild("RodaTraz");
		this.Body = this.Motocicleta.getChild("Body");
		this.Motor = this.Body.getChild("Motor");
		this.Paralama = this.Body.getChild("Paralama");
		this.Banco = this.Body.getChild("Banco");
		this.Guidao = this.Body.getChild("Guidao");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Motocicleta = partdefinition.addOrReplaceChild("Motocicleta", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 20.1716F, -3.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RodaFrente = Motocicleta.addOrReplaceChild("RodaFrente", CubeListBuilder.create().texOffs(18, 39).addBox(-4.1213F, -1.2929F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(-1.0F, -3.1716F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 40).addBox(2.1213F, -1.2929F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 7).addBox(-2.0F, 2.8284F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 10).addBox(-2.0F, -3.4142F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 28).addBox(-1.0F, -0.1716F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 51).addBox(-1.0F, -0.1716F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 7.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition lateralcima4_r1 = RodaFrente.addOrReplaceChild("lateralcima4_r1", CubeListBuilder.create().texOffs(50, 50).addBox(-1.5858F, -0.5858F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7071F, -2.1213F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition lateralcima3_r1 = RodaFrente.addOrReplaceChild("lateralcima3_r1", CubeListBuilder.create().texOffs(40, 50).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition lateralbaixo4_r1 = RodaFrente.addOrReplaceChild("lateralbaixo4_r1", CubeListBuilder.create().texOffs(14, 50).addBox(-1.5858F, -0.5858F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8284F, 2.4142F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition lateralbaixo3_r1 = RodaFrente.addOrReplaceChild("lateralbaixo3_r1", CubeListBuilder.create().texOffs(50, 13).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4142F, 2.4142F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Aro4_r1 = RodaFrente.addOrReplaceChild("Aro4_r1", CubeListBuilder.create().texOffs(8, 56).addBox(1.0355F, -7.4645F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4645F, 4.2929F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Aro3_r1 = RodaFrente.addOrReplaceChild("Aro3_r1", CubeListBuilder.create().texOffs(4, 56).addBox(1.0355F, -7.4645F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5355F, 2.2929F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Aro2_r1 = RodaFrente.addOrReplaceChild("Aro2_r1", CubeListBuilder.create().texOffs(30, 54).addBox(0.5355F, -8.4645F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5355F, -0.7071F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition RodaTraz = Motocicleta.addOrReplaceChild("RodaTraz", CubeListBuilder.create().texOffs(12, 56).addBox(-4.1213F, -1.2929F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 56).addBox(-1.0F, -3.1716F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 45).addBox(2.1213F, -1.2929F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 51).addBox(-2.0F, 2.8284F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 53).addBox(-2.0F, -3.4142F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 14).addBox(-1.0F, -0.1716F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 40).addBox(-1.0F, -0.1716F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 30).addBox(-1.0F, -0.1716F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 32).addBox(-1.0F, -0.1716F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, -12.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Conector4_r1 = RodaTraz.addOrReplaceChild("Conector4_r1", CubeListBuilder.create().texOffs(50, 0).addBox(-5.0F, -0.1716F, 0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 27).addBox(-5.0F, -0.1716F, 4.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4625F, -2.8726F, -3.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition lateralcima5_r1 = RodaTraz.addOrReplaceChild("lateralcima5_r1", CubeListBuilder.create().texOffs(20, 54).addBox(-1.5858F, -0.5858F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7071F, -2.1213F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition lateralcima4_r2 = RodaTraz.addOrReplaceChild("lateralcima4_r2", CubeListBuilder.create().texOffs(44, 53).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition lateralbaixo5_r1 = RodaTraz.addOrReplaceChild("lateralbaixo5_r1", CubeListBuilder.create().texOffs(34, 53).addBox(-1.5858F, -0.5858F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8284F, 2.4142F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition lateralbaixo4_r2 = RodaTraz.addOrReplaceChild("lateralbaixo4_r2", CubeListBuilder.create().texOffs(10, 53).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4142F, 2.4142F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Aro5_r1 = RodaTraz.addOrReplaceChild("Aro5_r1", CubeListBuilder.create().texOffs(42, 56).addBox(1.0355F, -7.4645F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4645F, 4.2929F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Aro4_r2 = RodaTraz.addOrReplaceChild("Aro4_r2", CubeListBuilder.create().texOffs(38, 56).addBox(1.0355F, -7.4645F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5355F, 2.2929F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Aro3_r2 = RodaTraz.addOrReplaceChild("Aro3_r2", CubeListBuilder.create().texOffs(54, 53).addBox(0.5355F, -8.4645F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5355F, -0.7071F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition Body = Motocicleta.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Motor = Body.addOrReplaceChild("Motor", CubeListBuilder.create().texOffs(60, 18).addBox(1.5F, -7.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 21).addBox(-2.5F, -7.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 37).addBox(-1.5F, -7.0F, 1.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 57).addBox(-2.0F, -6.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 57).addBox(1.0F, -6.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 3.8284F, -7.0F));

		PartDefinition cube_r1 = Motor.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 61).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 50).addBox(3.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 53).addBox(0.5F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.5425F, 4.7207F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Motor.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 61).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 16).addBox(0.5F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 42).addBox(3.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.5425F, 0.7207F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Motor.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(58, 16).addBox(-2.5F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Motor.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 2).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 58).addBox(3.5F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.5425F, 1.7207F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Motor.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 56).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 56).addBox(-4.5F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.3787F, 5.9873F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Motor.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(60, 10).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 6).addBox(-4.5F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.1161F, 1.5399F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Paralama = Body.addOrReplaceChild("Paralama", CubeListBuilder.create().texOffs(60, 24).addBox(-7.0F, 0.8284F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 27).addBox(-4.0F, 0.8284F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Paralama.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(50, 2).addBox(-0.5F, -9.5557F, 4.3501F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -11.604F, 2.8762F, -1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r8 = Paralama.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(54, 37).addBox(-0.5F, -7.5557F, 4.3501F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -10.5621F, 1.6739F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Paralama.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 46).addBox(-0.5F, -9.5557F, 4.3501F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -10.5621F, -1.3261F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r10 = Paralama.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(28, 9).addBox(-1.0F, -0.1716F, -1.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -10.7312F, 3.6742F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r11 = Paralama.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(14, 46).addBox(-1.0F, 0.8284F, -1.0F, 3.0F, -1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -10.3892F, 2.7345F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r12 = Paralama.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -1.1716F, -1.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -1.1716F, -1.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -10.0472F, 1.7948F, -1.2217F, 0.0F, 0.0F));

		PartDefinition Banco = Body.addOrReplaceChild("Banco", CubeListBuilder.create().texOffs(24, 30).addBox(-7.5F, -8.6716F, -8.3137F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(44, 30).addBox(-7.5F, -11.1398F, -16.8441F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(-6.5F, -9.6716F, -10.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-7.5F, -7.0257F, -9.3137F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = Banco.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 45).addBox(-5.0F, -5.8532F, -0.8604F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -7.0846F, -10.4593F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r14 = Banco.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(46, 23).addBox(-4.5F, -3.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.8672F, -9.1249F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r15 = Banco.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(46, 18).addBox(-4.5F, -5.0F, -1.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.852F, -9.2986F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r16 = Banco.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(40, 45).addBox(-3.5F, -2.0F, -1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.9655F, -13.8517F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r17 = Banco.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 39).addBox(-3.5F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.6976F, -11.1328F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r18 = Banco.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(37, 27).addBox(-3.5F, -3.0F, 2.0F, 5.0F, 3.0F, -4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.5928F, -1.3612F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r19 = Banco.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(24, 37).addBox(-2.5F, -6.0F, -1.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -3.3553F, -1.972F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r20 = Banco.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(28, 18).addBox(-2.0F, -8.0F, -1.0F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -2.502F, 1.5311F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Guidao = Body.addOrReplaceChild("Guidao", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.8284F, -7.0F));

		PartDefinition cube_r21 = Guidao.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(44, 35).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -15.8794F, 8.316F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r22 = Guidao.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(18, 44).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -14.0F, 7.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r23 = Guidao.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(58, 55).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -14.0F, 9.0F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
		Motocicleta.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
	}


}