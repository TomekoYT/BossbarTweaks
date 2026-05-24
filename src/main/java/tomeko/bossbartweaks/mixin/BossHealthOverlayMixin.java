package tomeko.bossbartweaks.mixin;

//? if >= 26.1 {
/*import net.minecraft.client.gui.GuiGraphicsExtractor;
 *///?} else {

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
        //?}
import net.minecraft.client.gui.components.BossHealthOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tomeko.bossbartweaks.config.BossbarTweaksConfig;

@Mixin(BossHealthOverlay.class)
public abstract class BossHealthOverlayMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void render(GuiGraphics graphics, CallbackInfo ci) {
        graphics.pose().pushMatrix();

        float x = Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2.0f;
        float y = 0.0f;

        graphics.pose().translate(x, y);
        graphics.pose().scale(BossbarTweaksConfig.scale / 100f, BossbarTweaksConfig.scale / 100f);
        graphics.pose().translate(-x, -y);
    }

    @Inject(method = "render", at = @At("RETURN"))
    private void renderRETURN(GuiGraphics graphics, CallbackInfo ci) {
        graphics.pose().popMatrix();
    }
}
