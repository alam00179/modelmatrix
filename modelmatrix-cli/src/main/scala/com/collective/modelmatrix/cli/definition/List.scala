package com.collective.modelmatrix.cli.definition

import com.collective.modelmatrix.catalog.ModelMatrixCatalog
import com.collective.modelmatrix.cli.{Script, CliModelCatalog}
import com.typesafe.config.Config

import scala.concurrent.ExecutionContext
import scalaz.@@

/**
 * List all Model Matrix definitions in catalog
 */
case class List(
  dbName: String, dbConfig: Config
)(implicit val ec: ExecutionContext @@ ModelMatrixCatalog) extends Script with CliModelCatalog {

  def run(): Unit = {
    printDefinitions(blockOn(db.run(modelDefinitions.all)))
  }
}
