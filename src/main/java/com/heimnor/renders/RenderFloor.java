package com.heimnor.renders;

import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import init.block.CTFloor;
import init.block.FloorBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderFloor implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		if (block instanceof CTFloor)
		{
			CTFloor blockH = (CTFloor) block;
			
			Tessellator tess = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			
			tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05, 1.0F);
			renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(meta,world, x, y, z, blockH));
			
			if(blockH.hasSide()) {
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon(meta));
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon(meta));
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon(meta));
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon(meta));
			}
			
			return true;
		} 
		if (block instanceof FloorBlock)
		{
			FloorBlock blockH = (FloorBlock) block;
			
			Tessellator tess = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			
			tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05, 1.0F);
			renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(meta,world, x, y, z, blockH));
			
			if(blockH.hasSide()) {
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}
	
	@Override
	public int getRenderId() {
		return ClientProxy.renderFloor;
	}
	
}
