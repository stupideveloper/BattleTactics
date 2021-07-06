package dev.tenfov.battletactics;

import org.bukkit.Location;
import org.bukkit.World;

import xyz.xenondevs.particle.ParticleEffect;

public class sphere {
    public sphere(Location loc, double radius) {
        double radian = Math.PI / 180;
        double accuracy = 20;
        /**
         * x = x0 + sin (angle1/2) * cos angle2
         * y = y0 + sin (angle1/2) * sin angle2
         * z = z0 + sin (angle1/2)
         */
        for (int xrot = 0; xrot < accuracy; xrot++) {
            for (int zrot = 0; zrot < accuracy; zrot++) {
                Location renderLocation = triangulateLocation(loc, radius, xrot, zrot, accuracy, radian);
                ParticleEffect.FLAME.display(renderLocation);
            }
        }
    }
    // Sphere point calculation
    // 360 / 20 = 18
    // 18 * 1 = 18
    public Location triangulateLocation(Location loc,double radius,double rotationx, double rotationz,double accuracy,double radian) {
        double x;
        double y;
        double z;
        double radians = Math.PI;
        x = loc.getX();
        y = loc.getY();
        z = loc.getZ();
        World world = loc.getWorld();
        double finalx = x + radius * Math.sin(radians * rotationx / accuracy) * Math.cos(2 * radians * rotationz / accuracy);
        double finaly = y + radius * Math.sin(radians * rotationx / accuracy) * Math.sin(2 * radians * rotationz / accuracy);
        double finalz = z + radius * Math.sin(radians * rotationx / accuracy);
        return new Location(world,finalx,finaly,finalz);
    }
}
