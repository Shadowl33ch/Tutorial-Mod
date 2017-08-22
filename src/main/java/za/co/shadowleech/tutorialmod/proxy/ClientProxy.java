package za.co.shadowleech.tutorialmod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import za.co.shadowleech.tutorialmod.TutorialMod;
import za.co.shadowleech.tutorialmod.block.ModBlocks;
import za.co.shadowleech.tutorialmod.item.ModItems;

/**
 * Created by Shadowl33ch on 22/11/2016.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(TutorialMod.MODID);
        registerModel(ModItems.tutorialItem);
    }

    public void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(TutorialMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
