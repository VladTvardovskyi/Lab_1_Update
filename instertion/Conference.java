
package ua.lviv.iot.merge.instertion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Conference {

	private String conference_name;
	int number_of_paticipans;
	private int tickets_price;
	private String venue;
	 private static int merge_Comprasion = 0;
	 private static int merge_Exchange = 0;
	 private static int insertion_Comprasion=0;
	 private static int insertion_Exchange=0;

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

	public List<Conference> insertionSort(List<Conference> objectList) {
		long startTime = System.nanoTime();
		for (int current_position = 0; current_position < objectList.size() - 1; current_position++) {
			while (current_position>-1 && objectList.get(number_of_paticipans + 1).getNumber_of_paticipans() > objectList
					.get(number_of_paticipans).getNumber_of_paticipans()) {
					insertion_Comprasion++;
//				if (objectList.get(number_of_paticipans + 1).getNumber_of_paticipans() > objectList
//					.get(number_of_paticipans).getNumber_of_paticipans()) {
					Conference temp = objectList.get(number_of_paticipans + 1);
					insertion_Exchange++;
					objectList.set(number_of_paticipans + 1, objectList.get(number_of_paticipans));
					objectList.set(number_of_paticipans, temp); 

//				}
			}
			number_of_paticipans++;

		}
		System.out.println("Insertion sorted object list");
		objectList.forEach((n) -> System.out.println(n));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds  : " + timeElapsed);
		 System.out.println("comprasion" + insertion_Comprasion);
		 System.out.println("exchange" + insertion_Exchange);
		return objectList;

	}

	public List<Conference> mergeMaximum(List<Conference> objectList) {
		long startTime = System.nanoTime();
		System.out.println("Algoritm: marge sort of tickets price by Increase");

		if (objectList.size() > 1) {
			objectList.get(0).mergeSort(objectList);
		}

		objectList.forEach((n) -> System.out.println(n));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds  : " + timeElapsed);
		 System.out.println("comprasion" + merge_Comprasion);
		 System.out.println("exchange" + merge_Exchange);
		return objectList;
	}

	public List<Conference> mergeSort(List<Conference> objectList) {
		List<Conference> left = new ArrayList<Conference>();
		List<Conference> right = new ArrayList<Conference>();
		List<Conference> target = new ArrayList<Conference>();
		for (int i = 0; i < objectList.size() / 2; i++) {
			left.add(objectList.get(i));
		}

		for (int i = objectList.size() / 2; i < objectList.size(); i++) {
			right.add(objectList.get(i));
		}

		if (left.size() > 1) {

			left.get(0).mergeSort(left);

		}
		if (right.size() > 1) {

			right.get(0).mergeSort(right);

		}
		target.addAll(mergeUnit(objectList, left, right));

		return objectList;
	}
 
	public List<Conference> mergeUnit(List<Conference> objectList, List<Conference> left, List<Conference> right) {
		int leftIndex = 0;
		int rightIndex = 0;
		int targetIndex=0;

		 while (leftIndex < left.size() && rightIndex < right.size()) {
			 merge_Comprasion++;
			if (left.get(leftIndex).getTickets_price() < right.get(rightIndex).getTickets_price()) {
				        objectList.set(targetIndex++, left.get(leftIndex++));
				      } else {
				    	  merge_Exchange++;
				        objectList.set(targetIndex++, right.get(rightIndex++));
				      }
				    }
				    while (leftIndex < left.size()) {
				    	 merge_Exchange++;
				      objectList.set(targetIndex++, left.get(leftIndex++));
				    }
				    while (rightIndex < right.size()) {
				    	 merge_Exchange++;
				      objectList.set(targetIndex++, right.get(rightIndex++));
				    }
		

		return objectList;
	}

	public static void main(String[] args) {

		List<Conference> objectList = new ArrayList<Conference>();
		objectList.add(new Conference("Web-Development Conference", 5600, 9800, "London"));
		objectList.add(new Conference("International Business Conference", 8764, 15000, "Dubai"));
		objectList.add(new Conference("HTFOYT(How to focus on your target?) Conference", 3872, 12500, "Singapore"));
		objectList.add(new Conference("Veres Conference", 2346, 9000, "Madrid"));
		
		System.out.println("Started list");
		objectList.forEach((n) -> System.out.println(n));
		Conference newSortedConference = new Conference();
		newSortedConference.insertionSort(objectList);
		newSortedConference.mergeMaximum(objectList);

	}

}