package net.ceoofgoogle.createrealguns.init;

import com.nukateam.ntgl.common.foundation.item.AmmoItem;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import net.ceoofgoogle.createrealguns.advancedbehaviors.AdvancedGunItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateRealGunsModItems {
    public static final DeferredRegister<Item> REGISTRY;

    public static final RegistryObject<AmmoItem> PISTOL_CARTRIDGE;
    public static final RegistryObject<AmmoItem> INTERMEDIATE_CARTRIDGE;
    public static final RegistryObject<AmmoItem> FULL_POWER_CARTRIDGE;
    public static final RegistryObject<AmmoItem> SHOTGUN_SHELL;
    public static final RegistryObject<AmmoItem> PAPER_CARTRIDGE;
    public static final RegistryObject<Item> FRAG_GRENADE;
    public static final RegistryObject<Item> SMOKE_GRENADE;
    public static final RegistryObject<Item> STUN_GRENADE;
    public static final RegistryObject<Item> FLAMING_COCKTAIL;
    public static final RegistryObject<Item> OLD_GRENADE;
    public static final RegistryObject<Item> FRAG_GRENADE_CARTRIDGE;
    public static final RegistryObject<Item> SMOKE_GRENADE_CARTRIDGE;
    public static final RegistryObject<Item> STUN_GRENADE_CARTRIDGE;
    public static final RegistryObject<AmmoItem> ROCKET_CARTRIDGE;
    public static final RegistryObject<AdvancedGunItem> BATTLE_RIFLE;
    public static final RegistryObject<AdvancedGunItem> BAZOOKA;
    public static final RegistryObject<AdvancedGunItem> BOLT_ACTION_RIFLE;
    public static final RegistryObject<AdvancedGunItem> CLASSIC_ASSAULT_RIFLE;
    public static final RegistryObject<AdvancedGunItem> MACHINE_GUN;
    public static final RegistryObject<AdvancedGunItem> MODERN_ASSAULT_RIFLE;
    public static final RegistryObject<AdvancedGunItem> MODERN_SMG;
    public static final RegistryObject<AdvancedGunItem> OLD_BATTLE_RIFLE;
    public static final RegistryObject<AdvancedGunItem> OLD_SMG;
    public static final RegistryObject<AdvancedGunItem> PISTOL;
    public static final RegistryObject<AdvancedGunItem> RAPID_SMG;
    public static final RegistryObject<AdvancedGunItem> REVOLVER;
    public static final RegistryObject<AdvancedGunItem> RPG;
    public static final RegistryObject<AdvancedGunItem> SHOTGUN;
    public static final RegistryObject<AdvancedGunItem> THUMPER;



    public CreateRealGunsModItems() {
    }

    private static RegistryObject<Item> block (RegistryObject < Block > block) {
        return REGISTRY.register(block.getId().getPath(), () -> {
            return new BlockItem((Block) block.get(), new Item.Properties());
        });
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "createrealguns");
        PISTOL_CARTRIDGE = REGISTRY.register("pistol_cartridge", () -> new AmmoItem(new Item.Properties()));
        INTERMEDIATE_CARTRIDGE = REGISTRY.register("intermediate_cartridge", () -> new AmmoItem(new Item.Properties()));
        FULL_POWER_CARTRIDGE = REGISTRY.register("full_power_cartridge", () -> new AmmoItem(new Item.Properties()));
        SHOTGUN_SHELL = REGISTRY.register("shotgun_shell", () -> new AmmoItem(new Item.Properties()));
        PAPER_CARTRIDGE = REGISTRY.register("paper_cartridge", () -> new AmmoItem(new Item.Properties()));
        FRAG_GRENADE = REGISTRY.register("frag_grenade", () -> new Item(new Item.Properties()));
        SMOKE_GRENADE = REGISTRY.register("smoke_grenade", () -> new Item(new Item.Properties()));
        STUN_GRENADE = REGISTRY.register("stun_grenade", () -> new Item(new Item.Properties()));
        FLAMING_COCKTAIL = REGISTRY.register("flaming_cocktail", () -> new Item(new Item.Properties()));
        OLD_GRENADE = REGISTRY.register("old_grenade", () -> new Item(new Item.Properties()));
        FRAG_GRENADE_CARTRIDGE = REGISTRY.register("frag_grenade_cartridge", () -> new Item(new Item.Properties()));
        SMOKE_GRENADE_CARTRIDGE = REGISTRY.register("smoke_grenade_cartridge", () -> new Item(new Item.Properties()));
        STUN_GRENADE_CARTRIDGE = REGISTRY.register("stun_grenade_cartridge", () -> new Item(new Item.Properties()));
        ROCKET_CARTRIDGE = REGISTRY.register("rocket_cartridge", () -> new AmmoItem(new Item.Properties()));
        BATTLE_RIFLE = REGISTRY.register("battle_rifle",  () -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        BAZOOKA = REGISTRY.register("bazooka",  () -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        BOLT_ACTION_RIFLE = REGISTRY.register("bolt_action_rifle",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        CLASSIC_ASSAULT_RIFLE = REGISTRY.register("classic_assault_rifle",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        MACHINE_GUN = REGISTRY.register("machine_gun",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        MODERN_ASSAULT_RIFLE =REGISTRY.register("modern_assault_rifle",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        MODERN_SMG = REGISTRY.register("modern_smg" ,() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        OLD_BATTLE_RIFLE = REGISTRY.register("old_battle_rifle",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        OLD_SMG = REGISTRY.register("old_smg",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        PISTOL = REGISTRY.register("pistol",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        RAPID_SMG = REGISTRY.register("rapid_smg",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        REVOLVER = REGISTRY.register("revolver",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        RPG =REGISTRY.register("rpg",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        SHOTGUN = REGISTRY.register("shotgun" ,() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));
        THUMPER = REGISTRY.register("thumper",() -> new AdvancedGunItem(new Item.Properties().stacksTo(1)));




    }
}
