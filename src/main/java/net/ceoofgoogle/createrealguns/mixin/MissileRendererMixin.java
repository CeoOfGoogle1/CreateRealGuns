package net.ceoofgoogle.createrealguns.mixin;

import com.nukateam.ntgl.client.render.renderers.projectiles.MissileRenderer;
import com.nukateam.ntgl.common.foundation.entity.MissileEntity;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MissileRenderer.class)
public abstract class MissileRendererMixin {
    /**
     * @author me
     * @reason because
     */
    @Overwrite
    public ResourceLocation getTextureLocation(MissileEntity entity) {
        return new ResourceLocation("createrealguns", "assets/createrealguns/textures/rocket_cartridge.png");
    }
}
