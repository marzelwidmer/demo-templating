package com.example.demotemplating

import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.StringWriter


@SpringBootApplication
class DemoTemplatingApplication

fun main(args: Array<String>) {
	runApplication<DemoTemplatingApplication>(*args)

	val ve = VelocityEngine()
	ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath")
	ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader::class.java.name)
	ve.init()
	val template = ve.getTemplate("templates/helloworld.vm")

	val context = VelocityContext()
	context.put("name", "World")

	val writer = StringWriter()
	template.merge(context, writer)
	template.process()
	println(writer)

}
