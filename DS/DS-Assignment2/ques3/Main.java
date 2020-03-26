package ques3;

import java.io.IOException;

/**
 * The Class Main.
 */
public class Main {
    
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        CollegeCounseling counseling = new CollegeCounseling();
        //counseling.showStudentDetail();
        
        counseling.genrateQueue();
        counseling.show();
        counseling.saveData();
    }
}
