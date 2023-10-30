package com.LuceneDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGeneration 
{
    
    public static void main(String args[])
    {
        final String fileDirectory =  "../src/resources";

        char symbols[] = {'0','1','2','3','4','5','6','7','8','9',
                          'a','b','c','d','e','f','g','h','i','j',
                          'k','l','m','n','o','p','q','r','s','t',
                          'u','v','w','x','y','z','A','B','C','D',
                          'E','F','G','H','I','J','K','L','M','N',
                          'O','P','Q','R','S','T','U','V','W','X',
                          'Y','Z'}; 
        
        int index = 0;

        for (int i = 0; i < 10; i++)
        {
            String filePath = fileDirectory + "/file_" + (i+1) + ".txt";

            try 
            {
                File f = new File(filePath);
                
                if(!f.exists())
                {
                    f.createNewFile();
                }
                else
                {
                    f.delete();
                    f.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

                for(int j = 0; j < 10; j++)
                {
                    for (int k = 0; k < 6; k++)
                    {
                        for (int l = 0; l < 10; l++)
                        {
                            bw.write(symbols[(index+l)%symbols.length]);
                        }
                        bw.write(" ");
                        index++;
                    }
                    bw.newLine();
                }

                bw.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            
        }

    }
}
