package com.heimnor.models;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.tileentity.TileEntityMiroir;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class MiroirRenderer extends TileEntitySpecialRenderer{

	public static ModelMiroir model = new ModelMiroir();
	public static ResourceLocation location = new ResourceLocation(Heimnor.MODID,
			"textures/models/block/miroir.png");
	
	public MiroirRenderer() {
		this.func_147497_a(TileEntityRendererDispatcher.instance);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTick) {
		this.renderTileEntityMiroirAt((TileEntityMiroir) tile, x, y, z, partialTick);
	}

	public void renderTileEntityMiroirAt(TileEntityMiroir tile, double x, double y, double z,
			float partialTick) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
		GL11.glRotatef(90F * tile.getDirection(), 0.0F, 1.0F, 0.0F);
		if (tile.getDirection() == 0 || tile.getDirection() == 2) {
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		}
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		this.bindTexture(location);
		model.renderAll();
		GL11.glPopMatrix();

	}


}
