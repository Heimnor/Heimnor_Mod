package com.heimnor.common;

import java.awt.List;

import init.drinks.ChopeBiere;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HeimnorCreativeTab extends CreativeTabs
{
	

	
	private List list;

	public HeimnorCreativeTab(String label)
	   {
	        super(label);
	   }
	
	
	@Override
	public Item getTabIconItem()
	{
	   return Heimnor.itemchope;
	}
	
	@Override
	public boolean hasSearchBar()
	{
	    return true;
	}
	
}
