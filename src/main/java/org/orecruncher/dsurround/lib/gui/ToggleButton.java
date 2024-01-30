package org.orecruncher.dsurround.lib.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class ToggleButton extends Button {

    private final ResourceLocation onSprite;
    private final ResourceLocation offSprite;

    private boolean isOn;

    protected ToggleButton(boolean initialState, ResourceLocation onSprite, ResourceLocation offSprite, OnPress onPress) {
        super(0, 0, 20, 20, Component.empty(), onPress, DEFAULT_NARRATION);

        this.isOn = initialState;
        this.onSprite = onSprite;
        this.offSprite = offSprite;
    }

    public void setOn(boolean flag) {
        this.isOn = flag;
    }

    public boolean toggle() {
        return this.isOn = !this.isOn;
    }

    // Basically what ImageButton does but simplified.
    @Override
    public void renderWidget(GuiGraphics guiGraphics, int i, int j, float f) {
        ResourceLocation resourceLocation = this.getSpriteToRender();

        RenderSystem.enableDepthTest();
        guiGraphics.blit(resourceLocation, this.getX(), this.getY(), 0, 0, this.width, this.height, 20, 20);
    }

    private ResourceLocation getSpriteToRender() {
        return this.isOn ? this.onSprite : this.offSprite;
    }
}
