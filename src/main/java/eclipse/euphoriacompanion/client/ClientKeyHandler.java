package eclipse.euphoriacompanion.client;

import com.mojang.blaze3d.platform.InputConstants;
import eclipse.euphoriacompanion.EuphoriaCompanion;
import eclipse.euphoriacompanion.shader.ShaderPackProcessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;

//import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;

@Mod.EventBusSubscriber(modid = EuphoriaCompanion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientKeyHandler {
    private static final Lazy<KeyMapping> ANALYZE_KEY =Lazy.of(() -> new KeyMapping("key.euphoriacompanion.analyze", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F6, "category.euphoriacompanion.keys")) ;

    /*
    public static void register() {
        ClientRegistry.registerKeyBinding(analyzeKey);
        MinecraftForge.EVENT_BUS.register(new ClientKeyHandler());
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && analyzeKey.isPressed()) {
            ShaderPackProcessor.processShaderPacks(getClientGameDir());
        }
    }
*/

    @SubscribeEvent
    public void registerBindings(RegisterKeyMappingsEvent event)
    {
        event.register(ANALYZE_KEY.get());
    }

    private Path getClientGameDir() {
        return Minecraft.getInstance().gameDirectory.toPath();
    }
}