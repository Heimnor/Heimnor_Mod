package com.heimnor.events;

import com.heimnor.common.Heimnor;
import com.heimnor.extendedentityproperties.EPAlcohol;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PropertiesEvent {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {

		if (event.entity instanceof EntityPlayer && EPAlcohol.get((EntityPlayer) event.entity) == null)

			EPAlcohol.register((EntityPlayer) event.entity);
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((EPAlcohol) (event.entity.getExtendedProperties(EPAlcohol.EXT_PROP_NAME)))
					.saveNBTData(playerData);
			Heimnor.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
			EPAlcohol.saveProxyData((EntityPlayer) event.entity);
		} else {

		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = Heimnor.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
			if (playerData != null) {
				((EPAlcohol) (event.entity.getExtendedProperties(EPAlcohol.EXT_PROP_NAME)))
						.loadNBTData(playerData);
			}

			((EPAlcohol) (event.entity.getExtendedProperties(EPAlcohol.EXT_PROP_NAME))).sync();
		}
	}
}
