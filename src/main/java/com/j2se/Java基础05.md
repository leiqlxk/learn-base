## 十五、 网络编程

### 1. 入门

#### 1.1 概述

![image-20210828225101186](img/image-20210828225101186.png)

计算机网络：

- 是指将地理位置不同的具有独立工能的多态计算机及外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件即网络通信协议的管理和协调下，实现资源共享和信息传递的计算机系统

网络编程：

- 在网络通信协议下，实现网络互连的不同计算机上运行的程序间进行数据交换

#### 1.2 网络编程三要素

- IP地址
  - 要想让网络中的计算机能够互相通信，必须为每台计算机指定一个标识号，通过这个标识号来指定要接收数据的计算机和识别发送的计算机，而IP地址就是这个标识号，也就是设备的标识
- 端口
  - 网络的通信，本质上是两个应用程序的通信。每台计算机都有很多的应用程序，通过端口号可以唯一标识设备中的应用程序，也就是应用程序的标识
- 协议
  - 通过计算机网络可以使多台计算机实现连接，位于同一个网络中的计算机在进行连接和通信时需要遵守一定的规则，这就好比在道路中行驶的汽车一定要遵守交通规则一样。在计算机网络中，这些连接和通信的规则被称为网络通信协议，它对数据的传输格式、传输速率、传输步骤等做了统一规定，通信双方必须同时遵守才能完成数据交换，常见的协议有UDP和TCP协议

#### 1.3 IP地址

IP地址：是网络中设备的唯一标识

IP地址分为两大类：

- IPv4：是给每个连接在网络上的主机分配一个32bit地址。按照TCP/IP规定，IP地址用二进制来表示，每个IP地址长32bit，也就是4个字节。如一个采用二进制形式的IP地址是“11000000 10101000 00000001 01000010”，这么长的地址，处理起来不够方便，为了方便使用，IP地址经常被写成十进制形式，中间使用符号“.”分隔不同的字节。于是上面的地址可以表示为“192.168.1.66”。IP地址的这种表示法叫作“点分十进制表示法”，显然比0和1容易记忆
- IPv6：由于互联网的蓬勃发展，IP地址的需求量越来越大，但是网络地址资源有限，使得IP的分配越发紧张。为了扩大地址空间，IPv6重新定义地址空间，采用128位地址长度，每16个字节一组，分成8组十六进制数，这样就解决了网络地址资源数量不够的问题

常用命令：

- ipconfig：查看本机IP地址
- ping IP地址：检查网络是否连通

特殊IP地址：

- 127.0.0.1：是回送地址，可以代表本机地址，一般用来测试使用

#### 1.4 InetAddress的使用

为了方便对IP地址的获取和操作，JAVA提供了InetAddress类

InetAddress：表示Internet协议(IP)地址

| 方法名                                    | 说明                                                         |
| ----------------------------------------- | ------------------------------------------------------------ |
| static InetAddress getByName(String host) | 确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址 |
| String getHostName()                      | 获取IP地址的主机名                                           |
| String getHostAddress()                   | 返回文本显示中的IP地址字符串                                 |

```java
InetAddress address = InetAddress.getByName("localhost");
// InetAddress address = InetAddress.getByName("127.0.0.1");

// localhost
System.out.println(address.getHostName());
// 127.0.0.1
System.out.println(address.getHostAddress());

InetAddress address1 = InetAddress.getByName("DESKTOP-5KH0KPQ");

// DESKTOP-5KH0KPQ
System.out.println(address1.getHostName());
// 192.168.2.4
System.out.println(address1.getHostAddress());
```

#### 1.5 端口

端口：设备上应用程序的唯一标识

端口号：用两个字节表示的整数，它的取值范围是0~65535。其中，0~1023之间的端口号用于一些知名的网络服务和应用，普通的应用程序需要使用1024以上的端口号。如果端口号被另外一个服务或应用所占用，会导致当前程序启动失败

#### 1.6 协议

协议：计算机网络中，连接和通信的规则被称为网络通信协议

UDP协议：

- 用户数据报协议
- UDP是无连接通信协议，即在数据传输时，数据的发送端和接收端不建立逻辑连接。简单来说，当一台计算机向另外一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会向发送端反馈是否收到数据
- 由于UDP协议消耗资源小，通信效率高，所以通常会用于音频、视频和普通数据的传输，如视频通话、音频通话等不会因为少量丢包产生较大影响的场景

TCP协议：

- 传输控制协议
- TCP协议是**面向连接**的通信协议，即传输数据之前，在发送端和接收端建立逻辑连接，然后再传输数据，它提供了两台计算机之间**可靠无差错**的数据传输。在TCP连接中必须要明确客户端与服务器端，由客户端向服务端发送连接请求，每次连接的创建都需要经过”三次握手“
- 三次握手：TCP协议中，在发送数据的准备阶段，客户端与服务器之间的三次交互，以保证连接的可靠
  - 第一次握手，客户端向服务器端发出连接请求，等待服务器确认
  - 第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求
  - 第三次握手，客户端再次向服务器端发送确认信息，确认连接
- 完成三次握手，连接建立后，客户端和服务器就可以开始进行数据传输了。由于这种面向连接的特性，TCP协议可以保证传输数据的安全，如上传文件、下载文件、浏览网页等

### 2. UDP通信程序

#### 2.1 概述

UDP协议是一种不可靠的网络协议，它在通信的两端个建立一个Socket对象，但是这两个Socket只是发送，接收数据的对象。

因此对于基于UDP协议的通信双方而言，没有所谓的客户端和服务器端的概念。

Java提供了DatagramSocket类作为基于UDP协议的Socket

#### 2.2 UDP发送数据

```java
// 创建发送端的Socket对象
DatagramSocket datagramSocket = new DatagramSocket();

// 创建数据，并把数据打包
byte[] bys = "hello,UDP".getBytes(StandardCharsets.UTF_8);
int length = bys.length;
InetAddress address = InetAddress.getByName("192.168.2.4");
int port = 10086;
// 构造数据报
DatagramPacket dp = new DatagramPacket(bys, length, address, port);

// 调用DatagramSocket发送数据
datagramSocket.send(dp);

// 关闭发送端
datagramSocket.close();
```

#### 2.3 UDP接收数据

```java
 // 创建接收端的Socket对象
DatagramSocket datagramSocket = new DatagramSocket(10086);

// 调用DatagramSocket接收数据
byte[] bytes = new byte[1024];
DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
datagramSocket.receive(datagramPacket);

// 解析数据报，并把数据打印在控制台
// 返回的是数据缓冲区
byte[] datas = datagramPacket.getData();
// 获取数据报实际长度
int len = datagramPacket.getLength();
String dataStr = new String(datas, 0, len, StandardCharsets.UTF_8);
System.out.println("数据是：" + dataStr);
// 关闭接收端
datagramSocket.close()
```

### 3. TCP通信程序

#### 3.1 TCP通信原理

TCP通信协议是一种可靠的网络协议，它在通信的两端各建立一个Socket对象，从而在通信的两端形成网络虚拟链路，一旦建立了虚拟的链路，两端的程序就可以通过虚拟链路进行通信。

Java对基于TCP协议的网络提供了良好的封装，使用Socket对象来代表两端的通信端口，并通过Socket产生IO流来进行网络通信。

Java为客户端提供了Socket类，为服务器端提供了ServerSocket类

#### 3.2 TCP发送数据

```java
// 创建socket对象
// Socket socket = new Socket(InetAddress.getByName("192.168.2.4"), 9000);
Socket socket = new Socket("192.168.2.4", 9000);

// 获取输出流，写数据
OutputStream stream = socket.getOutputStream();
stream.write("hello, server".getBytes(StandardCharsets.UTF_8));

// 释放资源
socket.close();
```

#### 3.3 TCP接收数据

```java
// 创建serverSocket对象
ServerSocket socket = new ServerSocket(9000);

// 等待连接，获取输入流
InputStream input = socket.accept().getInputStream();

// 打印输入流中数据
byte[] bytes = new byte[1024];
int len = input.read(bytes);
System.out.println("数据是" + new String(bytes, 0, len, StandardCharsets.UTF_8));

//释放资源
socket.close();
```

## 十六、 Lambda表达式

### 1. 函数式编程思想概述

在数学中，函数就是有输入量、输出量的一套计算方案，也就是“拿数据做操作”

面向对象思想强调“必须通过对象的形式来做事情”

函数式思想则尽量忽略面向对象的复杂语法：“强调做什么，而不是以书面形式做”

而Lambda表达式就是函数式思想的体现

### 2. 体验Lambda表达式

```java
// 实现类方式实现需求
MyRunnable my = new MyRunnalde();
Thread t = new Thread(my);
t.start();

// 匿名内部类的方式改进
new Thread(new Runable() {
    @Overide
    public void run() {
        System.out.println("多线程启动")
    }
}).start();

// lambda表达式
new Thread(() -> {
     System.out.println("多线程启动");
}).start();
```

### 3. Lambda表达式的标准格式

组成Lambda表达式的三要素：形式参数，箭头，代码块

- ()：为方法形式参数，如果有多个参数，参数之间用逗号隔开；如果没有参数，留空即可
- ->：用箭头指向后面要做的事情，固定写法，代表指向动作
- {}：包含一段代码，称之为代码块，可以看成是方法体中的内容

Lambda表达式的使用前提：

- 有一个接口

- 接口中有且仅有一个抽象方法

  ```java
  // 接口
  public interface Eatable {
  
      void eat();
  }
  
  // 使用
  public static void main(String[] args) {
      // 匿名内部类
      useEatable(new Eatable() {
          @Override
          public void eat() {
              System.out.println("hahaha");
          }
      });
  
      // lambda表达式
      useEatable(() -> {
          System.out.println("hahahah");
      });
  }
  
  private static void useEatable(Eatable e) {
      e.eat();
  }
  ```

  ### 4. Lambda表达式的省略方式

  ```java
  public static void main(String[] args)
      useEatable((int x, int y) -> {
          return x + y;
      });
      
      // lambda表达式的形参的参数类型可以省略，但是有过个参数的情况下，不能只省略一个或部分
  	useEatable((x, y) -> {
          return x + y;
      });
  
  	useFlyable((s) -> {
          System.out.println(s);
      });
  
  	// 如果参数有且仅有一个，那么小括号可以省略
  	useFlyable(s -> {
          System.out.println(s);
      });
  
  	// 如果代码块只有一条语句，那么大括号和分号可以省略
  	useFlyable(s -> System.out.println(s));
  
  	// 如果代码块只有一条语句，那么大括号和分号可以省略，如果有return，return也要省略掉
  	useEatable((x, y) -> x + y);
  }
  
  private static void useAddable(Addable a) {
      int sum = a.add(10, 20);
      System.out.println(sum);
  }
  
  public static void useFlyable(Flyable f) {
      f.fly("hehehhehehe")
  }
  ```

### 4. 注意事项

- 使用Lambda表达式必须要有接口，并且要求接口中有且仅有一个抽象方法
- 必须要有上下文环境，才能推导出Lambda对应的接口，即不能单独使用
  - 根据**局部变量的赋值**可以得知其对应的接口：`Runable r = () -> System.out.println("Lambda表达式");`
  - 根据**调用方法的参数**可以得知其对应的接口：`new Thread(() -> System.out.println("Lambda表达式")).start();`

### 5. Lambda表达式和匿名内部类的区别

所需类型不同

- 匿名内部类：可以是接口、抽象类、具体类
- Lambda表达式：只能是接口

使用限制不同

- 如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类
- 如果接口中多于一个抽象方法，只能使用匿名内部类，而不能使用Lambda表达式

实现原理不同

- 匿名内部类：编译之后，产生一个单独的.class字节码文件
- Lambda表达式：编译之后，没有一个单独的.class字节码文件，对应的字节码会在运行的时候动态生成

## 十七、 接口组成更新

### 1. JDK8后接口组成

- 常量
- 抽象方法
- 默认方法(Java8)
- 静态方法(Java8)
- 私有方法(Java9)

### 2. 接口中默认方法

- 默认方法不是抽象方法，所以不强制被重写。但是可以被重写，重写的时候去掉default关键字
- public 可以省略，default不能省略

```java
// public default 返回值类型 方法名(参数列表) {}
public interface MyInterface {

    void show1();

    void show2();

    // 默认方法，如果新增接口方法时就可以不影响之前写的实现类，提高了代码的可维护性
    default void show3() {
        System.out.println("show3 is default");
    }
}
```

### 3. 接口中静态方法

- 静态方法只能通过接口名调用，不能通过实现类或者对象名调用
- public 可以省略，static不能省略

```java
// public static 返回值类型 方法名(参数列表) {}

public interface MyInterface {

    void show1();

    void show2();
    
    static void show3() {
        System.out.println("show3 is static");
    }
}

// 使用,接口中的静态方法只能被接口调用，不能被对象或者实现类调用
MyInterface.show3();
```

### 4. 接口中私有方法

Java9中新增了带方法体的私有方法，其实在Java8中就埋下了伏笔：Java8运行在接口中定义带方法体的默认方法和静态方法。这样可能会引发一个问题：当两个默认方法或者静态方法中包含一段相同的代码实现时，程序必然考虑将这段实现代码抽取成一个共性方法，而这个共性方法是不需要让别人使用的，因此用私有给隐藏起来，其是Java9增加私有方法的必然性

- 默认方法可以调用私有的静态方法和非静态方法
- 静态方法只能调用私有的静态方法

```java
// private 返回值类型 方法名(参数列表) {}

public interface MyInterface {

    void show1();

    default void show2(){
        show3();
        show4();
    }

    private void show3() {
        System.out.println("show3 is private");
    }
    
    private static void show4() {
        System.out.println("show3 is private static");
    }
}
```

## 十八、 方法引用