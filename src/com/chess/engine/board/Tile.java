package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

//Understand a tile on Chess board
public abstract class Tile {

    private int tileCoordinate;

    //Constructor

    public Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    //Method to verify in the tile is occupied or not
    public abstract boolean isTileOccupied();

    //Method that returns if a piece is on a specific tile
    public abstract Piece getPiece();


    //We define an empty tile sub class if there is no Piece on the tile
    public static final class EmptyTile extends Tile {

        EmptyTile(int tileCoordinate) {
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

        Piece pieceOnTile;

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
