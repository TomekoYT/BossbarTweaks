package tomeko.bossbartweaks;

import net.fabricmc.api.ClientModInitializer;
import tomeko.bossbartweaks.config.BossbarTweaksConfig;

public class BossbarTweaks implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BossbarTweaksConfig.register();
    }
}