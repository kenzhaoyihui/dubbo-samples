#### About the dubbo-samples-api sample
This sample code is building up dubbo service provider and service consumer with the pure API approach. In this sample, nulticast is facilitated as the registration mechanism, therefore it is necessary to explicitly specify system property `java.net.preferIPv4Stack`.

#### [exec maven plugin](https://blog.csdn.net/xiaozaq/article/details/70053416)
```$xslt
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>1.6.0</version>
    <executions>
        <execution>
            <goals>
                <goal>java</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

#### Start the service provider
```$xslt
mvn clean package
mvn -Djava.net.preferIPv4Stack=true -Dexec.mainClass=com.yzhao.dubbo.samples.server.Application exec:java
```

#### Start the service consumer
```$xslt
mvn -Djava.net.preferIPv4Stack=true -Dexec.mainClass=com.yzhao.dubbo.samples.client.Application exec:java
```
