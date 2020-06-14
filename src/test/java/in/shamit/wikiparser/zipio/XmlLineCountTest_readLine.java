package in.shamit.wikiparser.zipio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlLineCountTest_readLine {
    public static void main(String[] args) {
        String  archivePath = "K:\\tmp\\enwiki-latest-pages-articles.xml";
        try(InputStream fin = Files.newInputStream(Paths.get(archivePath));
            //BufferedInputStream in = new BufferedInputStream(fin,1024*1024*1024);
            BufferedInputStream in = new BufferedInputStream(fin);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))){
                long count=0;
                //long count=reader.lines().count();
                while(reader.readLine()!=null){
                    count++;
                }
                System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/* Results
 *Run 	0	00:04:36
 * Run 	1	00:04:37
 * Run 	2	00:04:30
 * Run 	3	00:04:30
 * Average 	 	00:18:15
 *
 *
 */
