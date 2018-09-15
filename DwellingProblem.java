package tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class DwellingProblem {
	
	static ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
	static Integer b = null;
	static Integer c = null;
	static Integer f = null;
	static Integer m = null;
	static Integer s = null;
	static int floor = 0;
	
	public static void main(String[] args){
		ArrayList<String> residents = new ArrayList<String>(Arrays.asList("b","c","f","m","s"));
		ArrayList<String> partialSolutions = new ArrayList<String>();
		solve(residents,partialSolutions);
		System.out.println(solutions.size());
		for(ArrayList<String> solution: solutions){
			
			System.out.println(solution.toString());
		}
	}
	
	
	public static void solve(ArrayList<String> people, ArrayList<String> partialSolutions){
		floor += 1;

		//Iterate all possible people on that floor
		for(String p: people){
			
			setFloor(p);//set the floor to the person
			if(check()){// check if the floor assigned to the person is valid
				
				//if the person is valid on that floor//
				
				ArrayList<String>cPartialSolutions = new ArrayList<String>(partialSolutions);//make copy of partial solution
				ArrayList<String> cPeople = new ArrayList<String>(people);//make copy of possible people 
				cPeople.remove(p);//remove the person from the copy of people
			
				cPartialSolutions.add(p);//add the person to the copy of partial solution 
				
				if(cPartialSolutions.size() == 5){
					//if the partial solution has 5 people 
					solutions.add(new ArrayList<String>(cPartialSolutions)); // add it to solution
					floor -= 1; // adjust the value to the previous floor
					return; // go back to the previous floor
				}
				solve(cPeople,cPartialSolutions);//pass the copy of people(deleted the valid person) and the copy of partial solution(added the valid person)  
			}else{
				setNull(p);// if the person is not valid on the current floor, set the person back to null 
			}
		}
		floor -= 1;// adjust to the previous floor
	}
	
	private static void setFloor(String p){
		
		switch(p){
			case "b": b = floor; break;
			case "c": c = floor; break;
			case "f": f = floor; break;
			case "m": m = floor; break;
			case "s": s = floor; break;
		}
	}
	private static void setNull(String p){
		
		switch(p){
			case "b": b = null; break;
			case "c": c = null; break;
			case "f": f = null; break;
			case "m": m = null; break;
			case "s": s = null; break;
		}
	}
	
	private static boolean check(){
		
		if(b != null){
			if(b == 5){
				return false;
			}
		}
		
		if(c != null){
			if(c == 1){
				return false;
			}
		}
		
		if(f != null){
			if(f == 1 || f == 5){
				return false;
			}
		}
		
		if(m != null && c != null){
			if(m < c){
				return false;
			}
		}
		
		if(s != null && f != null){
			if(Math.abs(s-f) == 1){
				return false;
			}
		}
		
		if(f != null && c != null){
			if(Math.abs(f-c) == 1){
				return false;
			}
		}
		
		return true;
		
	}
	
	



}

