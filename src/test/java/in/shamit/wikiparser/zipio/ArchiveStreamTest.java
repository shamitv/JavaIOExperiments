package in.shamit.wikiparser.zipio;


import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArchiveStreamTest {
    public static void main(String args[]) throws Exception{
        String  archivePath = args[0];
        try(InputStream fin = Files.newInputStream(Paths.get(archivePath));
            BufferedInputStream in = new BufferedInputStream(fin);
            BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(bzIn,"UTF-8"))){
            long count=reader.lines().count();
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
