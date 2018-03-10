package com.heimnor.events;

import java.io.File;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.PacketPerm;
import com.heimnor.utils.NbtCsFile;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;

public class ServerEvents {

	
	@SubscribeEvent
	public void onPlayerConnection(PlayerEvent.PlayerLoggedInEvent event) {
	
		File permissions = new File("Heimnor/Permissions.dat");
		if(permissions.exists()) {
			if(!NbtCsFile.getData(permissions).getCompoundTag("index").hasKey(event.player.getDisplayName())) {
				
				NBTTagCompound index = NbtCsFile.getNbtTagCompound(permissions, "index");
				index.setString(event.player.getDisplayName(), "Visiteur");
				NbtCsFile.setNbtTagCompound(permissions, "index", index);
			}
		}
	}
}
