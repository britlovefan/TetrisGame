package tetris;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
	// You can create data to be used in the your
	// test cases like this. For each run of a test method,
	// a new PieceTest object is created and setUp() is called
	// automatically by JUnit.
	// For example, the code below sets up some
	// pyramid and s pieces in instance variables
	// that can be used in tests.
	private Piece pyr1, pyr2, pyr3, pyr4,pyr5,Square;
	private Piece s, sRotated,SquareRotated,S1_ROTATE;
    private Piece L1,L2,L1_f,L2_f,L1_Same;
    private Piece[] A;
	@Before
	public void setUp() throws Exception {
		
		pyr1 = new Piece(Piece.PYRAMID_STR);
		pyr2 = pyr1.computeNextRotation();
		pyr3 = pyr2.computeNextRotation();
		pyr4 = pyr3.computeNextRotation();
		pyr5 = pyr3.computeNextRotation();
		s = new Piece(Piece.S1_STR);
		sRotated = s.computeNextRotation();
		
		Square = new Piece(Piece.SQUARE_STR);
		SquareRotated = Square.computeNextRotation();
		
        L1 = new Piece(Piece.L1_STR);
        S1_ROTATE = new Piece(Piece.ROTATE);
        L1_f = L1.computeNextRotation();
        L2 = new Piece(Piece.L2_STR);
        L2_f = L2.computeNextRotation();
        //first round rotation of the pieces
		A =Piece.getPieces();
		
	}
	
	// Here are some sample tests to get you started
	
	@Test
	public void testSampleSize() {
		// Check size of each pieces
		assertEquals(3, pyr1.getWidth());
		assertEquals(2, pyr1.getHeight());
		assertEquals(3, L1.getHeight());
		assertEquals(2, L1.getWidth());
		assertEquals(2, s.getHeight());
		assertEquals(3, s.getWidth());

		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, pyr2.getWidth());
		assertEquals(3, pyr2.getHeight());
		assertEquals(3, pyr3.getWidth());
		assertEquals(2, pyr3.getHeight());
		assertEquals(3, L1_f.getWidth());
		assertEquals(2, L1_f.getHeight());
		assertEquals(3, L2_f.getWidth());
		assertEquals(2, L2_f.getHeight());
		assertEquals(2, A[5].getWidth()); //the square after rotation 
		assertEquals(2, A[5].getHeight());
		assertEquals(3, A[1].getWidth());//should be equal to the result OF L1_first_rotate
		assertEquals(2, A[1].getHeight());
		// Now try with some other piece, made a different way
		Piece l = new Piece(Piece.STICK_STR);
		assertEquals(1, l.getWidth());
		assertEquals(4, l.getHeight());
	}
	
	
	// Test the skirt returned by a few pieces
	@Test
	public void testSampleSkirt() {
		// Note must use assertTrue(Arrays.equals(... as plain .equals does not work
		// right for arrays.
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, pyr1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, s.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0}, L1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, sRotated.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0, 1}, pyr3.getSkirt()));
		
		
	}
	
	// Test if the equal method is correct
	@Test
	public void testEqual(){ // The A[]array computes the first round rotation
		assertTrue(S1_ROTATE.equals(sRotated));
		assertTrue(L2_f.equals(A[2]));
		assertTrue(pyr2.equals(A[6]));
		assertTrue(pyr3.equals(A[6].computeNextRotation()));
		assertTrue(L2_f.computeNextRotation().equals(A[2].fastRotation()));//test fast Rotation
		assertFalse(pyr1.equals(A[5]));
		assertTrue(Square.computeNextRotation().equals(Square));
	}
}
