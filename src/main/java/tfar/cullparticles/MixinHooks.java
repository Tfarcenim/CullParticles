package tfar.cullparticles;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraftforge.fml.common.Mod;

@Mod(MixinHooks.MODID)
public class MixinHooks {
  public static final Minecraft mc = Minecraft.getInstance();
  static final String MODID = "cullparticles";

  public static void cullParticles(Particle particle, IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
    if (((FrustumCapture) mc.worldRenderer).getFrustum().isBoundingBoxInFrustum(particle.getBoundingBox()))
      particle.renderParticle(buffer,renderInfo,partialTicks);
  }
}
