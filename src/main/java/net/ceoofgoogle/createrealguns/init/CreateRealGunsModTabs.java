package net.ceoofgoogle.createrealguns.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreateRealGunsModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY;
    public static final RegistryObject<CreativeModeTab> CREATEREALGUNS;

    public CreateRealGunsModTabs() {
    }

    static {
        REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "createrealguns");
        CREATEREALGUNS = REGISTRY.register("create_real_guns", () -> {
            return CreativeModeTab.builder().title(Component.translatable("creativetab.create_real_guns")).icon(() -> {
                return new ItemStack((ItemLike) CreateRealGunsModItems.CROWN.get());
            }).displayItems((parameters, tabData) -> {
                tabData.accept((ItemLike) CreateRealGunsModItems.CROWN.get());
            }).build();
        });
    }
}
