package work

import scala.Option

object TenantIdExtraction1 extends App{


  val value = getString
  println(value.get._1)
  println(value.get._2)
  println(value.get._3)



  def getString() = {

    val newProviderId = "azure:///subscriptions/24d61f39-b4be-4ada-a91d-0d6b451477c8/resourceGroups/mc_ct-cnapp-dev-ins-aks_envoy-poc_eastus2/providers/Microsoft.Compute/virtualMachineScaleSets/aks-agentpool-24265008-vmss/virtualMachines/0"
    val newReg = """([a-z:]*)/([A-Za-z]*)/([a-zA-Z0-9-]*)/([A-Za-z]*)/([A-Za-z]*)_([a-zA-Z0-9-]*)_([a-zA-Z0-9-]*)_([a-zA-Z0-9]*)/$""".r
    val splitStr = newProviderId.split("providers")
    val newString = splitStr(0).replace("///", "/")

    newString match {
      case newReg(a, b, c, d, e, f, g, h) => println(a)
        Option(c, f, g)
    }
  }



}
