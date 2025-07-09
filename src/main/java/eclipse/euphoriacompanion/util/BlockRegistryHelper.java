package eclipse.euphoriacompanion.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class BlockRegistryHelper {
    public static Set<String> getGameBlocks(Map<String, List<String>> blocksByMod) {
        Set<String> gameBlocks = new HashSet<>();
        for (ResourceLocation id : ForgeRegistries.BLOCKS.getKeys()) {
            if (id == null) continue;

            String registryId = id.toString();
            gameBlocks.add(registryId);

            blocksByMod.computeIfAbsent(id.getNamespace(), k -> new ArrayList<>()).add(id.getPath());
        }
        return gameBlocks;
    }
}
