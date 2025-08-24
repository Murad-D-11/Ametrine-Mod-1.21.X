package net.conciliatory.ametrinemod.item;

import net.conciliatory.ametrinemod.AmetrineMod;
import net.conciliatory.ametrinemod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    // Custom item group in creative menu
    public static final ItemGroup AMETRINE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AmetrineMod.MOD_ID, "ametrine_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AMETRINE))
                    .displayName(Text.translatable("itemgroup.ametrinemod"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.AMETRINE);
                      entries.add(ModItems.RAW_AMETRINE);
                      entries.add(ModBlocks.AMETRINE_BLOCK);
                      entries.add(ModBlocks.RAW_AMETRINE_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        AmetrineMod.LOGGER.info("Registering Item Groups for " + AmetrineMod.MOD_ID);
    }
}
