package work

object TenantIdExtraction extends App {

  val str = "/subscriptions/24d61f39-b4be-4ada-a91d-0d6b451477c8/resourceGroups/MC_vgs-rg_vgs-k8s_eastus/providers/Microsoft.ContainerService/managedClusters/aks-agentpool-86208562-vmss"
  //println(str)

  //val smith = "/subscriptions/24d61f39-b4be-4ada-a91d-0d6b451477c8/resourceGroups/MC_vgs-rg_vgs-k8s_eastus/providers/Microsoft.Compute/virtualMachineScaleSets/aks-agentpool-86208562-vmss"

  val finalRegex = """/([A-Za-z]+)/([a-zA-Z0-9-]*)/([A-Za-z]*)/([A-Za-z]+)_([a-zA-Z0-9-]*)_([a-zA-Z0-9-]*)_([a-zA-Z]*)/([A-Za-z]*)/([A-Za-z.]*)/([A-Za-z]*)/([a-zA-Z0-9-]*$)""".r


 // val resourceGroup = "MC_vgs-rg_vgs-k8s_eastus"

 // val regex = """([A-Za-z]+)_([a-zA-Z0-9-]*)_([a-zA-Z0-9-]*)_([a-zA-Z]*$)""".r

  /*resourceGroup match {
    case regex(a, b, c, d) => println(a)
  }*/

    str match {
    case finalRegex(a,b,c,d,e,f,g,h,i,j,k) => {
      println(s"$a \n $b \n $c \n $d \n $e \n $f \n $g \n $h \n $i \n $j \n $k")
      val finalStr = "/" + a + "/" + b + "/" + c + "/" + e + "/" + h + "/"  + i + "/" + j + "/" + f
      println(finalStr)
    }
  }
}
