package com.heimnor.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class PacketPerm implements IMessage{

	public PacketPerm() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	public static class Handler implements IMessageHandler<PacketPerm, IMessage>{

		@Override
		public IMessage onMessage(PacketPerm message, MessageContext ctx) {
			
			System.out.println("Packet reçu");
			
			return null;
		}
		
	}
}
