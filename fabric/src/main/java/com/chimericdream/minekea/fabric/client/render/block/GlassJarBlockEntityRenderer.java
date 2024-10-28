package com.chimericdream.minekea.fabric.client.render.block;

import com.chimericdream.minekea.client.render.block.GlassJarBlockEntityRendererLogic;
import com.chimericdream.minekea.entity.block.containers.GlassJarBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;

@Environment(EnvType.CLIENT)
public class GlassJarBlockEntityRenderer extends GlassJarBlockEntityRendererLogic implements BlockEntityRenderer<GlassJarBlockEntity> {
    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        super(ctx);
    }

    protected int getFluidColor(Fluid fluid) {
        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);

        return renderHandler.getFluidColor(null, null, fluid.getDefaultState());
    }

    protected Sprite getFluidTexture(Fluid fluid) {
        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        Sprite[] sprites = renderHandler.getFluidSprites(null, null, fluid.getDefaultState());

        return sprites[0];
    }
}
