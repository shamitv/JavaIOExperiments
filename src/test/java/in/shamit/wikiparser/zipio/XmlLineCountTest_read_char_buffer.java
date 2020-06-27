package in.shamit.wikiparser.zipio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlLineCountTest_read_char_buffer {
    public static void main(String[] args) {
        String  archivePath = "F:\\nlp\\Wikipedia\\wiki_aug_2019\\enwiki-latest-pages-articles-multistream.xml";
        int buf_size=1000*1000;
        try(InputStream fin = Files.newInputStream(Paths.get(archivePath));
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(fin, StandardCharsets.UTF_8))){
                long count=0;
                char[] buf=new char[buf_size];
                int read;
                while((read=reader.read(buf))!=-1){
                    for(int i=0;i<read;i++){
                        if(buf[i]=='\r'||buf[i]=='\n'){
                            count++;
                        }
                    }
                }
                System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/* Results
1121088878
Run 	0	00:07:37
1121088878
Run 	1	00:06:17
1121088878
Run 	2	00:07:38
1121088878
Run 	3	00:06:21
Average 	 	00:06:58
 *
 *
 */