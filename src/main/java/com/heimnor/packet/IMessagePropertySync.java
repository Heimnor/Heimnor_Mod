package com.heimnor.packet;

import com.heimnor.extendedentityproperties.EPAlcohol;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;

public class IMessagePropertySync implements IMessage{

	public int alcohol;
	
	
	public IMessagePropertySync() {}
	
	public IMessagePropertySync(int alcohol) {
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
	public static class CommonHandler implements IMessageHandler<IMessagePropertySync, IMessage>{

		@Override
		public IMessage onMessage(IMessagePropertySync message, MessageContext ctx) {
			
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			EPAlcohol properties = EPAlcohol.get(player);
			properties.alcohol = message.alcohol;
			System.out.println("Packet Serveur");
			return null;
		}
		
	}
}
