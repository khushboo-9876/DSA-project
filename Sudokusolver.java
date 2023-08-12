public class Sudokusolver
{
    public boolean isSafe(int[][] b,int r,int c,int n){
        //loop in row of grid
        for(int i=0;i<b.length;i++){
            //if number that we inserted in the row is already present then return false
            if(b[r][i]==n){
                return false;
            }
        }

        //loop in column of grid
        for(int i=0;i<b.length;i++){
            //if number that we inserted in the column is already present then return false
            if(b[i][c]==n){
                return false;
            }
        }

        //if number that we inserted in the subgrid is already present then return false
        int sqt=(int)Math.sqrt(b.length);
        int boxRow=r-r%sqt;
        int boxCol=c-c%sqt;

        for(int i=boxRow;i<boxRow+sqt;i++){
            for(int j=boxCol;j<boxCol+sqt;j++){
                //if number that we inserted in the subgrid is already present then return false
                if(b[i][j]==n){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solveSudoku(int[][]b,int num){
        int r=-1;
        int c=-1;
        boolean isVacant=true;

        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(b[i][j]==0){
                    r=i;
                    c=j;
                    //false value means there is still some vacant cells
                    isVacant=false;
                    break;
                }
            }
            if(!isVacant){
                break;
            }
        }
        //there is no empty space is left in the grid
        if(isVacant){
            return true;
        }

        //otherwise for each row do the backtracking
        for(int i=1;i<=num;i++){
            if(isSafe(b,r,c,i)){
                b[r][c]=i;
                if(solveSudoku(b,num)){
                    return true;
                }
                else{
                    b[r][c]=0;
                }
            }
        }
        return true;
    }

    //display method
    public void display(int[][] b,int n){
        //we have got the solution just display it
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(b[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
            if((i+1)%(int)Math.sqrt(n)==0){
                System.out.print("");
            }
        }
    }

    //main method
    public static void main(String[] args) {
        //9x9 grid
        int[][] b =new int[][]{{ 7, 0, 0, 0, 0, 0, 2, 0, 0 },   
                                { 4, 0, 2, 0, 0, 0, 0, 0, 3 },   
                                { 0, 0, 0, 2, 0, 1, 0, 0, 0 },   
                                { 3, 0, 0, 1, 8, 0, 0, 9, 7 },   
                                { 0, 0, 9, 0, 7, 0, 6, 0, 0 },   
                                { 6, 5, 0, 0, 3, 2, 0, 0, 1 },   
                                { 0, 0, 0, 4, 0, 9, 0, 0, 0 },   
                                { 5, 0, 0, 0, 0, 0, 1, 0, 6 },   
                                { 0, 0, 6, 0, 0, 0, 0, 0, 8 }   
        };

        //creating object of sudokupuzzle
        Sudokusolver obj=new Sudokusolver();

        //computing size of grid
        int size=b.length;

        System.out.println("the grid is:");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        if(obj.solveSudoku(b,size)){
            //display solution 
            System.out.println("The solution of grid is:");
            obj.display(b,size);
        }
        else{
            System.out.println("There is no solution availbale");
        }
    }
}