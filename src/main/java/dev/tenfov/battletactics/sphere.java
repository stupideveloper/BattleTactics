package dev.tenfov.battletactics;

import org.bukkit.Location;
import org.bukkit.World;

import xyz.xenondevs.particle.ParticleBuilder;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.color.RegularColor;

public class sphere {
    public sphere(Location loc, double radius) {
        double accuracy = 20; 
        accuracy = 2 * Math.PI * radius;
        accuracy = accuracy / 0.125;
        /**
         * x = x0 + sin (angle1/2) * cos angle2
         * y = y0 + sin (angle1/2) * sin angle2
         * z = z0 + sin (angle1/2)
         */
        for (int xrot = 0; xrot < accuracy; xrot++) {
            for (int zrot = 0; zrot < accuracy; zrot++) {
                Location renderLocation = triangulateLocation(loc, radius,radius,radius, xrot, zrot, accuracy);
                new ParticleBuilder(ParticleEffect.REDSTONE,renderLocation)
                    .setParticleData(new RegularColor(33,143,19))
                    .display();
            }
        }
    }
    public sphere(Location loc, double xSize,double ySize,double zSize) {
        double accuracy = 20; 
        accuracy = 2 * Math.PI * (xSize + ySize + zSize)/3;
        accuracy = accuracy / 0.125;
        /**
         * x = x0 + sin (angle1/2) * cos angle2
         * y = y0 + sin (angle1/2) * sin angle2
         * z = z0 + sin (angle1/2)
         */
        for (int xrot = 0; xrot < accuracy; xrot++) {
            for (int zrot = 0; zrot < accuracy; zrot++) {
                Location renderLocation = triangulateLocation(loc, xSize,ySize,zSize, xrot, zrot, accuracy);
                new ParticleBuilder(ParticleEffect.REDSTONE,renderLocation)
                    .setParticleData(new RegularColor(33,143,19))
                    .display();
            }
        }
    }
    // Sphere point calculation
    // 360 / 20 = 18
    // 18 * 1 = 18
    public Location triangulateLocation(Location loc,double xx,double yy, double zz,double rotationx, double rotationz,double accuracy) {
        double radians = Math.PI;
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        World world = loc.getWorld();
        double finalx = x + xx * Math.sin(radians * rotationz / accuracy) * Math.cos(2 * radians * rotationx / accuracy);
        double finaly = y + yy * Math.sin(radians * rotationz / accuracy) * Math.sin(2 * radians * rotationx / accuracy);
        double finalz = z + zz * Math.cos(radians * rotationz / accuracy);
        return new Location(world,finalx,finaly,finalz);
    }
}
