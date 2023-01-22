## conclusion
> bootstrap the application to work fast 

> we can choose which class should be singleton and which not

>easy to understand


## dependencies

```xml

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.glassfish.jersey.inject</groupId>
			<artifactId>jersey-hk2</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.containers</groupId>
			<artifactId>jersey-container-servlet</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.core</groupId>
			<artifactId>jersey-server</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.core</groupId>
			<artifactId>jersey-common</artifactId>
			<version>3.0.8</version>
		</dependency>
	</dependencies>

```

## 1 method boot class

```java
package com.lavesh.init;

import java.util.HashSet;
import java.util.Set;

import com.lavesh.init.newoj.NewOjPerReq;
import com.lavesh.init.singleton.Singletobj;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

//@ApplicationPath("/api")
public class AppBoot extends Application {

	Set<Object> singletons;
	Set<Class<?>> newperreq;

	public AppBoot() {
		singletons = new HashSet<Object>();
		newperreq = new HashSet<Class<?>>();

		// add in single to set to get same obj n no. of times
		singletons.add(new Singletobj());

		// add .class for req per new obj

		newperreq.add(NewOjPerReq.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return newperreq;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}


```

## 2 method boot class

```java

package com.lavesh.init;

import org.glassfish.jersey.server.ResourceConfig;

import com.lavesh.init.newoj.NewOjPerReq;
import com.lavesh.init.singleton.Singletobj;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class AppBootConfig extends ResourceConfig {

	public AppBootConfig() {
		super.register(NewOjPerReq.class);
		register(new Singletobj());
	}
}

```


## obj per new req class

```java
package com.lavesh.init.newoj;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/abc")
public class NewOjPerReq {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}")
	public String get(@PathParam("name") String name) {

		System.out.println("new obj per req : " + this.hashCode());
		return UUID.randomUUID().toString();
	}
}


```

## singleton class

```java
package com.lavesh.init.singleton;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("{name}/verify")
public class Singletobj {

	@GET
	@Produces(MediaType.TEXT_PLAIN)

	public String get(@PathParam("name") String name) {

		System.out.println(" singleton : " + this.hashCode());

		return "" + UUID.randomUUID().toString();
	}
}


```
