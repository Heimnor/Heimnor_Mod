package com.heimnor.renders;

import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import init.block.CTTrapDoor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderTrapDoor implements ISimpleBlockRenderingHandler {
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		Tessellator tess = Tessellator.instance;
		int meta = world.getBlockMetadata(x, y, z);
		
		tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		
		if (block instanceof CTTrapDoor)
		{
			CTTrapDoor blockH = (CTTrapDoor) block;
			
			if (meta == 0)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.18F, 1.0F);
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 1)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.18F, 1.0F);
				
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 2)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.18F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
			} else if (meta == 3)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.18F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 4)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.82F, 1.0F, 1.0F, 1.0F);
				renderer.renderFaceZPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceZNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
			} else if (meta == 5)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.18F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceZPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceZNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
			} else if (meta == 6)
			{
				renderer.setRenderBounds(0.82F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.renderFaceXPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceXNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
			} else if (meta == 7)
			{
				renderer.setRenderBounds(0.00F, 0.0F, 0.0F, 0.18F, 1.0F, 1.0F);
				renderer.renderFaceXPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceXNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
			} else if (meta == 8)
			{
				renderer.setRenderBounds(0.0F, 0.82F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));

				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 9)
			{
				renderer.setRenderBounds(0.0F, 0.82F, 0.0F, 1.0F, 1.0F, 1.0F);
				
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 10)
			{
				renderer.setRenderBounds(0.0F, 0.82F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 11)
			{
				renderer.setRenderBounds(0.0F, 0.82F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceYPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceYNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			}else if (meta == 12)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.82F, 1.0F, 1.0F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceZPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceZNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 13)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.18F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceZPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceZNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceXNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 14)
			{
				renderer.setRenderBounds(0.82F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceXPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceXNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
				
			} else if (meta == 15)
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.18F, 1.0F, 1.0F);
				renderer.uvRotateTop = 1;
				renderer.renderFaceXPos(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateBottom = 1;
				renderer.renderFaceXNeg(block, x, y, z, blockH.getIcon(0, world, x, y, z, blockH));
				renderer.uvRotateTop = 0;
				renderer.uvRotateBottom = 0;
				renderer.renderFaceYPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceYNeg(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZPos(block, x, y, z, blockH.getSideIcon());
				renderer.renderFaceZNeg(block, x, y, z, blockH.getSideIcon());
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
		return ClientProxy.renderTrapDoor;
	}
	
}
