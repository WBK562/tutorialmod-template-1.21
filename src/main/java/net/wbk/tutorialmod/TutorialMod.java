package net.wbk.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.wbk.tutorialmod.block.ModBlocks;
import net.wbk.tutorialmod.item.ModItem;
import net.wbk.tutorialmod.item.ModItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItem.registerModItems();
		ModBlocks.registerModBlocks();
	}
}