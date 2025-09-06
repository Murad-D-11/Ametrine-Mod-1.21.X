package net.conciliatory.ametrinemod.item;

import net.conciliatory.ametrinemod.AmetrineMod;
import net.conciliatory.ametrinemod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_AMETRINE = registerItem("raw_ametrine", new Item(new Item.Settings()));
    public static final Item AMETRINE = registerItem("ametrine", new Item(new Item.Settings()));

    public static final Item CHISEL =  registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(132)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AmetrineMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AmetrineMod.LOGGER.info("Registering Mod Items for " + AmetrineMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
           entries.add(RAW_AMETRINE);
           entries.add(AMETRINE);
        });
    }
}
