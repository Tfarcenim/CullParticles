package tfar.cullparticles;

import net.minecraft.client.renderer.culling.ClippingHelperImpl;

public interface Clipper {
  ClippingHelperImpl getClippingHelper();
}
