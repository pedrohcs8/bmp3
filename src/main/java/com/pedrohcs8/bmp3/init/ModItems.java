package com.pedrohcs8.bmp3.init;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.items.AdditedBloomItem;
import com.pedrohcs8.bmp3.items.CelularItem;
import com.pedrohcs8.bmp3.items.PureBloomItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Actually register the items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bmp3.MOD_ID);

    public static final RegistryObject<CelularItem> celular = ITEMS.register("celular", () -> new CelularItem(new Item.Properties()));

    public static final RegistryObject<AdditedBloomItem> addited_bloom = ITEMS.register("addited_bloom", () -> new AdditedBloomItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<PureBloomItem> pure_bloom = ITEMS.register("pure_bloom", () -> new PureBloomItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
