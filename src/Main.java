import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {
	public static void main(String[] argv) throws Exception {
		String base64zippedString = new String(Files.readAllBytes(Paths.get("/tmp/urlinfo.txt")));
		System.out.println(base64zippedString);			
		byte[] zippedArray = Base64.getDecoder().decode(base64zippedString);
		
//		byte[] input = Files.readAllBytes(Paths.get("/tmp/aha.zip"));
		System.out.println("zipped array size:" + zippedArray.length);
		byte[] unzippedArray = CompressionUtils.decompress(zippedArray);
		
		String revertedString = new String(unzippedArray);
		System.out.println("reverted string length:" + revertedString.length());		
		System.out.println(revertedString);
	}
}