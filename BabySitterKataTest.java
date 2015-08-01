
package babysitterkata;


public class BabySitterKataTest {

    public void babySitterDoesNotStartWorkUntil5PM()
    {
        EveningOfBabySitting evening = new EveningOfBabySitting();
        assertIsEqual(evening.setStartTime(5, 0), false);
        assertIsEqual(evening.setStartTime(10, 35), false);
        assertIsEqual(evening.setStartTime(17, 43), true);
        assertIsEqual(evening.setStartTime(1, 10), true);
    }
    
    public void babySitterDoesNotWorkPass4AM()
    {
        EveningOfBabySitting evening = new EveningOfBabySitting();
        assertIsEqual(evening.setEndTime(5, 0), false);
    }
    
    private <E extends Object> void assertIsEqual(E value1, E value2)
    {
        System.out.println("Tested Value : "+value1);
        System.out.println("Expected Value : "+value2);
        if(value1.equals(value2))
        {
            System.out.println("    Test Passed");
        }
        else
        {
            System.out.println("    Test Failed");
        }
    }
    
}
