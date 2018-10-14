package com.heimnor.creativetabs;

import com.heimnor.common.Heimnor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HeimnorBlockCreativeTabs extends CreativeTabs{

	public HeimnorBlockCreativeTabs(String lable) {
		super(lable);

	}

	@Override
	public Item getTabIconItem() {

		return Heimnor.itemclochette;
	}
	
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
