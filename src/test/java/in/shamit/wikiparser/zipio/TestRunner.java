package in.shamit.wikiparser.zipio;

import java.time.Duration;
import java.util.Date;

public class TestRunner {

    static String formatDuration(long milliseconds){
        Duration timeLeft = Duration.ofMillis(milliseconds);
        return String.format("%02d:%02d:%02d",
                timeLeft.toHours(), timeLeft.toMinutesPart(), timeLeft.toSecondsPart());
    }

    static void runTest(int count, String textFilePath){

        long total_elapsed_time = 0;
        for(int i=0;i<count;i++){
            long startMils= new Date().getTime();
            try {
                String[] args=new String[1];
                args[0]=textFilePath;
                XmlLineCountTest_read_char_buffer.main(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
            long endMils= new Date().getTime();
            long elapsed=endMils-startMils;
            total_elapsed_time += elapsed;
            String hhmmss = formatDuration(elapsed);
            System.out.println("Run \t"+i+"\t"+hhmmss);
        }
        String hhmmss = formatDuration(total_elapsed_time/count);
        System.out.println("Average \t"+" "+"\t"+hhmmss);
    }

    public static void main(String[] args){
        String textFilePath = args[0];
        runTest(4,textFilePath);
    }
}
