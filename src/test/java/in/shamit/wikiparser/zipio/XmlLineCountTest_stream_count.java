package in.shamit.wikiparser.zipio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;



public class XmlLineCountTest_stream_count {
    public static void main(String args[]) throws Exception{
        String  archivePath = "K:\\tmp\\enwiki-latest-pages-articles.xml";
        try(InputStream fin = Files.newInputStream(Paths.get(archivePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin,"UTF-8"),1024*1024*100)){
                long count=reader.lines().count();
                System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

// First   run : 5m 57s
// Second  run : 5m 57s
// Third   run : 6m 2s
