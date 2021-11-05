

## spring容器
+ spring容器的概念，我们的程序启动的时候会创建spring容器，会给spring容器一个清单，清单中列出了需要创建的对象以及对象依赖关系，spring容器会创建和组装好清单中的对象，然后将这些对象存放在spring容器中，当程序中需要使用的时候，可以到容器中查找获取，然后直接使用。
+ spring容器：主要负责容器中对象的创建、组装、对象查找、对象生命周期的管理等等操作。

## IOC：控制反转
+ 使用者之前使用B对象的时候都需要自己去创建和组装，而现在这些创建和组装都交给spring容器去给完成了，使用者只需要去spring容器中查找需要使用的对象就可以了；这个过程中B对象的创建和组装过程被反转了，之前是使用者自己主动去控制的，现在交给spring容器去创建和组装了，对象的构建过程被反转了，所以叫做控制反转；IOC是是面相对象编程中的一种设计原则，主要是为了降低系统代码的耦合度，让系统利于维护和扩展。
+ IOC控制反转，是一种设计理念，将对象创建和组装的主动控制权利交给了spring容器去做，控制的动作被反转了，降低了系统的耦合度，利于系统维护和扩展，主要就是指需要使用的对象的组装控制权被反转了，之前是自己要做的，现在交给spring容器做了。

## DI：依赖注入
+ 依赖注入是spring容器中创建对象时给其设置依赖对象的方式，比如给spring一个清单，清单中列出了需要创建B对象以及其他的一些对象（可能包含了B类型中需要依赖对象），此时spring在创建B对象的时候，会看B对象需要依赖于哪些对象，然后去查找一下清单中有没有包含这些被依赖的对象，如果有就去将其创建好，然后将其传递给B对象；可能B需要依赖于很多对象，B创建之前完全不需要知道其他对象是否存在或者其他对象在哪里以及被他们是如何创建，而spring容器会将B依赖对象主动创建好并将其注入到B中去，比如spring容器创建B的时候，发现B需要依赖于A，那么spring容器在清单中找到A的定义并将其创建好之后，注入到B对象中。
+ DI依赖注入，表示spring容器中创建对象时给其设置依赖对象的方式，通过某些注入方式可以让系统更灵活，比如自动注入等可以让系统变的很灵活，这个后面的文章会细说。


## IOC容器(spring容器)
+ IOC容器是具有依赖注入功能的容器，负责对象的实例化、对象的初始化，对象和对象之间依赖关系配置、对象的销毁、对外提供对象的查找等操作，对象的整个生命周期都是由容器来控制。
  我们需要使用的对象都由ioc容器进行管理，不需要我们再去手动通过new的方式去创建对象，由ioc容器直接帮我们组装好，当我们需要使用的时候直接从ioc容器中直接获取就可以了。

+ xml格式和java注解方式

## Bean
+ 由spring容器管理的对象统称为Bean对象。Bean就是普通的java对象，和我们自己new的对象其实是一样的，只是这些对象是由spring去创建和管理的，我们需要在配置文件中告诉spring容器需要创建哪些bean对象，
  所以需要先在配置文件中定义好需要创建的bean对象，这些配置统称为bean定义配置元数据信息，spring容器通过读取这些bean配置元数据信息来构建和组装我们需要的对象。

+ BeanFactory
    + org.springframework.beans.factory.BeanFactory
+ ApplicationContext
    + org.springframework.context.ApplicationContext
+ ClassPathXmlApplicationContext
    + org.springframework.context.support.ClassPathXmlApplicationContext
+ AnnotationConfigApplicationContext
    + org.springframework.context.annotation.AnnotationConfigApplicationContext

+ 4个注解：
    - @Component： 表示这个类需要在应用程序中被创建
    - @ComponentScan：自动发现应用程序中创建的类
    - 自动装配：@Autowird： 自动满足bean之间的依赖
    - 定义配置类：@Configuration： 表示当前类是一个配置类


### bean xml
```text
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd">
    <import resource="引入其他bean xml配置文件" />
    <bean id="bean标识" class="完整类型名称"/>
    <alias name="bean标识" alias="别名" />
</beans>
```
### 创建bean
+ 通过反射调用构造方法创建bean对象
  
```text
<bean id="bean名称" name="bean名称或者别名" class="bean的完整类型名称">
    <constructor-arg index="0" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="1" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="2" value="bean的值" ref="引用的bean名称" />
    ....
    <constructor-arg index="n" value="bean的值" ref="引用的bean名称" />
</bean>
```

+ 通过静态工厂方法创建bean对象
  ```text
<bean id="bean名称" name="" class="静态工厂完整类名" factory-method="静态工厂的方法">
    <constructor-arg index="0" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="1" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="2" value="bean的值" ref="引用的bean名称" />
    ....
    <constructor-arg index="n" value="bean的值" ref="引用的bean名称" />
</bean>
```
+ 通过实例工厂方法创建bean对象
```text
<bean id="bean名称" factory-bean="需要调用的实例对象bean名称" factory-method="bean对象中的方法">
    <constructor-arg index="0" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="1" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="2" value="bean的值" ref="引用的bean名称" />
    ....
    <constructor-arg index="n" value="bean的值" ref="引用的bean名称" />
</bean>
```
+ 通过FactoryBean创建bean对象


### 作用域
```text
<bean id="" class="" scope="作用域" />
```
+ singleton
  + 当scope的值设置为singleton的时候，整个spring容器中只会存在一个bean实例,singleton是scope的默认值
  + 单例bean是整个应用共享的，所以需要考虑到线程安全问题,不要共享变量
+ prototype
  + 表示这个bean是多例的，通过容器每次获取的bean都是不同的实例，每次获取都会重新创建一个bean实例对象
+ request
  + 当一个bean的作用域为request，表示在一次http请求中，一个bean对应一个实例；对每个http请求都会创建一个bean实例，request结束的时候，这个bean也就结束了
+ session
  + session级别共享的bean，每个会话会对应一个bean实例，不同的session对应不同的bean实例
+ application
  

### 依赖注入
+ 系统中类和类之间是有依赖关系的，如果一个类对外提供的功能需要通过调用其他类的方法来实现的时候，说明这两个类之间存在依赖关系
+ 构造函数的方式
  + 根据构造器参数索引注入
  + 根据构造器参数类型注入
  + 根据构造器参数名称注入
+ set属性的方式 
  + 属性都是private访问级别的
  + 属性通常情况下通过一组setter（修改器）和getter（访问器）方法来访问
  + 注入容器中的bean写法：
    + ref属性方式
    + 内置bean的方式

#### 手动注入


#### 自动注入

```text
<bean id="" class="" autowire="byType|byName|constructor|default" />
byteName：按照名称进行注入
byType：按类型进行注入
constructor：按照构造方法进行注入
default：默认注入方式

```
### bean初始化
+ 实时初始化
  + 在容器启动过程中被创建组装好的bean，称为实时初始化的bean，spring中默认定义的bean都是实时初始化的bean，这些bean默认都是单例的，在容器启动过程中会被创建好，然后放在spring容器中以供使用。
+ 延迟初始化
  + <bean lazy-init="是否是延迟初始化" />

  
  
### 注解
```text
public @interface 注解名称{
    [public] 参数类型 参数名称1() [default 参数默认值];
    [public] 参数类型 参数名称2() [default 参数默认值];
    [public] 参数类型 参数名称n() [default 参数默认值];
}

访问修饰符必须为public，不写默认为public
该元素的类型只能是基本数据类型、String、Class、枚举类型、注解类型（体现了注解的嵌套效果）以及上述类型的一位数组
该元素的名称一般定义为名词，如果注解中只有一个元素，请把名字起为value（后面使用会带来便利操作）
参数名称后面的()不是定义方法参数的地方，也不能在括号中定义任何参数，仅仅只是一个特殊的语法
default代表默认值，值必须和第2点定义的类型一致
如果没有默认值，代表后续使用注解时必须给该类型元素赋值


```

+ @Target 指定注解的使用范围
```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    ElementType[] value();
}
```
```java
package java.lang.annotation;
/*注解的使用范围*/
public enum ElementType {
       /*类、接口、枚举、注解上面*/
    TYPE,
    /*字段上*/
    FIELD,
    /*方法上*/
    METHOD,
    /*方法的参数上*/
    PARAMETER,
    /*构造函数上*/
    CONSTRUCTOR,
    /*本地变量上*/
    LOCAL_VARIABLE,
    /*注解上*/
    ANNOTATION_TYPE,
    /*包上*/
    PACKAGE,
    /*类型参数上*/
    TYPE_PARAMETER,
    /*类型名称上*/
    TYPE_USE
}
```

+ @Retention  指定注解的保留策略

```java
public enum RetentionPolicy {
    /*注解只保留在源码中，编译为字节码之后就丢失了，也就是class文件中就不存在了*/
    SOURCE,
    /*注解只保留在源码和字节码中，运行阶段会丢失*/
    CLASS,
    /*源码、字节码、运行期间都存在*/
    RUNTIME
}
```

+ @Inherit：实现类之间的注解继承

+ @Repeatable重复使用注解


### Spring注解
#### @ComponentScan
+ 之前通过xml的方式定义bean，里面会写很多bean元素，然后spring启动的时候，就会读取bean xml，然后解析这些配置，然后会将这些bean注册到spring容器中，供使用者使用。

+ @Configuration这个注解可以加在类上，让这个类的功能等同于一个bean xml配置文件
```java
@Configuration
public class ConfigBean {
}
```
```text
//此时ConfigBean类中没有任何内容，相当于一个空的xml配置文件，此时我们要在ConfigBean类中注册bean，那么我们就要用到@Bean注解了。
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
```

#### @Bean
+ 这个注解类似于bean xml配置文件中的bean元素，用来在spring容器中注册一个bean。
```java
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE}) //@1
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
    @AliasFor("name")
    String[] value() default {};
    @AliasFor("value")
    String[] name() default {};
    @Deprecated
    Autowire autowire() default Autowire.NO;
    boolean autowireCandidate() default true;
    String initMethod() default "";
    String destroyMethod() default AbstractBeanDefinition.INFER_METHOD;
}

```
@1：说明这个注解可以用在方法和注解类型上面。

每个参数含义：

value和name是一样的，设置的时候，这2个参数只能选一个，原因是@AliasFor导致的
@AliasFor这个注解不清楚的可以看这个文章：详解注解
value：字符串数组，第一个值作为bean的名称，其他值作为bean的别名
autowire：这个参数上面标注了@Deprecated，表示已经过期了，不建议使用了
autowireCandidate：是否作为其他对象注入时候的候选bean，之前的文章中专门介绍过这个属性，不清楚的可以去看看：autowire-candidate详解
initMethod：bean初始化的方法，这个和生命周期有关
destroyMethod：bean销毁的方法，也是和生命周期相关的


#### @ComponentScans
  
  
### spring-context.xml
```text
xmlns其实是XML Namespace的缩写，可译为“XML命名空间”

使用语法： xmlns:namespace-prefix="namespaceURI"。其中namespace-prefix为自定义前缀，只要在这个XML文档中保证前缀不重复即可

xmlns和xmlns:xsi有什么不同？

xmlns表示默认的Namespace。例如Spring XML文档中的
xmlns="http://www.springframework.org/schema/beans"
这一句表示该文档默认的XML Namespace为http://www.springframwork.org/schema/beans。对于默认的Namespace中的元素，可以不使用前缀。例如Spring XML文档中的

<bean id="xxx" class="xxx.xxx.xxx.Xxx">
  <property name="xxx" value="xxxx"/>
</bean>
xmlns:xsi表示使用xsi作为前缀的Namespace，当然前缀xsi需要在文档中声明。

xsi:schemaLocation有何作用？

xsi:schemaLocation属性其实是Namespace为http://www.w3.org/2001/XMLSchema-instance里的schemaLocation属性，
正是因为我们一开始声明了xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
这里才写作xsi:schemaLocation（当然一般都使用这个前缀）。它定义了XML Namespace和对应的 XSD（Xml Schema Definition）文档的位置的关系。
它的值由一个或多个URI引用对组成，两个URI之间以空白符分隔（空格和换行均可）。
第一个URI是定义的 XML Namespace的值，第二个URI给出Schema文档的位置，Schema处理器将从这个位置读取Schema文档，该文档的targetNamespace必须与第一个URI相匹配。

```