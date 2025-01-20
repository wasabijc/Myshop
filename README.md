myshop微服务，提供用户信息的增删改查功能和购票功能
myshop-web：购票微服务，实现负载均衡、熔断器功能
myshop-user：用户微服务，提供管理用户信息功能
myshop-gateway：融合swagger，对用户的增删改查操作进行转发，并提供过滤器功能
eureka-server：提供服务注册服务
myshop-config：配置中心
hystrix-monitor：Hystrix Dashboard监控面板
zipkin-server：数据链路追踪服务，收集请求链路的跟踪数据
