package pl.grm.narutocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.registry.RegJutsus;
import pl.grm.narutocraft.network.PacketNinjaStatsRequest;

public class GuiNinjaStats extends GuiContainer {
	private EntityPlayer player;
	private int padLeft = 44, padTop = 27;
	private Boolean jutsuMenu = false;
	private int jutsuPage = 0;

	public GuiNinjaStats(EntityPlayer player) {
		super(new ContainerNull());

		this.player = player;
		xSize = jutsuMenu ? 210 : 256;
		ySize = jutsuMenu ? 210 : 256;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		xSize = jutsuMenu ? 210 : 256;
		ySize = jutsuMenu ? 210 : 256;

		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(jutsuMenu
				? References.jutsuGUI[jutsuPage]
				: References.stats);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		this.buttonList.clear();
		// Start with main control buttons

		int x1 = guiLeft;
		int x2 = (guiLeft + xSize) - (22);
		int x3 = (x2 + x1) / 2;

		// Controls
		this.buttonList.add(new GuiNinjaTab(0, x2, guiTop - 22,
				RegJutsus.Enmakugire.getIconFromDamage(0)));// Stats page
		this.buttonList.add(new GuiNinjaTab(1, x1, guiTop - 22, Items.apple
				.getIconFromDamage(0)));// Jutsu
		this.buttonList.add(new GuiNinjaTab(2, x1 + 22, guiTop - 22,
				Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(3, x1 + 22 * 2, guiTop - 22,
				Items.apple.getIconFromDamage(0)));// Jutsu
		this.buttonList.add(new GuiNinjaTab(4, x1 + 22 * 3, guiTop - 22,
				Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(5, x1 + 22 * 4, guiTop - 22,
				Items.apple.getIconFromDamage(0)));// Jutsu
		this.buttonList.add(new GuiNinjaTab(6, x1 + 22 * 5, guiTop - 22,
				Items.apple.getIconFromDamage(0)));

		// Stats
		ExtendedProperties props = ExtendedProperties.get(player);
		if (!jutsuMenu) {
			this.drawString(fontRendererObj,
					"Ninja Level: " + props.psa.getNinjaLevel(), guiLeft
							+ padLeft, guiTop + padTop - 9, 0xddeeee);
			if (props.psa.skillPoints > 0)
				this.drawString(fontRendererObj, "Skill Points: "
						+ props.psa.skillPoints, guiLeft + padLeft, guiTop
						+ padTop, 0xddeeee);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(References.ninjaWidgets);
			drawTexturedModalRect(guiLeft + 132, guiTop + padTop - 7, 66, 0,
					39, 4);
			drawTexturedModalRect(
					guiLeft + 132,
					guiTop + padTop - 7,
					66,
					4,
					props.psa.getCurrentNinjaXp() * 39
							/ props.psa.getNinjaXpCap(), 4);

			this.drawString(fontRendererObj, "Stats (3 points)", guiLeft
					+ padLeft, guiTop + padTop + 9 * 2, 0xddeeee);
			this.drawString(fontRendererObj,
					"Strength: " + props.psa.getStrength(), guiLeft + padLeft,
					guiTop + padTop + 9 * 3, 0xddeeee);
			this.drawString(fontRendererObj,
					"Resistance: " + props.psa.getResistance(), guiLeft
							+ padLeft, guiTop + padTop + 9 * 4, 0xddeeee);
			this.drawString(fontRendererObj,
					"Dexterity: " + props.psa.getDexterity(),
					guiLeft + padLeft, guiTop + padTop + 9 * 5, 0xddeeee);
			this.drawString(fontRendererObj,
					"Agility: " + props.psa.getAgility(), guiLeft + padLeft,
					guiTop + padTop + 9 * 6, 0xddeeee);
			if (props.psa.skillPoints >= 3) {
				this.buttonList.add(new GuiNinjaButton(7, guiLeft + padLeft
						+ 70, guiTop + padTop + 9 * 3, "plus"));
				this.buttonList.add(new GuiNinjaButton(8, guiLeft + padLeft
						+ 70, guiTop + padTop + 9 * 4, "plus"));
				this.buttonList.add(new GuiNinjaButton(9, guiLeft + padLeft
						+ 70, guiTop + padTop + 9 * 5, "plus"));
				this.buttonList.add(new GuiNinjaButton(10, guiLeft + padLeft
						+ 70, guiTop + padTop + 9 * 6, "plus"));
			}

			this.drawString(fontRendererObj, "Training (1 point)", guiLeft
					+ padLeft, guiTop + padTop + 9 * 8, 0xddeeee);
			this.drawString(fontRendererObj,
					"Element Power: " + props.psa.getElementPowerModifier(),
					guiLeft + padLeft, guiTop + padTop + 9 * 9, 0xddeeee);
			this.drawString(fontRendererObj,
					"Max Chakra Bonus: " + props.psa.getChakraModifier(),
					guiLeft + padLeft, guiTop + padTop + 9 * 10, 0xddeeee);
			this.drawString(fontRendererObj,
					"Chakra Regen Bonus: " + props.psa.getChakraRegenBonus(),
					guiLeft + padLeft, guiTop + padTop + 9 * 11, 0xddeeee);
			if (props.psa.skillPoints >= 1) {
				this.buttonList.add(new GuiNinjaButton(11, guiLeft + padLeft
						+ 120, guiTop + padTop + 9 * 9, "plus"));
				this.buttonList.add(new GuiNinjaButton(12, guiLeft + padLeft
						+ 120, guiTop + padTop + 9 * 10, "plus"));
				this.buttonList.add(new GuiNinjaButton(13, guiLeft + padLeft
						+ 120, guiTop + padTop + 9 * 11, "plus"));
			}
			this.buttonList.add(new GuiButton(14, guiLeft + padLeft, guiTop
					+ padTop + 9 * 13, 50, 20, "Save"));
			this.buttonList.add(new GuiButton(15, guiLeft + padLeft + 50,
					guiTop + padTop + 9 * 13, 50, 20, "Reset"));
		}
	}

	/** Button Clicks **/
	@Override
	protected void actionPerformed(GuiButton button) {
		// Tabs 0 - 6, Stats and then the 6 Jutsu types
		switch (button.id) {
			case 0 : // Stats
				jutsuMenu = false;
				break;
			case 1 : // jutsu
				jutsuMenu = true;
				jutsuPage = 0;
				break;
			case 2 : // jutsu
				jutsuMenu = true;
				jutsuPage = 1;
				break;
			case 3 : // jutsu
				jutsuMenu = true;
				jutsuPage = 2;
				break;
			case 4 : // jutsu
				jutsuMenu = true;
				jutsuPage = 3;
				break;
			case 5 : // jutsu
				jutsuMenu = true;
				jutsuPage = 4;
				break;
			case 6 : // jutsu
				jutsuMenu = true;
				jutsuPage = 5;
				break;
			case 7 : // increase Strength
				ExtendedProperties.get(player).psa
						.setStrength(ExtendedProperties.get(player).psa
								.getStrength() + 1);
				ExtendedProperties.get(player).psa.skillPoints -= 3;
				break;
			case 8 : // increase Resist
				ExtendedProperties.get(player).psa
						.setResistance(ExtendedProperties.get(player).psa
								.getResistance() + 1);
				ExtendedProperties.get(player).psa.skillPoints -= 3;
				break;
			case 9 : // increase Dex
				ExtendedProperties.get(player).psa
						.setDexterity(ExtendedProperties.get(player).psa
								.getDexterity() + 1);
				ExtendedProperties.get(player).psa.skillPoints -= 3;
				break;
			case 10 : // increase Agi
				ExtendedProperties.get(player).psa
						.setAgility(ExtendedProperties.get(player).psa
								.getAgility() + 1);
				ExtendedProperties.get(player).psa.skillPoints -= 3;
				break;
			case 11 : // increase elm
				ExtendedProperties.get(player).psa
						.setElementPowerModifier(ExtendedProperties.get(player).psa
								.getElementPowerModifier() + 1);
				ExtendedProperties.get(player).psa.skillPoints -= 1;
				break;
			case 12 : // increase mcha
				ExtendedProperties.get(player).psa
						.setChakraModifier(ExtendedProperties.get(player).psa
								.getChakraModifier() + 1);
				ExtendedProperties.get(player).psa.skillPoints -= 1;
				break;
			case 13 : // increase char
				if (ExtendedProperties.get(player).psa.getChakraRegenBonus() < 75) {
					ExtendedProperties.get(player).psa
							.setChakraRegenBonus(ExtendedProperties.get(player).psa
									.getChakraRegenBonus() + 1);
					ExtendedProperties.get(player).psa.skillPoints -= 1;
				}
				break;
			case 14 : // send changes
				NarutoCraft.netHandler
						.sendToServer(new PacketNinjaStatsRequest("set",
								ExtendedProperties.get(player).psa.getValues()));
				break;
			case 15 : // reset all
				NarutoCraft.netHandler
						.sendToServer(new PacketNinjaStatsRequest("reset",
								ExtendedProperties.get(player).psa.getValues()));
				break;
		}
	}

	/** Keyboard Clicks **/
	@Override
	protected void keyTyped(char par1, int par2) {
		if (par2 == 1
				|| par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
			this.mc.thePlayer.closeScreen();
		}
	}
}
