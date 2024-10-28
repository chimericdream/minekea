package com.chimericdream.minekea.neoforge.client.render.block;

import com.chimericdream.minekea.client.render.block.GlassJarBlockEntityRendererLogic;
import com.chimericdream.minekea.entity.block.containers.GlassJarBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.textures.FluidSpriteCache;
import net.neoforged.neoforge.fluids.FluidStack;

public class GlassJarBlockEntityRenderer extends GlassJarBlockEntityRendererLogic implements BlockEntityRenderer<GlassJarBlockEntity> {
    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        super(ctx);
    }

    protected int getFluidColor(Fluid fluid) {
        IClientFluidTypeExtensions renderProperties = IClientFluidTypeExtensions.of(fluid);
        return renderProperties.getTintColor(new FluidStack(fluid, 1000));
    }

    protected Sprite getFluidTexture(Fluid fluid) {
        IClientFluidTypeExtensions renderProperties = IClientFluidTypeExtensions.of(fluid);
        Identifier sprite = renderProperties.getStillTexture();
        return FluidSpriteCache.getSprite(sprite);
    }
}
