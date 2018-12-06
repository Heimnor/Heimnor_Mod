package com.heimnor.utils;

import com.heimnor.common.Heimnor;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class TextureMap {
	
	private int width, height;
	private String name;
	private IIcon[][] icons;
	private Block[][] schema;
	
	public TextureMap(int width, int height, String name) {
		
		this.width = width;
		this.height = height;
		this.name = name;
		schema = new Block[width][height];
	}
	
	public IIcon[][] registerIcons(IIconRegister iconRegister, String nameBlock) {
		
		icons = new IIcon[height][width];
		
		for (int i = 0; i < width; i++)
		{
			for (int k = 0; k < height; k++)
			{
				
				icons[i][k] = iconRegister.registerIcon(Heimnor.MODID + ":" + nameBlock + "/" + this.name + i + "" + k);
			}
			
		}
		return icons;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public IIcon[][] getTextureMap() {
		return this.icons;
	}
	
	public int getRequiredSuccess() {
		return this.getWidth() * this.getHeight();
	}
	
	public String getTextureMapName() {
		return this.name;
	}
	
	public Block[][] getSchematic(Block block) {
		schema = new Block[width][height];
		for (int i = 0; i < width; i++)
		{
			for (int k = 0; k < this.height; k++)
			{
				schema[i][k] = block;
			}
		}
		return schema;
	}
}
