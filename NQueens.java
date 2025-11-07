import java.util.*;

public class NQueens{
static int N;
static void printBoard(int[][] board){
for(int i=0; i < N; i++){
for(int j=0; j < N; j++){
System.out.print(board[i][j] + " ");
}
System.out.println();
}
}

static boolean isSafe(int[][] board , int row , int col){
int i , j;
for(i=0; i < row; i++){
if(board[i][col] == 1) return false;
}
for(i=row , j=col; i >= 0 && j < N; i-- , j++){
if(board[i][j] == 1) return false;
}
for(i=row,j=col; i >= 0 && j >= 0 ;i--,j--){
if(board[i][j] == 1) return false;
}
return true;
}

static boolean solveNqueens(int[][] board , int row){
if(row == N){
 return true;
}
for(int col=0; col < N; col++){
if(isSafe(board,row,col)){
board[row][col] = 1;
if(solveNqueens(board , row + 1)) return true;
board[row][col] = 0;
}
}
return false;
}


public static void main(String[] args){
N = 4;
int[][] board = new int[N][N];
if(solveNqueens(board , 0)){
System.out.println("Final Solution : ");
printBoard(board);
}else{
System.out.println("No solution exist ");
}
}
}
