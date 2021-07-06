package dev.tenfov.battletactics.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public class TabCompleteSpawn implements TabCompleter {
    public static final String[] mobs = {"gabe","zombie","advanced_zombie","enhanced_zombie","cryptic_zombie", "josephi","skeleton_master","undead_zombie", "spider", "cave_spider"};
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 || args.length == 0) {
            final List<String> completions = new ArrayList<>();
            List<String> list = Arrays.asList(mobs);
            StringUtil.copyPartialMatches(args[0], list, completions);
            //sort the list
            Collections.sort(completions);
            return completions;
        } else return null;
    }
}
