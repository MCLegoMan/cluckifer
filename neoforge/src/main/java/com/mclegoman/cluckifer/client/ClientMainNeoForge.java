/*
    Cluckifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Cluckifer
    License: GNU LGPLv3
*/

package com.mclegoman.cluckifer.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = "fleecifer", dist = Dist.CLIENT)
public final class ClientMainNeoForge {
    public ClientMainNeoForge() {
        ClientMain.init();
    }
}
