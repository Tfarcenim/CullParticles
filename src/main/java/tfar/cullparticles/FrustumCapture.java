package tfar.cullparticles;

import net.minecraft.client.renderer.culling.ClippingHelper;

public interface FrustumCapture {
  ClippingHelper getFrustum();
}
