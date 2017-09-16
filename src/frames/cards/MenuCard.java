package frames.cards;

/*
 * SWEN 222 Group Project
 * Liam Byrne (byrneliam2)
 * 300338518
 */

import gfx.ImageLoader;

import javax.swing.*;

public class MenuCard extends Card {

    public MenuCard() {
        setBackground(ImageLoader.image("menu.jpg"));
        this.add(new JLabel(new ImageIcon(background)));
    }

    @Override
    public void redraw() {
        //
    }
}
