package com.heimnor.extendedentityproperties;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessagePropertyRep;
import com.heimnor.packet.IMessagePropertySync;
import com.heimnor.proxy.CommonProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EPAlcohol implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "EPHeimnor";
	private final EntityPlayer player;

	public int alcohol;

	public EPAlcohol(EntityPlayer player) {
		this.player = player;
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(EPAlcohol.EXT_PROP_NAME, new EPAlcohol(player));
	}

	public static final EPAlcohol get(EntityPlayer player) {
		return (EPAlcohol) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("alcohol", this.alcohol);
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
		EPAlcohol playerData = EPAlcohol.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}

	public static void loadProxyData(EntityPlayer player) {
		EPAlcohol playerData = EPAlcohol.get(player);
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
		
		this.alcohol = this.alcohol + alcoholLevel;
		this.sync();
	}
	
	public void reduceAlcohol(int amount) {
		this.alcohol -= amount;
		this.sync();
	}
	
	public void resetAlcohol() {
		this.alcohol = 0;
		this.sync();
	}
}
