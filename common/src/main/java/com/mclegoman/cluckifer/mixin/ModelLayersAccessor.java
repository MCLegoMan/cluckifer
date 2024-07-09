/*
    Cluckifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Cluckifer
    License: GNU LGPLv3
*/

package com.mclegoman.cluckifer.mixin;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(EntityModelLayers.class)
public interface ModelLayersAccessor {
	@Accessor("LAYERS")
	static Set<EntityModelLayer> getAllModels() {
		throw new AssertionError("");
	}
}
