package net.ceoofgoogle.createrealguns.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateRealGunsModItems {
    public static final DeferredRegister<Item> REGISTRY;

    public static final RegistryObject<Item> PISTOL_CARTRIDGE;
    public static final RegistryObject<Item> INTERMEDIATE_CARTRIDGE;
    public static final RegistryObject<Item> FULL_POWER_CARTRIDGE;
    public static final RegistryObject<Item> SHOTGUN_SHELL;
    public static final RegistryObject<Item> PAPER_CARTRIDGE;
    public static final RegistryObject<Item> FRAG_GRENADE;
    public static final RegistryObject<Item> SMOKE_GRENADE;
    public static final RegistryObject<Item> STUN_GRENADE;
    public static final RegistryObject<Item> FLAMING_COCKTAIL;
    public static final RegistryObject<Item> OLD_GRENADE;
    public static final RegistryObject<Item> FRAG_GRENADE_CARTRIDGE;
    public static final RegistryObject<Item> SMOKE_GRENADE_CARTRIDGE;
    public static final RegistryObject<Item> STUN_GRENADE_CARTRIDGE;
    public static final RegistryObject<Item> ROCKET_CARTRIDGE;

    public CreateRealGunsModItems() {
    }

    private static RegistryObject<Item> block (RegistryObject < Block > block) {
        return REGISTRY.register(block.getId().getPath(), () -> {
            return new BlockItem((Block) block.get(), new Item.Properties());
        });
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "createrealguns");
        PISTOL_CARTRIDGE = REGISTRY.register("pistol_cartridge", () -> new Item(new Item.Properties()));
        INTERMEDIATE_CARTRIDGE = REGISTRY.register("intermediate_cartridge", () -> new Item(new Item.Properties()));
        FULL_POWER_CARTRIDGE = REGISTRY.register("full_power_cartridge", () -> new Item(new Item.Properties()));
        SHOTGUN_SHELL = REGISTRY.register("shotgun_shell", () -> new Item(new Item.Properties()));
        PAPER_CARTRIDGE = REGISTRY.register("paper_cartridge", () -> new Item(new Item.Properties()));
        FRAG_GRENADE = REGISTRY.register("frag_grenade", () -> new Item(new Item.Properties()));
        SMOKE_GRENADE = REGISTRY.register("smoke_grenade", () -> new Item(new Item.Properties()));
        STUN_GRENADE = REGISTRY.register("stun_grenade", () -> new Item(new Item.Properties()));
        FLAMING_COCKTAIL = REGISTRY.register("flaming_cocktail", () -> new Item(new Item.Properties()));
        OLD_GRENADE = REGISTRY.register("old_grenade", () -> new Item(new Item.Properties()));
        FRAG_GRENADE_CARTRIDGE = REGISTRY.register("frag_grenade_cartridge", () -> new Item(new Item.Properties()));
        SMOKE_GRENADE_CARTRIDGE = REGISTRY.register("smoke_grenade_cartridge", () -> new Item(new Item.Properties()));
        STUN_GRENADE_CARTRIDGE = REGISTRY.register("stun_grenade_cartridge", () -> new Item(new Item.Properties()));
        ROCKET_CARTRIDGE = REGISTRY.register("rocket_cartridge", () -> new Item(new Item.Properties()));
    }
}
