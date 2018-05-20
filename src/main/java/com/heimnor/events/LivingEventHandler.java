package com.heimnor.events;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.heimnor.client.ChatGui;
import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageChat;
import com.heimnor.proxy.ClientProxy;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Type;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class LivingEventHandler {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayersChatOpened(KeyInputEvent event) {
		if (!(Minecraft.getMinecraft().currentScreen instanceof GuiChat)
				&& Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindChat.getKeyCode())) {

			Heimnor.network.sendToServer(new IMessageChat());
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void updateAlcohol(TickEvent.PlayerTickEvent event) {
		if (event.side.isClient()) {
			
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void openChatGui(GuiOpenEvent event) {

		if (event.gui != null && event.gui.getClass().equals(GuiChat.class)) {

			event.gui = new ChatGui();
			System.out.println(event.gui);
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer) {
			ClientProxy.CHATTING_PLAYERS_USERNAME.clear();

		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Pre event) {

		double x = event.entityPlayer.posX - Minecraft.getMinecraft().thePlayer.posX;
		double y = event.entityPlayer.posY - Minecraft.getMinecraft().thePlayer.posY;
		double z = event.entityPlayer.posZ - Minecraft.getMinecraft().thePlayer.posZ;

		if (ClientProxy.CHATTING_PLAYERS_USERNAME.contains(event.entityPlayer.getDisplayName())
				&& event.entityPlayer.getDisplayName().equals(Minecraft.getMinecraft().thePlayer.getDisplayName())) {
			RenderManager renderManager = (RenderManager) ObfuscationReflectionHelper.getPrivateValue(Render.class,
					event.renderer, 1);

			float scaleFactor = 0.10F / 6.0F;
			float yOffsetFactor = -0.05F;

			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glTranslated(x, y - 2.5, z);
			GL11.glNormal3f(0.0F, 0.0F, 0.1F);
			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 0.1F, 0.0F);
			GL11.glScalef(-scaleFactor, -scaleFactor, scaleFactor);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(new ResourceLocation("heimnormod", "textures/items/bulle.png"));

			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-16 + 0, -220 + 32, -10, 0.1F, 0.1F);
			tessellator.addVertexWithUV(-16 + 32, -220 + 32, -10, 0.1F, 0.0F);
			tessellator.addVertexWithUV(-16 + 32, -220 + 0, -10, 0.0F, 0.0F);
			// coin haut gauche

			tessellator.addVertexWithUV(-16 + 0, -220 + 0, -10, 0.0F, 0.1F);
			tessellator.draw();
			GL11.glPopMatrix();

		} else if (ClientProxy.CHATTING_PLAYERS_USERNAME.contains(event.entityPlayer.getDisplayName())
				&& event.entityPlayer.getDisplayName() != Minecraft.getMinecraft().thePlayer.getDisplayName()) {

			RenderManager renderManager = (RenderManager) ObfuscationReflectionHelper.getPrivateValue(Render.class,
					event.renderer, 1);

			float scaleFactor = 0.10F / 6.0F;
			float yOffsetFactor = -0.05F;

			GL11.glPushMatrix();
			GL11.glTranslated(x, y - 1, z);
			GL11.glNormal3f(0.0F, 0.0F, 0.1F);
			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 0.1F, 0.0F);
			GL11.glScalef(-scaleFactor, -scaleFactor, scaleFactor);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(new ResourceLocation("heimnormod", "textures/items/bulle.png"));

			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-16 + 0, -220 + 32, -10, 0.1F, 0.1F);
			tessellator.addVertexWithUV(-16 + 32, -220 + 32, -10, 0.1F, 0.0F);
			tessellator.addVertexWithUV(-16 + 32, -220 + 0, -10, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-16 + 0, -220 + 0, -10, 0.0F, 0.1F);
			tessellator.draw();
			GL11.glPopMatrix();

		}
	}
}