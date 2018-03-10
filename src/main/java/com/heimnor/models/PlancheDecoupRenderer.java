package com.heimnor.models;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityPlancheDecoup;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class PlancheDecoupRenderer extends TileEntitySpecialRenderer {

	public static ModelPlancheDecoup model = new ModelPlancheDecoup();
	public static ResourceLocation location = new ResourceLocation(Heimnor.MODID,
			"textures/models/block/planchedecoup.png");

	public PlancheDecoupRenderer() {
		this.func_147497_a(TileEntityRendererDispatcher.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTick) {
		this.renderTileEntityPlancheDecoupAt((TileEntityPlancheDecoup) tile, x, y, z, partialTick);
	}

	public void renderTileEntityPlancheDecoupAt(TileEntityPlancheDecoup tile, double x, double y, double z,
			float partialTick) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.28F, (float) z + 0.5F);
		GL11.glRotatef(90F * tile.getDirection(), 0.0F, 1.0F, 0.0F);
		GL11.glScalef(0.40F, 0.5F, 0.45F);
		this.bindTexture(location);
		model.renderAll();
		GL11.glPopMatrix();
		this.renderItems(tile, x, y, z, partialTick);

	}

	public void renderItems(TileEntityPlancheDecoup tile, double x, double y, double z, float partialTick) {

		if (tile.getContent() != null) {
			GL11.glPushMatrix();
			ItemStack stack = tile.getContent();
			EntityItem entItem = new EntityItem(null, 0, 0, 0, stack);
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float) x + 0.63F, (float) y + 0.07F, (float) z + 0.5F);
			GL11.glScalef(0.7F, 0.7F, 0.7F);
			GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
			int dir = tile.getDirection();
			if (dir == 0) {
				GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.2F, -0.2F, 0.0F);
			}

			else if (dir == 1) {
				GL11.glRotatef(90, 0.0F, 0.0F, -1.0F);
				GL11.glTranslatef(0.0F, -0.4F, 0.0F);

			} else if (dir == 2) {
				GL11.glTranslatef(-0.2F, -0.2F, 0.0F);
				GL11.glRotatef(0, 0, 0, 1.0F);

			} else if (dir == 3)
				GL11.glRotatef(90, 0.0F, 0.0F, (float) dir);

			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();

		}

		if (tile.getUstensile() != null) {

			GL11.glPushMatrix();
			ItemStack stack = tile.getUstensile();
			EntityItem entItem = new EntityItem(null, 0, 0, 0, stack);
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float) x + 0.8F, (float) y + 0.38F, (float) z + .5F);
			GL11.glRotatef(180, -0.5F, 0.0F, 0.5F);
			int dir = tile.getDirection();
			
			 if (dir == 1) {
					GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
					GL11.glTranslatef(-0.3F, 0.0F, -0.3F);

				} else if (dir == 2) {
					GL11.glTranslatef(0.0F, 0.0F, 0.6F);
					GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);

				} else if (dir == 3)
					GL11.glTranslatef(0.3F, 0.0F, 0.3F);
					GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);

			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}
	
	}

}
