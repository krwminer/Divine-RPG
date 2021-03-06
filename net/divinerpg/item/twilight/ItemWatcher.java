package net.divinerpg.item.twilight;

import net.divinerpg.helper.base.ItemDivineRPG;
import net.divinerpg.overworld.mobs.EntityNetherWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWatcher extends ItemDivineRPG {
	public ItemWatcher(int var1) {
		super(var1);
		this.maxStackSize = 1;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int var4 = 0;
		if(par3World.provider.dimensionId == -1){
			if (!par3World.isRemote) {
				while(var4 < 1)
				{
					EntityNetherWatcher var5 = new EntityNetherWatcher(par3World);
					var5.setPosition(par4, par5 + 1, par6);
					par3World.spawnEntityInWorld(var5);
					var4++;
					player.inventory.consumeInventoryItem(this.itemID);
				}
			}
		}
		if(par3World.isRemote)
			--par1ItemStack.stackSize;
		//player.inventory.consumeInventoryItem(this.itemID);
		player.addChatMessage("The Watcher can only be spawned in The Nether");

		return true;
	}

}