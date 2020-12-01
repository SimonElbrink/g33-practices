package se.lexicon.practice.section4.sequencer;

public class EmployeeSequencer {

    private static int sequencer = 0;

    public static int getNextId(){
        return ++sequencer;
    }

    public static int getLatestAssignedSequenceNumber() {
        return sequencer;
    }

    public static boolean resetSequencer()
    {
        sequencer = 0;

        return sequencer == 0;

    }

}
