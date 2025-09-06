package net.conciliatory.ametrinemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {
    public static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
                    Map.entry(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE),
                    Map.entry(Blocks.DIORITE, Blocks.POLISHED_DIORITE),
                    Map.entry(Blocks.GRANITE, Blocks.POLISHED_GRANITE),
                    Map.entry(Blocks.MUD, Blocks.MUD_BRICKS),
                    Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
                    Map.entry(Blocks.SAND, Blocks.SANDSTONE),
                    Map.entry(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE),
                    Map.entry(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
                    Map.entry(Blocks.DRIPSTONE_BLOCK, Blocks.POINTED_DRIPSTONE),
                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.CLAY, Blocks.BRICKS),
                    Map.entry(Blocks.COBBLESTONE, Blocks.STONE),
                    Map.entry(Blocks.TUFF, Blocks.TUFF_BRICKS),
                    Map.entry(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK),
                    Map.entry(Blocks.RED_SAND, Blocks.RED_SANDSTONE),
                    Map.entry(Blocks.TUFF_SLAB, Blocks.TUFF_BRICK_SLAB)
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
