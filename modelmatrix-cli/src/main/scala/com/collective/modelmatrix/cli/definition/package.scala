package com.collective.modelmatrix.cli

import com.bethecoder.ascii_table.ASCIITable
import com.collective.modelmatrix.catalog.ModelDefinition

package object definition {

  def printDefinitions(definitions: Seq[ModelDefinition]): Unit = {
    val header: Array[String] = Array(
      "Id", "Name", "Created By", "Created At", "Comment", "Features"
    )

    val noData: Array[Array[String]] = Array(Array.fill(header.length)("--"))

    val result = definitions.map { definition =>
      Array(
        definition.id.toString,
        definition.name.getOrElse("n/a"),
        definition.createdBy,
        timeFormatter.format(definition.createdAt),
        definition.comment.getOrElse("n/a"),
        definition.features.toString
      )
    }

    Console.out.println(s"Total number of Model Matrix definitions: ${definitions.length}")
    ASCIITable.getInstance().printTable(header, if (result.nonEmpty) result.toArray else noData)
  }


}
