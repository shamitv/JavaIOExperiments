package in.shamit.wikiparser.zipio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlLineCountTest_read_char_buffer {
    public static void main(String[] args) {
        String  archivePath = "K:\\tmp\\enwiki-latest-pages-articles.xml";
        try(InputStream fin = Files.newInputStream(Paths.get(archivePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin, StandardCharsets.UTF_8))){
            long count=0;
            int buf_size=1000*1000;
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

 *
 *
 */