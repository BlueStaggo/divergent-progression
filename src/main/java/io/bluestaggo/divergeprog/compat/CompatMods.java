package io.bluestaggo.divergeprog.compat;

import net.fabricmc.loader.api.FabricLoader;

public final class CompatMods {
    public static final boolean BRONZE = FabricLoader.getInstance().isModLoaded("bronze");
    public static final boolean BETTER_NETHER = FabricLoader.getInstance().isModLoaded("betternether");

    private CompatMods() {
    }

    public static void initialize() {
        if (BRONZE) {
            BronzeItems.initialize();
        }

        if (BETTER_NETHER) {
            BetterNetherItems.initialize();
        }
    }
}
