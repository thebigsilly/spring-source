# SpringMVC Source

## 流程

1. HandlerMapping找到HandlerExecutionChain
   1. 找到Handler
   2. 找到Interceptor
   3. 设置HandlerExecutionChain的Interceptor
2. 从Handler找到HandlerAdapter
3. HandlerAdapter执行
   1. 获取@InitBind工厂 WebDataBinderFactory
   2. 获取@ModelAttribute工厂 ModelFactory
   3. 创建ServletInvocableHandlerMethod
   4. 创建ModelAndViewContainer
   5. ModelFactory初始化@ModelAttribute
   6. 执行Handler
   7. 获取返回值Handler HandlerMethodReturnValueHandler
   8. HandlerMethodReturnValueHandler执行处理返回值，设置响应头等
4. 渲染View
5. 执行PostHandler

## 组件

- UrlPathHelper

  URL匹配工具

- AntPatternComparator

  Ant URL风格

- BeanNameUrlHandlerMapping

- HandlerMethod

  封装Controller和Method

- RequestMappingHandlerMapping

  urlLookup>/hello 映射MappingLookup

  nameLookup>HC:sayHello 映射HandleMethod

  mappingLookup>{GET /hello} 映射HandleMethod

  registry 映射RequestMappingInfo和HandleMethod

- ModelFactory

- WebDataBinderFactory

- ServletWebRequest

- HandlerMethodArgumentResolverComposite

  请求参数解析器

- HandlerMethodReturnValueHandlerComposite

  返回参数解析器

- ModelAndViewContainer

- @InitBinder

  进行数据转换

- @ModelAttribute

- ServletInvocableHandlerMethod

  包装HandlerMethod，使得可以对请求值和返回值进行处理

- @ResponseStatus

- ModelMap

- 

## Interceptor

### 使用

#### XML

```xml
<mvc:interceptors>
    <mvc:interceptor>
        <mvc:mapping path="/*"/>
        <bean class="com.fyh.mvc.source.interceptor.XMLInterceptor"/>
    </mvc:interceptor>
    <bean class="com.fyh.mvc.source.interceptor.BeanInterceptor"/>
    <ref bean="interceptor"/>
</mvc:interceptors>
```

####Java

```java
@EnableWebMvc
@ComponentScan(value = "com.fyh.mvc.source.controller", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorAnnotation());
    }
}
```

### 原理

#### 注入

##### XML

1. InterceptorsBeanDefinitionParser解析Interceptors标签。内部Interceptor，Bean，Ref都会组装为MappedInterceptor
2. HandlerMapping执行ApplicationContextAware阶段调用AbstractHandlerMapping的initApplicationContext获取Bean工厂所有MappedInterceptor进行注入

#####Java

1. DelegatingWebMvcConfiguration#setConfigurers自动注入WebMvcConfigurer
2. WebMmvConfigurationSupport实例化RequestMappingHandlerMapping调用WebMvcConfigurer#addInterceptors

####执行过程

1. AbstractHandlerMapping@getHandler将Handler包装为HandlerExecutionChain，在添加过程中进行过滤
2. 执行HandlerAdapter@handle之前执行HandlerInterceptor#preHandler
3. ViewName解析后执行HandlerInterceptor#postHandler
4. 页面渲染成功后执行HandlerInterceptor#triggerAfterCompletion