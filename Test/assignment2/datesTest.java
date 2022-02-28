package assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class datesTest {

    @Test
    void getAnalysisdata() {
        TaskDataAnalysis dates =new TaskDataAnalysis();

        assertEquals(4,dates.getAnalysisdata("./src/assignment2/data.txt", "./src/assignment2/data1.txt"));
    }
}