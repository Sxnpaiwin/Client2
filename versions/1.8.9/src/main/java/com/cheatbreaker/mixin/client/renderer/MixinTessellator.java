package com.cheatbreaker.mixin.client.renderer;

import com.cheatbreaker.bridge.client.renderer.TessellatorBridge;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Tessellator.class)
public abstract class MixinTessellator implements TessellatorBridge {
    @Shadow private WorldRenderer worldRenderer;

    public void bridge$startDrawingQuads() {
        this.worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
    }

    public void bridge$addVertexWithUV(double x, double y, double z, double u, double v) {
        this.worldRenderer.tex(u, v);
        this.bridge$addVertex(x, y, z);
    }

    public void bridge$finish() {
        this.worldRenderer.finishDrawing();
    }

    public void bridge$addVertex(double x, double y, double z) {
        this.worldRenderer.addVertexData(new int[]{ (int)x, (int)y, (int)z });
    }

    public void bridge$startDrawing(int mode) {
        this.worldRenderer.begin(mode, DefaultVertexFormats.POSITION_TEX);
    }

    public void bridge$setColorOpaque_I(int color) {
        int red = color >> 16 & 255;
        int green = color >> 8 & 255;
        int blue = color & 255;
        this.worldRenderer.color(red, green, blue, 255);
    }

    public void bridge$setColorRGBA_F(float r, float g, float b, float a) {
        this.worldRenderer.color((int)(r * 255.0F), (int)(g * 255.0F), (int)(b * 255.0F), (int)(a * 255.0F));
    }

    public void bridge$setTranslation(double x, double y, double z) {
        this.worldRenderer.setTranslation(x, y, z);
    }

    public void bridge$setColorRGBA_I(int color, int alpha) {
        int red = color >> 16 & 255;
        int green = color >> 8 & 255;
        int blue = color & 255;
        this.worldRenderer.color(red, green, blue, alpha);
    }
}