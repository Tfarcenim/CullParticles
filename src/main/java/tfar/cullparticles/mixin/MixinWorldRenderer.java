package tfar.cullparticles.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import tfar.cullparticles.Clipper;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer implements Clipper {

  private ClippingHelperImpl clippingHelper;

  @Inject(locals = LocalCapture.CAPTURE_FAILHARD,
          method = "getViewVector",
          at = @At(value = "INVOKE",target = "Lnet/minecraft/client/renderer/FogRenderer;updateFogColor(Lnet/minecraft/client/renderer/ActiveRenderInfo;FLnet/minecraft/client/world/ClientWorld;IF)V")
  )
  private void captureClipper(MatrixStack p_228426_1_, float p_228426_2_, long p_228426_3_, boolean p_228426_5_, ActiveRenderInfo p_228426_6_, GameRenderer p_228426_7_, LightTexture p_228426_8_, Matrix4f p_228426_9_, CallbackInfo ci,
                              IProfiler iprofiler, Vec3d vec3d, double d0, double d1, double d2, Matrix4f matrix4f, boolean flag, ClippingHelperImpl clippinghelperimpl) {
    this.clippingHelper = clippinghelperimpl;
  }

  @Override
  public ClippingHelperImpl getClippingHelper() {
    return clippingHelper;
  }
}
