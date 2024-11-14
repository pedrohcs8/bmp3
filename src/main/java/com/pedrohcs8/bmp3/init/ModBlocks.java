package com.pedrohcs8.bmp3.init;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.blocks.CustomDoorBlock;
import com.pedrohcs8.bmp3.blocks.SacoBloomBlock;
import com.pedrohcs8.bmp3.blocks.SacoBloomVazioBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, Bmp3.MOD_ID);

    public static final RegistryObject<Block> saco_bloom_block = registerBlock("saco_bloom", SacoBloomBlock::new);
    public static final RegistryObject<Block> saco_bloom_vazio_block = registerBlock("saco_bloom_vazio", SacoBloomVazioBlock::new);
    public static final RegistryObject<Block> custom_door_block = registerBlock("custom_door", CustomDoorBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = blocks.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.items.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        blocks.register(eventBus);
    }
}
