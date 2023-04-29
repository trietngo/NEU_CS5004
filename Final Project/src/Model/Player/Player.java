package Model.Player;

import Model.World.HexPos;
import Model.World.HexTile;
import Model.World.HexWorld;
import Model.Player.Interface.PlayerInterface;

/**
 * This class represents a Model.Player.Player. A Model.Player.Player has the following
 * characteristics:
 *      - name: String representation
 *      - pos: Current Position
 *      - fuel: represents movement points
 */
public class Player implements PlayerInterface {
    private String name;
    private HexPos pos;
    private int fuel = 100;

    /**
     * Construct a Model.Player.Player with name and start position
     * @param name Model.Player.Player's name
     */
    public Player(String name) {
        this.name = name;
        this.pos = new HexPos();
    }

    /**
     * Return the current name of the Player
     * @param world current hex world Player is in
     * @return the Name of the player
     */
    @Override
    public String getName(HexWorld world) {
        return this.name;
    }

    /**
     * Set a new name for the Player
     * @param world current hex world Player is in
     * @param name new name for the Player
     */
    @Override
    public void setName(HexWorld world, String name) {
        this.name = name;
    }

    /**
     * Return the current hex coordinates of player
     * @param world the current hex world Model.Player.Player is in
     * @return the Model.HexWorld.HexPos object pointing to the player
     */
    @Override
    public HexPos getPlayerPos(HexWorld world) {
        return this.pos;
    }

    /**
     * Return the tile the player is on
     * @param world the current hex world Model.Player.Player is in
     * @return the current tile the player is on
     */
    @Override
    public HexTile currentTile(HexWorld world) {
        return world.getHex(this.pos.getX(), this.pos.getY());
    }

    /**
     * Check how much fuel Player currently has
     * @param world the current hex world the Player is in
     * @return Player's current fuel count
     */
    @Override
    public int getFuel(HexWorld world) {
        return this.fuel;
    }

    /**
     * Set new fuel count for the Player
     * @param world the current hex world the Player is in
     * @param fuel the new fuel count
     */
    @Override
    public void setFuel(HexWorld world, int fuel) {
        this.fuel = fuel;
    }

    /**
     * Check if the player can move to a certain tile
     * Currently the player cannot move into OCEAN, SEA, MOUNTAIN,
     * and GLACIER tiles or if the player ran out of fuel
     * @param target the destination tile
     * @return true or false
     */
    @Override
    public boolean canMove(HexWorld world, HexTile target) {

        // Check fuel
        if (this.fuel <= 0) {
            System.out.println("Fuel Depleted.");
            return false;
        }

        return !target.getTerrain().name().equals("OCEAN") &&
            !target.getTerrain().name().equals("SEA") &&
            !target.getTerrain().name().equals("MOUNTAIN") &&
            !target.getTerrain().name().equals("GLACIER");
    }

    /**
     * Move the player to the destination.
     * Every move currently decreases fuel by 5.
     * @param world the current hex world
     * @param target the destination tile
     */
    @Override
    public void moveTo(HexWorld world, HexTile target) {

        if (this.canMove(world, target)) {
            world.setPlayer(this, target.getPosX(), target.getPosY());
            this.fuel = this.fuel - 5;
        }
        else {
            throw new ArithmeticException("Can't move to target tile!");
        }
    }
}
