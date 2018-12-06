package com.heimnor.renders;

import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import init.block.ConnectedStructureBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderFloorWallS implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		if (block instanceof ConnectedStructureBlock)
		{
			ConnectedStructureBlock blockH = (ConnectedStructureBlock) block;
			
			Tessellator tess = Tessellator.instance;
			int meta = world.getBlockMetadata(x, y, z);
			
			tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			
			if (meta == 1)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
				renderer.renderFaceZNeg(block, x, y, z, blockH.getIcon(world, x, y, z, blockH));
			} else if (meta == 2)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
				renderer.renderFaceZPos(block, x, y, z, blockH.getIcon(world, x, y, z, blockH));
			} else if (meta == 3)
			{
				renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.renderFaceXNeg(block, x, y, z, blockH.getIcon(world, x, y, z, blockH));
			} else if (meta == 4)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
				renderer.renderFaceXPos(block, x, y, z, blockH.getIcon(world, x, y, z, blockH));
			} else
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1, 1.0F);
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(world, x, y, z, blockH));
			}
		}
		return false;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		
		return false;
	}
	
	@Override
	public int getRenderId() {
		return ClientProxy.renderFloorWallS;
	}
	
}
