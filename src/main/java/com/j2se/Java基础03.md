## 八、 抽象类

### 1.  概述

在Java中，一个**没有方法体**的方法应该定义为**抽象方法**，而类中如果有**抽象方法**，该类必须定义为**抽象类**。

```java
// abstract 关键字为抽象的意思，抽象类渴望被继承，不能被实例化
public abstract class Animal {
	public abstract eat();
}
```

### 2. 抽象类的特点

- 抽象类和抽象方法必须使用**abstract**关键字修饰
- 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
- 抽象类不能实例化，其必须通过子类对象实例化，即多态方式
- 抽象类的子类要么重写抽象类中的所有抽象方法，要么其本身也是抽象类

### 3. 抽象类的成员特点

- 可以有成员变量，成员变量可以是变量也可以是常量
- 可以有构造方法，但是不能实例化，构造方法用于子类访问父类数据的初始化
- 可以有成员方法，可以是抽象的（限定子类必须完成某些动作）也可以是非抽象的（提高代码复用性）

## 九、 接口

### 1 .  概述

接口就是一种**公共的规范标准**，只要符合规范标准，大家都可以通用

Java中的接口更多的体现在**对行为的抽象**

```java
// 使用interface声明接口
public interface Interface {

}

// 通过implements关键字来实现接口，接口可以实现多个，实现接口必须实现所有抽象方法
public class InterfaceDemo implements Interface {}

// 接口也可以继承接口
public interface Interface1 extends Interface{}
```



### 2. 接口的特点

- 成员变量只能是常量，默认修饰符：**public static final**可以省略不写
- 接口没有构造方法，因为接口主要是对行为进行抽象，是没有具体的存在的，当一个类如果没有父类，默认继承自Object，所以当一个类没有父类时，构造方法里第一行无论显示还是隐式的super()调用的都是Object的无参构造方法，其是java中最顶层的父类
- 成员方法只能是抽象方法，默认修饰符为：**public abstract**可以省略

### 3. 类和接口的关系

- 类和类的关系：继承关系，只能单继承，但是可以多层继承
- 类和接口的关系：实现关系，可以单实现，也可以是多实现，还可以继承一个类的同时实现多个接口
- 接口和接口的关系：继承关系，可以单继承，也可以多继承

### 4. 抽象类和接口的区别

|      | 抽象类                                                 | 接口                                                 |
| ---- | ------------------------------------------------------ | ---------------------------------------------------- |
| 成员 | 变量，常量；<br />有构造方法<br />抽象方法和非抽象方法 | 常量<br />抽象方法                                   |
| 关系 | 类与类之间为继承关系，单继承                           | 接口与接口之间为继承关系，可以是单继承也可以是多继承 |
| 设计 | 对某类事物（类）抽象，包括属性、行为                   | 对行为抽象，主要是行为                               |

### 5. 形参与返回值问题

- 形参和返回值是类时，需要的都是该类的对象
- 形参和返回值是抽象类时，需要的是抽象类的子类对象
- 形参和返回值是接口时，需要的是该接口的实现类对象

## 十、 内部类

### 1. 概述

内部类：就是在一个类中定义另一个类。如在一个类A的内部定义一个类B，类B就被称为内部类

```java
public class 类名{
	修饰符 class 类名{
		
	}
}
```

内部类的访问特点：

- 内部类可以直接访问外部类的成员，包括私有
- 外部类要访问内部类的成员，必须创建内部类的对象
- 外部类的加载及实例化并不会加载内部类，只有在第一次使用时才会加载和初始化，本质上JVM并不关心什么是内部类，Java语言编译器（例如javac、ECJ）在将Java源码编译到Class文件的过程中，将内部类做了“解糖”，给其添加一些必要的转换之后将其提升为跟顶层类一样的形式，然后后面就不再有内部类与否的区别了。

内部类的分类：

- 在类的成员位置：成员内部类
- 在类的局部位置：局部内部类

### 2.  成员内部类

```java
// 非静态内部类、常规内部类
// 外部类
public class Outer {
    // 内部类
    public class Inner {
        
    }
}

// 成员内部类的使用
// 外部类名.内部类名 对象名 = 外部类对象.内部类对象
Outer.Inner oi = new Outer().new Inner();

// 正常情况下非静态内部类通常用于隐藏某部分实现，因此常用private修饰，通过外部类的方法来访问内部类的方法
// 外部类
public class Outer {
    // 内部类
    private class Inner {
        public void show() {
            
        }
    }
    
    public void method() {
        Inner inner = new Inner();
        inner.show();
    }
}

// 静态内部类，通常也称为嵌套类
// 能从嵌套类的对象中访问非静态的外围类对象
public class Outer {
    // 内部类
    public static class Inner {
        public void show() {
            
        }
    }
}

// 此时要创建嵌套类的对象，并不需要外围类的对象
Outer.Inner oi = Outer.Inner();

// 正常情况下使用
public class Outer {
    // 内部类
    public static class Inner {
        private static void show() {
            
        }
    }
    
    public void method() {
        Inner.show();
    }
}
```

### 3. 局部内部类

```java
// 局部内部类时在方法中定义的类，所以外界是无法直接使用的，需要在方法内部创建对象并使用
// 该类可以直接访问外部类的成员，也可以访问方法内部的局部变量
// 外部类
public class Outer {
	private int num = 10;

    public void method() {
         // 局部内部类不能有权限修饰符
        class Inner {
     		public void show() {
				System.out.println(num);
            }
        }
        
        // 直接在方法中使用
        Inner i = new Inner();
        i.show();
    }
}
```

### 4. 匿名内部类（实际也是局部内部类）

前提：存在一个类或者接口，这里的类可以是具体类也可以是抽象类

```java
// 主要用于重写或实现方法，本质上是一个继承了该类或者实现了该接口的子类匿名对象
new 类名或接口名() {
	重写方法;
}

new Inner() {
    public void show() {
        
    }
}
```

## 十一、 常用API

1. Math

   类`Math`包含用于执行基本数字运算的方法，其内部定义的变量和方法都是静态的，可以直接通过类名使用

   | 方法名                                       | 说明                                                 |
   | -------------------------------------------- | ---------------------------------------------------- |
   | public static int abs(int a)                 | 返回`int`值的绝对值                                  |
   | public static int max(int a, int b)          | 返回两个`int`值中较大的`int`                         |
   | public static int min(int a, int b)          | 返回两个`int`值中较小的`int`                         |
   | public static double floor(double a)         | 返回小于或等于参数的最大double值等于一个整数         |
   | public static double ceil(double a)          | 返回大于或等于参数的最小double值等于一个整数         |
   | public static long round(double a)           | 按照四舍五入返回最接近参数的int                      |
   | public static double random()                | 返回带有正号的`double`值，大于或等于`0.0`且小于`1.0` |
   | public static double pow(double a, double b) | 返回a的b此幂的值                                     |

2. System

   | 方法名                                 | 说明                                                 |
   | -------------------------------------- | ---------------------------------------------------- |
   | public static void exit(int status)    | 终止当前运行的Java虚拟机，非零状态代码表示异常终止。 |
   | public static long currentTimeMillis() | 以毫秒为单位返回当前时间。                           |

3. Object

   类`Object`是类层次结构的根。每个类都可以将Object作为超类，所有类都直接或间接的继承自该类。

   | 方法名                                     | 说明                                                         |
   | ------------------------------------------ | ------------------------------------------------------------ |
   | public String toString()                   | 返回对象的字符串表示形式。                                   |
   | public boolean equals(Object obj)          | 指示某个其他对象是否“等于”此对象，通常需要在重写此方法时覆盖`hashCode`方法 |
   | public int hashCode()                      | 返回对象的哈希码值                                           |
   | public final 类<?> getClass()              | 返回此`Object`的运行时类                                     |
   | protected Object clone()                   | 创建并返回此对象的副本。如果对象的类不支持`Cloneable`接口。  |
   | public final void notify()                 | 唤醒正在此对象监视器上等待的单个线程。                       |
   | public final void notifyAll()              | 唤醒等待此对象监视器的所有线程。                             |
   | public final void wait()                   | 导致当前线程等待它被唤醒，通常是*通知*或*中断* 。            |
   | public final void wait(long timeoutMillis) | 导致当前线程等待它被唤醒，通常是*通知*或*中断* ，或者直到经过一定时间后自动唤醒 |

4. Arrays

5. 基本类型包装类

6. 日期类