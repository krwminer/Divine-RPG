package net.divinerpg.render.entity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderBasicProjectile extends Render
{
    public ResourceLocation texture;
    float scale;

    public RenderBasicProjectile(ResourceLocation par1)
    {
        texture = par1;
        scale = 1F;
    }

    public RenderBasicProjectile(ResourceLocation par1, float scaleFactor)
    {
        texture = par1;
        scale = scaleFactor;
    }

    public void renderProjectile(EntityThrowable projectile, double x, double y, double z)
    {
        GL11.glPushMatrix();
        this.bindEntityTexture(projectile);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(scale * 0.5F, scale * 0.5F, scale * 0.5F);
        Tessellator tessellator = Tessellator.instance;
        float minU = 0;
        float maxU = 1;
        float minV = 0;
        float maxV = 1;
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, minU, maxV);
        tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, maxU, maxV);
        tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, maxU, minV);
        tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, minU, minV);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderProjectile((EntityThrowable)par1Entity, par2, par4, par6);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}


