package chess;

import java.util.*;

public class ChessBoard {

    public static final int WHITE = 1;
    public static final int BLACK = 0 ;
    int playerColor=WHITE;
    private Square kareler[][];
    public ChessBoard (){
       kareler = new Square[8][8];
        for (int row=0;row<8;row++){
            for (int column=0;column<8;column++){
                kareler[column][row]=new Square();
                kareler[column][row].Row=row;
                kareler[column][row].Column=column;
                kareler[column][row].board=this;
            }
        }
        for(int i=0;i<8;i++){
            kareler[i][1].setPiece(new Pawn(WHITE,kareler[i][1]));
            kareler[i][6].setPiece(new Pawn(BLACK,kareler[i][6]));
        }
        kareler[0][0].setPiece(new Rook(WHITE,kareler[0][0]));
        kareler[0][7].setPiece(new Rook(BLACK,kareler[0][7]));
        kareler[7][0].setPiece(new Rook(WHITE,kareler[7][0]));
        kareler[7][7].setPiece(new Rook(BLACK,kareler[7][7]));
        kareler[4][0].setPiece(new King(WHITE,kareler[4][0]));
        kareler[4][7].setPiece(new King(BLACK,kareler[4][7]));
        kareler[2][0].setPiece(new Bishop(WHITE,kareler[2][0]));
        kareler[2][7].setPiece(new Bishop(BLACK,kareler[2][7]));
        kareler[5][0].setPiece(new Bishop(WHITE,kareler[5][0]));
        kareler[5][7].setPiece(new Bishop(BLACK,kareler[5][7]));
        kareler[3][0].setPiece(new Queen(WHITE,kareler[3][0]));
        kareler[3][7].setPiece(new Queen(BLACK,kareler[3][7]));
        kareler[1][0].setPiece(new Knight(WHITE,kareler[1][0]));
        kareler[1][7].setPiece(new Knight(BLACK,kareler[1][7]));
        kareler[6][0].setPiece(new Knight(WHITE,kareler[6][0]));
        kareler[6][7].setPiece(new Knight(BLACK,kareler[6][7]));


    }

    public boolean isGameEnded() {
        boolean a=false;
        int beyazTasSayisi=0;
        int siyahTasSayisi=0;

        for (int row=0;row<8;row++){
            for(int column=0;column<8;column++){
                if(!kareler[column][row].isEmpty()){
                    if(kareler[column][row].getPiece().getColor()==BLACK){
                        siyahTasSayisi=siyahTasSayisi+1;
                    }
                    if(kareler[column][row].getPiece().getColor()==WHITE){
                        beyazTasSayisi=beyazTasSayisi+1;
                    }
                }
            }
        }
        if(beyazTasSayisi==0||siyahTasSayisi==0){
            a=true;
            System.out.println("The Game is Finished.");
            if(siyahTasSayisi==0){
                System.out.println("The White has won");
            }
            else {
                System.out.println("The Black has won.");
            }
        }

    return a;
    }

    public boolean isWhitePlaying() {
        return playerColor==WHITE;
    }

    public Piece getPieceAt(String from) {
        return getSquareAt(from).getPiece();
    }

    public Square getSquareAt(String to) {
        int toColumn=to.toUpperCase().charAt(0)-'A';
        int toRow=to.toUpperCase().charAt(1)-'1';
        return kareler[toColumn][toRow];
    }

    public Square[] getSquaresBetween(Square location, Square targetLocation) {

        List<Square> list=new ArrayList<>(0) ;
        if(location.Row== targetLocation.Row){
            int col;
            int direction;
            if(location.Column>targetLocation.Column){
                direction=-1;
            }
            else{
                direction=1;
            }
            col=location.Column+direction;
            while (targetLocation.Column!=col){
                list.add(kareler[col][location.Row]);
                col+=direction;
            }
        }
        if(location.Column== targetLocation.Column){
            int row;
            int direction;
            if(location.Row>targetLocation.Row){
                direction=-1;
            }
            else{
                direction=1;
            }
            row=location.Row+direction;
            while (targetLocation.Row!=row){
                list.add(kareler[location.Column][row]);
                row+=direction;
            }
        }
        Square[] dizi1=new Square[list.size()];
        for (int i=0;i<list.size();i++){
            dizi1[i]=list.get(i);
        }
        return dizi1 ;

    }

    public void nextPlayer() {

        playerColor= playerColor==BLACK ? WHITE:BLACK;
    }
    public boolean isDiagonalPathClear(Square location, Square targetLocation ){
        int rowDistance = location.getRowDistance(targetLocation);
        int colDistance = location.getColDistance(targetLocation);
        int rowDirection;
        int colDirection;

        if (rowDistance>0)
            rowDirection=-1;
        else
            rowDirection=1;

        if (colDistance>0)
            colDirection=-1;
        else
            colDirection=1;

        int col= location.Column+colDirection;
        int row= location.Row+rowDirection;

        while (col!= targetLocation.Column){
            if (!kareler[col][row].isEmpty())
                return false;
            col+=colDirection;
            row+=rowDirection;
        }
        return true;
    }

    //public boolean pathOfKnight(Square location,Square targetlocation){}

    public String toString(){
        String ret="    A   B   C   D   E   F   G   H \n";
        ret+="  ---------------------------------\r\n";
        for (int row=7;row>-1;row--){
            ret+=row+1;
            ret+=" | ";
            for (int column=0;column<8;column++){
                if(!kareler[column][row].isEmpty()){
                    ret+=kareler[column][row].getPiece();
                }
                else{
                    ret+=" ";
                }
                ret+=" | ";
            }
            ret+=row+1;
            ret+="\r\n  ---------------------------------\r\n";
        }
        ret+="    A   B   C   D   E   F   G   H \r\n";
        return ret;
    }
}
