<br/>
<p align="center">
  <h3 align="center">Minecraft Development Tools</h3>

  <p align="center">
    Some basic tools for Minecraft Development
    <br/>
    <br/>
  </p>
</p>

![Issues](https://img.shields.io/github/issues/dkf-lab/MongoCoins) 

## About

A little toolkit for Paper development. Copy and paste the files into your Java project to use. 

### Data.java
For custom config management. Change the `filename` to desired filename.

Ensure to run `saveDefaultConfig()` in your `onEnable` in your main class, creating an instance of the class. Use the `getConfig()` method, and then consult the Paper API.

### Utils.java
#### `color`
Contains the translation for color codes, i.e. when wanting to convert strings containing `&` into `§`. For instance, `&aGreen` becomes `§aGreen`. This method is used by the others in the file to translate color codes.
#### `sendMessage`
Send a message to a CommandSender with color formatting automatically applied.
#### `error`
Basic error handling message. Add your logging here.
#### `info`
Send info to player with a prefix automatically applied.
#### `notPlayer`
Default message to send to a CommandSender if they are not a player.
#### `parseInt`
Parse for an integer in a string. Useful when taking ints as an argument in a command. Handles error using `error` method.
#### `parseLong`
Same as `parseInt`, but for the `long` type.
#### `blankPane`
Blank stained glass, useful when creating in-game GUIs (inventories).
#### `createItem`
Easy item creation within a single method, containing all useful attributes.
#### `success`
Generic success message.
#### `noPerms`
Generic no permissions message.
#### `randomItemFromList`
Gets a random `ItemStack` from provided list.
#### `randInt`
Gets a random integer.
#### `getAmount`
Get amount of an ItemStack within a player's inventory. Uses `isSimilar` Paper method.
#### `hex`
Similar to `color`, but used for hex code parsing, prefixed with `&`.
#### `sendTitle`
Sends a title to a player, but parses for color codes.
