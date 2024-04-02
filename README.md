## 项目介绍

- 项目名称：gemini-ai
- 项目描述：AI服务

## 项目结构

```lua
─ gemini-ai
├─db -- 数据库脚本
├─gemini-ai-boot -- 启动模块
│  └─src
│     └─main
│        ├─java
│        │  └─com.gls.gemini.ai.boot
│        │     ├─config -- 配置
│        │     └─web
│        │        ├─controller -- 控制器
│        │        ├─converter -- 转换器
│        │        ├─entity -- 实体
│        │        ├─mapper -- mapper
│        │        └─service -- 服务
│        └─resources
│           └─mapper -- mapper文件
└─gemini-ai-sdk -- sdk模块
   └─src
      └─main
         ├─java
         │  └─com.gls.gemini.ai.sdk
         │     ├─feign -- feign
         │     └─vo -- vo
         └─resources
            └─META-INF
               └─spring -- spring配置文件
```