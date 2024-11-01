package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class LPTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LPTest
{
    private LP aLP;
    /**
     * Default constructor for test class LPTest
     */
    public LPTest()
    {
        aLP = new LP("123", "Blue", "Billie", "01/11/2024");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        LPCopy lpcopy1 = new LPCopy("321", "31/10/2024", "150", "god");
        aLP.addLPCopy(lpcopy1);
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testLP(){
        //Arrange
        //Act
        ArrayList<LPCopy> allCopys = aLP.getAllCopys();
        LPCopy lpcopy1 = allCopys.get(0);
        String serNo = lpcopy1.getSerialNumber();
        
        
        //Assert
        assertEquals(1, allCopys.size(), "Der skal kun være 1 copy");
        assertEquals("321", serNo, "Serienummer burde være 321.");
        assertEquals("31/10/2024", lpcopy1.getPurchaseDate(), "Dato på køb burde være '31/10/2024'.");
        assertEquals("150", lpcopy1.getPurchasePrice(), "Prisen på den første copy burde være '150'.");
        assertEquals("god", lpcopy1.getCondition(), "Stand af copy burde være'god'.");
   
    }
}
