package com.heimnor.proxy;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import net.minecraft.nbt.NBTTagCompound;

public class CommonProxy {
	private static final HashMap<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public static void storeEntityData(String name, NBTTagCompound compound) {
		((HashMap<String, NBTTagCompound>) extendedEntityData).put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) {
		return ((HashMap<String, NBTTagCompound>) extendedEntityData).remove(name);
	}

	public void registerRender() {

	}

}
