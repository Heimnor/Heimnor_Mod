package com.heimnor.common;

import com.heimnor.packet.IMessagePropertyRep;
import com.heimnor.packet.IMessagePropertySync;
import com.heimnor.proxy.CommonProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPropertyH implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "EPHeimnor";
	private final EntityPlayer player;

	public int alcohol;

	public ExtendedPropertyH(EntityPlayer player) {
		this.player = player;
		this.alcohol = 0;
		System.out.println("Constructor");
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPropertyH.EXT_PROP_NAME, new ExtendedPropertyH(player));
	}

	public static final ExtendedPropertyH get(EntityPlayer player) {
		return (ExtendedPropertyH) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("alcohol", this.alcohol);

		// Sauvegarde les properties (toujours à la fin)
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.alcohol = properties.getInteger("alcohol");
	}

	private static String getSaveKey(EntityPlayer player) {
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData(EntityPlayer player) {
		ExtendedPropertyH playerData = ExtendedPropertyH.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}

	public static void loadProxyData(EntityPlayer player) {
		ExtendedPropertyH playerData = ExtendedPropertyH.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
		playerData.sync();
	}

	@Override
	public void init(Entity entity, World world) {

	}

	public final void sync() {
		IMessagePropertySync packet = new IMessagePropertySync(this.alcohol);
		Heimnor.network.sendToServer(packet);
		if (!player.worldObj.isRemote) {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			Heimnor.network.sendTo(new IMessagePropertyRep(this.alcohol), playerMP);
		}
	}
	
	// méthodes spécifiques
	
	public int getAlcohol() {
		return this.alcohol;
	}
	
	public void addAlcohol(int alcoholLevel) {
		this.alcohol = this.alcohol + 1;
		this.sync();
	}
	
	public void reduceAlcohol() {
		this.alcohol -= 5;
		this.sync();
	}
}
