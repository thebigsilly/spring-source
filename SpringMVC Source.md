# SpringMVC Source

## 流程

1. HandlerMapping找到HandlerExecutionChain
   1. 找到Handler
   2. 找到Interceptor
   3. 设置HandlerExecutionChain的Interceptor
2. 从Handler找到HandlerAdapter

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

  查找传参

- HandlerMethodReturnValueHandlerComposite

- ModelAndViewContainer

