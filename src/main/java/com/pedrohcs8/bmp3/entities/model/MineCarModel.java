package com.pedrohcs8.bmp3.entities.model;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.entities.MineCarEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import javax.swing.text.html.parser.Entity;

public class MineCarModel<T extends MineCarEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "mine_car"), "main");
	private final ModelPart Carro;
	private final ModelPart Roda;
	private final ModelPart Roda2;
	private final ModelPart Roda3;
	private final ModelPart Roda4;
	private final ModelPart Body;
	private final ModelPart bone;
	private final ModelPart banco;
	private final ModelPart banco2;

	public MineCarModel(ModelPart root) {
		this.Carro = root.getChild("Carro");
		this.Roda = this.Carro.getChild("Roda");
		this.Roda2 = this.Carro.getChild("Roda2");
		this.Roda3 = this.Carro.getChild("Roda3");
		this.Roda4 = this.Carro.getChild("Roda4");
		this.Body = this.Carro.getChild("Body");
		this.bone = this.Body.getChild("bone");
		this.banco = this.Carro.getChild("banco");
		this.banco2 = this.Carro.getChild("banco2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Carro = partdefinition.addOrReplaceChild("Carro", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.0F, 24.0F, 17.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Roda = Carro.addOrReplaceChild("Roda", CubeListBuilder.create().texOffs(112, 170).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(76, 170).addBox(-3.0F, -9.6569F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(122, 177).addBox(-5.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(136, 177).addBox(1.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(168, 68).addBox(-4.0F, -8.0F, -1.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, 0.0F, -5.0F));

		PartDefinition cube_r1 = Roda.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(148, 170).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = Roda.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(130, 170).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r3 = Roda.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(164, 177).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -6.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = Roda.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(150, 177).addBox(0.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8284F, -6.8284F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Roda2 = Carro.addOrReplaceChild("Roda2", CubeListBuilder.create().texOffs(168, 79).addBox(-4.0F, -8.0F, -1.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(166, 170).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(94, 170).addBox(-3.0F, -9.6569F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(18, 178).addBox(-5.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(178, 28).addBox(1.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, 0.0F, -28.0F));

		PartDefinition cube_r5 = Roda2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(36, 171).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r6 = Roda2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 171).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r7 = Roda2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 178).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -6.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r8 = Roda2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(178, 19).addBox(0.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8284F, -6.8284F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Roda3 = Carro.addOrReplaceChild("Roda3", CubeListBuilder.create().texOffs(54, 171).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(168, 90).addBox(-3.0F, -9.6569F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(46, 178).addBox(-5.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(178, 132).addBox(1.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(54, 160).addBox(-4.0F, -8.0F, -1.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition cube_r9 = Roda3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(174, 50).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r10 = Roda3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(174, 43).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r11 = Roda3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(178, 141).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -6.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r12 = Roda3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(178, 123).addBox(0.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8284F, -6.8284F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Roda4 = Carro.addOrReplaceChild("Roda4", CubeListBuilder.create().texOffs(174, 57).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 170).addBox(-3.0F, -9.6569F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(178, 177).addBox(-5.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(180, 106).addBox(1.8284F, -6.8284F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 160).addBox(-4.0F, -8.0F, -1.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -28.0F));

		PartDefinition cube_r13 = Roda4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(72, 177).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r14 = Roda4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 177).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7071F, -0.7071F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r15 = Roda4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(182, 150).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, -6.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r16 = Roda4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(180, 97).addBox(0.0F, -4.0F, -1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8284F, -6.8284F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Body = Carro.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-36.0F, -10.0F, 5.0F, 44.0F, 1.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(58, 71).addBox(-36.0F, -18.0F, 5.0F, 5.0F, 8.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(58, 51).addBox(-31.0F, -18.0F, 5.0F, 39.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 103).addBox(6.0F, -25.0F, 7.0F, 2.0F, 15.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(100, 25).addBox(-29.0F, -25.0F, 5.0F, 37.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(100, 34).addBox(-29.0F, -25.0F, 27.0F, 37.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 61).addBox(-31.0F, -18.0F, 27.0F, 39.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 114).addBox(-21.8126F, -36.3273F, 5.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-21.8126F, -37.3273F, 5.0F, 26.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(116, 71).addBox(2.1874F, -36.3273F, 5.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(100, 43).addBox(-19.8126F, -36.3273F, 5.0F, 24.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(136, 15).addBox(-19.8126F, -36.3273F, 27.0F, 22.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 184).addBox(-10.8126F, -35.0F, 5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(76, 184).addBox(-10.8126F, -35.0F, 27.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 184).addBox(-4.8126F, -35.0F, 5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(184, 159).addBox(-4.8126F, -35.0F, 27.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 177).addBox(-34.0F, -25.0F, 24.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(106, 177).addBox(-34.0F, -25.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 3.0F, -32.0F));

		PartDefinition cube_r17 = Body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(60, 178).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(86, 138).addBox(-1.0F, -12.0F, 21.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 103).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.5147F, -25.0711F, 6.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition cube_r18 = Body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(184, 0).addBox(-1.0F, -10.6727F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 184).addBox(-1.0F, -10.6727F, -23.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9484F, -24.9656F, 28.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r19 = Body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 51).addBox(-4.0F, -11.0F, -1.0F, 5.0F, 11.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-33.1716F, -15.1716F, 6.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r20 = Body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(52, 138).addBox(-1.5F, -6.0F, -10.0F, 3.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.594F, -24.2811F, 20.0F, 0.0F, 0.0F, 1.309F));

		PartDefinition cube_r21 = Body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(140, 47).addBox(-1.5F, -5.0F, -10.0F, 3.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-34.1755F, -19.7091F, 20.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition bone = Body.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(128, 47).addBox(-37.0F, -11.0F, 29.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(150, 123).addBox(-37.0F, -11.0F, 4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(136, 19).addBox(-22.0F, -11.0F, 29.0F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(136, 22).addBox(-22.0F, -11.0F, 4.0F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 47).addBox(-30.0F, -14.0F, 29.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(116, 97).addBox(-30.0F, -14.0F, 4.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(114, 47).addBox(0.1213F, -13.9497F, 29.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(116, 100).addBox(0.1213F, -13.9497F, 4.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 86).addBox(8.0F, -11.0F, 4.0F, 1.0F, 2.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(98, 129).addBox(-37.0F, -11.0F, 5.0F, 1.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r22 = bone.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(32, 155).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(86, 152).addBox(-3.0F, -2.0F, 24.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8284F, -10.4142F, 5.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r23 = bone.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(152, 43).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(130, 100).addBox(-4.0F, -2.0F, 24.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.7071F, -9.7071F, 5.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r24 = bone.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(152, 68).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(140, 68).addBox(-4.0F, -2.0F, 24.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8284F, -11.8284F, 5.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r25 = bone.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(150, 126).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(130, 97).addBox(-4.0F, -2.0F, 24.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.1716F, -11.8284F, 5.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition banco = Carro.addOrReplaceChild("banco", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, -8.0F, -8.0F, 10.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(148, 129).addBox(7.9319F, -22.3461F, -8.0F, 1.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -6.0F, -14.0F));

		PartDefinition cube_r26 = banco.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(86, 155).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.673F, -9.3801F, -7.0F, 0.0F, 0.0F, -1.309F));

		PartDefinition cube_r27 = banco.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 155).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7071F, -7.7071F, -7.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition banco2 = Carro.addOrReplaceChild("banco2", CubeListBuilder.create().texOffs(0, 140).addBox(-3.0F, -8.0F, -8.0F, 10.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(150, 97).addBox(7.9319F, -22.3461F, -8.0F, 1.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -6.0F, -14.0F));

		PartDefinition cube_r28 = banco2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(150, 155).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.673F, -9.3801F, -7.0F, 0.0F, 0.0F, -1.309F));

		PartDefinition cube_r29 = banco2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(118, 155).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7071F, -7.7071F, -7.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {}

	@Override
	public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
		Carro.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
	}
}