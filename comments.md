### 完成度：
* 项目无法启动，完成度无法进行评估

### 知识点：
* 建议了解下DTO使用场景
* 了解下@ReponseStatus的用法
* 了解下数据库的使用和配置
* 需要加强对JPA的理解

__Details:__
- \- LearnerRepository.java:12 JPA知识点使用错误，声明了自定义方法，但是没有指明sql，JPA无法正常解析
- \- LearnerController.java:21 对于Ioc容器管理的bean之间的注入，推荐使用构造器注入
- \- LearnerController.java:53  思考下，这个ResponseEntity是否可以省略？什么样的场景，才需要专门使用ResponseEntity进行返回？

### 工程实践：
__Details:__

- \- GroupList.java:13 learnerList数据的存储，不是这个dto的职责。数据存储相关的操作，应该由repository来做。
- \- GroupList.java:21 长方法，需要按模块抽取方法，进行重构
- \- GroupList.java:23  randomGroup这个操作不是dto的职责
- \- LearnerController.java:24 最好不要跨层调用
- \- LearnerController.java:31 数据初始化的操作，不是controller的职责。
- \- LearnerController.java:52 返回状态码，不符合restful实践，POST请求应该返回201

### 综合：
__Details:__
- \- build.gradle:23 Lombok相关包导入少了，了解下如果要使用Lombok，至少需要导入什么样的包

