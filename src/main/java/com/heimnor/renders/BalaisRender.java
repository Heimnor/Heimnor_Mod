package com.heimnor.renders;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class BalaisRender implements IItemRenderer {
	

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		case EQUIPPED: {

			EntityLivingBase living = (EntityLivingBase) data[1];
			int renderPass = item.getItem().requiresMultipleRenderPasses() ? 1 : 0;

			GL11.glPushMatrix();
			GL11.glScalef(1.5F, 1.5F, 1F);
			GL11.glTranslatef(0.35F, 0.0F, -0.1F);

			GL11.glRotatef(-30.0F, 1.0F, 0.55F, -0.5F);
			GL11.glRotatef(30.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
			this.renderItem(living, item, renderPass);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED_FIRST_PERSON: {

			EntityLivingBase living = (EntityLivingBase) data[1];
			int renderPass = item.getItem().requiresMultipleRenderPasses() ? 1 : 0;

			GL11.glPushMatrix();
			GL11.glScalef(2.0F, 2.0F, 1F);
			GL11.glTranslatef(0.2F, 0.0F, -0.1F);

			GL11.glRotatef(-30.0F, 1.0F, 0.55F, -0.5F);
			GL11.glRotatef(30.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
			this.renderItem(living, item, renderPass);
			GL11.glPopMatrix();
			break;
		}
		default:
			break;
		}

	}

	public void renderItem(EntityLivingBase living, ItemStack stack, int pass) {
		TextureManager texturemanager = FMLClientHandler.instance().getClient().getTextureManager();
		GL11.glPushMatrix();
		IIcon icon = living.getItemIcon(stack, pass);

		if (icon == null) {
			GL11.glPopMatrix();
			return;
		}
		texturemanager.bindTexture(texturemanager.getResourceLocation(stack.getItemSpriteNumber()));
		Tessellator tessellator = Tessellator.instance;
		float f = icon.getMinU();
		float f1 = icon.getMaxU();
		float f2 = icon.getMinV();
		float f3 = icon.getMaxV();
		float f4 = -0.2F;
		float f5 = 0.3F;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glTranslatef(-f4, -f5, 0.0F);
		float f6 = 1F;
		GL11.glScalef(f6, f6, f6);
		GL11.glRotatef(130.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(315.0F, 7.0F, 0.0F, 6.0F);
		GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
		ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}
}
