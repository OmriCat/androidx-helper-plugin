package com.omricat

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

fun NodeList.asList(): List<Node> =
  object : AbstractList<Node>() {
    override val size: Int get() = length

    override fun get(index: Int): Node = this@asList.item(index)
  }

fun NodeList.asElementList(): List<Element> =
  asList()
    .filterIsInstance<Element>()

fun document(string: String): Document =
  DocumentBuilderFactory.newInstance().newDocumentBuilder()
    .parse(InputSource(StringReader(string)))


fun Element.normalized() = apply { normalize() }
