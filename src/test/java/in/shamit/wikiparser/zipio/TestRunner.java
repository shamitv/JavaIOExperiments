package in.shamit.wikiparser.zipio;

import java.time.Duration;
import java.util.Date;

public class TestRunner {

    static void runTest(int count){
        for(int i=0;i<count;i++){
            long startMils= new Date().getTime();
            try {
                XmlLineCountTest_stream_count.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            long endMils= new Date().getTime();
            long elapsed=endMils-startMils;
            Duration timeLeft = Duration.ofMillis(elapsed);
            String hhmmss = String.format("%02d:%02d:%02d",
                    timeLeft.toHours(), timeLeft.toMinutesPart(), timeLeft.toSecondsPart());
            System.out.println("Run \t"+i+"\t"+hhmmss);
        }
    }

    public static void main(String args[]){
        runTest(4);
    }
}
