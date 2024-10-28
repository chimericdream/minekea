package com.chimericdream.minekea.neoforge.client.render.item;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.client.render.item.GlassJarItemRendererLogic;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class GlassJarItemRenderer extends BuiltinModelItemRenderer {
    public GlassJarItemRenderer() {
        super(MinecraftClient.getInstance().getBlockEntityRenderDispatcher(), MinecraftClient.getInstance().getEntityModelLoader());
    }

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState defaultState = ContainerBlocks.GLASS_JAR.get().getDefaultState();
        GlassJarItemRendererLogic.render(stack, matrices, vertexConsumers, light, overlay, MinecraftClient.getInstance().getBlockRenderManager().getModel(defaultState));
    }

    public static class GlassJarItemRendererExtension implements IClientItemExtensions {
        private final GlassJarItemRenderer renderer = new GlassJarItemRenderer();

        @Override
        public @NotNull BuiltinModelItemRenderer getCustomRenderer() {
            return renderer;
        }
    }
}
