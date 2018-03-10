package com.heimnor.packet;

import com.heimnor.common.Heimnor;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;

public class IMessageChat implements IMessage {
	private boolean LivingEventHandler;

	public IMessageChat() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {
		

	}

	public static class IMessageHandlerChat implements IMessageHandler<IMessageChat, IMessage> {

		@Override
		public IMessage onMessage(IMessageChat message, MessageContext ctx) {

			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			Heimnor.network.sendToAll(new IMessageChatReponse(player.getDisplayName()));
			return null;
		}
	}
}
