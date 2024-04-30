package xueluoanping.dtfruittrees.client;


import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import snownee.fruits.block.FruitLeavesBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class BlockColorHandler {
    @SubscribeEvent
    public static void handleBlockColor(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BlockState birchLeaves = Blocks.BIRCH_LEAVES.defaultBlockState();
            Block CHERRY_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:cherry_leaves"));
            Block MANDARIN_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:mandarin_leaves"));
            Block LIME_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:lime_leaves"));
            Block CITRON_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:citron_leaves"));
            Block POMELO_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:pomelo_leaves"));
            Block ORANGE_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:orange_leaves"));
            Block LEMON_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:lemon_leaves"));
            Block GRAPEFRUIT_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:grapefruit_leaves"));
            Block REDLOVE_LEAVES = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:redlove_leaves"));

            Block CHERRY = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:cherry"));
            Block MANDARIN = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:mandarin"));
            Block LIME = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:lime"));
            Block CITRON = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:citron"));
            Block POMELO = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:pomelo"));
            Block ORANGE = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:orange"));
            Block LEMON = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:lemon"));
            Block GRAPEFRUIT = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:grapefruit"));
            Block REDLOVE = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("dtfruittrees:redlove"));

            Minecraft.getInstance().getBlockColors().register((state, worlds, poss, i) -> {
                if (i == 0) {
                    return Minecraft.getInstance().getBlockColors().getColor(birchLeaves, worlds, poss, i);
                }
                if (i == 1) {
                    int stage = state.getValue(FruitLeavesBlock.AGE);
                    if (stage < 3) {
                        return Minecraft.getInstance().getBlockColors().getColor(birchLeaves, worlds, poss, i);
                    }
                    Block block = state.getBlock();
                    if (block == CITRON_LEAVES)
                        return 0xDDCC58;
                    if (block == GRAPEFRUIT_LEAVES)
                        return 0xF4502B;
                    if (block == LEMON_LEAVES)
                        return 0xEBCA4B;
                    if (block == LIME_LEAVES)
                        return 0xCADA76;
                    if (block == MANDARIN_LEAVES)
                        return 0xF08A19;
                    if (block == ORANGE_LEAVES)
                        return 0xF08A19;
                    if (block == POMELO_LEAVES)
                        return 0xF7F67E;
                    if (block == REDLOVE_LEAVES)
                        return 0xC22626;
                    if (block == CHERRY_LEAVES)
                        return 0xE45B55;
                }
                return FoliageColor.getEvergreenColor();
            }, CHERRY_LEAVES, MANDARIN_LEAVES, LIME_LEAVES, CITRON_LEAVES, POMELO_LEAVES, ORANGE_LEAVES, LEMON_LEAVES, GRAPEFRUIT_LEAVES, REDLOVE_LEAVES);

            Minecraft.getInstance().getBlockColors().register((state, worlds, poss, i) -> {


                Block block = state.getValue(BlockStateProperties.AGE_3) == 0 ?
                        Blocks.AIR : state.getBlock();

                if (block == CHERRY && i == 0)
                    return 0xE45B55;
                // if (i == 0)
                {
                    if (block == CITRON)
                        return 0xDDCC58;
                    if (block == GRAPEFRUIT)
                        return 0xF4502B;
                    if (block == LEMON)
                        return 0xEBCA4B;
                    if (block == LIME)
                        return 0xCADA76;
                    if (block == MANDARIN)
                        return 0xF08A19;
                    if (block == ORANGE)
                        return 0xF08A19;
                    if (block == POMELO)
                        return 0xF7F67E;
                    if (block == REDLOVE)
                        return 0xC22626;
                }
                // else
                //     return FoliageColors.getBirchColor();

                return -1;
            }, CHERRY, MANDARIN, LIME, CITRON, POMELO, ORANGE, LEMON, GRAPEFRUIT, REDLOVE);

        });


    }

    @SubscribeEvent
    public static void registerJsonColorMultipliers(RegisterColorHandlersEvent.Block event) {
        // Register programmable custom block color providers for LeavesPropertiesJson

        BlockState birchLeaves = Blocks.BIRCH_LEAVES.defaultBlockState();
        BlockColors blockColors = event.getBlockColors();

        // BlockColorMultipliers.register("fruitleaves", (state, world, pos, tineIndex) -> {
        //     if (tineIndex == 0) {
        //         return blockColors.getColor(birchLeaves, world, pos, tineIndex);
        //     }
        //     if (tineIndex == 1) {
        //         int stage = state.getValue(FruitLeavesBlock.AGE);
        //         if (stage < 3) {
        //             return blockColors.getColor(birchLeaves, world, pos, tineIndex);
        //         }
        //         return 0xE45B55;
        //     }
        //     return 0xE45B55;
        // });
        //
        // BlockColorMultipliers.register("cherryleaves", (state, world, pos, tineIndex) -> {
        //     if (tineIndex == 0) {
        //         return blockColors.getColor(birchLeaves, world, pos, tineIndex);
        //     }
        //     if (tineIndex == 1) {
        //         int stage = state.getValue(FruitLeavesBlock.AGE);
        //         if (stage < 3) {
        //             return blockColors.getColor(birchLeaves, world, pos, tineIndex);
        //         }
        //         // if (block == REDLOVE_LEAVES)
        //         //     return 0xC22626;
        //         // if (block == CHERRY_LEAVES)
        //
        //         return 0xE45B55;
        //     }
        //     return -1;
        // });

    }
}
