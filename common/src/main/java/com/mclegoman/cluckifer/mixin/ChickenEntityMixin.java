/*
    Cluckifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Cluckifer
    License: GNU LGPLv3
*/

package com.mclegoman.cluckifer.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChickenEntity.class)
public abstract class ChickenEntityMixin extends AnimalEntity {
	protected ChickenEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}
	@Inject(method = "createChickenAttributes", at = @At("RETURN"), cancellable = true)
	private static void createAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
		cir.setReturnValue(cir.getReturnValue().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0).add(EntityAttributes.GENERIC_ARMOR, 2.0).add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0));
	}
	@Inject(method = "initGoals", at = @At("RETURN"))
	private void initGoals(CallbackInfo ci) {
		this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.add(0, new MeleeAttackGoal(this, 1.25, true));
		this.goalSelector.add(1, new RevengeGoal(this).setGroupRevenge(SheepEntity.class));
	}
}
