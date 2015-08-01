
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
        assertIsEqual(evening.setEndTime(4, 34), false);
        assertIsEqual(evening.setEndTime(22, 15), true);
        assertIsEqual(evening.setEndTime(1, 22), true);
        assertIsEqual(evening.setEndTime(18, 20), true);
    }
    
    public void babySitterStartsWorkingBeforeTheyFinishWorking()
    {
        EveningOfBabySitting evening = new EveningOfBabySitting();
        evening.setStartTime(17, 0);
        evening.setEndTime(23, 20);
        assertIsEqual(evening.validWorkHoursEnter(), true);
        
        evening.setStartTime(19, 30);
        evening.setEndTime(18, 20);
        assertIsEqual(evening.validWorkHoursEnter(), false);
        
        evening.setStartTime(11, 30);
        evening.setEndTime(23, 20);
        assertIsEqual(evening.validWorkHoursEnter(), false);
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
