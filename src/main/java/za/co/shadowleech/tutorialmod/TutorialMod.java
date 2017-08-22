package za.co.shadowleech.tutorialmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import za.co.shadowleech.tutorialmod.block.ModBlocks;
import za.co.shadowleech.tutorialmod.item.ModItems;
import za.co.shadowleech.tutorialmod.proxy.CommonProxy;
import za.co.shadowleech.tutorialmod.tab.CreativeTabTutorial;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION, name = TutorialMod.NAME)
public class TutorialMod {
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "0.1";
    public static final String NAME = "Tutorial Mod";

    @SidedProxy(clientSide = "za.co.shadowleech.tutorialmod.proxy.ClientProxy", serverSide = "za.co.shadowleech.tutorialmod.proxy.CommonProxy")

    public static CommonProxy proxy;

    @Mod.Instance
    public static TutorialMod instance;

    public static CreativeTabTutorial tabTutorial;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabTutorial = new CreativeTabTutorial(CreativeTabs.getNextID(), "tab_tutorial");
        ModItems.preInit();
        ModBlocks.preInit();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
