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

