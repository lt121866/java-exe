# java-exe
打包java成exe

-- 使用GraalVM编译jar成exe文件，需要完成以下步骤:

第一步：
    下载GraalVM软件，并安装。官网地址:https://www.graalvm.org/downloads/#
    配置环境变量：JAVA_HOME=GraalVM 安装路径
    命令：java --version     查看jvm版本的java

    gu --version            查看jvm管理工具版本

    常见命令：
    gu --version	        查看 gu 工具版本
    gu list	                列出所有可用和已安装的组件
    gu install native-image	安装 native-image 组件
    gu install js	        安装 JavaScript 运行时
    gu remove python	    卸载 Python 支持
    gu upgrade-component	更新组件

第二步：
    下载 Visual Studio 官网地址：https://visualstudio.microsoft.com/zh-hans/downloads/
    
    安装时，勾选一下插件：

    C++ build tools
    MSVC v143 - VS 2022 C++ x64/x86 构建工具
    Windows 10/11 SDK

第三部：
    配置maven的pom文件
    
     <plugin>
        <groupId>org.graalvm.buildtools</groupId>
        <artifactId>native-maven-plugin</artifactId>
        <version>${native-maven-plugin.version}</version>
        <executions>
            <execution>
                <id>build-native</id>
                <goals>
                    <goal>build</goal>
                </goals>
                <phase>package</phase>
            </execution>
        </executions>
        <configuration>
            <imageName>demo-app</imageName>
            <mainClass>com.liutai.demo.DemoNativeApplication</mainClass>
            <metadataRepository>
                <enabled>true</enabled>
            </metadataRepository>
            <fallback>false</fallback>
            <verbose>true</verbose>
            <buildArgs>
                --enable-url-protocols=http
                -H:Name=demo-native-app
                -H:+ReportExceptionStackTraces
            </buildArgs>
        </configuration>
    </plugin>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
            <source>17</source>
            <target>17</target>
        </configuration>
    </plugin>
