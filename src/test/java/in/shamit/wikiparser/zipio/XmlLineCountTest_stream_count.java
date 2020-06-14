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
            //BufferedInputStream in = new BufferedInputStream(fin,1024*1024*1024);
            BufferedInputStream in = new BufferedInputStream(fin);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"))){
                long count=reader.lines().count();
                System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
