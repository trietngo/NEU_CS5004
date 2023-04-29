package Model.Player.Interface;

import Model.World.HexPos;
import Model.World.HexTile;
import Model.World.HexWorld;

/**
 * This interface contains all operations that all Model.Player.Player classes
 * should support.
 */

public interface PlayerInterface {

    /**
     * Return the current name of the Player
     * @param world current hex world Player is in
     * @return the Name of the player
     */
    String getName(HexWorld world);

    /**
     * Set a new name for the Player
     * @param world current hex world Player is in
     * @param name new name for the Player
     */
    void setName(HexWorld world, String name);

    /**
     * Return the current hex coordinates of player
     * @param world the current hex world Model.Player.Player is in
     * @return the Model.HexWorld.HexPos object pointing to the player
     */
    HexPos getPlayerPos(HexWorld world);

    /**
     * Return the current tile the player is on
     * @param world the current hex world Model.Player.Player is in
     * @return the Model.HexWorld.HexTile the player is on
     */
    HexTile currentTile(HexWorld world);

    /**
     * Check how much fuel Player currently has
     * @param world the current hex world the Player is in
     * @return Player's current fuel count
     */
    int getFuel(HexWorld world);

    /**
     * Set new fuel count for the Player
     * @param world the current hex world the Player is in
     * @param fuel the new fuel count
     */
    void setFuel(HexWorld world, int fuel);

    /**
     * Check whether Model.Player.Player can move to a certain tile
     * @param world the current world the Model.Player.Player is in
     * @param target the target tile the Model.Player.Player can move to
     * @return true or false
     */
    boolean canMove(HexWorld world, HexTile target);

    /**
     * Move the Model.Player.Player to the new position
     * @param world the current hex world the Model.Player.Player is in
     * @param target the target tile
     */
    void moveTo(HexWorld world, HexTile target);
}
