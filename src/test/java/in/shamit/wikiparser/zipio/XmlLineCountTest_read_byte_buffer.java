package in.shamit.wikiparser.zipio;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlLineCountTest_read_byte_buffer {
    public static void main(String[] args) {
        String  archivePath = args[0];
        int buf_size=1000*1000*100;
        try(InputStream fin = Files.newInputStream(Paths.get(archivePath))){
            long count=0;
            int read;
            byte []buf;
            while((buf=fin.readNBytes(buf_size)).length>0){
                read=buf.length;
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
0
Run 	0	00:04:15
0
Run 	1	00:03:21
0
Run 	2	00:03:24
0
Run 	3	00:03:25
Average 	 	00:03:36
 *
 *
 */