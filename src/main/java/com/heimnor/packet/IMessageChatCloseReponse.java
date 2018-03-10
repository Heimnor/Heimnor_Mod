package com.heimnor.packet;

import com.heimnor.events.LivingEventHandler;
import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class IMessageChatCloseReponse implements IMessage {

	private String username;

	public IMessageChatCloseReponse() {
	}

	public IMessageChatCloseReponse(String text) {
		this.username = text;
	}

	@Override
	public void fromBytes(ByteBuf buf) {

		this.username = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeUTF8String(buf, username);
	}

	public static class IMessageHandlerChatReponseClose implements IMessageHandler<IMessageChatCloseReponse, IMessage> {

		@Override
		public IMessage onMessage(IMessageChatCloseReponse message, MessageContext ctx) {

			while (ClientProxy.CHATTING_PLAYERS_USERNAME.contains(message.username)) {

				ClientProxy.CHATTING_PLAYERS_USERNAME.remove(message.username);
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				System.out.println(ClientProxy.CHATTING_PLAYERS_USERNAME);
			}
			return null;
		}

	}

}