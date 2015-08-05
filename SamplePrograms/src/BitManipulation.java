
public class BitManipulation {

	static byte updateBit (byte num, byte i, byte val)
	{
		byte mask = (byte)~(1 << i);
		System.out.println("~1 << i " + mask);
		byte t1 = (byte)(num & mask);
		System.out.println("num and mask " + t1);
		byte t2 = (byte)(val << i);
		System.out.println("val << i " + t2);
		return (byte)((num & mask) | (val << i));
	}
	
	static int getPrevNumber (int num)
	{
		int cur = num;
		int c0 = 0;
		int c1 = 0;
		
		//Get all trailing ones
		while ((cur & 1) == 1)
		{
			c1++;
			cur >>= 1;
			System.out.printf("%d, ", cur);
		}
		
		if (cur == 0)
		{
			return -1;
		}
		
		//Count block of zeroes
		while (((cur & 1) == 0) && cur != 0)
		{	
			c0++;
			cur >>= 1;
			System.out.printf("%d, ", cur);
		}
		System.out.println("");
		
		System.out.println("");
		int p = c0 + c1;
		
		System.out.printf("c0 = %d, c1 = %d, p = %d\n", c0, c1, p );
		
		int nextNum = num & ((~0) << (p + 1)); // clears from bit p onwards
		System.out.printf("Num after flipping the righmost one = %d\n", nextNum);
		
		int mask = (1 << (c1 + 1)) - 1; // Sequence of (cl+1) ones
		nextNum |= mask << (c0 - 1);
		
		System.out.printf("prevNum method 1 = %d\n", nextNum); 
		
		// Clear everything from pos 0 to p to zero
		int prevNum = num & ((~0) << (p+1));
		System.out.printf("Num after flipping the righmost one = %d\n", prevNum);
		
		// Fill in (c1+1) 1's starting from right
		int mask1 = (1 << (c1+1)) - 1;
		prevNum |= mask1 << (c0 -1);
		
		System.out.printf("prevNum method 2 = %d\n\n", prevNum);
		
		int pNum = num & ~(1 << p);
		System.out.printf("Num after flipping the righmost zero = %d\n", pNum);
		
		int mask2 = ((1<<p) - 1);
		pNum |= mask2; // clear all 1's to right of p
		
		// Fill in (c1-1) 1's starting from right
		int mask3 = (~(0) << (c0-1));
		pNum &= mask3;
		System.out.printf("prevNum method 3 = %d\n\n", pNum);
		return nextNum;
	}
	
	static int getNextNumber (int num)
	{
		int cur = num;
		int c0 = 0;
		int c1 = 0;
		
		//Count number of zeroes
		while (((cur & 1) == 0) && cur != 0)
		{	
			c0++;
			cur >>= 1;
			System.out.printf("%d, ", cur);
		}
		System.out.println("");
		while ((cur & 1) == 1)
		{
			c1++;
			cur >>= 1;
			System.out.printf("%d, ", cur);
		}
		System.out.println("");
		int p = c0 + c1;
		
		System.out.printf("c0 = %d, c1 = %d, p = %d\n", c0, c1, p );
		
		int nextNum = num | (1 << p);
		System.out.printf("Num after flipping the righmost zero = %d\n", nextNum);
		
		int mask = ~((1<<p) - 1);
		nextNum &= mask; // clear all 1's to right of p
		
		// Fill in (c1-1) 1's starting from right
		int mask1 = (1 << (c1-1)) - 1;
		nextNum |= mask1;
		return nextNum;
	}
	
	void drawLine(byte[] screen, int width, int xl, int x2, int y) 
	{
		 int start_offset = xl % 8;
		 int first_full_byte = xl / 8;
		 if (start_offset != 0) 
		 {
			 first_full_byte++;
		 }
		
		 int end_offset = x2 % 8;		
		
		 int last_full_byte = x2 / 8;
		 if (end_offset != 7) 
		 {
			 last_full_byte--;
		 }
		
		 // Set full bytes
		 for (int b = first_full_byte; b <= last_full_byte; b++) 
		 {
			 screen[(width / 8) * y + b] = (byte) 0xFF;
		 }
		
		 // Create masks for start and end of line
		 byte start_mask = (byte) (0xFF >> start_offset);
		 byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
		
		 // Set start and end of line
		 if ((xl / 8) == (x2 / 8))
		 { // xl and x2 are in the same byte
			 byte mask = (byte) (start_mask & end_mask);
			 screen[(width / 8) * y + (xl / 8)] |= mask;
		 } 
		 else 
		 {
			 if (start_offset != 0) 
			 {
				 int byte_number = (width / 8) * y + first_full_byte - 1;
				 screen[byte_number] |= start_mask;
			 }
			 if (end_offset != 7) {
				 int byte_number = (width / 8) * y + last_full_byte + 1;
				 screen[byte_number] |= end_mask;
			 }
		 }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Update bit 3 of number 7 with that of number 6: " + updateBit((byte)7, (byte)3, (byte)6) + "\n");
		System.out.printf("Next number after %d with same numer of 1's is %d\n", 6, getNextNumber(198));
		System.out.printf("Prev number after %d with same numer of 1's is %d\n", 11, getPrevNumber(16));
	}

}
