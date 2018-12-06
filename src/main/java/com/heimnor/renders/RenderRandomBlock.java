package com.heimnor.renders;

import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import init.block.CTRandom;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderRandomBlock implements ISimpleBlockRenderingHandler{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		if(block instanceof CTRandom) {
			
			CTRandom blockH = (CTRandom) block;
			Tessellator tessellator = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderer.renderFaceXPos(blockH, x, y, z, blockH.getIcon(meta,world, x, y, z, blockH));
			renderer.renderFaceXNeg(blockH, x, y, z, blockH.getIcon(meta,world, x, y, z, blockH));
			renderer.renderFaceZNeg(blockH, x, y, z, blockH.getIcon(meta,world, x, y, z, blockH));
			renderer.renderFaceZPos(blockH, x, y, z, blockH.getIcon(meta,world, x, y, z, blockH));
			renderer.renderFaceYPos(blockH, x, y, z, blockH.getSideIcon());
			renderer.renderFaceYNeg(blockH, x, y, z, blockH.getSideIcon());
		}
		
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.renderRandom;
	}
	
}
