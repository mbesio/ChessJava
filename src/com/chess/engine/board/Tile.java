package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

//Understand a tile on Chess board
public abstract class Tile {

    protected final int tileCoordinate;

    //This is a private static method
    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for(int i=0; i<64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        //A map is a container, an immutable map cannot change it once it has been created. This is from Google's Guava library
        return ImmutableMap.copyOf(emptyTileMap);
    }

    //Factory method - only method that anyone can use to create tiles
    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
    }


    //Constructor

    private Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    //Method to verify in the tile is occupied or not
    public abstract boolean isTileOccupied();

    //Method that returns if a piece is on a specific tile
    public abstract Piece getPiece();


    //We define an empty tile sub class if there is no Piece on the tile
    public static final class EmptyTile extends Tile {

        EmptyTile(final int tileCoordinate) {
            super(tileCoordinate);
        }

        //Method that tells us that an empty tile is not occupied
        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        OccupiedTile(int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        //Method that tells us that an occupied tile is occupied
        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }

    }





}
