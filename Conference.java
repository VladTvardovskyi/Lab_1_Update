
package ua.lviv.iot.merge.instertion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Conference {

	private String conference_name;
	int number_of_paticipans;
	private int tickets_price;
	private String venue;
	 private static int merge_comprasion = 0;
	 private static int merge_exchange = 0;
	 private static int insertion_comprasion=0;
	 private static int insertion_exchange=0;

	public Conference(String conference_name, int number_of_paticipans, int tickets_price, String venue) {
		super();
		this.conference_name = conference_name;
		this.number_of_paticipans = number_of_paticipans;
		this.tickets_price = tickets_price;
		this.venue = venue;
	}

	public Conference() {
		super();
	}

	public String getConference_name() {
		return conference_name;
	}

	public void setConference_name(String conference_name) {
		this.conference_name = conference_name;
	}

	public int getNumber_of_paticipans() {
		return number_of_paticipans;
	}

	public void setNumber_of_paticipans(int number_of_paticipans) {
		this.number_of_paticipans = number_of_paticipans;
	}

	public double getTickets_price() {
		return tickets_price;
	}

	public void setTickets_price(int tickets_price) {
		this.tickets_price = tickets_price;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "Conference [conference_name=" + conference_name + ", number_of_paticipans=" + number_of_paticipans
				+ ", tickets_price=" + tickets_price + ", venue=" + venue + "]";
	}

	public List<Conference> insertion_sort(List<Conference> object_list) {
		long start_time = System.nanoTime();
		for (int current_position = 0; current_position < object_list.size() - 1; current_position++) {
			while (current_position>-1 && object_list.get(number_of_paticipans + 1).getNumber_of_paticipans() > object_list
					.get(number_of_paticipans).getNumber_of_paticipans()) {
					insertion_comprasion++;

					Conference temp = object_list.get(number_of_paticipans + 1);
					insertion_exchange++;
					object_list.set(number_of_paticipans + 1, object_list.get(number_of_paticipans));
					object_list.set(number_of_paticipans, temp); 			
			}
			number_of_paticipans++;

		}
		System.out.println("Insertion sorted object list");
		object_list.forEach((n) -> System.out.println(n));
		long end_time = System.nanoTime();
		long time_elapsed = end_time - start_time;
		System.out.println("Execution time in nanoseconds  : " + time_elapsed);
		 System.out.println("comprasion" + insertion_comprasion);
		 System.out.println("exchange" + insertion_exchange);
		return object_list;

	}

	public List<Conference> merge_maximum(List<Conference> object_list) {
		long start_time = System.nanoTime();
		System.out.println("Algoritm: marge sort of tickets price by Increase");

		if (object_list.size() > 1) {
			object_list.get(0).merge_sort(object_list);
		}

		object_list.forEach((n) -> System.out.println(n));
		long end_time = System.nanoTime();
		long time_elapsed = end_time - start_time;
		System.out.println("Execution time in nanoseconds  : " + time_elapsed);
		 System.out.println("comprasion" + merge_comprasion);
		 System.out.println("exchange" + merge_exchange);
		return object_list;
	}

	public List<Conference> merge_sort(List<Conference> object_list) {
		List<Conference> left = new ArrayList<Conference>();
		List<Conference> right = new ArrayList<Conference>();
		List<Conference> target = new ArrayList<Conference>();
		for (int i = 0; i < object_list.size() / 2; i++) {
			left.add(object_list.get(i));
		}

		for (int i = object_list.size() / 2; i < object_list.size(); i++) {
			right.add(object_list.get(i));
		}

		if (left.size() > 1) {

			left.get(0).merge_sort(left);

		}
		if (right.size() > 1) {

			right.get(0).merge_sort(right);

		}
		target.addAll(merge_unit(object_list, left, right));

		return object_list;
	}
 
	public List<Conference> merge_unit(List<Conference> object_list, List<Conference> left, List<Conference> right) {
		int left_index = 0;
		int right_index = 0;
		int target_index=0;

		 while (left_index < left.size() && right_index < right.size()) {
			 merge_comprasion++;
			if (left.get(left_index).getTickets_price() < right.get(right_index).getTickets_price()) {
				        object_list.set(target_index++, left.get(left_index++));
				      } else {
				    	  merge_exchange++;
				        object_list.set(target_index++, right.get(right_index++));
				      }
				    }
				    while (left_index < left.size()) {
				    	 merge_exchange++;
				      object_list.set(target_index++, left.get(left_index++));
				    }
				    while (right_index < right.size()) {
				    	 merge_exchange++;
				      object_list.set(target_index++, right.get(right_index++));
				    }
		

		return object_list;
	}

	public static void main(String[] args) {

		List<Conference> object_list = new ArrayList<Conference>();
		object_list.add(new Conference("Web-Development Conference", 5600, 9800, "London"));
		object_list.add(new Conference("International Business Conference", 8764, 15000, "Dubai"));
		object_list.add(new Conference("HTFOYT(How to focus on your target?) Conference", 3872, 12500, "Singapore"));
		object_list.add(new Conference("Veres Conference", 2346, 9000, "Madrid"));
		
		System.out.println("Started list");
		object_list.forEach((n) -> System.out.println(n));
		Conference new_sorted_conference = new Conference();
		new_sorted_conference.insertion_sort(object_list);
		new_sorted_conference.merge_maximum(object_list);

	}

}