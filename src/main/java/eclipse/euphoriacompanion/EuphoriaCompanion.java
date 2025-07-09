package eclipse.euphoriacompanion;

import com.mojang.logging.LogUtils;
import eclipse.euphoriacompanion.client.ClientKeyHandler;
import eclipse.euphoriacompanion.shader.ShaderPackProcessor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EuphoriaCompanion.MODID)
public class EuphoriaCompanion {
    public static final String MODID = "euphoriacompanion";
    public static final Logger LOGGER = LogUtils.getLogger();

    /*
    @Mod.EventHandler
    public static void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("Server starting, processing shader packs");
        ShaderPackProcessor.processShaderPacks(event.getServer().getDataDirectory().toPath());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (event.getSide().isClient()) {
            ClientKeyHandler.register();
        }
    }
     */

    public EuphoriaCompanion(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ClientKeyHandler handl = new ClientKeyHandler();
        modEventBus.register(handl.new ModKeybind());
        MinecraftForge.EVENT_BUS.register(handl.new KeybindLogic());
    }


}