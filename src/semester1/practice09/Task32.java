package semester1.practice09;

public class Task32 {
    public static void run(){
        ZipCompressor zip = new ZipCompressor("ZIP");
        UltraLzmaCompressor lzma = new UltraLzmaCompressor("LZMA");
        int size = 1000;
        System.out.println(zip);
        System.out.println("Розмір після стиснення: " + zip.estimateCompressedSize(size));
        System.out.println("Коефіцієнт: " + zip.getCompressionRatio(size));
        System.out.println();
        System.out.println(lzma);
        System.out.println("Розмір після стиснення: " + lzma.estimateCompressedSize(size));
        System.out.println("Коефіцієнт: " + lzma.getCompressionRatio(size));
    }
}
abstract class AbstractCompressor{
    private final String algorithmName;
    AbstractCompressor(String algorithmName){
        this.algorithmName=algorithmName;
    }
    public abstract int estimateCompressedSize(int originalSizeBytes);
    public double getCompressionRatio(int originalSizeBytes){
        return (double) originalSizeBytes / estimateCompressedSize(originalSizeBytes);
    }
    @Override
    public String toString() {
        return "Алгоритм стиснення: " + algorithmName;
    }
}
class ZipCompressor extends AbstractCompressor{
    ZipCompressor(String algorithmName){
        super(algorithmName);
    }
    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        return (int) (originalSizeBytes * 0.45);
    }
}
class UltraLzmaCompressor extends  AbstractCompressor{
    UltraLzmaCompressor(String algorithmName){
        super(algorithmName);
    }

    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        return (int) (originalSizeBytes*0.70)+128;
    }
}
