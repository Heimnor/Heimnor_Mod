package com.heimnor.creativetabs;

import com.heimnor.common.Heimnor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HeimnorBlocksDecoTabs extends CreativeTabs{

	public HeimnorBlocksDecoTabs(String lable) {
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Heimnor.itemverre_vin;
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
