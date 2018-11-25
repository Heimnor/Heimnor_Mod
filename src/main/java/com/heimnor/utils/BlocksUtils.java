package com.heimnor.utils;

import java.util.Random;

import init.block.BlockConnectedTextureUpDown;
import net.minecraft.world.IBlockAccess;

/**
 * 
 * @author Joe 25 nov. 2018
 *
 */
public class BlocksUtils {

	public static boolean isNormalBlockUp(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x, y + 1, z).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockDown(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x, y - 1, z).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockFront(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x, y, z + 1).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockBehind(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x, y, z - 1).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockRight(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x + 1, y, z).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockLeft(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x - 1, y, z).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockAround(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x - 1, y, z).isNormalCube() || block.getBlock(x + 1, y, z).isNormalCube()
				|| block.getBlock(x, y, z - 1).isNormalCube() || block.getBlock(x, y, z + 1).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isNormalBlockAllAround(IBlockAccess block, int x, int y, int z) {

		if (block.getBlock(x - 1, y, z).isNormalCube() && block.getBlock(x + 1, y, z).isNormalCube()
				&& block.getBlock(x, y, z - 1).isNormalCube() && block.getBlock(x, y, z + 1).isNormalCube()
				&& block.getBlock(x, y - 1, z).isNormalCube() && block.getBlock(x, y + 1, z).isNormalCube())
			return true;
		else
			return false;
	}

	public static boolean isSameBlockDown(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x, y - 1, z) == ref)
			return true;

		return false;
	}
	
	public static boolean isSameBlockUp(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x, y + 1, z) == ref)
			return true;

		return false;
	}
	
	public static boolean isSameBlockBehind(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x, y, z - 1) == ref)
			return true;

		return false;
	}
	
	public static boolean isSameBlockFront(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x, y, z + 1) == ref)
			return true;

		return false;
	}
	
	public static boolean isSameBlockRight(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x + 1, y, z) == ref)
			return true;
		else
			return false;
	}
	
	public static boolean isSameBlockLeft(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x - 1, y, z) == ref)
			return true;
		else
			return false;
	}
	
	public static boolean isSameBlockAround(IBlockAccess block, BlockConnectedTextureUpDown ref, int x, int y, int z) {

		if (block.getBlock(x - 1, y, z) == ref || block.getBlock(x + 1, y, z) == ref
				|| block.getBlock(x, y, z - 1) == ref || block.getBlock(x, y, z + 1) == ref)
			return true;
		else
			return false;
	}
	
	/**
	 * Méthode qui calcule si oui ou non un int généré sera en dessous du paramètre percent
	 * @param percent
	 * @return alternatif ?
	 * @author Joe
	 */
	public static boolean getRandomIcon(int percent) {

		Random rand = new Random();
		int result;
		result = rand.nextInt(99);

		if (result <= percent -1)
			return false;
		else
			return true;
	}
}
