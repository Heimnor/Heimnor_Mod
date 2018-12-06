package com.heimnor.utils;

import init.block.ConnectedStructureBlock;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class StructureSchemeUtils {

	public static int getStructureType(ConnectedStructureBlock blockRef, IBlockAccess world, int x, int y, int z) {
		
		return 0;
	}

	public static int getLargeur(ConnectedStructureBlock blockRef, IBlockAccess world, int x, int y, int z) {
		
		int l = 1;
		Block selected = world.getBlock(x, y, z);
		int xS = x;
		
		do {
			selected = world.getBlock(xS + 1, y, z);
			if(selected == blockRef) {
				l++;
				xS++;
			}
			
		}while(selected == blockRef);
		
		xS = x;
		
		do {
			selected = world.getBlock(xS - 1, y, z);
			if(selected == blockRef) {
				l++;
				xS--;
			}
			
		}while(selected == blockRef);
		
		return l;
	}

	public static int getHauteur(ConnectedStructureBlock blockRef, IBlockAccess world, int x, int y, int z) {
		
		int h = 1;
		Block selected = world.getBlock(x, y, z);
		int zS = z;
		
		do {
			selected = world.getBlock(x, y, zS + 1);
			if(selected == blockRef) {
				h++;
				zS++;
			}
			
		}while(selected == blockRef);
		
		zS = z;
		
		do {
			selected = world.getBlock(x, y, zS - 1);
			if(selected == blockRef) {
				h++;
				zS--;
			}
			
		}while(selected == blockRef);
		
		return h;
	}
	
	public static int matchingStructure (ConnectedStructureBlock blockRef, IBlockAccess world, int x, int y, int z) {
		
		int l = StructureSchemeUtils.getLargeur(blockRef, world, x, y, z);
		int h = StructureSchemeUtils.getHauteur(blockRef, world, x, y, z);
		
		Block[][] selected = new Block[l][h];
		
		for(int i = 0; i < l; i++) {
			for(int k = 0; k < h; k++) {
				
				
				
			}
		}
		
		return 0;
	}
	
	public static Block[][] getStructureSquare(Block block){
		
		Block[][] structure = new Block[][] {};
		
		return structure;
	}

}
