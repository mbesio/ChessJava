package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.List;

public abstract class Piece {

    //Every Piece has a position
    protected final int piecePosition;
    //Piece will be either white or black - will use an enum for this
    protected final Alliance pieceAlliance;

    Piece(final int piecePosition, final Alliance pieceAlliance){
        this. piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    //method that is responsible of calculating the legal moves of a piece
    //Will return a list of legal moves
    public abstract List<Move> calculateLegalMoves(final Board board);


}
