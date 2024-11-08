package com.pedrohcs8.bmp3.init;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.items.CelularItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Actually register the items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bmp3.MOD_ID);

    public static final RegistryObject<CelularItem> celular = ITEMS.register("celular", () -> new CelularItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
