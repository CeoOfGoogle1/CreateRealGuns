package net.ceoofgoogle.createrealguns;

import net.ceoofgoogle.createrealguns.init.CreateRealGunsModItems;
import net.ceoofgoogle.createrealguns.init.CreateRealGunsModTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateRealGuns.MOD_ID)
public class CreateRealGuns
{
    public static final String MOD_ID = "createrealguns";

    public CreateRealGuns()
    {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CreateRealGunsModItems.REGISTRY.register(bus);
        CreateRealGunsModTabs.REGISTRY.register(bus);
    }
}