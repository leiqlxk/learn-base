## 十三 IO流

### 1. File

#### 1.1 概述和构造方法

File：它是文件和目录路径名的抽象表示

- 文件和目录是可以通过File分装成对象的
- 对于File而言，其封装的并不是一个真正存在的文件，仅仅是一个路径名而已。它可以是存在的，也可以是不存在的。将来是要通过具体的操作把这个路径的内容转换为具体存在的。

构造方法：

| 方法名                                                       | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| **[File](https://www.apiref.com/java11-zh/java.base/java/io/File.html#(java.lang.String))**([String](https://www.apiref.com/java11-zh/java.base/java/lang/String.html) pathname) | 通过将给定的路径名字符串转换为抽象路径名来创建新的 `File`实例。 |
| **[File](https://www.apiref.com/java11-zh/java.base/java/io/File.html#(java.lang.String,java.lang.String))**([String](https://www.apiref.com/java11-zh/java.base/java/lang/String.html) parent, [String](https://www.apiref.com/java11-zh/java.base/java/lang/String.html) child) | 从父路径名字符串和子路径名字符串创建新的 `File`实例。        |
| **[File](https://www.apiref.com/java11-zh/java.base/java/io/File.html#(java.io.File,java.lang.String))**([File](https://www.apiref.com/java11-zh/java.base/java/io/File.html) parent, [String](https://www.apiref.com/java11-zh/java.base/java/lang/String.html) child) | 从父抽象路径名和子路径名字符串创建新的 `File`实例。          |
| **[File](https://www.apiref.com/java11-zh/java.base/java/io/File.html#(java.net.URI))**([URI](https://www.apiref.com/java11-zh/java.base/java/net/URI.html) uri) | 通过将给定的 `file:` URI转换为抽象路径名来创建新的 `File`实例。 |

```java
// 并未要求一定存在
// 三者输出都为：E:\demo\java.txt
File f1 = new File("E:/demo/java.txt");
System.out.println(f1);

File f2 = new File("E:/demo", "java.txt");
System.out.println(f2);

File f3 = new File("E:/demo");
File f4 = new File(f3, "java.txt");
System.out.println(f4);
```

#### 1.2 File类创建功能

| 方法名                                            | 说明                                                         |
| ------------------------------------------------- | ------------------------------------------------------------ |
| public boolean createNewFile() throws IOException | 当且仅当具有此名称的文件尚不存在时，以原子方式创建由此抽象路径名命名的新空文件。 |
| public boolean mkdir()                            | 创建此抽象路径名指定的目录。                                 |
| public boolean mkdirs()                           | 创建此抽象路径名指定的目录，包括任何必需但不存在的父目录。   |

```java
// 路径为相对路径时，默认java运行时默认的工作目录为当前目录，/开始为根路径
File f1 = new File("E:/demo/java");
// 返回true/false，会自动创建不存在的上级目录，该目录存在是返回false
f1.mkdirs();

// 返回true/false，父目录不存在或改目录已存在时返回false，不会报错
f1.mkdir();

// 目录必须存在，否则报错，如果文件不存在，就创建文件，返回true，如果文件存在就不创建，返回false
f1.createNewFile();

```

#### 1.3 File类判断和获取功能

| 方法名                          | 说明                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| public boolean isDirectory()    | 测试此抽象路径名表示的文件是否为目录                         |
| public boolean isFile()         | 测试此抽象路径名表示的文件是否为普通文件                     |
| public boolean exists()         | 测试此抽象路径名表示的文件或目录是否存在                     |
| public String getAbsolutePath() | 返回此抽象路径名的绝对路径名字符串                           |
| public String getPath()         | 将此抽象路径名转换为路径名字符串                             |
| public String getName()         | 返回此抽象路径名表示的文件或目录的名称                       |
| public String[] list()          | 返回一个字符串数组，用于命名此抽象路径名表示的目录中的文件和目录 |
| public File[] listFiles()       | 返回一个抽象路径名数组，表示此抽象路径名表示的目录中的文件   |

#### 1.4 File类删除功能

| 方法名                  | 说明                                                         |
| ----------------------- | ------------------------------------------------------------ |
| public boolean delete() | 删除此抽象路径名表示的文件或目录。 **如果此路径名表示目录，则该目录必须为空才能被删除** |

### 2. 字节流

#### 2.1 IO流概述和分类

IO流概述：

- IO：输入/输出（Input/Output）
- 流：是一种抽象概念，是对数据传输的总称。也就是说数据在设备间的传输称为流，流的本质是数据传输
- IO流就是用来处理设备间数据传输问题的：文件复制、文件上传、文件下载

分类：

- 按照数据的流向：
  - 输入流（输入到内存）：读数据
  - 输出流（从内存输出）：写数据
- 按照数据类型来分：
  - 字节流：
    - 字节输入流、字节输出流
  - 字符流：
    - 字符输入流、字符输出流

#### 2.2 字节流写数据

字节流抽象基类：

- InputStream：这个抽象类是表示字节输入流的所有类的超类
- OutputStream：这个抽象类是表示字节输出流的所有类的超类
- 子类特点：子类名称都是以其父类名作为子类名的后缀

```java
// 使用FileOutputStream（文件输出流）将数据写入File
// FileOutpuStream(String name)：创建文件输出流以指定的名称写入文件
// 创建字节输出流对象
// 做了三件事：
//      1. 调用系统功能创建了文件，默认情况下会覆盖已有文件
//      2. 创建了字节输出流对象
//      3. 让字节输出流对象指向创建好的文件
FileOutputStream stream = new FileOutputStream("javase/java.txt");

// void write(int b)：将制定的字节写入此文件输出流
stream.write(97);

// write(byte[] b)：将b.length字节从指定的字节数组写入输出流
// byte[] bytes = {97, 98, 99, 100, 101};
// String中byte[] getBytes()
byte[] bytes = "abcde".getBytes();
stream.write(bytes);

// write(byte[] b, int off, int len)：将len字节从指定的字节数开始，从偏移量off开始写入输出流
byte[] bytes1 = "abcdef".getBytes();
stream.write(bytes1, 2, 3);

// 最后释放资源
// void flush()：刷新此输出流并强制写出任何缓冲的输出字节
// void close()：关闭此文件输出流并释放与此流相关联的任何系统资源
stream.flush();
stream.close();
```

#### 2.4 字节流写数据的3种方式

| 方法                              | 说明                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| void write(int b)                 | 将指定的字节写入输出流<br>一次写一个字节数据                 |
| write(byte[] b)                   | 将b.length字节从指定的字节数组写入输出流<br>一次写一个字节数组数据 |
| write(byte[] b, int off, int len) | 将len字节从指定的字节数开始，从偏移量off开始写入输出流<br>一次写一个字节数组的部分数据 |

#### 2.5 字节流洗数据问题

```java
// 处理异常
FileOutputStream stream;
try{
    // 追加写入
    // FileOutputStream(String name, boolean append)：创建文件输出流以写入具有指定名称的文件，第二个参数为true，则字节将写入文件的末尾而不是开头
    stream = new FileOutputStream("javase/java.txt", true);

    // 换行问题
    //      windows：\r\n
    //      linux：\n
    //      mac：\r
    for (int i = 0; i < 10; i++) {
        stream.write("hello".getBytes());
        stream.write("\r\n".getBytes());
    }
}catch (IOException e) {
    e.printStackTrace();
}finally {
    // finally一般用于执行所有清除操作，如IO流的释放资源
    // finally块中的语句一定会执行，除非JVM退出
    try {
        if (stream != null) {
            stream.flush();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        if (stream != null) {
            stream.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// try-with-resources方式
// try-with-resources 是JDK 7中一个新的异常处理机制，它能够很容易地关闭在 try-catch 语句块中使用的资源
// try-with-resources 语句确保了每个资源在语句结束时关闭。所有实现了 java.lang.AutoCloseable 接口（其中，它包括实现了 java.io.Closeable 的所有对象），可以使用作为资源。
 try (FileOutputStream stream = new FileOutputStream("javase/java.txt", true)) {

 }  catch (IOException e) {
     e.printStackTrace();
 }
```

#### 2.6 字节流读数据（一次读一个字节数据）

```java
// FileInputStream:从文件系统中的文件获取输入字节
// FileInputStream(String name)：通过打开与实际文件的连接来创建 FileInputStream ，该文件由文件系统中的路径名 name命名。
// 创建字节输入流对象
try (FileInputStream stream = new FileInputStream("javase/java.txt")) {
    int read;
    // 调用字节流对象的读数据方法，一次读取一个字节
    while ( (read = stream.read()) != -1) {
        System.out.println((char) read);
    }
    
    // 一次读完数据
    // int available()：返回可以从此输入流中读取（或跳过）的剩余字节数的估计值
    byte[] bytes = new byte[stream.available()];
    stream.read(bytes);
    System.out.println(new String(bytes));
} catch (IOException e) {
    e.printStackTrace();
}

// 复制文件
try (FileInputStream stream = new FileInputStream("javase/java.txt");
             FileOutputStream outputStream = new FileOutputStream("javase/java-copy.txt")
        ) {
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

```

#### 2.7 字节流读数据的3中方法

| 方法                                        | 说明                                                         |
| ------------------------------------------- | ------------------------------------------------------------ |
| public int read()                           | 从此输入流中读取一个字节的数据。 如果尚未提供输入，此方法将阻塞。<br>返回数据的下一个字节，如果到达文件的末尾， `-1` |
| public int read(byte[] b)                   | 从此输入流`b.length`最多`b.length`个字节的数据读入一个字节数组。 此方法将阻塞，直到某些输入可用。<br/>如果由于文件末尾已到达而没有更多数据， `-1` ，否则返回读取的长度 |
| public int read(byte[] b, int off, int len) | 从此输入流`len`最多`len`字节的数据读入一个字节数组。 如果`len`不为零，则该方法将阻塞，直到某些输入可用; 否则，不读取任何字节，返回`0` 。<br/>如果由于文件末尾已到达而没有更多数据， `-1` ，否则返回读取的长度 |

#### 2.8 字节缓冲流

- BufferedOutputStream：该类实现缓冲输出流，通过设置这样的输出流，应用程序可以将底层输出流写入字节，而不必为写入的每个字节导致底层系统的调用

- BufferedInputStream：将创建一个内部缓冲区数组，当从流中读取或跳过字节时，内部缓冲区将根据需要从所包含的输入流中重新填充，一次很多字节

  ```java
  try (
      // 创建输入、输出流对象
      // 实际内部维护了一个byte数组，本质还是使用的FileInputStream和FileOutputStream
      BufferedInputStream stream = new BufferedInputStream(new FileInputStream("javase/java.txt"));
      BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("javase/java-copy.txt"))
  ) {
  	// stream.transferTo(outputStream);
      final byte[] bytes = new byte[8 * 1027];
      int copySize;
      while ((copySize = stream.read(bytes)) != -1) {
          outputStream.write(bytes, 0, copySize);
      }
  } catch (IOException e) {
  	e.printStackTrace();
  }
  ```

### 3. 字符流

#### 3.1 字符流的作用

由于字节流操作中文不是特别方便，所以java提供了字符流

- **字符流 = 字节流 + 编码表**
- 用字节流赋值文本文件时，文本文件也会有中，但是没有问题，原因是最终底层操作会自动进行字节拼接成中文：汉字在存储时，无论选择哪种编码存储，第一个字节都是负数



### 4. 特殊操作流

