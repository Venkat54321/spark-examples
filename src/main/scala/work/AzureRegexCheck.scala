package work

object AzureRegexCheck extends App{

  val str = "azure:///resourceGroups/"

  val newString = str.replace("///","/")

  val reg = """([a-z:]+)/([A-Za-z]*)/$""".r

  newString match {
    case reg(a,b) => println(a)
  }

}
