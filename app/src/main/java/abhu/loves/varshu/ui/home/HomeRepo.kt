package abhu.loves.varshu.ui.home
import abhu.loves.varshu.base.BaseRepo
import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.ui.home.model.HomeData
import abhu.loves.varshu.ui.home.model.customModel.*
import io.reactivex.Single

class HomeRepo: BaseRepo() {
    val service = retrofit.create(HomeService::class.java)

    fun getData(): Single<Any>{
        return service.getHomeData().map {
            organise(it)
        }
    }

    private fun organise(homeData: HomeData): Any {
        val organisedGroup: HashMap<String, ArrayList<Entry>> = hashMapOf()
        for (entry in homeData.feed.entry){
            entry.groupId.value?.let {
                if(organisedGroup.containsKey(entry.groupId.value!!)){
                    val entryList = organisedGroup.get(entry.groupId.value!!)
                    entryList!!.add(entry)
                    organisedGroup.put(entry.groupId.value!!, entryList)
                } else {
                    val entryList: ArrayList<Entry> = arrayListOf()
                    entryList.add(entry)
                    organisedGroup.put(entry.groupId.value!!, entryList)
                }
            }
        }

        val organisedData: ArrayList<Any> = arrayListOf()
        for(key in organisedGroup.keys){
            val title = organisedGroup.get(key)!![0].text.value ?: ""
            val products = getProductList(organisedGroup.get(key) as ArrayList<Entry>)
            when(products[0].family.value){
                0 -> {
                    val family = Family0(title, products)
                    organisedData.add(family)
                }
                1 -> {
                    val family = Family1(title, products)
                    organisedData.add(family)
                }
                2 -> {
                    val family = Family2(title, products)
                    organisedData.add(family)
                }
                3 -> {
                    val family = Family3(title, products)
                    organisedData.add(family)
                }
                4 -> {
                    val family = Family4(title, products)
                    organisedData.add(family)
                }
                6 -> {
                    val family = Family6(title, products)
                    organisedData.add(family)
                }
                100 -> {
                    val family = Family100(title, products)
                    organisedData.add(family)
                }
                200 -> {
                    val family = Family200(title, products)
                    organisedData.add(family)
                }
                else -> {
//                    val family = Family4(title, products)
//                    organisedData.add(family)
                }
            }
        }

        return organisedData
    }

    private fun getProductList(entries: ArrayList<Entry>): ArrayList<Entry>{
        val products = arrayListOf<Entry>()
        for(entry in entries){
            if(entry.type.value.equals("Product")){
                products.add(entry)
            }
        }
        return products
    }
}