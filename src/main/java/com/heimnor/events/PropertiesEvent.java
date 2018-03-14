package com.heimnor.events;

import com.heimnor.common.ExtendedPropertyH;
import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PropertiesEvent {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {

		if (event.entity instanceof EntityPlayer && ExtendedPropertyH.get((EntityPlayer) event.entity) == null)

			ExtendedPropertyH.register((EntityPlayer) event.entity);
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPropertyH) (event.entity.getExtendedProperties(ExtendedPropertyH.EXT_PROP_NAME)))
					.saveNBTData(playerData);
			Heimnor.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
			ExtendedPropertyH.saveProxyData((EntityPlayer) event.entity);
		} else {

		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = Heimnor.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
			if (playerData != null) {
				((ExtendedPropertyH) (event.entity.getExtendedProperties(ExtendedPropertyH.EXT_PROP_NAME)))
						.loadNBTData(playerData);
			}

			((ExtendedPropertyH) (event.entity.getExtendedProperties(ExtendedPropertyH.EXT_PROP_NAME))).sync();
		}
	}
}
