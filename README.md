# Spring Boot
Spring boot helps we use Spring use same codes and same background just help to do effectively
# Maven
when we make a web we need many JAR files but maven can manage these files from the repo.
## source code is in src/main/java
## web file is in src/main/webapp > css.js.
## src/test/java > can store unit test codes
# POM file
Project Object Model file
## Project meta data, dependencies, plug-ins
### Project meta data: project name... output file type:JAR,WAR
### Dependencies : Spring,Hibernate
### plugins: Junits...

# dev-tools
<dependency>      
<groupId>org.springframework.boot</groupId>      
<artifactId>spring-boot-devtools</artifactId>        
</dependency>      

# Actuator
### actuator/beans
beans : List of all string beans > use for debug
### actuator/threaddump
analyzing and profiling the performance 
### actuator/mappings
what requested mappings are available

## If anyone can search from the web how about security
add spring-boot-starter-security

###management.endpoints.web.exposure.include=*
include the endopoints (no security)

### management.endpoints.web.exposure.exclude=health,info
add security

# Core Properties

### Logging level
Trace > Debug > Info > Warn > Error > Fatal > Off

# Primary
when you set primary the only that bean be activated
# Qualifier : you can set the component you want to call
### even you set the lazy : the qualifier will be activated

# Singleton & Prototype
Singleton : single shared bean, Default   // @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)   
Prototype : use different bean //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

# MySQL
if you use dependency JDBC helps you to contact with sql database
# Entity Manager & JpaRepository
If you need low level control and flexibility > Entity Manager    
High level control and flexibility > JpaRepository

# DAO : Data Access Objects

# Interface VS Abstract Class
Interface has only abstract class  <> Abstract Class has several abstract class (mixed)
# @Transactional
help begin automatically
# @Repository
specialized annotation for respositories / supports component scanning / Translate JDBC exceptions

# JPQL
### ALl JPQL syntax is not database table > based on entity name and entity fields

# Spring configuration
## spring.jpa.hibernate.ddl-auto=PROPERTY-VALUE  
none : no action   
create only :data tables only created   
drop: drop tables   
create : drop > create   
create drop : drop > create > shutdown > drop    
validate: validation   
update : update

# REST > Representational State Transfer
# JSON > Javascript Object Notation : Lightweight data interchange format



