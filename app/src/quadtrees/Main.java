package quadtrees;

import java.io.Reader;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) {

		// What am I? I am 128x128 pixels.
//		Reader r = new StringReader("11011011101011011010100011010000010101101110100000100100000100101000001100100010100100010101100000101100100010000100000100001100010000101011000101000010010001010000001000010001000110000010110110110100000110100000101110101000010100000000001010110100000001111101000000000000110000010001100010000001100000101000001110000010110000010101011110101000100100000100001000001100010101011001000101010100110001010001101011010100001010100001000110101000000101101000001101000010101000010101101010000101010000101101101010010101000110000100010100000110110010001010010001010000100100010100100010000001010110101000010101000010101101011010100001010100001010110101000101111101101000000000110000100000101100000100100101010000000011010100010000101000001110000100000101100000101100001000001011000001011101010000101010000000011010100001010100000000011110100000100001010000010101110100000100001010000011110000100000101100000101100001000001011000001011001010101000000110101000010101000000001100001000001011000001011000010000010110000010111010100010000001010110100000010001010011100010100001010001010110001100010100001001000101000110000010010010100000000001101011010001010111010100010000001000010000010101011110101101010000101010000101010010100000010010000000100101010000100000101110101100010100000101100100010100100010000001110000010100001010000011100010000101010000001000101011101010000000000001110101000000000010000011000001011101010000101010000000011000100001010100000000111101000101000001110001010001011000101001001000100000000101000001101101011010100010110000100010101100000101110100000000100000101001011010100101010000001100010000000000110110100000110100000101100011010101000010010001000000100000001011010111010110101011000100000101111010100000100100000001010111010100010101001101101000101101010100011100000101001010001010111000000011000100001010000001010100011011000001010101011111100100010100100010100100000001011101000000000010000000111010000010010000010110100010110101011101010100010110001010011100010100010110001010001101010110001000011000100001010100000000110101001010000011010000001000010000010110100010011010000010000000111101011010101000001101010110101010010000001010001010110101101010110101010010101101010000101010000110100000111000101000101100010100110001010001101010000100010000101000010101000011100001000001010110010101000000100000001110100010100000101110110000000100101000000100100010000000011000001011000001010101100100000101010011000101000110101101010000101010000100011010100000010110100000110100001010100001010110101000010101000001101010111010110101101010000101010001011010101110100010110101010000101010100111000000011000001001000100000110101011010100001100010101011010101001010100001101000000100000101010110111000001001000001010110001010011000100001010000011000001001010001010111110000100000101100000101100001000001011000001011010110100000101100101010100000011000010000010110000010110000100000101100000101110101000010101000000001101000001000000110010101010000000101100100000100011000001011110100000100001010000011011010000011010001010111000100000010000010000110100000100100000001011110000100000101100000101100001000001011000001011101010000101010000000011010100001010100000000110000100000001100000101100010100100100010100100010100001101010000000000101100100010100100010100001001000101001000101000001011110101011010100000110010001000000100000101100001000001011010001011101101010001101000001011001000101001000101010010001010011010000000000001101000010101000111000101000101100010100110101010001010111010000000000001101011010100000001100101000000000000110111000101010100101000001110100000100001010000000111010110001000000101011010100001010100001000001011100000100001010100000011000010000010101100101010000000011010100001010000000000110101000010101000000001110101000010100000010100000100100100000101100010100000010010101000000001111110000010110000010101011001000001001000101000010010001010010001010000011110000010110000010101011100000101100000101010101011110101000010101000000001101010000101010000000001011011000000100000001010111110000010110000010101011100000101100000101101000001011011010000000010101000101110010001000010001010000010110010001010101001110001010001010101010111101010000101010000000011010000000000001001000101001000101010010101101000001011110100001010000011100000100010110001010101100100000100100000100000101110010001010101100000100010111000101010101011101010001101011000010000000110000010110000100000101100000101101101000010100000111010000000010001010000101011010100010110110010001010010001010000100100010100100010100000111101101101010001000110110100000101010111101010100101010100101000001011011000000011010000010111010100001010000001000101010011010101001010000010010000000111101010100010100011101010000101010000100000101100000101110001000010101000010000010100011110101011010101000101110001010101010101011010101110101000001011000000011101010111010101000101100010100010111100010101010101010101110101101011010001010101110001011000101010111010100001010101000010000010110010101000010000010110000010111101010000010101101011010101000110110000010010001010110100000010101101010000101010000101101101000001100010100011101000001100010100001010001010111110101101000101011011000001011010101001000100001011000001010101101010110101010011000001011100000100010101011100010000101010100100010101101000101111000100000101100010100010101111000100000110001000010100010110101101010001011001000101000110000010110110000010101010101111101010001100010101011010001000101010101011110110010001010010001010000100100010000000001110110100000000101010001100010110001010001100100000100100010101001110000010001011000101010101011010010010001010001100000100101101000001001010100011011010110101101010001010111010110101000101101100000001011010100001011010100011000001001010100011011000001001000101001010000011010110101101010000010111101101010001100010100011101000100100010101101010001011100010000100000101011000100001011000000011010001010111101000001100010000100000001011100000100011010100001010100001100000101100010101010110110100010101010111100010101010101110000000110101010010001010110000000101011110000100010101100000100011010110000010010101000010101011010100001010110101101010001011101010000011000101011000001011101101010000100010101100000101101100000001010111000101000101011101010100101010001100000101100000101111010000010101101000001110100000001001000000011101000001100010000100000101011001000101001000101001000000011110101101101010001101100010100000101011111010100000010000010010000000110010000010110101010010001000010110100010101011010110100000001110101011010101000101110001010101010101110101000010101101000000001010010000010001011111000100001010100001000001011000001011101000000100010101011000101011001000101001000000011000001001101010001101000000100000101001010101101010110101010011100010000010110000010001011010110001010100111000001000101100010100110001010001011010100011010110100000010101000111000000011010101000101101101101101000101010101011011011010000010101010101111011000000101000001110100010100100000001010111100000100100000101011000101001100000101100000101010101100011010101000011001000100000000110101000010101000000001010101100010100110100000100001010001011011011010000010101010111110000010110000010101011100000101100000101010101011110000000100001010000011100000101100000101010101110100000100001010000011100001000001000001010111101010000101010000000011010100001010100000000010111010110000100000101100000101100001000001011000001001010101001110100000100001010000010101110100000100001010000011100011000101000001101010110101010010010001000000101000001101110110000000110100010101100011000101000011000000010000100000001011011101000101001000000010101010111010110101011010101101010100111010100011010101000110000010001110001000001100000001011011010100001000001001010000001110100101000101011100010000011010101000011000000010000101000101011110100000100001010000010101110100000000000010001110101000001101010100001101000001001000000010110110110000000110100010101010111010111010100011010101000001100101010100100010101001011000010000000110100010110101011010101001010110100000110001010111011010000011010000010110001100010000101000101101100000001010110110100010000011100010100110101000110000010010001010010100000111010000011000101011000101011010001011100000001010101111100000100010110001010010110100000100101010001100100010101101010001011100000001101000000010111100010100011010000011000101011010101100010100110001010010101000100100010000110101000110000010001100000100110110100000110100010101100100010101011000101011011010001010101011011011000000010101010110111101001010001010110010000010101010101110101101010100101010000011101010001101010100100010100001010110100000001111010000001000101010110001010011010000010110101000100100100000100011000001001010110101000101101101101010000101000101010101101101101101000001101000001010101010101");

		String input = "10011010001010010001010101100011000101000000";
		Reader reader = new StringReader(input);
		QTree qt = new QTree(reader);
		Bitmap bitmap = new Bitmap(8, 8);
		qt.fillBitmap(bitmap);
		System.out.println(bitmap);
	}
}
