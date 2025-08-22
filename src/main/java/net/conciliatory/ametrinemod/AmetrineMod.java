/**
 * TO-DO:
 * 1. Create icon for the mod
 * 2.
 */

package net.conciliatory.ametrinemod;

import net.conciliatory.ametrinemod.block.ModBlocks;
import net.conciliatory.ametrinemod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmetrineMod implements ModInitializer {
	public static final String MOD_ID = "ametrinemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}