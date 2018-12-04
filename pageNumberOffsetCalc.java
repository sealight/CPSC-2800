/**
 * 
 * @author Tyler Benjamin
 * 10/24/18
 * CPSC 2800-45180 - Introduction to Operating Systems
 *
 */

import java.util.Scanner;

public class pageNumberOffsetCalc {
	
	//finalizing minimum and maximum for page sizes and virtual addresses
	//had to use double for virtual address due to being out of int's range
	public final static int pageSizeMinimum = 512;
	public final static int pageSizeMaximum = 16384;
	public final static int virtualAddressMinimum = 0;
	public final static double virtualAddressMaximum = 4294967295.0;
	
	//method that checks if the page size is a power of two
	public static boolean powerOfTwoCalc(int pageSize) {
		
		//if the page size is equal to zero, it's not a power of two
		if (pageSize == 0) {
			return false;
		}
		
		//if the page size is equal to 1, it is a power of two.
		//the initial input page size will never be equal to one
		//because the if statement requires that the page size must be
		//within the inclusive range of 512 - 16384.
		while (pageSize != 1) {
			
			//if the page size is not divisible by 2, it's not a power of two
			if (pageSize % 2 != 0) {
				return false;
			}
			//iteration to continue dividing two, provided that the page size is divisible
			//by two
			pageSize = pageSize / 2;
			
			
		}
		//the final, reduced page size is equal to 1, so the initial page size is
		//a power of two
		return true;
	}
		
	//main method
	public static void main(String[] args) {
		
		//obtains input page size and assigns it to a variable
		System.out.println("Please enter the page size.");
		Scanner userInputPageSize = new Scanner(System.in);
		int pageSize = userInputPageSize.nextInt();
		
		//obtains input virtual address and assigns it to a variable
		System.out.println("Please enter the virtual address.");
		Scanner userInputVirtualAddress = new Scanner(System.in);
		int virtualAddress = userInputVirtualAddress.nextInt();
	
		//checks to make sure both the page size and the virtual address are
		//within the inclusive range of accepted values and if the page size
		//is a power of two
		if (pageSize >= pageSizeMinimum && pageSize <= pageSizeMaximum && powerOfTwoCalc(pageSize) == true) {
			if (virtualAddress >= virtualAddressMinimum && virtualAddress <= virtualAddressMaximum) {
				
				//variable to store calculation result necessary for identifying page number
				int pageNumberInitialStep = virtualAddress / pageSize;
				//rounds the page Number down and casts the result into an int
				int pageNumber = (int) Math.floor(pageNumberInitialStep);
				//calculates the offset
				int offset = virtualAddress - (pageSize * pageNumber);
				
				//outputs the page number and offset to console
				System.out.println("This address is in virtual page:");
				System.out.println(pageNumber);
				System.out.println("At offset:");
				System.out.println(offset);
				
			}
		}
	
	}

}
