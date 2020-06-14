package in.shamit.wikiparser.zipio;

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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/*

Results :

Run 	0	00:06:00
Run 	1	00:06:05
Run 	2	00:05:57
Run 	3	00:05:59

* */