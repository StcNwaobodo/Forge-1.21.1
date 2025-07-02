package com.stc.gemmod.item;

import com.stc.gemmod.GemMod;
import com.stc.gemmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GemMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MITHRIL_ITEMS_TAB = CREATIVE_MODE_TABS.register("mithril_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL.get()))
                    .title(Component.translatable("creativetab.gemmod.mithril_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MITHRIL.get());
                        output.accept(ModItems.RAW_MITHRIL.get());

                        output.accept(ModItems.CHISEL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> MITHRIL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("mithril_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL.get()))
                    .withTabsBefore(MITHRIL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.gemmod.mithril_block"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MITHRIL_BLOCK.get());
                        output.accept(ModBlocks.MITHRIL_ORE.get());

                        output.accept(ModBlocks.MITHRIL_BLOCK_ORE.get());
                        output.accept(ModBlocks.MITHRIL_DEEPSLATE_ORE.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
