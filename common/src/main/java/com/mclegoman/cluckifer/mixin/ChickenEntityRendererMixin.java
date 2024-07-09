/*
    Cluckifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Cluckifer
    License: GNU LGPLv3
*/

package com.mclegoman.cluckifer.mixin;

import com.mclegoman.cluckifer.client.model.Models;
import com.mclegoman.cluckifer.client.renderer.EyesOverlayFeatureRenderer;
import net.minecraft.client.render.entity.ChickenEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChickenEntityRenderer.class)
public abstract class ChickenEntityRendererMixin extends MobEntityRenderer<ChickenEntity, ChickenEntityModel<ChickenEntity>> {
	public ChickenEntityRendererMixin(EntityRendererFactory.Context context, ChickenEntityModel<ChickenEntity> entityModel, float f) {
		super(context, entityModel, f);
	}
	@Inject(method = "<init>(Lnet/minecraft/client/render/entity/EntityRendererFactory$Context;)V", at = @At("TAIL"))
	private void perspective$init(EntityRendererFactory.Context context, CallbackInfo ci) {
		this.addFeature(new EyesOverlayFeatureRenderer<>(this, new ChickenEntityModel<>(context.getPart(Models.chickenEyes)), Identifier.of("cluckifer", "textures/entity/chicken/chicken_eyes.png"), false));
		this.addFeature(new EyesOverlayFeatureRenderer<>(this, new ChickenEntityModel<>(context.getPart(Models.chickenEyesEmissive)), Identifier.of("cluckifer", "textures/entity/chicken/chicken_eyes_emissive.png"), true));
	}
}
