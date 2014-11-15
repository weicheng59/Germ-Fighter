
public class GameMap 
{
	private int rows;
	private int cols;
	
	private GameTile[][] board;
	
	public GameMap(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		this.board = new GameTile[rows][cols];
		
		for(int r = 0; r< rows; r++)
		{
			for(int c = 0; c < cols; c++)
			{
				board[r][c] = new GameTile();
			}
		}
	}
	public void setSpawn(int row, int col)
	{
		board[row][col].hasUnit = true;
	}
	public void setMapObject(int row, int col)
	{
		board[row][col].hasMapObject = true;
	}
	public void setItem(int row, int col)
	{
		board[row][col].hasItem = true;
	}
	public boolean hasUnit(int row, int col)
	{
		return board[row][col].hasUnit;
	}
	public boolean hasMapObject(int row, int col)
	{
		return board[row][col].hasMapObject;
	}
	public boolean hasItem(int row, int col)
	{
		return board[row][col].hasItem;
	}
	public int getRows()
	{
		return rows;
	}
	public int getColumns()
	{
		return cols;
	}
}
