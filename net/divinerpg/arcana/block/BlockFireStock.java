package net.divinerpg.arcana.block;
import java.util.Random;

import net.divinerpg.block.BlockBase;
import net.divinerpg.helper.block.ArcanaBlockHelper;
import net.divinerpg.helper.item.ArcanaItemHelper;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFireStock extends BlockBase implements IPlantable
{
	public BlockFireStock(int par1)
	{
		super(par1, Material.plants);
		float var3 = 0.375F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
		this.setTickRandomly(true);
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par1World.isAirBlock(par2, par3 + 1, par4))
		{
			if(blockID == ArcanaBlockHelper.fireStock.blockID)
			{
				par1World.setBlock(par2, par3 + 1, par4, ArcanaBlockHelper.fireStock2.blockID);
			}
		}
	}
	
	public int getRenderType()
	{
		return 1;
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		this.checkBlockCoordValid(par1World, par2, par3, par4);
	}

	/**
	 * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
	 */
	protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4)
	{
		if (!this.canBlockStay(par1World, par2, par3, par4))
		{
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlockToAir(par2, par3, par4);
		}
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return ArcanaItemHelper.fireStockItem.itemID;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

    public int quantityDropped(Random par1Random)
    {
        return 6;
    }

	@SideOnly(Side.CLIENT)

	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return ArcanaItemHelper.fireStockSeeds.itemID;
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return EnumPlantType.Beach;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z)
	{
		return blockID;
	}
	
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return par1World.getBlockMaterial(par2, par3 - 1, par4).isSolid();
    }
	
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false : this.canBlockStay(par1World, par2, par3, par4);
    }
	
	@Override
	public int getPlantMetadata(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
}
