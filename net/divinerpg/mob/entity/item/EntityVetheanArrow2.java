package net.divinerpg.mob.entity.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class EntityVetheanArrow2 extends EntityArrow
{
    public EntityVetheanArrow2(World par1World)
    {
        super(par1World);
    }

    public EntityVetheanArrow2(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    public EntityVetheanArrow2(World par1World, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving, float par4, float par5)
    {
        super(par1World, par2EntityLiving, par3EntityLiving, par4, par5);
    }

    public EntityVetheanArrow2(World par1World, EntityLivingBase par2EntityLiving, float par3)
    {
        super(par1World, par2EntityLiving, par3);
    }
}