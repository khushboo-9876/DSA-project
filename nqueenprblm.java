public class nqueenprblm{
    static int N=4;

    //row-col+N-1 store negative indices
    static int[] ld=new int[30];

    //row+col used to indicate diagnol right or not
    static int[] rd=new int[30];

    //column array
    static int[] cl=new int[30];

    //utility function to print solution
    static void printsolution(int board[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.printf("%d",board[i][j]);
            }
            System.out.printf("\n");
        }
    }

    //recursive function to solve queen problem
    static boolean solveNQ(int board[][],int col){
        //base case:if all queen are placed return true
        if(col>=N){
            return true;
        }
        //consider the column and try placing queen in row one by onr
        for(int i=0;i<N;i++){
            if((ld[i-col+N-1]!=1 && rd[i+col]!=1) && cl[i]!=1){
                //place queen in board
                board[i][col]=1;
                ld[i-col+N-1]=rd[i+col]=cl[i]=1;
                //place rest of queen
                if(solveNQ(board,col+1))
                return true;
                //if place queen is not a correct solution remove it
                board[i][col]=0;//BACKTRACK
                ld[i-col+N-1]=rd[i+col]=cl[i]=0;
            }
        }
        return false;
    }

    //this function solves the n queen problem with the help of backtracking
    static boolean solve(){
        int board[][]={{0,0,0,0},
                       {0,0,0,0},
                       {0,0,0,0},
                       {0,0,0,0}};
        if(solveNQ(board,0)==false){
            System.out.printf("Solution does not exist");
            return false;
        }
        printsolution(board);
        return true;
    }

    public static void main(String[] args) {
        solve();
    }
}