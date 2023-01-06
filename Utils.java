import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.ChatColor.COLOR_CHAR;

public class Utils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(color(message));
    }

    public static void error(CommandSender sender, String error) {
        sendMessage(sender,"&c&lError! &7" + error);
    }

    public static void info(CommandSender sender, String info) {
        sendMessage(sender, "&b&l[!] &7" + info);
    }

    public static void notPlayer(CommandSender s) {
        error(s, "You need to be a player to execute that command!");
    }

    public static boolean parseInt(CommandSender sender, String parse) {
        try {
            Integer.parseInt(parse);
        } catch (NumberFormatException e) {
            error(sender, parse + " is not an integer!");
            return false;
        }
        return true;
    }

    public static String shuffleString(String x) {
        List<Character> list = new ArrayList<Character>();
        for(char c : x.toCharArray()) {
            list.add(c);
        }
        Collections.shuffle(list);
        StringBuilder builder = new StringBuilder();
        for(char c : list) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static boolean parseLong(CommandSender sender, String parse) {
        try {
            Long.parseLong(parse);
        } catch (NumberFormatException e) {
            error(sender, parse + " is not an integer!");
            return false;
        }
        return true;
    }

    private static ItemStack pane;
    public static ItemStack blankPane() {
        if (pane == null) {
            pane = createItem(Material.GRAY_STAINED_GLASS_PANE,1,"&r",null,null,null,false);
        }
        return pane;
    }

    public static ItemStack createItem(Material material, int amount, String name, List<String> lore, HashMap<Enchantment, Integer> enchants, List<ItemFlag> flags, Boolean unbreakable) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(color(name));
        if (lore != null) {
            List<String> l = new ArrayList<>();
            for (String s:lore) {
                l.add(color(s));
            }
            meta.setLore(l);
        }
        if (enchants != null) {
            for (Enchantment e:enchants.keySet()) {
                meta.addEnchant(e, enchants.get(e), true);
            }
        }
        if (flags != null) {
            for (ItemFlag f : flags) {
                meta.addItemFlags(f);
            }
        }
        meta.setUnbreakable(unbreakable);

        item.setItemMeta(meta);
        return item;
    }

    public static void success(CommandSender sender, String message) {
        sendMessage(sender, "&a&lSuccess! &7" + message);
    }

    public static void noPerms(CommandSender s) {
        error(s, "Insufficient permissions.");
    }

    public static String randomItemFromList(List<String> list) {
        Random rand = new Random(System.currentTimeMillis());
        return list.get(rand.nextInt(list.size()));
    }

    public static int randInt(int min, int max) {
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt((max - min) + 1) + min;
    }

    public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null) {
            return 0;
        }
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }

    public static String hex(String message) {
        final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
    }

    public static void sendTitle(Player p, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        p.sendTitle(color(title), color(subtitle), fadeIn, stay, fadeOut);
    }
}

