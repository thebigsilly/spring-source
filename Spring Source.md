#Spring Source

## IOC

### 流程

1. 创建Environment（系统环境变量，JVM环境变量）
2. ConfigPath占位符替换
3. 创建BeanFactory
4. loadBeanDefinition
5. prepareBeanFactory
   1. 设置SpringEl解析器，StandardBeanExpressionResolver
   2. 添加ResourceEditorRegistrar
   3. 添加BeanFactoryProcessor
      1. ApplicationContextAwareProcessor
      2. ApplicationListenerDetector
   4. 设置忽略扫描接口
      1. EmbeddedValueResolverAware
      2. EnvironmentAware
      3. ResourceLoaderAware
      4. ApplicationEventPublisherAware
      5. MessageSourceAware
      6. ApplicationContextAware
   5. 设置忽略扫描实体
      1. BeanFactory
      2. ResourceLoader
      3. ApplicationEventPublisher
      4. ApplicationContext
   6. 注册环境Bean
      1. environment
      2. systemProperties
      3. systemEnvironment
   7. 模板方法postProcessBeanFactory
   8. 执行BeanFactoryPostProcessor
      1. 执行ApplicationContext的BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry
      2. 执行BeanFactory的PriorityOrderd->BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry
      3. 执行BeanFactory的Orderd->BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry
      4. 执行BeanFactory的BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry
      5. 执行BeanDefinitionRegistryPostProcessor#postProcessBeanFactory
      6. 执行ApplicationContext的BeanFactoryPostProcessor#postProcessBeanFactory
      7. 执行BeanFactory的PriorityOrderd->BeanFactoryPostProcessor#postProcessBeanFactory
      8. 执行BeanFactory的Orderd->BeanFactoryPostProcessor#postProcessBeanFactory
      9. 执行BeanFactory的BeanFactoryPostProcessor#postProcessBeanFactory
   9. 注册BeanPostProcessor
      1. BeanFactory中的PriorityOrdered-Ordered-NoOrdered-MergedBeanDefinitionPostProcessor
      2. BeanPostProcessorChecker
      3. ApplicationListenerDetector
   10. 初始化MessageSource--DelegatingMessageSource,key=messageSource
   11. 初始化时间广播器SimpleApplicationEventMulticaster，key=applicationEventMulticaster
   12. 模板方法onRefresh
   13. 注册监听
   14. 实例化Bean
   15. 初始化生命周期
   16. 发布生命周期onRefresh
   17. 发布ContextRefreshedEvent
   18. 注册MBean

#### XML加载BeanDefinition

1. XMLBeanDefinitionReader 读取XML InputSource
2. DocumentLoader 加载XML文件到内存
3. BeanDefinitionDocumentReader 讲XML按照父节点分流
4. BeanDefinitionParserDelegate 解析Bean标签
5. GenericBeanDefinition
6. BeanDefinitionHolder
7. BeanDefinitionParserDelegate

#### 实例化Bean

1. InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
2. InstantiationAwareBeanPostProcessor#postProcessAfterInitialization
3. SmartInstantiationAwareBeanPostProcessor#determineCandidateConstructors
4. CglibSubclassingInstantiationStrategy
5. 创建成功
6. MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition
7. InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation
8. InstantiationAwareBeanPostProcessor#postProcessProperties
9. InstantiationAwareBeanPostProcessor#postProcessPropertyValues
10. BeanNameAware
11. BeanClassLoaderAware
12. BeanFactoryAware
13. BeanPostProcessor#postProcessBeforeInitialization
14. InitializingBean#afterPropertiesSet
15. invokeCustomInitMethod
16. BeanPostProcessor#postProcessAfterInitialization
17. SmartInitializingSingleton#afterSingletonsInstantiated
18. 

### 组件

#### BeanDefinitionHolder

通过BeanName和Alias保持BeanDefinition

### 设计模式

## AOP

### 流程

### 组件

### 设计模式

## Transaction

### 流程

### 组件

### 设计模式

## MVC

### 流程

### 组件

### 设计模式

## ExceptionHandler

### 流程

### 组件

### 设计模式

