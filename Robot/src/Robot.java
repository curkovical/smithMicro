
public class Robot {
	
	enum Direction { 
		NORTH, EAST, SOUTH, WEST;
		static final Direction[] VALUES = values();
		public Direction rotate(int increment) {
			return VALUES[Math.floorMod(this.ordinal() + increment, VALUES.length)];
		}
	}
	
	private Direction currentDirection;
	private int x;
	private int y;
	
	public Robot() {
		this.currentDirection = Direction.NORTH;
		this.x = 0;
		this.y = 0;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void executeCommands(String commands) {
		char[] commandsArr = commands.toCharArray();
		for(int i=0; i<commandsArr.length; i++)
			this.execute(commandsArr[i]);
	}
	
	private void execute(char cmd) {
		switch(cmd) {
		case 'L':
		case 'D':
			this.changeDirection(cmd);
			break;
		case 'P':
			this.move();
			break;
		}
	}
	
	private void changeDirection(char rotation) {
		int increment = 0;
		if(rotation == 'L')
			increment = -1;
		else if(rotation == 'D')
			increment = 1;
		this.currentDirection = currentDirection.rotate(increment);
	}
	
	private void move() {		
		switch(this.currentDirection) {
		case NORTH:
			this.y++;
			break;
		case EAST:
			this.x++;
			break;
		case SOUTH:
			this.y--;
			break;
		case WEST:
			this.x--;
			break;			
		}
	}
	
}
