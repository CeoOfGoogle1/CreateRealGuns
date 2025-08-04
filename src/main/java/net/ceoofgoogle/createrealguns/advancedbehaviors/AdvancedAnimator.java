package net.ceoofgoogle.createrealguns.advancedbehaviors;

import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.ntgl.client.animators.GunAnimator;
import com.nukateam.ntgl.client.handlers.ClientHandler;
import com.nukateam.ntgl.client.util.handler.ShootingData;
import com.nukateam.ntgl.client.util.util.TransformUtils;
import com.nukateam.ntgl.common.base.utils.EquipTracker;
import com.nukateam.ntgl.common.data.config.gun.Gun;
import com.nukateam.ntgl.common.util.util.GunData;
import com.nukateam.ntgl.common.util.util.GunModifierHelper;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.*;
import mod.azure.azurelib.core.object.PlayState;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;


public class AdvancedAnimator extends GunAnimator {

    public AdvancedAnimator(ItemDisplayContext transformType, DynamicGeoItemRenderer<GunAnimator> renderer) {
        super(transformType, renderer);

    }

    @Override
    protected AnimationController.AnimationStateHandler<GunAnimator> animate() {
        return (event) -> {
            try {
                AnimationController<GunAnimator> controller = event.getController();
                controller.setAnimationSpeed((double)1.0F);
                LivingEntity entity = this.getEntity();
                RawAnimation holdAnimation = this.getHoldAnimation(event);
                if (!TransformUtils.isHandTransform(this.transformType)) {
                    return event.setAndContinue(holdAnimation);
                } else {
                    boolean isShooting = this.shootingHandler.isShooting(entity, this.arm);
                    ShootingData data = this.shootingHandler.getShootingData(this.arm);
                    RawAnimation animation = RawAnimation.begin();
                    if (this.equipTime > 0 && entity instanceof Player) {
                        Player player = (Player)entity;
                        if (EquipTracker.isEquiping(player, this.getArm())) {
                            animation = this.getEquipAnimation(event);
                            return event.setAndContinue(animation);
                        }
                    }

                    if (this.fireDelay > 0 && data.fireTimer > 0 && this.fireDelay != data.fireTimer) {
                        animation = this.getChargingAnimation(event, data);

                    } else if (this.reloadHandler.isReloading(entity, this.arm) && TransformUtils.isFirstPerson(this.transformType)) {
                        int ammo = Gun.getAmmo(itemStack);
                        if(ammo == 0){
                            animation = getReloadingAnimation(event);

                        } else{
                            animation = getTacReloadAnimation(event);
                        }
                        return event.setAndContinue(animation);
                    } else if (isShooting) {
                        animation = this.getShootingAnimation(event);
                    } else if (this.reloadHandler.isReloading(entity, this.arm.getOpposite()) && TransformUtils.isFirstPerson(this.transformType)) {
                        animation = getHideAnimation();
                    } else if (ClientHandler.getInspectionTicks(this.getArm()) > 0) {
                        int ammo = Gun.getAmmo(itemStack);
                        if(ammo != 0) {
                            animation = this.getInspectionAnimation(event);
                        }else{
                            animation = this.getEmptyInspectionAnimation(event);
                        }
                    } else if (this.currentGun == this.getGunItem()) {
                        animation = holdAnimation;
                    }else if( Gun.getAmmo(itemStack) == 0){
                        animation = this.getEmptyHoldAnimation(event);
                    } else {
                        this.currentGun = this.getGunItem();
                        animation = this.playGunAnim("shot", Animation.LoopType.LOOP);
                    }

                    return event.setAndContinue(animation);
                }
            } catch (Exception var9) {
                return PlayState.STOP;
            }
        };
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "gui_controller", 0, this::guiPredicate));
        controllerRegistrar.add(new AnimationController[]{this.MAIN_CONTROLLER});
        controllerRegistrar.add(new AnimationController[]{this.TRIGGER_CONTROLLER});
        controllerRegistrar.add(new AnimationController[]{this.REVOLVER_CONTROLLER});
        controllerRegistrar.add(new AnimationController[]{this.BARREL_CONTROLLER});
    }

    private <T extends GeoAnimatable> PlayState guiPredicate(AnimationState<T> state) {
        if (state.getData(DataTickets.ITEM_RENDER_PERSPECTIVE) == ItemDisplayContext.GUI) {
            state.setAnimation(RawAnimation.begin().then("hide_arms", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }
    protected RawAnimation getEmptyHoldAnimation(AnimationState<GunAnimator> event){
        return this.playGunAnim("hold_empty", Animation.LoopType.LOOP);
    }
   protected RawAnimation getTacReloadAnimation(AnimationState<GunAnimator> event) {
       GunData data = this.getGunData();
       int time = GunModifierHelper.getReloadTime(data);
       this.animationHelper.syncAnimation(event, "reload_tactical", time);
       return RawAnimation.begin().then("reload_tactical", Animation.LoopType.LOOP);
   }
   protected RawAnimation getEmptyInspectionAnimation(AnimationState<GunAnimator> event) {
       RawAnimation animation = this.playGunAnim("inspect_empty", Animation.LoopType.PLAY_ONCE);
       this.animationHelper.syncAnimation(event, "inspect_empty", ClientHandler.getMaxInspectionTicks());
       return animation;
   }
}
