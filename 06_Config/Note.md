+ 如果想将第三方库中的组件装配到应用程序中，则没有办法在类上添加 @Component和@Autowired等注解。

+ 方案：显示装配
    + Java装配
    + xml装配
    
+ JavaConfig装配的歧义性
    + 首选bean
        + 在声明类的时候使用@Primary
        + 只能定义一个@Primary
        
    + 使用限定符
        + @Qualifier
        
    + 使用限定符+ bean id
        + 在声明的时候指定bean的id
        + 在装配的时候使用@Qualifier