package tomeko.bossbartweaks.mixin;

import net.minecraft.client.Minecraft;
//? if >= 26.1 {
/*import net.minecraft.client.gui.GuiGraphicsExtractor;
 *///?} else {
import net.minecraft.client.gui.GuiGraphics;
        //?}
import net.minecraft.client.gui.components.BossHealthOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tomeko.bossbartweaks.config.BossbarTweaksConfig;

@Mixin(BossHealthOverlay.class)
public class BossHealthOverlayMixin {
    //? if >= 26.1 {
    /*@Inject(method = "extractRenderState", at = @At("HEAD"))
    private void extractRenderState(GuiGraphicsExtractor graphics, CallbackInfo ci) {
     *///?} else {
    @Inject(method = "render", at = @At("HEAD"))
    private void render(GuiGraphics graphics, CallbackInfo ci) {
        //?}
        graphics.pose().pushMatrix();

        float x = Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2.0f;
        float y = 0.0f;

        graphics.pose().translate(x, y);
        graphics.pose().scale(BossbarTweaksConfig.scale / 100f, BossbarTweaksConfig.scale / 100f);
        graphics.pose().translate(-x, -y);
    }

    //? if >= 26.1 {
    /*@Inject(method = "extractRenderState", at = @At("RETURN"))
    private void extractRenderStateRETURN(GuiGraphicsExtractor graphics, CallbackInfo ci) {
     *///?} else {
    @Inject(method = "render", at = @At("RETURN"))
    private void renderRETURN(GuiGraphics graphics, CallbackInfo ci) {
        //?}
        graphics.pose().popMatrix();
    }
}
