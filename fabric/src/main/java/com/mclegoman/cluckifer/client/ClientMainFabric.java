/*
    Cluckifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Cluckifer
    License: GNU LGPLv3
*/

package com.mclegoman.cluckifer.client;

import net.fabricmc.api.ClientModInitializer;

public final class ClientMainFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient()  {
        ClientMain.init();
    }
}
