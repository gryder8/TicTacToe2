import java.util.Scanner;
public class Game {
	public static Scanner input = new Scanner(System.in);
	public static boolean gameOver = false;
	public static Scanner in = new Scanner(System.in);
	public static int option = 0;
	public static int i;
	public static int x;
	public static int y;
	public static String playerChar =  " ";
	public static String player2Char =  " ";
	public static String AIchar = " ";
	public static String args[] = {};
	public static String board[][];
	public static final int boardSize = 3;
	public static boolean twoPlayer = true;
	public static boolean isFirst;
	
	public static void clearArray(){
		for (i=0;i<board.length;i++){
			board[i][0]=" ";
			board[i][1]=" ";
			board[i][2]=" ";
		}
	}

	public static boolean isGameOverP1(boolean hasWon){//y is column, x is row
		String Player = board[x][y];
		boolean onDiagonal = (x == y) || (y == -1 * x + (board.length-1));
		boolean HorizontalWin = true;
		boolean VerticalWin = true;
		boolean DiagonalWinOne = true;
		boolean DiagonalWinTwo = true;

		for(i= 0; i < boardSize; i++){
			if(!board[x][i].equals(Player)){
				HorizontalWin = false;
			}
			if(!board[i][y].equals(Player)){
				VerticalWin = false;
			}
		}
		if(onDiagonal){
			// Check the diagonals
			for(int n = 0; n < boardSize; n++){
				if(!board[n][n].equals(Player))
					DiagonalWinOne = false;
				if(!board[n][-1*n+(boardSize-1)].equals(Player))
					DiagonalWinTwo = false;
			}
		}
		else{
			DiagonalWinOne = false;
			DiagonalWinTwo = false;
		}
		hasWon = (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo);

		if(hasWon == true){
			System.out.println("***Player 1 Wins!***");
			Game.main(args);
		}

		return hasWon;
	}
	public static boolean isGameOverP2(boolean hasWon){//y is column, x is row
		String Player = board[x][y];
		boolean onDiagonal = (x == y) || (y == -1 * x + (board.length-1));
		boolean HorizontalWin = true;
		boolean VerticalWin = true;
		boolean DiagonalWinOne = true;
		boolean DiagonalWinTwo = true;

		for(i= 0; i < boardSize; i++){
			if(!board[x][i].equals(Player)){
				HorizontalWin = false;
			}
			if(!board[i][y].equals(Player)){
				VerticalWin = false;
			}
		}
		if(onDiagonal){
			// Check the diagonals
			for(int n = 0; n < boardSize; n++){
				if(!board[n][n].equals(Player))
					DiagonalWinOne = false;
				if(!board[n][-1*n+(boardSize-1)].equals(Player))
					DiagonalWinTwo = false;
			}
		}
		else{
			DiagonalWinOne = false;
			DiagonalWinTwo = false;
		}
		hasWon = (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo);

		if(hasWon == true){
			System.out.println("***Player 2 Wins!***");
			//System.exit(0);
			Game.main(args);
		}
		return hasWon;
	}
	public static boolean isGameOverAI(boolean hasWon){//y is column, x is row
		String AI = board[x][y];
		boolean onDiagonal = (x == y) || (y == -1 * x + (boardSize-1));
		boolean HorizontalWin = true, VerticalWin = true;
		boolean DiagonalWinOne = true, DiagonalWinTwo = true;

		for(i= 0; i < boardSize; i++){
			if(!board[x][i].equals(AI)){
				HorizontalWin = false;
			}
			if(!board[i][y].equals(AI)){
				VerticalWin = false;
			}
		}
		if(onDiagonal){
			// Check diagonals
			for(i = 0; i < boardSize; i++){
				if(!board[i][i].equals(AI))
					DiagonalWinOne = false;
				if(!board[i][-1*i+(boardSize-1)].equals(AI))
					DiagonalWinTwo = false;
			}
		}
		else{
			DiagonalWinOne = false;
			DiagonalWinTwo = false;
		}
		hasWon = (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo);

		if(hasWon == true){
			System.out.println("***Computer wins! Better luck next time.***");
			Game.main(args);
		}

		return hasWon;
	}
	public static void boardFilled(){
		int n = 9;
		for (i=0;i<board.length;i++){
			for(int j = 0; j< board.length;j++){
				if(board[i][j]!=" "){
					n--;
				}
				else{
					break;
				}
			}
		}
		if(n == 0){
			if(gameOver==false){
				System.out.println("Game is a draw!");
				//System.exit(0);
				
				Game.main(args);
			}
		}
	}
	public static void updateBoard() {//board formatting and printing
		int  a = 0;
		System.out.println("   0 1 2");
		System.out.println(a+" " + "|" + board[a][0] +"|"+board[a][1]+"|"+board[a][2]+"|"); 
		a++;
		System.out.println("  -------");
		System.out.println(a+" " + "|" + board[a][0]+"|"+board[a][1]+"|"+board[a][2]+"|");
		a++;
		System.out.println("  -------");
		System.out.println(a+" " + "|" + board[a][0]+"|"+board[a][1]+"|"+board[a][2]+"|");
		System.out.println("******************");
	}
	
	public static void player1Move(){ //to enter both positions at once, ask for indice (must have space) and delete line asking for row 
		System.out.println("Player 1, please enter the indice of your move .");
		y = input.nextInt(); //passed to updateBoard function
		x = input.nextInt(); //passed to updateBoard function
		if (x>2|y>2|x<0|y<0){
			System.out.println("Invalid move!");
			updateBoard();
			player1Move();
		}
		else if (board[x][y] == " ") {
			board[x][y] = playerChar;
		}
		else {
			System.out.println("Space taken! Sorry!");
			updateBoard();
			player1Move();
		}
	}
	public static void player2Move(){ //to enter both positions at once, ask for indice (must have space) and delete line asking for row
		System.out.println("Player 2, please enter the indice of your move.") ;
		y = input.nextInt(); //passed to updateBoard function
		x = input.nextInt(); //passed to updateBoard function
		if (x>2|y>2|x<0|y<0){
			System.out.println("Invalid move!");
			updateBoard();
			player2Move();
		}
		else if (board[x][y] == " ") {
			board[x][y] = player2Char;
		}
		else {
			System.out.println("Space taken! Sorry!");
			updateBoard();
			player2Move();
		}
	}
	public static void AIMove()
	{
		// Find the first empty cell and put a tic there.
		for (x = 0; x < boardSize; x++) {
			for (y = 0; y < board[0].length; y++) {
				if (board[x][y].equals(" ")) { // empty cell
					board[x][y] = AIchar;
					return;
				}
			}
		}
	}
	public static void chooseMode(){

		System.out.println("Type 1 and press enter for single player mode.");
		System.out.println("Type 2 and press enter for two player mode");
		option=in.nextInt();
		if(option == 1){
			twoPlayer = false;
		}
		else if(option == 2){
			twoPlayer = true;
			playerChar  = "x";
			player2Char = "o";
		}
		else {
			System.out.println("Invalid option");
			chooseMode();
		}
	}

	public static void chooseChar(){
		System.out.println("Type x or o to choose your token.");
		playerChar = input.nextLine();
		System.out.println(playerChar);
		if (playerChar.equals("o")) {
			isFirst=false;
			AIchar = "x";
		}
		else if (playerChar.equals("x")){
			isFirst = true;
			AIchar = "o";
		}
		else{
			System.out.println("Invalid token! Please try again");
			chooseChar();
		}
	}
	public static void main(String[] args) {
		board = new String[boardSize][boardSize];
		chooseMode();
		clearArray();
		//updateBoard();
		while (gameOver == false && twoPlayer == true){
			updateBoard();
			player1Move();
			updateBoard();
			isGameOverP1(gameOver);
			boardFilled();
			player2Move();
			updateBoard();
			isGameOverP2(gameOver);
			boardFilled();
		}
		if (gameOver == false && twoPlayer == false){
			chooseChar();
			while (gameOver == false && twoPlayer == false){
				if (isFirst == true){
					updateBoard();
					player1Move();
					updateBoard();
					isGameOverP1(gameOver);
					boardFilled();
					AIMove();
					System.out.println("");
					System.out.println("**Computer's Turn**");
					System.out.println("");
					//updateBoard();
					isGameOverAI(gameOver);
					boardFilled();
				}
				else if (isFirst == false){
					AIMove();
					System.out.println("");
					System.out.println("**Computer's Turn**");
					System.out.println("");
					updateBoard();
					isGameOverAI(gameOver);
					boardFilled();
					player1Move();
					updateBoard();
					isGameOverP1(gameOver);
					boardFilled();
				}
			}
		}
	}
}
