# SunFavorite🌟空想家网页收藏夹
## 1. 主要功能
- 微信公众号验证码登录
- 个人网页收藏(公开收藏/私有收藏)
- 收藏广场，显示其他用户公开收藏
- 网页收藏搜索
- 个人中心(个人名称+头像)
## 2. 技术的选型和基础环境搭建配置
**技术的选型：**
1. 数据库使用MySQL
2. 缓存使用Redis
3. 搜索功能使用ElasticSearch，分词使用IK分词器
4. MySQL和ElasticSearch的同使用Canal，这个Canal包含Canal-Server和Canal-Adapter
5. 持久层框架使用SpringData JPA(如果有复杂的查询不推荐)
6. 基础框架使用SpringBoot
7. 模板引擎使用FreeMarker
8. 前端使用BootStrap做布局，也使用到了Layui部分组件


