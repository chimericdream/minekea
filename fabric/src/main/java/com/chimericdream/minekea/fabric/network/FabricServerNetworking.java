package com.chimericdream.minekea.fabric.network;

import com.chimericdream.minekea.network.CyclePainterColorPayload;
import com.chimericdream.minekea.network.ServerNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class FabricServerNetworking extends ServerNetworking {
    public static void init() {
        PayloadTypeRegistry.playC2S().register(CyclePainterColorPayload.ID, CyclePainterColorPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(CyclePainterColorPayload.ID, FabricServerNetworking::receiveCyclePainterColorPacket);
    }

    private static void receiveCyclePainterColorPacket(CyclePainterColorPayload payload, ServerPlayNetworking.Context context) {
        MinecraftServer server = context.server();
        ServerPlayerEntity player = context.player();

        handleCyclePainterColorPacket(server, player);
    }
}
