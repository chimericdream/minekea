package com.chimericdream.minekea.client;

import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class Keybindings {
    public static final KeyBinding CYCLE_PAINTER_COLOR = new KeyBinding(
        "key.minekea.items.painter.cycle_color",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_EQUAL,
        "category.minekea"
    );

    static {
        KeyMappingRegistry.register(CYCLE_PAINTER_COLOR);
    }

    public static void init() {
    }
}
