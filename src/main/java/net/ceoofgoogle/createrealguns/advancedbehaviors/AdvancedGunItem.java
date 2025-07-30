package net.ceoofgoogle.createrealguns.advancedbehaviors;

import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.ntgl.client.animators.GunAnimator;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.ntgl.common.util.interfaces.IGunModifier;
import net.minecraft.world.item.ItemDisplayContext;

import java.util.function.BiFunction;

public class AdvancedGunItem extends GunItem {
    public AdvancedGunItem(Properties properties, IGunModifier... modifiers) {
        super(properties, modifiers);
    }

    public BiFunction<ItemDisplayContext, DynamicGeoItemRenderer<GunAnimator>, GunAnimator> getAnimatorFactory() {
        return AdvancedAnimator::new;
    }
}
