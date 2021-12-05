package ฤฺลื;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Solution5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stream<String> input = br.lines();
		input.filter(s -> s.length()>=5)
			.filter(s->s.length()<10)
			.map(s->s.toUpperCase())
			.forEach(System.out::println);
			
	}
}
