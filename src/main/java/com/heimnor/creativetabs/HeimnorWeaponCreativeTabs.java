package com.heimnor.creativetabs;

import java.awt.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import registry.WeaponsRegistry;

public class HeimnorWeaponCreativeTabs extends CreativeTabs
{
	

	
	private List list;

	public HeimnorWeaponCreativeTabs(String label)
	   {
	        super(label);
	   }
	
	
	@Override
	public Item getTabIconItem()
	{
	   return WeaponsRegistry.epeeClaymore;
	}
	
	@Override
	public boolean hasSearchBar()
	{
	    return true;
	}
	
}