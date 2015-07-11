name := "MovieHibernate"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.10.Final"

libraryDependencies += "org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.0.Final"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"

mainClass in (Compile, packageBin) := Some("MovieApp")