package net.ceoofgoogle.createrealguns.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateRealGunsModItems {
    public static final DeferredRegister<Item> REGISTRY;

    public static final RegistryObject<Item> CROWN;

    public CreateRealGunsModItems() {
    }

    private static RegistryObject<Item> block (RegistryObject < Block > block) {
        return REGISTRY.register(block.getId().getPath(), () -> {
            return new BlockItem((Block) block.get(), new Item.Properties());
        });
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "createrealguns");
        CROWN = REGISTRY.register("crown", () -> new Item(new Item.Properties()));
    }
}
