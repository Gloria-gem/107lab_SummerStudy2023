import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class strcode
{
    public static void main(String[] args) throws IOException {
        File demo =new File("demo");
        if (!demo.exists()){
            demo.mkdir();
        }
        File file =new File(demo,"raf.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile raf =new RandomAccessFile(file,"rw");
        int i =0x7fffffff;
        raf.writeInt(i);
        String s="中";
        byte[] gbk =s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.length());
        //读文件，必须把指针移到头部
        raf.seek(0);
        byte[] buf =new byte[(int)raf.length()];
        String string =new String(buf);
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
        System.out.println(string);
        raf.close();

    }
}
