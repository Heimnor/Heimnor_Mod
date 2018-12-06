package com.heimnor.henum;

import java.util.HashMap;

import init.block.BlockReactUpDown;
import init.block.ConnectedStructureBlock;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public enum HDirection {
	
	INSTANCE(0, 0, 0),
	
	NORTH(0, 0, -1),
	EAST(1, 0, 0),
	SOUTH(0, 0, 1),
	WEST(-1, 0, 0),
	SOUTH_EAST(1, 0, 1),
	SOUTH_WEST(-1, 0, 1),
	NORTH_EAST(1, 0, -1),
	NORTH_WEST(-1, 0, -1),
	TOP(0, 1, 0),
	BOTTOM(0, -1, 0),
	TOP_EAST(1, 1, 0),
	TOP_WEST(-1, 1, 0),
	BOTTOM_EAST(1, -1, 0),
	BOTTOM_WEST(-1, -1, 0),
	TOP_NORTH(0, 1, -1),
	TOP_SOUTH(0, 1, 1),
	BOTTOM_NORTH(0, -1, -1),
	BOTTOM_SOUTH(0, -1, 1);
	
	public int x, y, z;
	
	HashMap dirs = new HashMap();
	
	HDirection(int x, int y, int z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public HashMap getDirs(int meta) {
		
		if (meta == 0)
		{
			dirs.put(NORTH, false);
			dirs.put(NORTH_EAST, false);
			dirs.put(EAST, false);
			dirs.put(SOUTH_EAST, false);
			dirs.put(SOUTH, false);
			dirs.put(SOUTH_WEST, false);
			dirs.put(WEST, false);
			dirs.put(NORTH_WEST, false);
		}
		
		return dirs;
	}
	
	public boolean canConnect(IBlockAccess world, int x, int y, int z, Block block, boolean checkMeta) {
		
		Block blockH = world.getBlock(x, y, z);
		Block selected = world.getBlock(x + this.x, y + this.y, z + this.z);
		
		if (checkMeta)
		{
			if (blockH == selected && world.getBlockMetadata(x, y, z) == world.getBlockMetadata(x + this.x, y + this.y, z + this.z))
			{
				return true;
			} else
				return false;
		} else
		{
			if (blockH == selected)
			{
				return true;
			} else
				return false;
		}
		
	}
	
	public boolean canConnect(IBlockAccess world, int x, int y, int z, Block block, boolean checkMeta, boolean connectToNormal) {
		
		Block blockH = world.getBlock(x, y, z);
		Block selected = world.getBlock(x + this.x, y + this.y, z + this.z);
		
		if (checkMeta && connectToNormal)
		{
			
			if (blockH == selected && world.getBlockMetadata(x, y, z) == world.getBlockMetadata(x + this.x, y + this.y, z + this.z)
					&& selected.isNormalCube())
			{
				return true;
			} else
				return false;
		} else if (connectToNormal && !checkMeta)
		{
			if (blockH == selected && selected.isNormalCube())
			{
				return true;
			} else
				return false;
			
		} else if (checkMeta && !connectToNormal)
		{
			if (blockH == selected && world.getBlockMetadata(x, y, z) == world.getBlockMetadata(x + this.x, y + this.y, z + this.z))
			{
				return true;
			} else
				return false;
			
		} else
		{
			if (blockH == selected)
			{
				return true;
			} else
				return false;
		}
		
	}
}
