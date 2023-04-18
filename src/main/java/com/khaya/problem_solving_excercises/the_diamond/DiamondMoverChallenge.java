package com.khaya.problem_solving_excercises.the_diamond;


public class DiamondMoverChallenge {
        private int sizeOfShape;
        private int xCentre;
        private int yCentre;
        private String[][]board;

        public DiamondMoverChallenge(int sizeOfShape, int xCentre, int yCentre){
                if(xCentre<0||xCentre>78||yCentre<0||yCentre>24){
                        throw new RuntimeException("SpecifiedvalueofxCenteroryCenterisinvalid,shouldbe:xCenter[0,78]andyCenter[0,24]");
        }
        //initializevariables
        this.sizeOfShape=sizeOfShape;
        this.xCentre=xCentre-1;//subtract1becausetheindexesofthearraystartfromzerobutthisisreferringtotheactualindexes(from1)
        this.yCentre=yCentre-1;//subtract1becausetheindexesofthearraystartfromzerobutthisisreferringtotheactualindexes(from1)

        board = new String[25][79];//createandemptyboardwith25rowsand79columns
        }

        /**
         * add"="signstotheboard
         */
        private void addEqualsSignsToTheBoard(){
                for(int row=0;row<25;row++){
                        for(int col=0;col<79;col++){
                                board[row][col]="=";
                        }
                }
        }

        /**
         *addnumberstotheboard
         */
        private void addNumbersToTheBoard(){
                //countuntilwereachthe10throworcol
                int rowCount=-1;
                int colCount=-1;

                //valuetobeassignedatevery10throworcol
                // madethese"int"becauseIwillneedtoincrementthem
                int tenthRowValue=1;
                int tenthColValue=1;

                for(int row=0;row<25;row++){
                        rowCount++;
                        tenthColValue=1;
                        colCount=-1;
                        //startcolCountafreshwhenstartinganewrow
                        for(int col=0;col<79;col++){
                                colCount++;
                                if(rowCount==9){
                                        board[row][0]=String.valueOf(tenthRowValue);
                                        rowCount=-1;//startrowCountafresh
                                        tenthRowValue++;
                                }
                                if(colCount==9){
                                        board[row][col]=String.valueOf(tenthColValue);
                                        tenthColValue++;
                                        colCount=-1;//startcolCountafresh
                                        }
                        }
                }
        }

        /**
         *
         * @paramrow
         * @paramcol
         * @returntrueifthepositionwherethe$sign(ofthediamond)willbeplacedisvalid
         */
        private boolean isValidPosition(int row,int col){
                return(row>=0&&row<25)&&(col>=0&&col<79);
        }

        /**
         * Nowwewilladdthediamondtotheboard,thingstoconsider
         * -centercoordinates,validmoves
         */
        private void addDiamondToTheBoard(){
                int move=sizeOfShape-1;//numberofmovestothediamondcorners
                // centerofdiamond
                board[yCentre][xCentre]="$";

                //Movefromthetopofthediamondtotheright(whileadding'$'),untilwereachthecenterrow
                int moveRightFromTop=xCentre;
                for(int i=yCentre-move;i<=yCentre;i++){
                        if(isValidPosition(i,moveRightFromTop)){
                                board[i][moveRightFromTop]="$";
                        }
                        moveRightFromTop++;
                }

                //Movefromthetopofthediamondtotheleft(whileadding'$'),untilwereachthecenterrow
                int moveLeftFromTop=xCentre;
                for(int i=yCentre-move;i<=yCentre;i++){
                        if(isValidPosition(i,moveLeftFromTop)){
                                board[i][moveLeftFromTop]="$";
                        }
                        moveLeftFromTop--;
                }

                //Movefromthebottomofthediamondtotheleft(whileadding'$'),untilwereachthecenterrow
                int moveLeftFromBottom=xCentre;
                for(int i=yCentre+move;i>=yCentre;i--){
                        if(isValidPosition(i,moveLeftFromBottom)){
                                board[i][moveLeftFromBottom]="$";
                        }
                        moveLeftFromBottom--;
                }

                //Movefromthebottomofthediamondtotheright(whileadding'$'),untilwereachthecenterrow
                int moveRightFromBottom=xCentre;
                for(int i=yCentre+move;i>=yCentre;i--){
                        if(isValidPosition(i,moveRightFromBottom)){
                                board[i][moveRightFromBottom]="$";
                        }
                        moveRightFromBottom++;
                }
        }

        /**
         * createstheboard
        */
        private void createBoard(){
                addEqualsSignsToTheBoard();
                addNumbersToTheBoard();
                addDiamondToTheBoard();
        }

        /**
         * Printstheboard
         */
        public void printBoard(){
                createBoard();
                for(int row=0;row<25;row++){
                        for(int col=0;col<79;col++){
                                System.out.print(board[row][col]);
                        }
                        System.out.println();
                }
        }

        public static void main(String[]args){
        DiamondMoverChallenge problemALG005 = new DiamondMoverChallenge(6,30,9);
        problemALG005.printBoard();
        }
}

