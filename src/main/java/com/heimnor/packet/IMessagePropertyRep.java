package com.heimnor.packet;

import com.heimnor.common.ExtendedPropertyH;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class IMessagePropertyRep implements IMessage{

	public int alcohol;
	
	public IMessagePropertyRep() {}
	
	public IMessagePropertyRep(int alcohol) {
		this.alcohol = alcohol;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.alcohol = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, alcohol, 5);
	}
	public static class ClientHandler implements IMessageHandler<IMessagePropertyRep, IMessage>{

		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(IMessagePropertyRep message, MessageContext ctx) {
			EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().thePlayer;
			ExtendedPropertyH properties = ExtendedPropertyH.get(player);
			properties.alcohol = message.alcohol;
			return null;
		}
	}
}
