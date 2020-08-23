package tfar.cullparticles.mixin;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.ActiveRenderInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tfar.cullparticles.MixinHooks;

@Mixin(ParticleManager.class)
public class MixinParticleManager {
  @Redirect(method = "renderParticles",
          at = @At(value = "INVOKE",
                  target = "Lnet/minecraft/client/particle/Particle;renderParticle(Lcom/mojang/blaze3d/vertex/IVertexBuilder;Lnet/minecraft/client/renderer/ActiveRenderInfo;F)V"))
  private void cullParticles(Particle particle, IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks){
    MixinHooks.cullParticles(particle,buffer,renderInfo,partialTicks);
  }
}
