package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_������ {
	public static void main(String[] args) {
		Solution_������ s = new Solution_������();
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		//{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
		//{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
		s.solution(tickets);
	}// end of main

	/** Ƽ�� Ŭ���� (�����, ������)*/
	static class Ticket implements Comparable<Ticket>{
		String from, to;

		public Ticket(String from, String to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Ticket o) {
			return this.to.compareTo(o.to);
		}
		@Override
		public String toString() {
			return "from " + from + " to " + to;
		}
	}

	private static ArrayList<Ticket> ticketList;
	private static int size;
	public String[] solution(String[][] tickets) {
		String[] answer = {};
		
		ticketList = new ArrayList<Ticket>();
		
		for (int i = 0; i < tickets.length; i++) {
			ticketList.add(new Ticket(tickets[i][0], tickets[i][1]));
		}
		/*
		Collections.sort(ticketList);
		
		for(Ticket t : ticketList) {
			System.out.println(t.toString());
		}
		*/
		
		size = ticketList.size();
		boolean[] visited = new boolean[size]; 
		
		return answer;
	}
	
	private static void dfs(int idx, boolean[] visited) {
		visited[idx] = true;
		
	}

}
