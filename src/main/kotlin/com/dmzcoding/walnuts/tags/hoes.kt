package com.dmzcoding.walnuts.tags

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.dialect.AbstractProcessorDialect
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IModelFactory
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.processor.IProcessor
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor
import org.thymeleaf.processor.element.IElementTagStructureHandler
import org.thymeleaf.templatemode.TemplateMode


/**
class MyThTag(templateMode: TemplateModel, dialectPrefix:String,
              elementName:String, prefixElementName:Boolean,
              attributeName:String, prefixAttributeName:Boolean,
              precedence:Int, removeAttribute:Boolean) : AbstractAttributeTagProcessor(templateMode) {

    override fun doProcess(context: ITemplateContext?, tag: IProcessableElementTag?, attributeName: AttributeName?, attributeValue: String?, structureHandler: IElementTagStructureHandler?) {
        TODO("Not yet implemented")
    }

}
*/


class MyThTag(templateMode: TemplateMode, dialectPrefix: String, elementName: String, prefixElementName: Boolean, attributeName: String, prefixAttributeName: Boolean, precedence: Int, removeAttribute: Boolean)
    : AbstractAttributeTagProcessor(templateMode, dialectPrefix, elementName,
        prefixElementName, attributeName, prefixAttributeName, precedence, removeAttribute) {

    override fun doProcess(context: ITemplateContext, tag: IProcessableElementTag, attributeName: AttributeName, attributeValue: String, structureHandler: IElementTagStructureHandler) {
        // 创建将替换自定义标签的 DOM 结构

        // 创建将替换自定义标签的 DOM 结构
        val modelFactory: IModelFactory = context.modelFactory
        val model = modelFactory.createModel()

        // 需要替换的页面元素

        // 需要替换的页面元素
        model.add(modelFactory.createOpenElementTag("div"))
        model.add(modelFactory.createText("Hello Thymeleaf Dialect"))
        model.add(modelFactory.createCloseElementTag("div"))

        // 利用引擎替换整个标签

        // 利用引擎替换整个标签
        structureHandler?.replaceWith(model, false)

    }

}


class MyThDailect(name: String,prefix:String,processorPrecedence:Int) :
        AbstractProcessorDialect(name,prefix,processorPrecedence){

    override fun getProcessors(dialectPrefix: String?): MutableSet<IProcessor> {
        TODO("Not yet implemented")
    }

}