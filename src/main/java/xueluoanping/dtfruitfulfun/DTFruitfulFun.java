package xueluoanping.dtfruitfulfun;

import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;

import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import snownee.fruits.FFCommonConfig;
import xueluoanping.dtfruitfulfun.data.start;


import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DTFruitfulFun.MOD_ID)
public class DTFruitfulFun {
    public static final String MOD_ID = "dtfruitfulfun";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final boolean useLogger=Objects.equals(System.getProperty("forgegradle.runs.dev"), "true");

    public DTFruitfulFun() {

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // MinecraftForge.EVENT_BUS.register(TreeGrowHandler.instance);
        RegistryHandler.setup(MOD_ID);

    }


    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        //        LOGGER.info("HELLO FROM PREINIT");
        //        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        //        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        //        LOGGER.info("Got IMC {}", event.getIMCStream().
        //                map(m->m.getMessageSupplier().get()).
        //                collect(Collectors.toList()));
        FFCommonConfig.villageAppleTreeWorldGen=false;
        FFCommonConfig.appleSaplingFromHeroOfTheVillage=false;
    }



    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    // @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    // public static class RegistryEvents {
    //     @SubscribeEvent
    //     public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    //         // register a new block here
    //         //            LOGGER.info("HELLO from Register Block");
    //     }
    // }

    public void gatherData(final GatherDataEvent event) {
        // Resources.MANAGER.gatherData();

        // GatherDataHelper.gatherAllData(
        //         MOD_ID,
        //         event,
        //         SoilProperties.REGISTRY,
        //         Family.REGISTRY,
        //         Species.REGISTRY,
        //         LeavesProperties.REGISTRY
        // );

        start.dataGen(event);
    }

    public static void logger(Object... x) {

        // if (General.bool.get())
        if (useLogger) {
            StringBuilder output = new StringBuilder();
            for (Object i : x) {
                output.append("，【").append(i).append("】");
            }
            LOGGER.info(output.substring(1));
        }

    }

    public static ResourceLocation rl(String name) {
        return new ResourceLocation(DTFruitfulFun.MOD_ID, name);
    }
}
