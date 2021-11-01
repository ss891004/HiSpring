

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
+ 通过静态工厂方法创建bean对象
+ 通过实例工厂方法创建bean对象
+ 通过FactoryBean创建bean对象





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