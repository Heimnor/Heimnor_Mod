package com.heimnor.utils;

import java.util.Random;

import init.block.HBlock;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

/**
 * méthodes utilitaires a la réalisation de blocks pour Heimnor
 * 
 * @author Joe 25 nov. 2018
 */
public class BlocksUtils {
	
	public static final int BOTTOM = 0;
	public static final int TOP = 1;
	public static final int NORTH = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	public static final int EAST = 5;
	
	public static boolean isNormalBlockAround(IBlockAccess block, int x, int y, int z) {
		
		if (block.getBlock(x - 1, y, z).isNormalCube() || block.getBlock(x + 1, y, z).isNormalCube() || block.getBlock(x, y, z - 1).isNormalCube()
				|| block.getBlock(x, y, z + 1).isNormalCube())
			return true;
		else
			return false;
	}
	
	public static boolean isNormalBlockAllAround(IBlockAccess block, int x, int y, int z) {
		
		if (block.getBlock(x - 1, y, z).isNormalCube() && block.getBlock(x + 1, y, z).isNormalCube() && block.getBlock(x, y, z - 1).isNormalCube()
				&& block.getBlock(x, y, z + 1).isNormalCube() && block.getBlock(x, y - 1, z).isNormalCube()
				&& block.getBlock(x, y + 1, z).isNormalCube())
			return true;
		else
			return false;
	}
	
	/*
	 * public static boolean sameTexture(IBlockAccess world, BlockFloorWall block,
	 * int x, int y, int z, int dir) {
	 * 
	 * BlockFloorWall selected; boolean same = false;
	 * 
	 * switch (dir) { case 0: if (world.getBlock(x, y - 1, z) == block) { selected =
	 * (BlockFloorWall) world.getBlock(x, y - 1, z); if () same = true; } return
	 * same; case 1: return world.getBlock(x, y + 1, z) == block; case 2: return
	 * world.getBlock(x, y, z - 1) == block; case 3: return world.getBlock(x, y, z +
	 * 1) == block; case 4: return world.getBlock(x - 1, y, z) == block; case 5:
	 * return world.getBlock(x + 1, y, z) == block; default: return false; }
	 * 
	 * }
	 */
	
	/**
	 * Return un boolean après avoir vérifier le block dans la direction spécifiée
	 * 
	 * @param block
	 * @param x
	 * @param y
	 * @param z
	 * @param connectToNormal
	 * @param direction       (use BlocksUtils.NORTH for ex)
	 * @return
	 * @author Joe
	 */
	public static boolean shouldConnectTexture(IBlockAccess world, int x, int y, int z, Block block, boolean connectToNormal, int dir) {
		
		// 0 - Bottom, y neg
		// 1 - Top, y pos
		// 2 - North, z neg
		// 3 = South, z pos
		// 4 - West, x neg
		// 5 - East, x pos
		
		if (connectToNormal)
		{
			switch (dir)
			{
			case 0:
				return world.getBlock(x, y - 1, z) == block || world.getBlock(x, y - 1, z).isNormalCube()|| block.getClass() == world.getBlock(x, y - 1, z).getClass();
			case 1:
				return world.getBlock(x, y + 1, z) == block || world.getBlock(x, y + 1, z).isNormalCube()|| block.getClass() == world.getBlock(x, y + 1, z).getClass();
			case 2:
				return world.getBlock(x, y, z - 1) == block || world.getBlock(x, y, z - 1).isNormalCube()|| block.getClass() == world.getBlock(x, y , z- 1).getClass();
			case 3:
				return world.getBlock(x, y, z + 1) == block || world.getBlock(x, y, z + 1).isNormalCube()|| block.getClass() == world.getBlock(x, y, z + 1).getClass();
			case 4:
				return world.getBlock(x - 1, y, z) == block || world.getBlock(x - 1, y, z).isNormalCube()|| block.getClass() == world.getBlock(x - 1, y, z).getClass();
			case 5:
				return world.getBlock(x + 1, y, z) == block || world.getBlock(x + 1, y, z).isNormalCube() || block.getClass() == world.getBlock(x + 1, y, z).getClass();
			default:
				return false;
			}
		} else
		{
			switch (dir)
			{
			case 0:
				return world.getBlock(x, y - 1, z) == block;
			case 1:
				return world.getBlock(x, y + 1, z) == block;
			case 2:
				return world.getBlock(x, y, z - 1) == block;
			case 3:
				return world.getBlock(x, y, z + 1) == block;
			case 4:
				return world.getBlock(x - 1, y, z) == block;
			case 5:
				return world.getBlock(x + 1, y, z) == block;
			default:
				return false;
			}
		}
	}
	
	public static boolean shouldConnectTextureVerifyMeta(IBlockAccess world, int x, int y, int z, Block block, boolean connectToNormal, int dir) {
		
		// 0 - Bottom, y neg
		// 1 - Top, y pos
		// 2 - North, z neg
		// 3 = South, z pos
		// 4 - West, x neg
		// 5 - East, x pos
		
		int meta = world.getBlockMetadata(x, y, z);
		
		if (connectToNormal)
		{
			switch (dir)
			{
			case 0:
				return (world.getBlock(x, y - 1, z) == block && meta == world.getBlockMetadata(x, y - 1, z))
						|| world.getBlock(x, y - 1, z).isNormalCube();
			case 1:
				return (world.getBlock(x, y + 1, z) == block && meta == world.getBlockMetadata(x, y + 1, z))
						|| world.getBlock(x, y + 1, z).isNormalCube();
			case 2:
				return (world.getBlock(x, y, z - 1) == block && meta == world.getBlockMetadata(x, y, z - 1))
						|| world.getBlock(x, y, z - 1).isNormalCube();
			case 3:
				return (world.getBlock(x, y, z + 1) == block && meta == world.getBlockMetadata(x, y, z + 1))
						|| world.getBlock(x, y, z + 1).isNormalCube();
			case 4:
				return (world.getBlock(x - 1, y, z) == block && meta == world.getBlockMetadata(x - 1, y, z))
						|| world.getBlock(x - 1, y, z).isNormalCube();
			case 5:
				return (world.getBlock(x + 1, y, z) == block && meta == world.getBlockMetadata(x + 1, y, z))
						|| world.getBlock(x + 1, y, z).isNormalCube();
			default:
				return false;
			}
		} else
		{
			switch (dir)
			{
			case 0:
				return world.getBlock(x, y - 1, z) == block && meta == world.getBlockMetadata(x, y - 1, z);
			case 1:
				return world.getBlock(x, y + 1, z) == block && meta == world.getBlockMetadata(x, y + 1, z);
			case 2:
				return world.getBlock(x, y, z - 1) == block && meta == world.getBlockMetadata(x, y, z - 1);
			case 3:
				return world.getBlock(x, y, z + 1) == block && meta == world.getBlockMetadata(x, y, z + 1);
			case 4:
				return world.getBlock(x - 1, y, z) == block && meta == world.getBlockMetadata(x - 1, y, z);
			case 5:
				return world.getBlock(x + 1, y, z) == block && meta == world.getBlockMetadata(x + 1, y, z);
			default:
				return false;
			}
		}
	}
	
	public static boolean isSameBlockAround(IBlockAccess block, HBlock ref, int x, int y, int z) {
		
		if (block.getBlock(x - 1, y, z).getClass() == ref.getClass() || block.getBlock(x + 1, y, z).getClass() == ref.getClass() || block.getBlock(x, y, z - 1).getClass() == ref.getClass()
				|| block.getBlock(x, y, z + 1).getClass() == ref.getClass())
			return true;
		else
			return false;
	}
	
	/**
	 * Méthode qui calcule si oui ou non un int généré sera en dessous du paramètre
	 * percent
	 * 
	 * @param percent
	 * @return alternatif ?
	 * @author Joe
	 */
	public static boolean getRandomBool(int percent) {
		
		Random rand = new Random();
		int result;
		result = rand.nextInt(99);
		
		if (result <= percent - 1)
			return false;
		else
			return true;
	}
	
	public static int getRandomInt (int randomTexture) {
		
		Random rand = new Random();
		int result = rand.nextInt(randomTexture);
		return result;
	}
	
	/**
	 * Mettre les valeurs obtenues dans la méthode this.setBlockBounds
	 * 
	 * @param block
	 * @param x
	 * @param y
	 * @param z
	 * @return Tableau de variables float (xMin,xMax,zMin,zMax)
	 * @author Joe
	 */
	public static float[] boundingBoxFence(IBlockAccess world, int x, int y, int z) {
		
		float f1 = 0.0F;
		float f2 = 0.0F;
		float f3 = 1.0F;
		float f4 = 1.0F;
		
		boolean north = BlocksUtils.shouldConnectTexture(world, x, y, z, world.getBlock(x, y, z), true, BlocksUtils.NORTH);
		boolean south = BlocksUtils.shouldConnectTexture(world, x, y, z, world.getBlock(x, y, z), true, BlocksUtils.SOUTH);
		boolean west = BlocksUtils.shouldConnectTexture(world, x, y, z, world.getBlock(x, y, z), true, BlocksUtils.WEST);
		boolean east = BlocksUtils.shouldConnectTexture(world, x, y, z, world.getBlock(x, y, z), true, BlocksUtils.EAST);
		
		if ((!east && !west) && (north || south || west || east))
		{
			if (north && !south)
			{
				// right
				f1 = 0.4F;
				f3 = 0.6F;
				f4 = 0.5F;
			} else if (south && !north)
			{
				
				f1 = 0.4F;
				f3 = 0.6F;
				f2 = 0.5F;
			} else
			{
				f1 = 0.4F;
				f3 = 0.6F;
			}
		}
		
		if ((!north && !south) && (north || south || west || east))
		{
			if (east && !west)
			{
				f1 = 0.5F;
				f2 = 0.4F;
				f4 = 0.6F;
			} else if (west && !east)
			{
				f2 = 0.4F;
				f4 = 0.6F;
				f3 = 0.5F;
			} else
			{
				f2 = 0.4F;
				f4 = 0.6F;
			}
		}
		
		if ((!north || !south) && (north || south || west || east))
		{
			
			if (north && !south)
			{
				f2 = 0.0F;
			} else if (!north && south)
			{
				f4 = 1.0F;
				
			}
		} else
		{
			f2 = 0.0F;
			f4 = 1.0F;
		}
		
		float[] boundingBox = new float[] { f1, f2, f3, f4 };
		return boundingBox;
	}
	
	/**
	 * Méthode qui renvoit un int correspondant a une structure particulière
	 * 
	 * @param world
	 * @param block
	 * @param x
	 * @param y
	 * @param z
	 * @return int
	 * @author Joe
	 */
	public static int getStructureType(IBlockAccess world, Block block, int x, int y, int z) {
		return 0;
	}
}
