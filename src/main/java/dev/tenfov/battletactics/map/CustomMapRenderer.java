package dev.tenfov.battletactics.map;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursor;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class CustomMapRenderer extends MapRenderer {
    public void render(MapView map, MapCanvas canvas, Player player) {
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++) {
                canvas.setPixel(i, j, (byte) 24);
            }
        }
        MapCursorCollection cursors = new MapCursorCollection();
        cursors.addCursor(64, 64, (byte) 12, MapCursor.Type.RED_X.getValue(), true);
        canvas.setCursors(cursors);
    }
}
