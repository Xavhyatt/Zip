package zip.snappy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.xerial.snappy.Snappy;
import org.zeroturnaround.zip.ZipUtil;
import org.apache.commons.compress.compressors.bzip2.*;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	int buffersize = 4096;
    	
    	// Snappy Start
    	
/*    	FileInputStream fis = new FileInputStream(new File("C:\\Users\\xavhy\\Desktop\\test.txt"));
    	FileChannel channel = fis.getChannel();
    	ByteBuffer bb = ByteBuffer.allocate((int) channel.size());
    	channel.read(bb);
    	byte[] beforeBytes = bb.array();

    	//compress
    	System.out.println("Before snappy compress size：" + beforeBytes.length + " bytes");
    	long startTime1 = System.currentTimeMillis();
    	byte[] afterBytes = Snappy.compress(beforeBytes);
    	long endTime1 = System.currentTimeMillis();
    	System.out.println("after snappy compress size：" + afterBytes.length + " bytes");
    	System.out.println("snappy compress time elapsed：" + (endTime1 - startTime1)
    	        + "ms");

    	//uncompress
    	long startTime2 = System.currentTimeMillis();
    	byte[] resultBytes = Snappy.uncompress(afterBytes);
    	System.out.println("snappy uncompress size：" + resultBytes.length + " bytes");
    	long endTime2 = System.currentTimeMillis();
    	System.out.println("uncompress time elapsed：" + (endTime2 - startTime2)
    	        + "ms"); 
    	*/
    	
    	// Snappy End
    	
    	// XZ Start
    	
/*    	InputStream in = Files.newInputStream(Paths.get("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test1.txt"));
    	OutputStream fout = Files.newOutputStream(Paths.get("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test1.txt.xz"));
    	long startTime1 = System.currentTimeMillis();
    	BufferedOutputStream out = new BufferedOutputStream(fout);
    	XZCompressorOutputStream xzOut = new XZCompressorOutputStream(out);   	
    	
		final byte[] buffer = new byte[buffersize ];
    	int n = 0;  
    	while (-1 != (n = in.read(buffer))) {
    	    xzOut.write(buffer, 0, n);
    	}
    	xzOut.close();
    	in.close();
    	long endTime1 = System.currentTimeMillis();
    	System.out.println("XZ compress time elapsed：" + (endTime1 - startTime1)
    	        + "ms");
    	
    	
    	
    	InputStream fin1 = Files.newInputStream(Paths.get("C:\\Users\\xavhy\\Desktop\\test1.txt.xz"));
    	long startTime2 = System.currentTimeMillis();
    	BufferedInputStream in1 = new BufferedInputStream(fin1);
    	OutputStream out1 = Files.newOutputStream(Paths.get("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test1uncomp.txt"));
    	XZCompressorInputStream xzIn1 = new XZCompressorInputStream(in1);
    	final byte[] buffer1 = new byte[buffersize];
    	int n1 = 0;
    	while (-1 != (n1 = xzIn1.read(buffer))) {
    	    out1.write(buffer1, 0, n1);
    	}
    	out1.close();
    	xzIn1.close();
    	long endTime2 = System.currentTimeMillis();
    	System.out.println("XZ decompress time elapsed：" + (endTime2 - startTime2)
    	        + "ms");*/
    	
    	// XZ End
    	
    	// ZT Zip only start
    	
//    	ZipUtil.packEntry(new File("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test.txt"), new File("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test.zip"));
    	
    	//ZT Zip End
    	
    	InputStream in = Files.newInputStream(Paths.get("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test1.txt"));
    	OutputStream fout = Files.newOutputStream(Paths.get("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test1.txt.xz"));
    	long startTime1 = System.currentTimeMillis();
    	BufferedOutputStream out = new BufferedOutputStream(fout);
    	XZOutputStream xzOut = new XZOutputStream(out, new LZMA2Options());   	
    	
		final byte[] buffer = new byte[buffersize ];
    	int n = 0;  
    	while (-1 != (n = in.read(buffer))) {
    	    xzOut.write(buffer, 0, n);
    	}
    	xzOut.close();
    	in.close();
    	long endTime1 = System.currentTimeMillis();
    	System.out.println("XZ compress time elapsed：" + (endTime1 - startTime1)
    	        + "ms");
    	
    	
    	
    	InputStream fin1 = Files.newInputStream(Paths.get("C:\\Users\\xavhy\\Desktop\\test1.txt.xz"));
    	long startTime2 = System.currentTimeMillis();
    	BufferedInputStream in1 = new BufferedInputStream(fin1);
    	OutputStream out1 = Files.newOutputStream(Paths.get("C:\\\\Users\\\\xavhy\\\\Desktop\\\\test1uncomp.txt"));
    	XZInputStream xzIn1 = new XZInputStream(in1);
    	final byte[] buffer1 = new byte[buffersize];
    	int n1 = 0;
    	while (-1 != (n1 = xzIn1.read(buffer))) {
    	    out1.write(buffer1, 0, n1);
    	}
    	out1.close();
    	xzIn1.close();
    	long endTime2 = System.currentTimeMillis();
    	System.out.println("XZ decompress time elapsed：" + (endTime2 - startTime2)
    	        + "ms");
    	
    }
}
