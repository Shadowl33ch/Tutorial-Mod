package za.co.shadowleech.tutorialmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import za.co.shadowleech.tutorialmod.TutorialMod;

import javax.annotation.Nullable;

/**
 * Created by Shadowl33ch on 22/11/2016.
 */
public class BlockTutorialBlock extends Block {
    public BlockTutorialBlock(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setCreativeTab(TutorialMod.tabTutorial);
        this.setHardness(1F);
        this.setResistance(1F);
        this.setSoundType(SoundType.SLIME);
        this.setLightLevel(1F);
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.setBlockState(pos, Blocks.TNT.getDefaultState());

        super.onBlockDestroyedByPlayer(worldIn, pos, state);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 5F, false);

        super.onBlockAdded(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(playerIn));
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }
}
