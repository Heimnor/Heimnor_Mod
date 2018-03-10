package com.heimnor.proxy;

import org.lwjgl.opengl.GL11;

import com.heimnor.models.FourRenderer;
import com.heimnor.models.MiroirRenderer;
import com.heimnor.models.PlancheDecoupRenderer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import registry.BlockFoodRegistry;
import registry.FurnitureRegistry;

public class TESRInventoryRender implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

		if (block == BlockFoodRegistry.fourCuisine)
		{

			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.75F, 0.0F);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			Minecraft.getMinecraft().getTextureManager().bindTexture(FourRenderer.textureRock);
			FourRenderer.model.renderAll();
			GL11.glPopMatrix();

		} else if(block == BlockFoodRegistry.plancheDecoup) {
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.25F, 0.0F);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			Minecraft.getMinecraft().getTextureManager().bindTexture(PlancheDecoupRenderer.location);
			PlancheDecoupRenderer.model.renderAll();
			GL11.glPopMatrix();
		} else if(block == FurnitureRegistry.miroir) {
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.2F, 0.0F);
			GL11.glScalef(0.4F, 0.4F, 0.4F);
			Minecraft.getMinecraft().getTextureManager().bindTexture(MiroirRenderer.location);
			MiroirRenderer.model.renderAll();
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return ClientProxy.renderID;
	}

}
