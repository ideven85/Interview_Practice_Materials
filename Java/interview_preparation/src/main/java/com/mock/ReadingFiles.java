package mock;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.StringTokenizer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class ReadingFiles {
    private static final String FILE= Objects.requireNonNull(ReadingFiles.class.getResource("./rural.txt")).getFile();

    public static void main(String[] args) throws Exception{
        System.out.println(Paths.get(FILE));
      BufferedReader reader = new BufferedReader(new FileReader(FILE));
       // InputStreamReader in = new InputStreamReader(FILE);
        measureTime("BufferedReader.readLine() into LinkedList", ReadingFiles::bufferReaderToLinkedList, FILE);
        measureTime("BufferedReader.readLine() into ArrayList", ReadingFiles::bufferReaderToArrayList, FILE);
        measureTime("Files.readAllLines()", ReadingFiles::readAllLines, FILE);
        measureTime("Scanner.nextLine() into ArrayList", ReadingFiles::scannerArrayList, FILE);
        measureTime("Scanner.nextLine() into LinkedList", ReadingFiles::scannerLinkedList, FILE);
        measureTime("RandomAccessFile.readLine() into ArrayList", ReadingFiles::randomAccessFileArrayList, FILE);
        measureTime("RandomAccessFile.readLine() into LinkedList", ReadingFiles::randomAccessFileLinkedList, FILE);
        System.out.println("-----------------------------------------------------------");

    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
    private static void measureTime(String name, Function<String, List<String>> fn, String path) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("run: " + name);
        long startTime = System.nanoTime();
        List<String> l = fn.apply(path);

        System.out.println(l.size());
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("lines: " + l.size());
        System.out.println("estimatedTime: " + estimatedTime / 1_000_000_000.);
    }

    private static List<String> bufferReaderToLinkedList(String path) {
        return bufferReaderToList(path, new LinkedList<>());
    }

    private static List<String> bufferReaderToArrayList(String path) {
        return bufferReaderToList(path, new ArrayList<>());
    }

    private static List<String> bufferReaderToList(String path, List<String> list) {
        try {
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
            in.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<String> readAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> randomAccessFileLinkedList(String path) {
        return randomAccessFile(path, new LinkedList<>());
    }

    private static List<String> randomAccessFileArrayList(String path) {
        return randomAccessFile(path, new ArrayList<>());
    }

    private static List<String> randomAccessFile(String path, List<String> list) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "r");
            String str;
            while ((str = file.readLine()) != null) {
                list.add(str);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<String> scannerLinkedList(String path) {

        return scanner(path, new LinkedList<>());
    }

    private static List<String> scannerArrayList(String path) {

        return scanner(path, new ArrayList<>());
    }

    private static List<String> scanner(String path, List<String> list) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
