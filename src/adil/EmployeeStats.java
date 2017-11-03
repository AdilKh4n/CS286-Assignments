package adil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStats {
	public int employees;
	public int employeesWithOutsideFriends;

	public EmployeeStats(int employees, int employeesWithOutsideFriends) 
	{
	this.employees = employees;
	this.employeesWithOutsideFriends = employeesWithOutsideFriends;
	}
	
	@Override
	public boolean equals(Object o) {
	if (!(o instanceof EmployeeStats)) {
	return false;
	}
	EmployeeStats other = (EmployeeStats)o;
	return
	employees == other.employees &&
	employeesWithOutsideFriends == other.employeesWithOutsideFriends;
	}
	
	@Override
	public int hashCode() {
	return employees ^ employeesWithOutsideFriends;
	}
	}

	
	class Helpers {

	static class Pair <T1, T2> {
	private T1 first;
	private T2 second;

	public Pair(T1 first, T2 second) 
	{
    this.first = first;
    this.second = second;}

	public T1 getFirst() { return first; }
	public T2 getSecond() { return second; }
	}
	
	@SafeVarargs
	public static <K, V> Map<K, V> asMap(Pair<K, V>... args) {
	Map<K, V> result = new HashMap<>();
	for (Pair<K, V> entry : args) {
	result.put(entry.getFirst(), entry.getSecond());
	}
	return result;
	}

	public static <T1, T2> Pair<T1, T2> asPair(T1 first, T2 second) {
	return new Pair<>(first, second);
	}

	}
	
	class Solution {

		public static Map<String, EmployeeStats> getEmployeeStats(List<String> employees, List<String> friendships) {
		return new HashMap<>();
		}

		private static final List<Test> tests = Arrays.asList(
		new Test(
		"sample input",
		Arrays.asList(
		"1,Richard,Engineering","2,Erlich,HR","3,Monica,Business","4,Dinesh,Engineering","6,Carla,Engineering",
	"9,Laurie,Directors"),
		Arrays.asList(
		"1,2","1,3","1,6","2,4"),
		Helpers.asMap(
		Helpers.asPair("Engineering", new EmployeeStats(3, 2)),
		Helpers.asPair("HR", new EmployeeStats(1, 1)),
		Helpers.asPair("Business", new EmployeeStats(1, 1)),
		Helpers.asPair("Directors", new EmployeeStats(1, 0))
		)
		)
		);

		private static class Test {

		public String name;
		public List<String> employees;
		public List<String> friendships;
		public Map<String, EmployeeStats> expectedOutput;

		public Test(String name, List<String> employees, List<String> friendships, Map<String, EmployeeStats> expectedOutput) {
		this.name = name;
		this.employees = employees;
		this.friendships = friendships;
		this.expectedOutput = expectedOutput;
		}
		}

		private static boolean equalOutputs(Map<String, EmployeeStats> a, Map<String, EmployeeStats> b) {
		if (a == null || b == null) {
		return false;
		}
		return a.equals(b);
		}

	public static void main(String[] args) {
		int passed = 0;
		for (Test test : tests) {
		try {
		System.out.printf("==> Testing %s...\n", test.name);
		Map<String, EmployeeStats> actualOutput = getEmployeeStats(test.employees, test.friendships);
		if (equalOutputs(actualOutput, test.expectedOutput)) {
		System.out.println("PASS");
		passed++;
		} else 
		{
		System.out.println("FAIL");
		}
		} catch (Exception e) {
		System.out.println("FAIL");
		System.out.println(e);
		}
		}
		System.out.printf("==> Passed %d of %d tests\n", passed, tests.size());
		}
		
	}

