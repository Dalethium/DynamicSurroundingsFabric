package org.orecruncher.dsurround.lib.config;

import net.minecraft.client.gui.screens.Screen;

@FunctionalInterface
public interface IScreenFactory<S extends Screen> {
    S create(Screen parent);
}
