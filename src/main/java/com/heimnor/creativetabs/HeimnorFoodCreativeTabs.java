package com.heimnor.creativetabs;

import com.heimnor.common.Heimnor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HeimnorFoodCreativeTabs extends CreativeTabs{

	public HeimnorFoodCreativeTabs(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return Heimnor.itemchope;
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
