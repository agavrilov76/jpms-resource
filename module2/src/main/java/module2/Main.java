package module2;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    loadResource("root.txt", "From module's root directory");
    loadResource("dir1/resource1.txt", "From opened package `dir1`");
    loadResource("dir2/resource2.txt", "From internal package `dir2`");
    loadResource("dir-3/resource3.txt", "From directory `dir-3` with non-Java name");
  }

  public static void loadResource(String name, String comment) throws IOException {
    // module2 application class loader
    final var classLoader = Main.class.getClassLoader();
    try (var in = classLoader.getResourceAsStream(name)) {
      System.out.println();
      System.out.println("// " + comment);
      System.out.println(name + ": " + (in != null));
    }
  }
}
