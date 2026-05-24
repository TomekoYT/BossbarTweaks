package tomeko.bossbartweaks.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.*;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import tomeko.bossbartweaks.utils.Constants;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class BossbarTweaksConfig {
    public static final ConfigClassHandler<BossbarTweaksConfig> CONFIG = ConfigClassHandler.createBuilder(BossbarTweaksConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve(Constants.MOD_ID + ".json"))
                    .build())
            .build();

    @SerialEntry
    public static int scale = 100;

    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Component.literal(Constants.MOD_NAME))

                .category(ConfigCategory.createBuilder()
                        .name(Component.literal(Constants.MOD_NAME + " Config"))

                        .option(Option.<Integer>createBuilder()
                                .name(Component.literal("Scale"))
                                .binding(defaults.scale, () -> config.scale, newVal -> config.scale = newVal)
                                .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Component.literal(value + "%"))
                                        .range(0, 200)
                                        .step(1))
                                .build())
                        .build())

        )).generateScreen(parent);
    }

    public static void register() {
        BossbarTweaksConfig.CONFIG.load();
    }
}
