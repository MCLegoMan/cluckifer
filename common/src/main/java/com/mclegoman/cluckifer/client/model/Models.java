/*
    Cluckifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Cluckifer
    License: GNU LGPLv3
*/

package com.mclegoman.cluckifer.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class Models {
	public static final EntityModelLayer chickenEyes = new EntityModelLayer(Identifier.of("fleecifer", "chicken"), "eyes");
	public static final EntityModelLayer chickenEyesEmissive = new EntityModelLayer(Identifier.of("fleecifer", "chicken"), "eyes_emissive");
	public static void init() {
		EntityModelLayerRegistry.registerModelLayer(chickenEyes, () -> getChickenTexturedModelData(new Dilation(0.001F)));
		EntityModelLayerRegistry.registerModelLayer(chickenEyesEmissive, () -> getChickenTexturedModelData(new Dilation(0.002F)));
	}
	public static TexturedModelData getChickenTexturedModelData(Dilation dilation) {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, dilation), ModelTransform.pivot(0.0F, 15.0F, -4.0F));
		modelPartData.addChild("beak", ModelPartBuilder.create().uv(14, 0).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, dilation), ModelTransform.pivot(0.0F, 15.0F, -4.0F));
		modelPartData.addChild("red_thing", ModelPartBuilder.create().uv(14, 4).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, dilation), ModelTransform.pivot(0.0F, 15.0F, -4.0F));
		modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F, dilation), ModelTransform.of(0.0F, 16.0F, 0.0F, 1.5707964F, 0.0F, 0.0F));
		ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, dilation);
		modelPartData.addChild("right_leg", modelPartBuilder, ModelTransform.pivot(-2.0F, 19.0F, 1.0F));
		modelPartData.addChild("left_leg", modelPartBuilder, ModelTransform.pivot(1.0F, 19.0F, 1.0F));
		modelPartData.addChild("right_wing", ModelPartBuilder.create().uv(24, 13).cuboid(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, dilation), ModelTransform.pivot(-4.0F, 13.0F, 0.0F));
		modelPartData.addChild("left_wing", ModelPartBuilder.create().uv(24, 13).cuboid(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, dilation), ModelTransform.pivot(4.0F, 13.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
}
