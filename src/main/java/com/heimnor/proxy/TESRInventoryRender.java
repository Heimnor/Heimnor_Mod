package com.heimnor.proxy;

import org.lwjgl.opengl.GL11;

import com.heimnor.models.OneBlockRenderer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import registry.BlocksDecoRegistry;

public class TESRInventoryRender implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

		if (block == BlocksDecoRegistry.pain) {

			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.2F, 0.0F);
			GL11.glScalef(0.4F, 0.4F, 0.4F);
			Minecraft.getMinecraft().getTextureManager()
					.bindTexture(OneBlockRenderer.TESRBlocksModels.PAIN.getResource());
			OneBlockRenderer.TESRBlocksModels.PAIN.getModel().renderAll();
			GL11.glPopMatrix();
		}

		if (block == BlocksDecoRegistry.balais) {

			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, - 0.1F, 0.0F);
			GL11.glScalef(0.4F, 0.4F, 0.4F);
			Minecraft.getMinecraft().getTextureManager()
					.bindTexture(OneBlockRenderer.TESRBlocksModels.BALAIS.getResource());
			OneBlockRenderer.TESRBlocksModels.BALAIS.getModel().renderAll();
			GL11.glPopMatrix();
		}

		if (block == BlocksDecoRegistry.miroir) {
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.2F, 0.0F);
			GL11.glScalef(0.4F, 0.4F, 0.4F);
			Minecraft.getMinecraft().getTextureManager().bindTexture(OneBlockRenderer.TESRBlocksModels.MIROIR.getResource());
			OneBlockRenderer.TESRBlocksModels.MIROIR.getModel().renderAll();
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
