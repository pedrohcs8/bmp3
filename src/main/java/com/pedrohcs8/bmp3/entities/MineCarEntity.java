package com.pedrohcs8.bmp3.entities;

import com.pedrohcs8.bmp3.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class MineCarEntity extends AbstractHorse {
    public MineCarEntity(EntityType<? extends AbstractHorse> type, Level level) {
        super(type, level);
        setNoAi(true);
    }

    public MineCarEntity(Level level, double x, double y, double z) {
        this(EntityInit.mine_car_entity.get(), level);
        setPos(x, y, z);
    }

    public MineCarEntity(Level level, BlockPos pos) {
        this(level, pos.getX(), pos.getY(), pos.getZ());
    }

    public static AttributeSupplier.Builder createMineCarAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.JUMP_STRENGTH, 0.7)
                .add(Attributes.MAX_HEALTH, 53.0)
                .add(Attributes.MOVEMENT_SPEED, 0.500F)
                .add(Attributes.STEP_HEIGHT, 1.0)
                .add(Attributes.SAFE_FALL_DISTANCE, 6.0)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0.5);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        pPlayer.setYRot(this.getYRot());
        pPlayer.setXRot(this.getXRot());
        pPlayer.startRiding(this);
        this.setTamed(true);
        this.equipSaddle(new ItemStack(Items.SADDLE, 1), SoundSource.MASTER);

        return InteractionResult.sidedSuccess(this.level().isClientSide);
    }

    @Override
    public void openCustomInventoryScreen(Player pPlayer) {
        return;
    }

    @Override
    protected void registerGoals() {
        return;
    }

    @Override
    protected void dropEquipment() {
        return;
    }
}
