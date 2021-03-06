package com.clowcadia.test.gui;

import java.util.ArrayList;
import java.util.List;

import com.clowcadia.test.TestModHandler;
import com.clowcadia.test.containers.ContainerBasic;
import com.clowcadia.test.npc.Basic;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import scala.reflect.internal.Trees.This;

public class GuiBasic extends GuiContainer{
	
	private IInventory playerInv;
	private Entity entity;
	//private int stomach;

	public GuiBasic(IInventory playerInv, Entity entity) {
		super(new ContainerBasic(playerInv, entity));
		
		//this.stomach = stomach;
		this.xSize=176;
		this.ySize=166;
		
		this.playerInv = playerInv;
		this.entity = entity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F,1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(TestModHandler.modId, "textures/gui/container/basic.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize,this.ySize);
		
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Block Breaker in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("container.basic"); //Gets the formatted name for the block breaker from the language file
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
		this.mc.fontRendererObj.drawString(((Basic) entity).getStomach()+"", this.xSize / 2 - this.mc.fontRendererObj.getStringWidth("") / 2, 20, 4210752);
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		
	}
	

}
