package work

object AzureRegexCheck extends App{

  val str = "azure:///resourceGroups/"

  val newString = str.replace("///","/")

  val reg = """([a-z:]+)/([A-Za-z]*)/$""".r

  private val providerIdRegex = """(.*)///subscriptions/([^/]+)/resourceGroups/([^/]+)/providers/(.*)$""".r
  val value = "azure:///subscriptions/24d61f39-b4be-4ada-a91d-0d6b451477c8/resourceGroups/mc_ct-cnapp-dev-ins-aks_envoy-poc_eastus2/providers/Microsoft.Compute/virtualMachineScaleSets/aks-agentpool-24265008-vmss/virtualMachines/0"
  val res = getAzureRegex(value)
  println(res.get)

  def getAzureRegex(providerId: String)= {
    providerId match {
      case providerIdRegex(_, subscriptionId, resourceGroup, _) =>
        Option(s"$subscriptionId.*$resourceGroup")
      case _ => println(s"Regex not found for the providerId : $providerId")
        None
    }
  }

}
