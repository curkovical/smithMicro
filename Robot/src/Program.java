import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	private static ArrayList<int[]> permutations = new ArrayList<int[]>();
	
	private static void permute(int[] arr, int index){
	    if(index == arr.length - 1){ 
	    	permutations.add(arr.clone());	        	        
	        return;
	    }

	    for(int i = index; i < arr.length; i++) {
	        int tmp = arr[index];
	        arr[index] = arr[i];
	        arr[i] = tmp;

	        permute(arr, index+1);
	        
	        tmp = arr[index];
	        arr[index] = arr[i];
	        arr[i] = tmp;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try (Scanner sc = new Scanner(new File("robot.in"))){			
			int k = sc.nextInt(), n = sc.nextInt();
			sc.nextLine();			
			int[] arr = new int[k];
			for(int i=0; i<k; i++)
				arr[i] = i;
			permute(arr, 0);
			
			ArrayList<String> allCommands = new ArrayList<String>();
			for(int i=0; i<k; i++) {				
				allCommands.add(sc.nextLine());				
			}			
					
			Robot r;
			int counter = 0;
			for(int[] permutation : permutations) {
				r = new Robot();
				//System.out.println(Arrays.toString(permutation));
				for(int i=0; i<k; i++) { 
					r.executeCommands(allCommands.get(permutation[i]));					
				}
				if(r.getX() == 0 && r.getY() == 0)
					counter++;
				//System.out.println(r.getX() + " " + r.getY());
			}
			//System.out.println(counter);
			try (FileWriter out = new FileWriter(new File("robot.out"))){
				out.write(counter + "");							
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
