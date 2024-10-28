package com.chimericdream.minekea.fabric.client.render.item;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.client.render.item.GlassJarItemRendererLogic;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class GlassJarItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState defaultState = ContainerBlocks.GLASS_JAR.get().getDefaultState();

        JarModel model = new JarModel();
        model.setModel(MinecraftClient.getInstance().getBlockRenderManager().getModel(defaultState));

        GlassJarItemRendererLogic.render(stack, matrices, vertexConsumers, light, overlay, model);
    }

    private static class JarModel extends ForwardingBakedModel {
        public void setModel(BakedModel model) {
            this.wrapped = model;
        }
    }
}
