package tfar.cullparticles.mixin;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import tfar.cullparticles.FrustumCapture;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer implements FrustumCapture {

  private ClippingHelper clippingHelper;

  @ModifyVariable(
          method = "updateCameraAndRender",
          at = @At(value = "INVOKE",
                  target = "Lnet/minecraft/client/renderer/culling/ClippingHelper;setCameraPosition(DDD)V",ordinal = 1)
  )
  private ClippingHelper captureFrustum(ClippingHelper clippingHelper) {
    this.clippingHelper = clippingHelper;
    return clippingHelper;
  }

  @Override
  public ClippingHelper getFrustum() {
    return clippingHelper;
  }
}
