package tfar.cullparticles;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;

public class MixinHooks {
  public static final Minecraft mc = Minecraft.getInstance();
  public static void cullParticles(Particle particle, IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
    if (((Clipper) mc.worldRenderer).getClippingHelper().isBoundingBoxInFrustum(particle.getBoundingBox()))
      particle.renderParticle(buffer,renderInfo,partialTicks);
  }
}
