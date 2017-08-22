package za.co.shadowleech.tutorialmod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import za.co.shadowleech.tutorialmod.TutorialMod;

/**
 * Created by Shadowl33ch on 22/11/2016.
 */
public class ModItems {

    public static Item tutorialItem;

    public static void preInit() {

        tutorialItem = new ItemTutorialItem(EnumHelper.addToolMaterial("EMERALD", 3, 3200, 9.0F, 3.5F, 22), "tutorial_item");

        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(tutorialItem, new ResourceLocation(TutorialMod.MODID, "tutorial_item"));
    }

    public static void registerRenders() {
        //registerRender(tutorialItem);
    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(TutorialMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
